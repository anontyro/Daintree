package co.alexwilkinson.auth.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.alexwilkinson.auth.service.UserService;
import co.alexwilkinson.models.User;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserService userService;
	

	@Override
	public boolean supports(Class<?> theClass) {
	
		return User.class.equals(theClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		User user = (User) obj;
		
		//Username validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length() < 6 || user.getUsername().length() > 36){
			errors.rejectValue("username", "Size.userForm.username");
		}
		
		if(userService.findByUsername(user.getUsername()) != null){
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
		//Password validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
	}

}
