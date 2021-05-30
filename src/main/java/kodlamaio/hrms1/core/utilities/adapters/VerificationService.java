package kodlamaio.hrms1.core.utilities.adapters;

public interface VerificationService {

	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);

}
