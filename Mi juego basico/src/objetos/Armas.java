package objetos;

import java.awt.Point;
import java.awt.Rectangle;


public class Armas extends Objetos {

	public Armas(Point posicion, String url, String urlInventario, int ancho, int alto, TipoObjetos tipoObjetos) {
		super(posicion, url, urlInventario, ancho, alto, tipoObjetos);
		this.setCogido(false);
		this.areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		
		// TODO Auto-generated constructor stub
	}

	

}
