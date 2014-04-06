package com.kris.ss;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("players")
public class PlayerController {

	@RequestMapping(value="/user/player", method = RequestMethod.GET)
	public String player(ModelMap model) throws Exception
	{
		PlayerModel playerModel = new PlayerModel();
		List<Player> res = playerModel.readWithCsvBeanReader();
		model.addAttribute("players", res);
		model.addAttribute("fileHeader", Arrays.toString(playerModel.getHeaders()));
		
		return "user/player";
	}
}
