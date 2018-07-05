package sprites;

import java.util.ArrayList;

public class Cuadro {
	
	//Atributos
	private int x;
	private int y;
	private ArrayList <Integer> pixeles;
	private HojaSprite hoja;
	private boolean solido;
	
	//Constructor
	
	
	//Metodos
	public void identificar() {
		//Aqui identificara si el color es por ejemplo rojo sera un cuadro en especifico
	}
	
	public Cuadro(int x, int y, HojaSprite hoja) {
		super();
		this.x = x;
		this.y = y;
		this.hoja = hoja;
		//Identificar si el cuadro es true o false hacer que se pueda mover el personaje
		//this.solido;
	}

	//Getter-Setter
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ArrayList<Integer> getPixeles() {
		return pixeles;
	}
	public void setPixeles(ArrayList<Integer> pixeles) {
		this.pixeles = pixeles;
	}
	public HojaSprite getHoja() {
		return hoja;
	}
	public void setHoja(HojaSprite hoja) {
		this.hoja = hoja;
	}
	public boolean isSolido() {
		return solido;
	}
	public void setSolido(boolean solido) {
		this.solido = solido;
	}
}
