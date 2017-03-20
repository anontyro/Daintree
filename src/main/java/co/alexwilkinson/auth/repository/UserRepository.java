package co.alexwilkinson.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.alexwilkinson.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
