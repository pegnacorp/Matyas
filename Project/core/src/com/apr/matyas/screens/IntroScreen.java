package com.apr.matyas.screens;

import com.apr.matyas.MatyasGame;
import com.apr.matyas.services.MatyasMusic;
import com.apr.matyas.services.MatyasSound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class IntroScreen extends AbstractScreen{

	public IntroScreen(MatyasGame game) {
		super(game);
	}

	@Override
	public void show(){
		super.show();
		
		game.getMusicManager().play(MatyasMusic.MENU_MUSIC);
		
		Table table = super.getTable();
		table.clear();
		Image image = new Image(game.getAssetManager()
								.get("game.atlas", TextureAtlas.class)
								.findRegion("blackboard"));
		table.setBackground(image.getDrawable());
		
		Button startGameButton = new Button( getSkin(),"iniciar");
		startGameButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				stage.addAction(Actions.sequence(Actions.delay(0.25f),
						Actions.fadeOut(0.75f),
						new Action(){
							public boolean act(float delta){
								game.getMusicManager().stop();
								game.getSoundManager().play(MatyasSound.CLICK);
								game.setScreen(new MenuScreen(game));
								return true;
							}
						}));
			}
		});
		startGameButton.setScale(0.2f);
		startGameButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(startGameButton);
		Image logo = new Image(game.getAssetManager().
				get("game.atlas", TextureAtlas.class).
				findRegion("main_title"));
		table.add(logo);
		table.row();
		table.add(startGameButton).padBottom(10);
	}
	
	@Override	
	public void render(float delta){
		super.render(delta);
	}
}
