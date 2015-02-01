package com.mygdx.bombertruckbackend;


public class Player extends MapObject {

	private int bombTimer = 3;
	private int bombPower = 1;
	
	public Player(Maplocation locObj) {
		super(locObj);
		this.objectName = "Player";
		this.playerPassable = false;
		this.penetratable = true;
		// TODO Auto-generated constructor stub
	}

	public boolean moveUp() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		this.myLocObj.upLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.upLocation();
		return true;
	}
	
	public boolean moveDown() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		this.myLocObj.downLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.downLocation();
		return true;
	}
	
	public boolean moveLeft() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		this.myLocObj.leftLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.leftLocation();
		return true;
	}
	
	public boolean moveRight() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		this.myLocObj.rightLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.rightLocation();
		return true;
	}
}
