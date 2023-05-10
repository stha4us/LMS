package com.librarybooks.controllers;

import com.librarybooks.models.LoginCredentialsEntity;
import com.librarybooks.pojos.ResponseData;
import com.librarybooks.services.userValidationService.ValidateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class ValidateUser {

    @Autowired
    private ValidateUserService validateUserService;


    @RequestMapping (value="/validateUser", method= RequestMethod.POST)
    public ResponseEntity <ResponseData>validateUser(@RequestBody LoginCredentialsEntity loginCredentials){

        String response=validateUserService.validateUser(loginCredentials);

        /*System.out.println(loginCredentials.getUsername());
        System.out.println(loginCredentials.getPassword());
        System.out.println("Result of our user Validation is below");
        System.out.println(response);
        */

        ResponseData responseData=new ResponseData("Server connected!","200",response);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);

    }

}
