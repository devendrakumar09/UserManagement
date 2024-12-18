package com.userManagement.UserManagement.Services.ServicesImp;

import com.userManagement.UserManagement.Entity.ProfileEntity;
import com.userManagement.UserManagement.Entity.UsersEntity;
import com.userManagement.UserManagement.Repository.UserRepo;
import com.userManagement.UserManagement.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.HttpCookie;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UsersEntity> getAll() {
        return this.userRepo.findAll();
    }

    @Override
    public ResponseEntity<UsersEntity> getById(long id) {
        Optional<UsersEntity> user = this.userRepo.findById(id);
        if (user.isPresent()){
            UsersEntity existUser = user.get();
            return new ResponseEntity<>(existUser, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UsersEntity> post(UsersEntity usersEntity) {
        try{
            this.userRepo.save(usersEntity);
            return  new ResponseEntity<>(usersEntity,HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UsersEntity> update(long id, UsersEntity updatedUser) {
         Optional<UsersEntity> userOptional = userRepo.findById(id);

        if (userOptional.isPresent()) {
            UsersEntity existingUser = userOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());

             if (updatedUser.getProfile() != null) {
                ProfileEntity updatedProfile = updatedUser.getProfile();

                if (existingUser.getProfile() == null) {
                     existingUser.setProfile(updatedProfile);
                } else {
                     ProfileEntity existingProfile = existingUser.getProfile();
                    existingProfile.setCity(updatedProfile.getCity());
                    existingProfile.setContact(updatedProfile.getContact());
                    existingProfile.setZip_code(updatedProfile.getZip_code());
                }
            }

             UsersEntity savedUser = userRepo.save(existingUser);

             return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteById(long id) {
        Optional<UsersEntity> user = this.userRepo.findById(id);
        if (user.isPresent()){
            this.userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
