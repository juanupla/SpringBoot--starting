package com.example.VideoLabo.repositories.jpa;


import com.example.VideoLabo.entities.PlayerEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {

    Optional<PlayerEntity> findByUserNameOrEmail(String username, String email);
}
