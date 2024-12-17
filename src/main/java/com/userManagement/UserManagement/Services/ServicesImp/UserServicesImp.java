package com.userManagement.UserManagement.Services.ServicesImp;

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
    public ResponseEntity<UsersEntity> getById(UUID id) {
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
            UsersEntity user = new UsersEntity();
            user.setName(usersEntity.getName());
            user.setUsername(usersEntity.getUsername());
            user.setPassword(usersEntity.getPassword());
            this.userRepo.save(user);
            return  new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UsersEntity> update(UUID id, UsersEntity usersEntity) {
        Optional<UsersEntity> user = this.userRepo.findById(id);
        if (user.isPresent()){
            UsersEntity existUser = user.get();
            existUser.setName(usersEntity.getName());
            existUser.setUsername(usersEntity.getUsername());
            existUser.setPassword(usersEntity.getPassword());
            this.userRepo.save(existUser);
            return new ResponseEntity<>(existUser, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        Optional<UsersEntity> user = this.userRepo.findById(id);
        if (user.isPresent()){
            this.userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
