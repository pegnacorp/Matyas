package com.apr.matyas.screens;

import com.apr.matyas.MatyasGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class AbstractScreen implements Screen{

	public static final int VIEWPORT_WIDTH = 1024;
	public static final int VIEWPORT_HEIGHT = 768;
	
	
	protected final MatyasGame game;
	
	protected final Stage stage;
	
	private Skin skin;
	
	private TextureAtlas atlas;
	
	private Table table;
	
	public AbstractScreen(MatyasGame game){
		this.game = game;
		this.stage = new Stage(new StretchViewport(VIEWPORT_WIDTH,VIEWPORT_HEIGHT));
	}
	
	public String getName(){
		return getClass().getSimpleName();
	}
	
	protected Skin getSkin(){
		if (skin==null){
			skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));
			
		}
		return skin;
	}
	
	protected Table getTable(){
		if (table==null){
			table = new Table(getSkin());
			table.setFillParent(true);
			stage.addActor(table);
		}
		return table;
		
	}
	
	public void show(){
		Gdx.input.setInputProcessor(stage);
	}
	
	public void resize(int width, int height) {
	    stage.getViewport().update(width, height, false);
	}
	
	public void render(float delta){
		stage.act(delta);
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		
	}

	@Override
	public void hide() {
		Gdx.app.log(MatyasGame.LOG, "Ocultar pantalla " + getName());
		dispose();
		
	}

	@Override
	public void pause() {
		Gdx.app.log(MatyasGame.LOG, "Ir a pausa en pantalla " + getName());
		
	}

	@Override
	public void resume() {
		Gdx.app.log(MatyasGame.LOG, "Resumir pantalla " + getName());
		
	}

	@Override
	public void dispose() {
		Gdx.app.log(MatyasGame.LOG, "Eliminar recursos de pantalla " + getName());

		
	}
	
	
}
