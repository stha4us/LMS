package com.librarybooks.services;

import com.librarybooks.models.UserInformation;

import java.util.List;

public interface ReadUserInfoService {
    public List<UserInformation> readUserInformation();
}