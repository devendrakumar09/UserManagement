package com.userManagement.UserManagement.Services;

import com.userManagement.UserManagement.Entity.ProfileEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProfileServices {

    List<ProfileEntity> getAll();
    ResponseEntity<ProfileEntity> getById(UUID id);
    ResponseEntity<ProfileEntity> post(ProfileEntity profileEntity);
    ResponseEntity<ProfileEntity> update(UUID id, ProfileEntity profileEntity);
    ResponseEntity<Void> deleteById(UUID id);
}
