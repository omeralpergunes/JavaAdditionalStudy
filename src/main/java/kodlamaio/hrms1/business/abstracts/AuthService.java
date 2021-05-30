package kodlamaio.hrms1.business.abstracts;

import kodlamaio.hrms1.core.utilities.results.Result;

import kodlamaio.hrms1.entities.concretes.Employer;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

public interface AuthService {

	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword);
}
