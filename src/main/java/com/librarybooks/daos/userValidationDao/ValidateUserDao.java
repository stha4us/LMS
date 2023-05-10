package com.librarybooks.daos.userValidationDao;

import com.librarybooks.models.LoginCredentialsEntity;

import java.util.List;

public interface ValidateUserDao {
    public List validateUser (LoginCredentialsEntity loginCredentialsEntity);
}
