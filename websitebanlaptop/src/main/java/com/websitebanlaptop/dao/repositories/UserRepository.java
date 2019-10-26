package com.websitebanlaptop.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.websitebanlaptop.dao.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query(value = "SELECT u FROM UserEntity u WHERE u.userName = :username")
	UserEntity findByUserName(@Param("username") String username);
}
