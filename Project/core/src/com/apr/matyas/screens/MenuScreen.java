package com.apr.matyas.screens;

import com.apr.matyas.MatyasGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends AbstractScreen{

	public MenuScreen(MatyasGame game) {
		super(game);
		
	}
	
	@Override
	public void show(){
		super.show();
		Table table = super.getTable();
		table.clear();
		Image image = new Image(game.getAssetManager()
								.get("game.atlas", TextureAtlas.class)
								.findRegion("blackboard"));
		table.setBackground(image.getDrawable());
		

		
		
		
		
		Button floresGameButton = new Button(getSkin(),"flores");
		floresGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				//Mandar a la pantalla correspondiente
			}
		});
		
		TextButton optionsGameButton = new TextButton("Opciones", getSkin());
		optionsGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new OptionScreen(game));
			}
		});
		
		TextButton highScoresGameButton = new TextButton("Tabla de honor", getSkin());
		highScoresGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				//Mandar a la pantalla correspondiente
			}
		});
		TextButton exitGameButton = new TextButton("Salir", getSkin());
		exitGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				Gdx.app.exit();
			}
		});
		
		table.add(floresGameButton).padBottom(10);
		table.row();
		table.add(optionsGameButton).size(250, 50).padBottom(10);;
		table.row();
		table.add(highScoresGameButton).size(250, 50).padBottom(10);;
		table.row();
		table.add(exitGameButton).size(250, 50).padBottom(10);;
		
		
		
	}
	
	public void render(float delta){
		super.render(delta);
	}

}
