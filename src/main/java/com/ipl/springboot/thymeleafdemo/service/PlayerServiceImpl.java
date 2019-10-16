package com.ipl.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.springboot.thymeleafdemo.dao.PlayerRepository;
import com.ipl.springboot.thymeleafdemo.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository thePlayerRepository){
		playerRepository = thePlayerRepository;
	}
	
	@Override
	public List<Player> findAll() {
		return playerRepository.findAllByOrderByPlayerNameAsc();
	}

	@Override
	public Player findById(int id) {
		Optional<Player> result = playerRepository.findById(id);
		
		Player thePlayer = null;
		
		if (result.isPresent()) {
			thePlayer = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find player id - " + id);
		}
		
		return thePlayer;
	}

	@Override
	public void save(Player player) {
		playerRepository.save(player);
	}

	@Override
	public void deleteById(int id) {
		playerRepository.deleteById(id);
	}

}
