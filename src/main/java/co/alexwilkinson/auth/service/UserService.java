package co.alexwilkinson.auth.service;

import co.alexwilkinson.models.User;

public interface UserService {
	void save(User user);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public User findById(Long id);
}
