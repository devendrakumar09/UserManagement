package com.userManagement.UserManagement.Repository;

import com.userManagement.UserManagement.Entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEntity, UUID> {
}
