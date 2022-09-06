package com.backend.season_checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
@CrossOrigin
public class MainController {

	@Autowired
	private ConnectRepository userRepository;

	@GetMapping(path = "/all")
	@ResponseBody
	public Iterable<LebensmittelEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(path = "/addEntity/{name}/{anfangsDatum}/{endDatum}/{isFavorit}", method = RequestMethod.GET)
	@ResponseBody
	public String getTest(
			@PathVariable String name,
			@PathVariable String anfangsDatum,
			@PathVariable String endDatum,
			@PathVariable boolean isFavorit) {

		LebensmittelEntity entity = new LebensmittelEntity(name, anfangsDatum, endDatum, isFavorit);
		userRepository.save(entity);

		return "Entity erzeugt: "
				+ name + " "
				+ anfangsDatum + " "
				+ endDatum + " "
				+ isFavorit;
	}
}