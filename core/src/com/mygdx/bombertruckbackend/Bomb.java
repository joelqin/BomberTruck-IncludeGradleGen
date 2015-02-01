package com.mygdx.bombertruckbackend;
import com.mygdx.bombertruckbackend.MapObject;
import com.mygdx.bombertruckbackend.Maplocation;


public class Bomb extends MapObject {

	private int bombPower = 0;
	private int bombTimer = 0;
	
	public Bomb(Maplocation locObj) {
		super(locObj);
		this.playerPassable = false;
		this.penetratable = false;
	}
	
	public boolean setBombPower(int power) {
		if (power == 0) {
			bombPower = power;
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean setBombTimer(int time) {
		if (time == 0) {
			bombTimer = time;
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean onExplode() {
		bombTimer = 0;
		Maplocation nextLoc = myLocObj.upLocation();
		for (int upCount = 0; upCount < bombPower; upCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
				mapObj.onDetenate();
				nextLoc = nextLoc.upLocation();
			}
			
		}
		
		nextLoc = myLocObj.downLocation();
		for (int downCount = 0; downCount < bombPower; downCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
				mapObj.onDetenate();
				nextLoc = nextLoc.downLocation();
			}
		}
		
		nextLoc = myLocObj.leftLocation();
		for (int leftCount = 0; leftCount < bombPower; leftCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
			
				mapObj.onDetenate();
				nextLoc = nextLoc.leftLocation();
			}
			
		}
		
		nextLoc = myLocObj.rightLocation();
		for (int rightCount = 0; rightCount < bombPower; rightCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
				mapObj.onDetenate();
				nextLoc = nextLoc.rightLocation();
			}
		}
		return true;
	}
	
	
	public boolean onDetenate() {
		onExplode();
		return true;
	}
}
