package com.gzr.StationLocator.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzr.StationLocator.helpers.MailClient;
import com.gzr.StationLocator.models.Station;
import com.gzr.StationLocator.models.StationStripped;
import com.gzr.StationLocator.repos.StationRepo;

@RestController
@RequestMapping(value="/api/stations")
public class StationController {

	private StationRepo repo;
	private MailClient mailClient;
	
	@Autowired
	public StationController(StationRepo repository,MailClient mailClient)
	{
		this.repo = repository;
		this.mailClient = mailClient;
	}
	
	@GetMapping()
	public  ResponseEntity<List<Station>> getAll()
	{
		return new ResponseEntity<List<Station>>(repo.findAll(),HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/{Vrsta}")
	public  ResponseEntity<?> getAllByVrstaStripped(@PathVariable("Vrsta") String Vrsta,@RequestParam(value="strip",defaultValue="false") boolean stripp)
	{
		
		if(stripp)
		{
			List<StationStripped> strippedList = repo.findAll().stream().map(station->new StationStripped(station.getNaziv())).collect(Collectors.toList());
			return new ResponseEntity<List<StationStripped>>(strippedList,HttpStatus.OK);
		}
		else
		{
		
		List<Station> myList = repo.findAll().parallelStream().filter(stanica->stanica.getVrsta().equals(Vrsta)).collect(Collectors.toList());
		
		
		
		return new ResponseEntity<List<Station>>(myList,HttpStatus.OK);
		}
		
	}
	@GetMapping("/mail")
	public ResponseEntity<String> sendMail()
	{
		mailClient.prepareAndSendHTML("ivn.males@gmail.com", "Hello from Spring");
		
		return new ResponseEntity<String>("sent",HttpStatus.OK);
		
	}
	
	
	
}
