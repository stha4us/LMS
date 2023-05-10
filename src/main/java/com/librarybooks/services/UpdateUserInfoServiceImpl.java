package com.librarybooks.services;


import com.librarybooks.daos.UpdateUserDataDao;
import com.librarybooks.models.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UpdateUserInfoServiceImpl implements UpdateUserInfoService {
    @Autowired
    UpdateUserDataDao updateUserDataDao;
    @Override

    public String updateUserInfo (UserInformation userInformation){

        return updateUserDataDao.updateUserDataDao(userInformation);

    }
}
