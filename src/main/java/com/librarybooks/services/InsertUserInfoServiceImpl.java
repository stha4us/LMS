package com.librarybooks.services;

import com.librarybooks.daos.InsertUserInfoDao;
import com.librarybooks.models.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertUserInfoServiceImpl implements InsertUserInfoService{

    @Autowired
    InsertUserInfoDao insertUserInfoDao;
    @Override
    public String insertUserInfo (UserInformation userInfo){
        String response=insertUserInfoDao.insertUserInfo(userInfo);
        return response;
    }

}

