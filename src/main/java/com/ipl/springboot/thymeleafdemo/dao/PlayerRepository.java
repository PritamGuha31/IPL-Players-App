package com.ipl.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.springboot.thymeleafdemo.entity.Player;

// @RepositoryRestResource(path="members")
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	public List<Player> findAllByOrderByPlayerNameAsc();
}
