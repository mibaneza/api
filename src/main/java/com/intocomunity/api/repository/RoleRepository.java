package com.intocomunity.api.repository;


import com.intocomunity.api.dominio.ERole;
import com.intocomunity.api.dominio.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByName(ERole name);

}
