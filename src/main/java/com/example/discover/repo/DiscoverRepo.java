package com.example.discover.repo;

import com.example.discover.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscoverRepo extends JpaRepository<Profile, Long> {

    Optional<Profile> findProfileByCardNumber(String cardNumber);
}
