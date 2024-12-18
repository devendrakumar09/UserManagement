package com.userManagement.UserManagement.Services.ServicesImp;

import com.userManagement.UserManagement.Entity.ProfileEntity;
import com.userManagement.UserManagement.Entity.UsersEntity;
import com.userManagement.UserManagement.Repository.ProfileRepo;
import com.userManagement.UserManagement.Services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiecesImp implements ProfileServices {

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public List<ProfileEntity> getAll() {
        return this.profileRepo.findAll();
    }

    @Override
    public ResponseEntity<ProfileEntity> getById(long id) {
        Optional<ProfileEntity> profile = this.profileRepo.findById(id);
        if (profile.isPresent()){
            ProfileEntity existprofile = profile.get();
            return new ResponseEntity<>(existprofile, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ProfileEntity> post(ProfileEntity profileEntity) {
        try{
            ProfileEntity profile = new ProfileEntity();
            profile.setCity(profileEntity.getCity());
            profile.setContact(profileEntity.getContact());
            profile.setZip_code(profileEntity.getZip_code());
            this.profileRepo.save(profile);
            return  new ResponseEntity<>(profile,HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProfileEntity> update(long id, ProfileEntity profileEntity) {
        Optional<ProfileEntity> profile = this.profileRepo.findById(id);
        if (profile.isPresent()){
            ProfileEntity getProfile= profile.get();

            getProfile.setCity(profileEntity.getCity());
            getProfile.setContact(profileEntity.getContact());
            getProfile.setZip_code(profileEntity.getZip_code());

            this.profileRepo.save(getProfile);

            this.profileRepo.save(getProfile);
            return new ResponseEntity<>(getProfile, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteById(long id) {
        Optional<ProfileEntity> profile = this.profileRepo.findById(id);
        if (profile.isPresent()){
            this.profileRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
