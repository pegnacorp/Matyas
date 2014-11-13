package com.apr.matyas.minigames;

import com.apr.matyas.minigames.flores.Flor;
import com.apr.matyas.minigames.flores.Flor.FlorType;
import com.apr.matyas.minigames.flores.Fraccion;
import com.apr.matyas.minigames.flores.Vasija;
import com.badlogic.gdx.utils.Array;

public class FloresGame extends BaseGame{

	private static final String[] VASIJAS = {"flower_blue","flower_yellow","flower_red"};
	private static final FlorType[] VASIJAS_TYPE = {FlorType.BLUE, FlorType.YELLOW, FlorType.RED};
	private static final int[] XS = {695,805,910};
	private Array<Flor> flores;
	private Array<Vasija> vasijas;
	
	
	public FloresGame(){
		super();
		flores = new Array<Flor>();
		
		vasijas = new Array<Vasija>();
		
		for (int i=0;i<3;i++){
			int denominador = 2+random.nextInt(8);
			int numerador = 1+random.nextInt(denominador-1);
			Fraccion fraccion = new Fraccion(numerador, denominador);
			vasijas.add(new Vasija(fraccion, VASIJAS[i],XS[i],150));
			for (int j=0;j<denominador;j++){
				flores.add(new Flor(VASIJAS[i],VASIJAS_TYPE[i], this.random));
			}
			
		}
		

	}
	
	@Override
	public void update(float delta) {
		for (Flor flor: flores){
			flor.update();
		}
		
	}

	@Override
	public void render() {
		batch.begin();
		
		batch.draw(atlas.findRegion("cenote"),0f,0f);
		for (Flor flor: flores){
			flor.draw(batch, atlas);
		}
		for (Vasija vasija: vasijas){
			vasija.draw(batch, atlas, font);
		}

		batch.end();
		
	}

	@Override
	public void touch(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drag(float x, float y) {
		// TODO Auto-generated method stub
		
	}

}
