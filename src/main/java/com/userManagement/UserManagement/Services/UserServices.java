package com.userManagement.UserManagement.Services;

import com.userManagement.UserManagement.Entity.UsersEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServices {

    List<UsersEntity> getAll();
    ResponseEntity<UsersEntity> getById(long id);
    ResponseEntity<UsersEntity> post(UsersEntity usersEntity);
    ResponseEntity<UsersEntity> update(long id, UsersEntity usersEntity);
    ResponseEntity<Void> deleteById(long id);
}
