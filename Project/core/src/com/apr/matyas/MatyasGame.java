package com.apr.matyas;

import com.apr.matyas.screens.SplashScreen;
import com.apr.matyas.services.*;
import com.apr.matyas.world.World;
import com.apr.matyas.world.WorldRenderer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

public class MatyasGame extends Game{
	
	/**
	 * Para log
	 */
	public static final String LOG = MatyasGame.class.getSimpleName();
	
	/**
	 * Modo de prueba
	 */
	public static final boolean DEV_MODE = false;
	
	/**
	 * Tasa de comparacion de la resolucion base del juego
	 * con la resolucion de la pantalla
	 */
	public float factorX, factorY;
	
	/**
	 * Administrador de recursos
	 */
	private AssetManager manager = new AssetManager();
	
	/**
	 * Administrador de sonidos
	 */
	private SoundManager soundManager;
	
	
	/**
	 * Administrador de musica de fondo
	 */
	private MusicManager musicManager;
	
	/**
	 * Administrador del estado interno del juego
	 */
	private ProfileManager profileManager;
	
	/**
	 * Administrador de las preferencias de usuario
	 */
	private PreferencesManager preferencesManager;
	
	public World world;
	
	public WorldRenderer renderer;
	
	public AssetManager getAssetManager(){
		return manager;
	}
	
	public SoundManager getSoundManager(){
		return soundManager;
	}
	
	public MusicManager getMusicManager(){
		return musicManager;
	}
	
	public ProfileManager getProfileManager(){
		return profileManager;
	}
	
	public PreferencesManager getPreferencesManager(){
		return preferencesManager;
	}
	
	public MatyasGame(){
		
	}

	@Override
	public void create() {
		Gdx.app.log(MatyasGame.LOG, "Creando juego en " + Gdx.app.getType());
		
		preferencesManager = new PreferencesManager();
		
		profileManager = new ProfileManager();
		
		musicManager = new MusicManager();
		
		soundManager = new SoundManager();
		
	}
	
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		Gdx.app.log(MatyasGame.LOG, "Cambiando resolucion a: " + width + "x" + height);
		
		factorX = 1024f/(float)width;
		factorY = 768f/(float)height;
		
		if (getScreen()==null){
			setScreen(new SplashScreen(this));
		}
		
		
	}
	
	
}
