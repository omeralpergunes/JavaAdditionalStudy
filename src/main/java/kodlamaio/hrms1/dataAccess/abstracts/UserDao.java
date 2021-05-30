	package kodlamaio.hrms1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms1.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findUserByEmail(String email);

}
