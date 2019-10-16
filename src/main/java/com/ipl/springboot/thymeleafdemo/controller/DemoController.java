package com.ipl.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipl.springboot.thymeleafdemo.entity.Player;
import com.ipl.springboot.thymeleafdemo.service.PlayerService;

@Controller
public class DemoController {

	private PlayerService playerService;
	
	@Autowired
	public DemoController(PlayerService thePlayerService){
		playerService = thePlayerService;
	}
	
	@GetMapping("/hello")
	public String sayHello(Model theModel){
		theModel.addAttribute("theDate", new java.util.Date());
		return "helloworld";
	}
	
	@GetMapping("/list")
	public String listPlayers(Model theModel){
		List<Player> thePlayers = playerService.findAll();
		theModel.addAttribute("players", thePlayers);
		return "players/list-players";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Player thePlayer = new Player();
		theModel.addAttribute("player", thePlayer);
		return "players/player-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("player") Player thePlayer){
		playerService.save(thePlayer);
		return "redirect:/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int theId, Model theModel){
		Player thePlayer = playerService.findById(theId);
		theModel.addAttribute("player", thePlayer);
		return "players/player-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("playerId") int theId){
		playerService.deleteById(theId);
		return "redirect:/list";
	}
	
}
