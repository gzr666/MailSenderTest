package com.gzr.StationLocator.models;

public class StationStripped {
	
	
	public StationStripped(){}
	public StationStripped(String name)
	{
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
