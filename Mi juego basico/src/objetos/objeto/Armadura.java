package objetos.objeto;

import java.awt.Point;

import objetos.TipoObjetos;

public class Armadura extends Objetos {
	private int parte;
	
	

	public Armadura(Point posicion, String url, String urlInventario, int ancho, int alto, TipoObjetos tipoObjetos,
			int sumarle, int parte) {
		super(posicion, url, urlInventario, ancho, alto, tipoObjetos, sumarle);
		this.parte = parte;
	}

	public int getParte() {
		return parte;
	}

	public void setParte(int parte) {
		this.parte = parte;
	}
	
	
	
}
