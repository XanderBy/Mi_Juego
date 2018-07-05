package mapa;

import sprites.HojaSprite;

public class Mapa {
//Atributos
	private int ancho;
	private int alto;
	private HojaSprite hoja;
	
	
	//Constructores
	public Mapa(int ancho, int alto, HojaSprite hoja) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.hoja = hoja;
	}
	
	//Metodos
	public void dibujar(){
		
	}


	//Getter-Setter
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public HojaSprite getHoja() {
		return hoja;
	}
	public void setHoja(HojaSprite hoja) {
		this.hoja = hoja;
	}
}
