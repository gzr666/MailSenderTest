package com.gzr.StationLocator.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gzr.StationLocator.models.Station;

@Repository
public interface StationRepo extends MongoRepository<Station, String> {
	
	public List<Station> findByvrsta(String vrsta);
	
	

}
