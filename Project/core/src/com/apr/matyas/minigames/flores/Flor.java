package com.apr.matyas.minigames.flores;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Flor extends Actor{

	private static final int MAX_X = 600;
	private static final int MAX_Y = 500;
	
	private static final int[] deltas = {-2,-1,0,1,2};
	
	
	public enum FlorType{
		BLUE, YELLOW, RED;
	}
	
	private FlorType type;
	private float dx, dy;
	
	
	public Flor(String name, FlorType type, Random random){
		this.setName(name);
		this.type = type;
		this.setPosition(random.nextInt(MAX_X),random.nextInt(MAX_Y));
		this.dx = deltas[random.nextInt(deltas.length)];
		this.dy = deltas[random.nextInt(deltas.length)];
		
	}
	
	public void update(){
		this.setX(this.getX()+dx);
		this.setY(this.getY()+dy);
		if (getX()>MAX_X || getX()<0)
			this.dx*=-1;
		if (getY()>MAX_Y || getY()<0)
			this.dy*=-1;

	}
	
	public void draw(SpriteBatch batch, TextureAtlas atlas){
		batch.draw(atlas.findRegion(getName()),getX(), getY());
	}
}
