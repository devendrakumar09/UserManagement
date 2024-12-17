package com.userManagement.UserManagement.Services;

import com.userManagement.UserManagement.Entity.UsersEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServices {

    List<UsersEntity> getAll();
    ResponseEntity<UsersEntity> getById(UUID id);
    ResponseEntity<UsersEntity> post(UsersEntity usersEntity);
    ResponseEntity<UsersEntity> update(UUID id, UsersEntity usersEntity);
    ResponseEntity<Void> deleteById(UUID id);
}
