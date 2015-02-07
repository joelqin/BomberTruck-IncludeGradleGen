package com.mygdx.bombertruckgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.bombertruckbackend.GameCycleController;
import com.mygdx.bombertruckbackend.Map;
import com.mygdx.bombertruckbackend.PlayerController;

public class ClientConnector {
	
	GameCycleController connection;
	PlayerController playerController;
	
	public ClientConnector() {
		connection = new GameCycleController(new Map(5,5, true));
		playerController = getPlayerController();
	}
	
	public Map getMap() {
		return connection.sentMap();
	}
	
	public PlayerController getPlayerController() {
		return connection.testControlPlayerOne();
	}
	
	public void update() {
		if (Gdx.input.isKeyPressed(Keys.A)) {
			playerController.enqueueCommand("A");
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			playerController.enqueueCommand("D");
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			playerController.enqueueCommand("W");
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			playerController.enqueueCommand("S");
		}
		if (Gdx.input.isKeyPressed(Keys.B)) {
			playerController.enqueueCommand("B");
		}
		
		//this going to be replace with a server side cycling when the project goes to web
		connection.onCycle();
	}
}
