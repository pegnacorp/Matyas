package com.apr.matyas.screens;

import com.apr.matyas.MatyasGame;
import com.apr.matyas.game.MiniGame;
import com.apr.matyas.minigames.BaseGame;
import com.apr.matyas.minigames.BaseGameListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameScreen extends AbstractScreen
implements BaseGameListener{

	private MiniGame minigame;
	private BaseGame baseGame;
	
	public GameScreen(MatyasGame game) {
		super(game);	
	}
	
	public void show(){
		super.show();
		
		minigame = game.getWorld().getCurrentGame();
		Gdx.app.log(MatyasGame.LOG, "Entrando a minigame: " + minigame.name);
		
		try {
			Class theClass = Class.forName("com.apr.matyas.minigames." + minigame.className);
			baseGame = (BaseGame)theClass.newInstance();
			baseGame.setBaseGameListener(this);
			baseGame.setAssets(game.getAssetManager());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Table table = super.getTable();
		
		Texture back = new Texture("background.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,1024,768)));
		
		Label labelName = new Label("Minigame " + minigame.name,getSkin());
		Label labelPoints = new Label("Puntos: " + game.getWorld().getGameState().points,getSkin());
		Label labelLevel = new Label("Nivel: " + game.getWorld().getGameState().level,getSkin());
		Label labelXP = new Label("Experiencia: " + game.getWorld().getGameState().xp,getSkin());

		Table topTable = new Table();
		topTable.add(labelName);
		topTable.row();
		topTable.add(labelPoints);
		topTable.row();
		topTable.add(labelLevel);
		topTable.row();
		topTable.add(labelXP);
		topTable.row();
		
		table.add(topTable).expand().top().left();
		
	}
	
	@Override
	public void render(float delta){
		
		
		baseGame.update(delta);
		
		super.render(delta);
		baseGame.render();
		
	}

}
