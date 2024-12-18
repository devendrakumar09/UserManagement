package com.userManagement.UserManagement.Services;

import com.userManagement.UserManagement.Entity.ProfileEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProfileServices {

    List<ProfileEntity> getAll();
    ResponseEntity<ProfileEntity> getById(long id);
    ResponseEntity<ProfileEntity> post(ProfileEntity profileEntity);
    ResponseEntity<ProfileEntity> update(long id, ProfileEntity profileEntity);
    ResponseEntity<Void> deleteById(long id);
}
