package org.videosharing.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.videosharing.domain.AuthModel;
import org.videosharing.domain.UserModel;
import org.videosharing.repo.AuthRepo;
import org.videosharing.repo.UsersRepo;

@Service
@AllArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {
    private UsersRepo repoU;

    @Override
    @Transactional
    public String createUser(String login, String password) {
        if (repoU.findByLogin(login)) {
            return "User already exists";
        }
        UserModel createdUser = new UserModel();
        createdUser.setLogin(login);
        createdUser.setPassword(password);
        repoU.save(createdUser);
        return "User created";
    }
}
