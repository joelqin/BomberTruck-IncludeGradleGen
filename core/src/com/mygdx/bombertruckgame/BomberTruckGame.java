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
	SpriteBatch batch;
	//Texture img;
	Texture playerImg;
	Texture roadImg;
	Map mapObj;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		playerImg = new Texture("player.png");
		roadImg = new Texture("road.png");
		mapObj = new Map(5,5, true);
	}

	@Override
	public void render () {
		drawMap();
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
				}
			}
		}
		batch.end();
	}
}
