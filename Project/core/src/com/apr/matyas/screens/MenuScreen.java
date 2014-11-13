package com.apr.matyas.screens;

import com.apr.matyas.MatyasGame;
import com.apr.matyas.game.MiniGame;
import com.apr.matyas.services.MatyasSound;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

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
		
		Label labelPoints = new Label("Puntos: " + game.getWorld().getGameState().points,getSkin());
		Label labelLevel = new Label("Nivel: " + game.getWorld().getGameState().level,getSkin());
		Label labelXP = new Label("Experiencia: " + game.getWorld().getGameState().xp,getSkin());

		table.add(labelPoints).colspan(3);
		table.row();
		table.add(labelLevel).colspan(3);
		table.row();
		table.add(labelXP).colspan(3);
		table.row();
		
		Array<MiniGame> minigames = game.getWorld().getGameState().minigames;
		int i=0;
		for (final MiniGame miniGame: minigames){
			Button gameButton = new Button(getSkin(),miniGame.name);
			gameButton.addListener(new ClickListener(){
				public void clicked(InputEvent event, float x, float y){
					game.getSoundManager().play(MatyasSound.CLICK);
					game.getWorld().setCurrentGame(miniGame);
					game.setScreen(new GameScreen(game));
				}
			});
		//	gameButton.setDisabled(level.locked);
			table.add(gameButton).padBottom(10);
			i++;
			if (i%3==0) table.row();
		}
		
		table.row();
		
		
		
		
		TextButton optionsGameButton = new TextButton("Opciones", getSkin());
		optionsGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new OptionScreen(game));
				game.getSoundManager().play(MatyasSound.CLICK);
			}
		});
		
		TextButton highScoresGameButton = new TextButton("Tabla de honor", getSkin());
		highScoresGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getSoundManager().play(MatyasSound.CLICK);
				//Mandar a la pantalla correspondiente
			}
		});
		TextButton exitGameButton = new TextButton("Salir", getSkin());
		exitGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getSoundManager().play(MatyasSound.CLICK);
				Gdx.app.exit();
			}
		});
		
		
		table.add(optionsGameButton).size(250, 50).padBottom(10);;
		
		table.add(highScoresGameButton).size(250, 50).padBottom(10);;
		
		table.add(exitGameButton).size(250, 50).padBottom(10);;
		
		
		
	}
	
	public void render(float delta){
		super.render(delta);
	}

}
