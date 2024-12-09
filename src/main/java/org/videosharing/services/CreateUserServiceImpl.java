package org.videosharing.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.videosharing.domain.AuthModel;
import org.videosharing.domain.UserModel;
import org.videosharing.repo.AuthRepo;

@Service
@AllArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {
    private AuthRepo repo;

    @Override
    @Transactional
    public String createUser(String login, String password) {
        UserModel userModel = new UserModel(login, password);
        if (userModel.equals(repo.findByLogin(login))) {
            //todo create db acc ~ can't
            return "Account has been Created";
        }
        //todo new form for login
        return "Login has duplicate";
    }
}
