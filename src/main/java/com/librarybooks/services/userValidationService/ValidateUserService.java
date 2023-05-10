package com.librarybooks.services.userValidationService;

import com.librarybooks.models.LoginCredentialsEntity;

public interface ValidateUserService {
    public String validateUser (LoginCredentialsEntity loginCredentialsEntity);
}
