package com.example.discover.controller;

import com.example.discover.model.Profile;
import com.example.discover.service.DiscoverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiscoverController {
    private final DiscoverService discoverService;

    public DiscoverController(DiscoverService discoverService) {
        this.discoverService = discoverService;
    }

    @GetMapping("/retrieveprofile")
    public ResponseEntity<Profile> getProfile(@RequestBody String cardNumber) {
        Profile profile = discoverService.findProfileByCardNumber(cardNumber);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/addprofile")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        Profile newProfile = discoverService.addProfile(profile);
        return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
    }

    @PutMapping("/updateprofile")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        Profile updatedProfile = discoverService.updateProfile(profile);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }
}
