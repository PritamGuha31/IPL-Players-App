package com.ipl.springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="player_name")
	private String playerName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="team")
	private String team;
	
	@Column(name="nationality")
	private String nationality;
	
	public Player(){}

	public Player(String playerName, String role, String team,
			String nationality) {
		this.playerName = playerName;
		this.role = role;
		this.team = team;
		this.nationality = nationality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", role="
				+ role + ", team=" + team + ", nationality=" + nationality
				+ "]";
	}
	
}
