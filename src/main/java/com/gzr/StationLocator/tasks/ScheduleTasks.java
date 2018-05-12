package com.gzr.StationLocator.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gzr.StationLocator.helpers.MailClient;
import com.gzr.StationLocator.models.Station;
import com.gzr.StationLocator.repos.StationRepo;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class ScheduleTasks {
	
	private StationRepo stationRepo;
	private MailClient mailClient;
	private static int changePage=0;


	@Autowired
	public ScheduleTasks(StationRepo stationRepo,MailClient mailClient)
	{
		this.stationRepo = stationRepo;
		this.mailClient = mailClient;
	}
	
	
	
	@Scheduled(fixedRate=50000)
	public void schedule1()
	{
		
		List<Station> stanice = stationRepo.findAll(new PageRequest(changePage, 1)).getContent();
		
		changePage++;
		
		if(changePage>5)
		{
			changePage=0;
		}
		
		stanice.stream()
		.map(stanica->stanica.getNaziv())
		.forEach(item->System.out.println(item));
		
		
		
		
		
		
		
	}

}
