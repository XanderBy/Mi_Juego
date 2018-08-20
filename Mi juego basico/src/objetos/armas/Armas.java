package objetos.armas;

import java.awt.Point;
import java.awt.Rectangle;

import objetos.TipoObjetos;
import objetos.objeto.Objetos;


public class Armas extends Objetos {

	public Armas(Point posicion, String url, String urlInventario, int ancho, int alto, TipoObjetos tipoObjetos) {
		super(posicion, url, urlInventario, ancho, alto, tipoObjetos,0);
		this.setCogido(false);
		this.areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		
		// TODO Auto-generated constructor stub
	}

	

}
