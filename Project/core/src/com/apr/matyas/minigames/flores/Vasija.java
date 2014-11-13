package com.apr.matyas.minigames.flores;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Vasija extends Actor{

	private Fraccion fraccion;
	
	public Vasija(Fraccion fraccion, String name, int x, int y){
		this.fraccion = fraccion;
		this.setName(name);
		this.setX(x);
		this.setY(y);
		
	}
	
	
	public void draw(SpriteBatch batch, TextureAtlas atlas, BitmapFont font){
		batch.draw(atlas.findRegion("vajilla"),getX(), getY());
		batch.draw(atlas.findRegion(getName()),getX()+25, getY()+50);
		font.draw(batch, fraccion.toString(), getX(), getY());
	}
}
