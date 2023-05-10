package com.librarybooks.controllers;


import com.librarybooks.models.UserInformation;
import com.librarybooks.pojos.ResponseData;
import com.librarybooks.services.DeleteUserDataService;
import com.librarybooks.services.InsertUserInfoService;
import com.librarybooks.services.ReadUserInfoService;
import com.librarybooks.services.UpdateUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller

public class MemberController {
    @Autowired
    InsertUserInfoService insertUserInfoService;

    @Autowired
    ReadUserInfoService readUserInfoService;

    @Autowired
    private DeleteUserDataService deleteUserDataService;

    @Autowired
    private UpdateUserInfoService updateUserInfoService;

    @GetMapping({"/frontEnd"})
    public String indexPage(){
        return "index";
    }
    @RequestMapping(method = RequestMethod.POST, value="/insertUserData")
    public ResponseEntity <ResponseData> InsertData(@RequestBody UserInformation userInfo){

        String response=insertUserInfoService.insertUserInfo(userInfo);
        ResponseData responseData=new ResponseData ("Server Connected!", "200",response);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST,value="/getUserData")
    public ResponseEntity<ResponseData> ReadData(){

        ResponseData responseData=new ResponseData("Server Connected!","200",readUserInfoService.readUserInformation());
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST, value="/userdata/delete")
    public ResponseEntity <ResponseData> DeleteData (@RequestBody UserInformation userInformation){
        System.out.println(userInformation.getId());
        System.out.println(userInformation.getUsername());
        ResponseData responseData=new ResponseData("Server Connected!","200",deleteUserDataService.deleteUserData(userInformation));
        return new ResponseEntity<ResponseData>(responseData,HttpStatus.OK);
    }

    @RequestMapping (method =RequestMethod.POST, value="/updateData")
    public ResponseEntity <ResponseData> UpdateData (@RequestBody UserInformation userInformation){
        System.out.println(userInformation.getUsername());
        System.out.println(userInformation.getId());
        System.out.println(userInformation.getContact());
        System.out.println(userInformation.getAddress());
        ResponseData responseData =new ResponseData("Server Connected!","200", updateUserInfoService.updateUserInfo(userInformation));
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);

    }






}
