package com.project.fooddeliveryproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.fooddeliveryproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailIdAndPassword(String emailId,String password);
	Optional<User> findByEmailId(String emailId);
	@Transactional
	void deleteUserByEmailId(String emailId);
}
