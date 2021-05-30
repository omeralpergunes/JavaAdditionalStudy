package kodlamaio.hrms1.mernisSer;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisService {

	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, int yearOfBirth)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}
}
