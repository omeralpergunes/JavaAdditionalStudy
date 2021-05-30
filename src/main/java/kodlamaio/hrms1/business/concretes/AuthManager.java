package kodlamaio.hrms1.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms1.business.abstracts.AuthService;
import kodlamaio.hrms1.business.abstracts.EmployerService;
import kodlamaio.hrms1.business.abstracts.JobSeekerService;
import kodlamaio.hrms1.business.abstracts.UserService;
import kodlamaio.hrms1.business.abstracts.ValidationCodeService;
import kodlamaio.hrms1.core.utilities.ValidationService;
import kodlamaio.hrms1.core.utilities.adapters.VerificationService;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.entities.concretes.Employer;
import kodlamaio.hrms1.entities.concretes.JobSeeker;
import kodlamaio.hrms1.entities.concretes.ValidationCode;

public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobSeekerService jobseekerService;
	private ValidationService validationService;
	private VerificationService verificationService;
	private ValidationCodeService validationCodeService;

	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobSeekerService jobSeekerService,
			VerificationService verificationService, ValidationService validationService,
			ValidationCodeService validationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobseekerService = jobSeekerService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.validationCodeService = validationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
		}

		employerService.add(employer);
		String code = validationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(JobSeeker.getNationalId()), JobSeeker.getFirstName(),
				JobSeeker.getLastName(), JobSeeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForJobseeker(jobSeeker, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(JobSeeker.getNationalId())) {

			return new ErrorResult(JobSeeker.getNationalId() + " already exists.");
		}

		if (!checkIfEmailExists(jobSeeker.getEmail())) {

			return new ErrorResult(jobSeeker.getEmail() + " already exists.");
		}

		
		jobseekerService.add(jobSeeker);
		String code = validationService.sendCode();
		verificationCodeRecord(code, jobSeeker.getId(), jobSeeker.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	
	private boolean checkIfNullInfoForJobseeker(JobSeeker jobSeeker, String confirmPassword) {

		if (JobSeeker.getFirstName() != null && JobSeeker.getLastName() != null && JobSeeker.getNationalId() != null
				&& JobSeeker.getDateOfBirth() != null && jobSeeker.getPassword() != null && jobSeeker.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if (this.jobseekerService.getJobSeekerByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (verificationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		ValidationCode validationCode = new ValidationCode(id, code, false, LocalDate.now());
		this.validationCodeService.add(validationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}
}
