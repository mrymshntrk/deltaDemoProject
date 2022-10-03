package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.AppUser;
import org.springframework.stereotype.Service;

import javax.persistence.SequenceGenerator;
import java.util.List;


public interface UserService {

    //neler yapmak istiyorsak onları oluşturuyoruz.

    AppUser saveUser(AppUser user); //db'ye user kaydeden methot
    void addRoleToUser(String UserName, String roleName); //user'a role ekle.
    void addDepartmentToUser(String UserName, String departmentName); //user'a dept. ekle.
    AppUser getUser(String Email_Address); //db'den user getirir.
    List<AppUser>getUser();

}
