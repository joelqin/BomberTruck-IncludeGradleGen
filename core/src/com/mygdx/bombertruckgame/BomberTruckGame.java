package com.mygdx.bombertruckgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bombertruckbackend.Map;

public class BomberTruckGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture playerImg;
	Texture roadImg;
	Map mapObj;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		playerImg = new Texture("player.png");
		roadImg = new Texture("road.png");
		mapObj = new Map(5,5,)
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	public drawMap
}
