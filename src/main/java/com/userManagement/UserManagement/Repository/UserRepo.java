package com.userManagement.UserManagement.Repository;

import com.userManagement.UserManagement.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UsersEntity, UUID> {
}
