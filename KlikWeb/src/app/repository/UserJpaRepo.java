package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserJpaRepo extends JpaRepository<User, String>{
	
	public User findByUsernameAndPassword(String username,String password);
	
}
