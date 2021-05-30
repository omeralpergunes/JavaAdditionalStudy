package kodlamaio.hrms1.business.abstracts;

import java.util.List;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.User;

public interface UserService {

	Result add(User user);
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);
}
