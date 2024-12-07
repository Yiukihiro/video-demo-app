package org.videosharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.videosharing.domain.AuthModel;
import org.videosharing.domain.VideoModel;

import java.util.List;

@Repository
public interface AuthRepo extends JpaRepository<AuthModel, Long> {
    AuthModel findByLogin(String login);
}
