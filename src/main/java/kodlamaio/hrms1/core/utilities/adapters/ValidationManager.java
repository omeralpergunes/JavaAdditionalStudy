package kodlamaio.hrms1.core.utilities.adapters;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.core.utilities.ValidationService;

@Service
public class ValidationManager implements ValidationService {

	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String validationLink = "https://hrms1verificationmail/" + uuid.toString();
		System.out.println("Verification link has been sent to " + email );
		System.out.println("Please click on the link to verify your account:  " + validationLink );
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Your activation code:  " + verificationCode );
		return verificationCode;
	}
}
