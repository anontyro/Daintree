package co.alexwilkinson.auth.service;

import co.alexwilkinson.models.User;

public interface UserService {
	void save(User user);
	
	User findByUsername(String username);
}
