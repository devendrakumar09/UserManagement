package com.userManagement.UserManagement.Controllers;

import com.userManagement.UserManagement.Entity.UsersEntity;
import com.userManagement.UserManagement.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    List<UsersEntity> getAll(){
        return this.userServices.getAll();
    }
    @PostMapping()
    ResponseEntity<UsersEntity> post(@RequestBody  UsersEntity usersEntity){
        return  this.userServices.post(usersEntity);
    }

    @GetMapping("{id}")
    ResponseEntity<UsersEntity> getById(@PathVariable UUID id){
        return  this.userServices.getById(id);
    }

    @PutMapping("{id}")
    ResponseEntity<UsersEntity> update(@PathVariable UUID id,@RequestBody UsersEntity usersEntity){
        return  this.userServices.update(id,usersEntity);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id){
        return this.userServices.deleteById(id);
    }


}
