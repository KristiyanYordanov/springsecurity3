package com.kris.ss;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("players")
public class PlayerController {

	@RequestMapping(value = "/user/player", method = RequestMethod.GET)
	public String player(ModelMap model) throws Exception {
		PlayerModel playerModel = new PlayerModel();
		List<Player> res = playerModel.readWithCsvBeanReader();
		model.addAttribute("players", res);
		model.addAttribute("fileHeader",
				Arrays.toString(playerModel.getHeaders()));

		return "user/player";
	}

	@RequestMapping(value = "/user/import", method = RequestMethod.POST)
	public View uploadPlayer(@RequestParam("myFile") final MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("test" + "-uploaded")));
				stream.write(bytes);
				stream.close();
				Reader reader = new InputStreamReader(new ByteArrayInputStream(bytes));
				BufferedReader bf = new BufferedReader(reader);
				String line = bf.readLine();
				while (line != null) {
					String[] players = line.split(",");
					Player player = new Player();
					line = bf.readLine();
				}
				return new RedirectView("/raviser/Player");
			} catch (Exception e) {
				return new RedirectView("/raviser/Player");
			}
		} else {
			return new RedirectView("/raviser/Player");
		}
	}
}
