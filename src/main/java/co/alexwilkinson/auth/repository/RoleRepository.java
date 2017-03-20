package co.alexwilkinson.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.alexwilkinson.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
