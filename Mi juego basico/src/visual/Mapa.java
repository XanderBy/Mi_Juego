package visual;

import java.awt.Point;

import CosasBasicas.AtributosBasicos;

public class Mapa extends AtributosBasicos
{
	private String url;
	private final static Point posicion= new Point(0, 0);
	
	public Mapa(int ancho, int alto, String url) {
		super();
		this.setAncho(ancho);
		this.setAlto(alto);
		this.url = url;
		cargarImagen(ancho, alto, url);
	}

	public static Point getPosicion() {
		return posicion;
	}
	
	
	
	
}
