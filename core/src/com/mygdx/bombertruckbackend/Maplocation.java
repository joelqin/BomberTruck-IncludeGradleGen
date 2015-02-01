package com.mygdx.bombertruckbackend;
import com.mygdx.bombertruckbackend.MapObject;


public class Maplocation {
	private Map myMap = null;
	private int myLocationX = 0;
	private int myLocationY = 0;
	private MapObject myObject = null;
	
	public Maplocation (int x, int y, Map map) {
		myLocationX = x;
		myLocationY = y;
		myMap = map;
	}
	
	public boolean setMapObject (MapObject obj) {
		myObject = obj;
		return true;
	}
	
	public MapObject getMapObject() {
		return myObject;
	}
	
	public Maplocation upLocation() {
		if (myMap == null) {
			return null;
		} else {
			return myMap.getLocation(myLocationX, myLocationY + 1);	
		}		
	}
	
	public Maplocation downLocation() {
		if (myMap == null) {
			return null;
		} else {
			return myMap.getLocation(myLocationX, myLocationY - 1);	
		}	
	}
	
	public Maplocation leftLocation() {
		if (myMap == null) {
			return null;
		} else {
			return myMap.getLocation(myLocationX - 1, myLocationY);	
		}	
	}
	

	public Maplocation rightLocation() {
		if (myMap == null) {
			return null;
		} else {
			return myMap.getLocation(myLocationX + 1, myLocationY);	
		}	
	}
}
