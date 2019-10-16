package com.ipl.springboot.thymeleafdemo.service;

import java.util.List;

import com.ipl.springboot.thymeleafdemo.entity.Player;

public interface PlayerService {

	public List<Player> findAll();
	
	public Player findById(int id);
	
	public void save(Player player);
	
	public void deleteById(int id);
}
