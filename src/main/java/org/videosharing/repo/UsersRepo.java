package org.videosharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.videosharing.domain.AuthModel;
import org.videosharing.domain.UserModel;

@Repository
public interface UsersRepo extends JpaRepository<UserModel, Long> {
    boolean findByLogin(String login);
}
