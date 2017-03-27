package co.alexwilkinson.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{
	
	public User findByEmail(String email);
	
	public User findById(Long id);
	
	public User findByUsername(String username);
	
}
