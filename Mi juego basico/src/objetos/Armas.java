package objetos;

import java.awt.Point;
import java.awt.Rectangle;


public class Armas extends Objetos {

	public Armas(Point posicion, String url, String urlInventario, int ancho, int alto) {
		super(posicion, url, urlInventario, ancho, alto);
		this.setCogido(false);
		this.areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		
		// TODO Auto-generated constructor stub
	}

	

}
