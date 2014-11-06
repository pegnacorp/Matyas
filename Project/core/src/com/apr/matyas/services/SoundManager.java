package com.apr.matyas.services;

import com.apr.matyas.MatyasGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	
	private float volume = 1f;
	private boolean enabled = true;
	
	private AssetManager manager;
	
	public SoundManager(AssetManager manager){
		this.manager = manager;
	}
	
	public void play(MatyasSound sound){
		if (!enabled) return;
		
		Sound soundToPlay = manager.get(sound.getFileName());
		if (soundToPlay==null) return;
		
		Gdx.app.log(MatyasGame.LOG, "Reproduciendo sonido: " + sound.name());
		soundToPlay.play(volume);
		
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
