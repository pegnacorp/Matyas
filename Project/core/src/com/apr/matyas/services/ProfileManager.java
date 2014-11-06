package com.apr.matyas.services;

import com.apr.matyas.MatyasGame;
import com.apr.matyas.game.GameState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;

public class ProfileManager {

	private static final String DATA_FILE = "data/game-state.json";
	
	private GameState gameState;
	
	
	public GameState retrieveGameState(){
		
		if (gameState!=null) return gameState;
		
		Json json = new Json();
		FileHandle dataFile = Gdx.files.local(DATA_FILE);
		Gdx.app.log(MatyasGame.LOG, "Obteniendo datos de configuracion de: " + dataFile.path());
		
		if (dataFile.exists()){
			String gameStateAsText = dataFile.readString().trim();
			
			if (gameStateAsText.matches("^[A-Za-z0-9/+=]+$")){
				Gdx.app.log(MatyasGame.LOG, "Desencriptando datos de configuracion de: " + dataFile.path());
				gameStateAsText = Base64Coder.decodeString(gameStateAsText);
			
			}
			
			gameState = json.fromJson(GameState.class, gameStateAsText);
			
		}else{
			dataFile = Gdx.files.internal(DATA_FILE);
			gameState = json.fromJson(GameState.class, dataFile);
			persist(gameState);
		}
		return gameState;
		
		
	}
	
	private void persist(GameState gs){
		Json json = new Json();
		FileHandle dataFile = Gdx.files.local(DATA_FILE);
		Gdx.app.log(MatyasGame.LOG, "Guardando datos de configuracion de: " + dataFile.path());
		String gameStateAsText = json.toJson(gs);
		
		gameStateAsText = Base64Coder.encodeString(gameStateAsText);
		
		dataFile.writeString(gameStateAsText, false);
		
		
	}
	
	
}
