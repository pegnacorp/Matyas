package com.apr.matyas.minigames.flores;

public class Fraccion {

	private int numerador;
	private int denominador;
	
	public Fraccion(int numerador, int denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public String toString(){
		return numerador + "/" + denominador;
	}
}
