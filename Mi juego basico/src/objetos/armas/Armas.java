package objetos.armas;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import objetos.TipoObjetos;
import objetos.balas.Bala;
import objetos.objeto.Objetos;


public class Armas extends Objetos {
	
	public boolean poderDisparar=false;
	public int velocidadDisparo;
	public int esperaDisparo;
	
	public Armas(Point posicion, String url, String urlInventario, int ancho, int alto, TipoObjetos tipoObjetos, int velocidadDisparo) {
		super(posicion, url, urlInventario, ancho, alto, tipoObjetos,0);
		this.velocidadDisparo=velocidadDisparo;
		this.setCogido(false);
		this.areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		this.poderDisparar=false;
		// TODO Auto-generated constructor stub
	}
	
	public void dispararJugador(Bala bala, Graphics2D g) {
		
	}
	

}
