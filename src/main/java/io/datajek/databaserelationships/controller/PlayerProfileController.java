package io.datajek.databaserelationships.controller;

import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService service;

    @GetMapping
    public List<PlayerProfile> allPlayerProfiles() {
        return service.allPlayerProfiles();
    }

    @GetMapping("/{id}")
    public PlayerProfile getPlayerProfile(@PathVariable int id) {
        return service.getPlayerProfile(id);
    }

    @PostMapping
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile playerProfile) {
        return service.addPlayerProfile(playerProfile);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        service.deletePlayerProfile(id);
    }

}
