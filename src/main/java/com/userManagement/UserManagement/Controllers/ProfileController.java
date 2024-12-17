package com.userManagement.UserManagement.Controllers;

import com.userManagement.UserManagement.Entity.ProfileEntity;

import com.userManagement.UserManagement.Services.ProfileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/profile/")
public class ProfileController {

    @Autowired
    private ProfileServices profileServices;

    @GetMapping
    List<ProfileEntity> getAll(){
        return this.profileServices.getAll();
    }
    @PostMapping()
    ResponseEntity<ProfileEntity> post(@RequestBody ProfileEntity profileEntity){
        return this.profileServices.post(profileEntity);
    }

    @GetMapping("{id}")
    ResponseEntity<ProfileEntity> getById(@PathVariable UUID id){
        return  this.profileServices.getById(id);
    }

    @PutMapping("{id}")
    ResponseEntity<ProfileEntity> update(@PathVariable UUID id,@RequestBody ProfileEntity profileEntity){
        return  this.profileServices.update(id,profileEntity);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id){
        return this.profileServices.deleteById(id);
    }
}
