package co.alexwilkinson.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.alexwilkinson.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public User findById(Long id);

}
