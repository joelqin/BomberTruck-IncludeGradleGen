package com.mygdx.bombertruckbackend;


public class MapObject {
	
	// default object just empty space
	
	public boolean penetratable = true;
	public boolean playerPassable = true;
	protected Maplocation myLocObj = null; 
	
	public MapObject (Maplocation locObj) {
		myLocObj = locObj;
	}
	
	public boolean onDetenate() {
		return true;
	}
}