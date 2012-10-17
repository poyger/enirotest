
package com.eniro.test.json;

import java.util.List;

public class Location{
   	private List<Coordinates> coordinates;

 	public List<Coordinates> getCoordinates(){
		return this.coordinates;
	}
	public void setCoordinates(List<Coordinates> coordinates){
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "Location [coordinates=" + coordinates + "]";
	}
}
