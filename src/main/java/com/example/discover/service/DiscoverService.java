package com.example.discover.service;

import com.example.discover.model.Profile;
import com.example.discover.repo.DiscoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return discoverRepo.save(profile);
    }

    public Profile findProfileByCardNumber(String cardNumber) {
        return discoverRepo.findProfileByCardNumber(cardNumber).orElseThrow(() -> new RuntimeException("Profile with card number: " + cardNumber + " was not found."));
    }
}
