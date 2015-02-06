package com.mygdx.bombertruckbackend;


public class Player extends MapObject {

	private int bombTimer = 3;
	private int bombPower = 1;
	private String playerID = null;
	
	
	public Player(Maplocation locObj) {
		super(locObj);
		this.objectName = "Player";
		this.playerPassable = false;
		this.penetratable = true;
		// TODO Auto-generated constructor stub
	}

	public boolean setPlayerID(String playerID) {
		if (this.playerID == null) {
			this.playerID = playerID;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean moveUp() {
		
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		// if leaving a detenating square, the new create square will detenate	
		this.myLocObj.getMapObject().setDetenate(getDetenate());
		this.myLocObj.getMapObject().setCycleMuxTrue();
		// if arriving a detenating square, this will detenate		
		setDetenate(this.myLocObj.upLocation().getMapObject().getDetenate());
		
		this.myLocObj.upLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.upLocation();
		
		setCycleMuxTrue();
		return true;
	}
	
	public boolean moveDown() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		
		// if leaving a detenating square, the new create square will detenate
		this.myLocObj.getMapObject().setDetenate(getDetenate());
		this.myLocObj.getMapObject().setCycleMuxTrue();
		// if arriving a detenating square, this will detenate		
		setDetenate(this.myLocObj.downLocation().getMapObject().getDetenate());
		
		this.myLocObj.downLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.downLocation();
		
		setCycleMuxTrue();
		return true;
	}
	
	public boolean moveLeft() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		
		// if leaving a detenating square, the new create square will detenate
		this.myLocObj.getMapObject().setDetenate(getDetenate());
		this.myLocObj.getMapObject().setCycleMuxTrue();
		// if arriving a detenating square, this will detenate		
		setDetenate(this.myLocObj.leftLocation().getMapObject().getDetenate());
		
		this.myLocObj.leftLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.leftLocation();
		
		setCycleMuxTrue();
		return true;
	}
	
	public boolean moveRight() {
		this.myLocObj.setMapObject(new MapObject(this.myLocObj));
		
		// if leaving a detenating square, the new create square will detenate
		this.myLocObj.getMapObject().setDetenate(getDetenate());
		this.myLocObj.getMapObject().setCycleMuxTrue();
		// if arriving a detenating square, this will detenate		
		setDetenate(this.myLocObj.rightLocation().getMapObject().getDetenate());
		
		this.myLocObj.rightLocation().setMapObject(this);
		this.myLocObj = this.myLocObj.rightLocation();
		
		setCycleMuxTrue();
		return true;
	}
	
	
}
