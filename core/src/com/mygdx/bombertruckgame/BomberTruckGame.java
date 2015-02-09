package com.mygdx.bombertruckgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bombertruckbackend.Map;
import com.mygdx.bombertruckbackend.Maplocation;
import com.mygdx.bombertruckbackend.MapObject;

public class BomberTruckGame extends ApplicationAdapter {
	
	// eventually this is becomes the client
	
	SpriteBatch batch;
	//Texture img;
	Texture playerImg;
	Texture roadImg;
	Texture bombImg;
	Texture playerandbombImg;
	Texture explodeImg;
	Map mapObj;
	ClientConnector connectorObj;
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		playerImg = new Texture("player.png");
		roadImg = new Texture("road.png");
		bombImg = new Texture("bomb.png");
		playerandbombImg = new Texture("playerandbomb.png");
		explodeImg = new Texture("explode.png");
		connectorObj = new ClientConnector();
		mapObj = connectorObj.getMap();
		
	}

	@Override
	public void render () {
		drawMap();
		connectorObj.update();
	}
	
	public void drawMap() {
		int cellWidth = 100;
		int cellHeight = 100;
		
		batch.begin();
		for (int x = 0; x < mapObj.getMapSizeX(); x++) {
			for (int y = 0; y < mapObj.getMapSizeY(); y++) {
				Maplocation mapLocObj = mapObj.getLocation(x,y);
				MapObject mapObjectObj = mapLocObj.getMapObject();
				if (mapObjectObj.objectName.equals("Road")) {
					batch.draw(roadImg, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
				} else if (mapObjectObj.objectName.equals("Player")) {
					batch.draw(playerImg, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
				} else if (mapObjectObj.objectName.equals("Bomb")) {
					batch.draw(bombImg, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
				} else if (mapObjectObj.objectName.equals("PlayerAndBomb")) {
					batch.draw(playerandbombImg, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
				} else if (mapObjectObj.objectName.equals("Explode")) {
					batch.draw(explodeImg, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
				}			
			}
		}
		batch.end();
	}
	
}
