package co.alexwilkinson.models;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Long>{
	
	public Employee findByEmployeecode(String employeecode);
	
	public Employee findByEmail(String email);
	
	public Employee findByPosition(String position);

}
