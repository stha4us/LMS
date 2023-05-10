package com.librarybooks.services.userValidationService;

import com.librarybooks.daos.userValidationDao.ValidateUserDao;
import com.librarybooks.models.LoginCredentialsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class validateUserServiceImpl implements ValidateUserService{

    @Autowired
    ValidateUserDao validateUserDao;

    @Override

    public String validateUser(LoginCredentialsEntity loginCredentialsEntity){
        List<LoginCredentialsEntity> response=validateUserDao.validateUser(loginCredentialsEntity );


        String validator=new String ("0");
        if (response.size()==0){
            validator="0";
        }
        else{
            validator="1";
        }
        return validator;
    }


}

