package com.example.discover.service;

import com.example.discover.model.Profile;
import com.example.discover.repo.DiscoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscoverService {
    private final DiscoverRepo discoverRepo;

    @Autowired
    public DiscoverService(DiscoverRepo discoverRepo) {
        this.discoverRepo = discoverRepo;
    }

    public Profile addProfile(Profile profile) {
        return discoverRepo.save(profile);
    }

    public Profile updateProfile(Profile profile) {
        Optional<Profile> oldProfile = discoverRepo.findProfileByCardNumber(profile.getCardNumber());
        if (oldProfile.isPresent()) {
            Profile p = oldProfile.get();
            p.setPoints(profile.getPoints());
            return discoverRepo.save(p);
        } else {
            throw new RuntimeException("Profile with card number: " + profile.getCardNumber() + " does not exist.");
        }
    }

    public Profile findProfileByCardNumber(String cardNumber) {
        return discoverRepo.findProfileByCardNumber(cardNumber).orElseThrow(() -> new RuntimeException("Profile with card number: " + cardNumber + " does not exist."));
    }
}
