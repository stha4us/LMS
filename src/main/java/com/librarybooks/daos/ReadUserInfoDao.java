package com.librarybooks.daos;

import com.librarybooks.models.UserInformation;

import java.util.List;

public interface ReadUserInfoDao {

    public List<UserInformation> getUserInfo();
}
