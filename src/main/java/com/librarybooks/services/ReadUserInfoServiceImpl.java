package com.librarybooks.services;

import com.librarybooks.daos.ReadUserInfoDao;
import com.librarybooks.models.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadUserInfoServiceImpl implements ReadUserInfoService{

    @Autowired
    ReadUserInfoDao readUserInfoDao;

    @Override
    public List <UserInformation> readUserInformation(){
        return readUserInfoDao.getUserInfo();
    }


}
