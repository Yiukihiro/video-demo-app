package org.videosharing.services;


public interface AuthService {
    String loginAccess(String username, String password);
    String createUser(String login, String password);
}
