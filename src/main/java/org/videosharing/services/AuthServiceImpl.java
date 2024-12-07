package org.videosharing.services;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.videosharing.domain.AuthModel;
import org.videosharing.repo.AuthRepo;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private AuthRepo repo;

    @Override
    @Transactional
    public String loginAccess(String username, String password) {
        AuthModel user = repo.findByLogin(username);
        if (user.getPassword().equals(password)) {
            return "Access granted";
        }
        return "Access denied";
    }
}


