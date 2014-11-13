package com.apr.matyas.game;

public class World {

	private GameState gameState;
	
	private MiniGame currentGame;
	
	public World(GameState gameState){
		this.setGameState(gameState);
	}


	public GameState getGameState() {
		return gameState;
	}


	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}


	public MiniGame getCurrentGame() {
		return currentGame;
	}


	public void setCurrentGame(MiniGame currentGame) {
		this.currentGame = currentGame;
	}
}
