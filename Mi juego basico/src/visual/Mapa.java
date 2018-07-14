package visual;

import java.awt.Graphics2D;
import java.awt.Point;

import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;

public class Mapa extends Sprites
{	
	private final static Point posicion= new Point(0, 0);
	private static Sprites sprite;
	
	public Mapa(int ancho, int alto, String url) {
		super(ancho, alto, url);
		cargarImagen(ancho, alto, url);
	}
	
	public void cargarImagen(int ancho, int alto, String url) {
		sprite=new Sprites(ancho, alto, url);
		
	}
	
	public void dibujar(Graphics2D g)
	{
		DibujosBasicos.pintarImagenMapa(g, SuperficieDibujo.mapa.sprite,this);
	}
	
	public static Point getPosicion() {
		return posicion;
	}
	
	
	
	
}
