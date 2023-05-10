package com.librarybooks.services;

import com.librarybooks.daos.DeleteUserDataDao;
import com.librarybooks.models.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserDataServiceImpl implements DeleteUserDataService {

    @Autowired

    private DeleteUserDataDao deleteUserDataDao;
    @Override
    public String deleteUserData(UserInformation userInformation) {
        return deleteUserDataDao.deleteUserData(userInformation);
    }

}
