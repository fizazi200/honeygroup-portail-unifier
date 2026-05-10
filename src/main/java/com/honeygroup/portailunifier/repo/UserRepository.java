package com.honeygroup.portailunifier.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.honeygroup.portailunifier.bo.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
