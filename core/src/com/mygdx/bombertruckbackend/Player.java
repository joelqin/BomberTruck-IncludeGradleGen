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
		if ((myLocObj.upLocation() != null) && (myLocObj.upLocation().getMapObject().playerPassable)) {
			myLocObj.setMapObject(new MapObject(myLocObj));
			// if leaving a detenating square, the new create square will
			// detenate
			myLocObj.getMapObject().setDetenate(getDetenate());
			myLocObj.getMapObject().setCycleMuxTrue();
			// if arriving a detenating square, this will detenate
			setDetenate(myLocObj.upLocation().getMapObject().getDetenate());

			myLocObj.upLocation().setMapObject(this);
			myLocObj = myLocObj.upLocation();

			setCycleMuxTrue();
			return true;
		} else {
			setCycleMuxTrue();
			return false;
		}

	}

	public boolean moveDown() {

		if ((myLocObj.downLocation() != null)  && (myLocObj.downLocation().getMapObject().playerPassable)) {

			myLocObj.setMapObject(new MapObject(myLocObj));

			// if leaving a detenating square, the new create square will
			// detenate
			myLocObj.getMapObject().setDetenate(getDetenate());
			myLocObj.getMapObject().setCycleMuxTrue();
			// if arriving a detenating square, this will detenate
			setDetenate(myLocObj.downLocation().getMapObject().getDetenate());

			myLocObj.downLocation().setMapObject(this);
			myLocObj = myLocObj.downLocation();

			setCycleMuxTrue();
			return true;
		} else {
			setCycleMuxTrue();
			return false;
		}
	}

	public boolean moveLeft() {
		if ((myLocObj.leftLocation() != null)  && (myLocObj.leftLocation().getMapObject().playerPassable)) {
			myLocObj.setMapObject(new MapObject(myLocObj));

			// if leaving a detenating square, the new create square will
			// detenate
			myLocObj.getMapObject().setDetenate(getDetenate());
			myLocObj.getMapObject().setCycleMuxTrue();
			// if arriving a detenating square, this will detenate
			setDetenate(myLocObj.leftLocation().getMapObject().getDetenate());

			myLocObj.leftLocation().setMapObject(this);
			myLocObj = myLocObj.leftLocation();

			setCycleMuxTrue();
			return true;
		} else {
			setCycleMuxTrue();
			return false;
		}
	}

	public boolean moveRight() {
		if ((myLocObj.rightLocation() != null) && (myLocObj.rightLocation().getMapObject().playerPassable)) {
			myLocObj.setMapObject(new MapObject(myLocObj));

			// if leaving a detenating square, the new create square will
			// detenate
			myLocObj.getMapObject().setDetenate(getDetenate());
			myLocObj.getMapObject().setCycleMuxTrue();
			// if arriving a detenating square, this will detenate
			setDetenate(myLocObj.rightLocation().getMapObject().getDetenate());

			myLocObj.rightLocation().setMapObject(this);
			myLocObj = myLocObj.rightLocation();

			setCycleMuxTrue();
			return true;
		} else {
			setCycleMuxTrue();
			return false;
		}
	}

}
