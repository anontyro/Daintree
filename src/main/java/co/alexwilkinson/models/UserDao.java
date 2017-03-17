package co.alexwilkinson.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{
	
	public User findByEmail(String email);
	
//	public List<User> findall();

}
