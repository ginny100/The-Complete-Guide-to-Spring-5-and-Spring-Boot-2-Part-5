package io.datajek.databaserelationships.service;

import io.datajek.databaserelationships.onetoone.Player;
import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> allPlayers() {
        return repo.findAll();
    }

    public Player getPlayer(int id) {
        return repo.findById(id).get();
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        return repo.save(player);
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile) {
        Player player = repo.findById(id).get();
        player.setPlayerProfile(profile);
        return repo.save(player);
    }

}
