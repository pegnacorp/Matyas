package com.apr.matyas.screens;

import com.apr.matyas.MatyasGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SplashScreen extends AbstractScreen{

	public SplashScreen(MatyasGame game) {
		super(game);
		
	}
	
	@Override
	public void show(){
		super.show();
		
		Table table = super.getTable();
		
		Texture back = new Texture("background.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,1024,768)));
		
		
		game.getAssetManager().load("game.atlas", com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
		game.getAssetManager().load("fonts/default-32.fnt",BitmapFont.class);
		
		
		
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		
		if (game.getAssetManager().update()){
			stage.addAction(Actions.sequence(Actions.delay(2.25f),
											Actions.fadeOut(0.75f),
											new Action(){
												public boolean act(float delta){
													game.setScreen(new MenuScreen(game));
													return true;
												}
											}));
		}
		
	}

}
