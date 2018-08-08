package visual;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import CosasBasicas.SpritesMapa;
import constantes.Constantes;
import gestores.GestorJuego;

public class Mapa extends Sprites
{	
	public static Point posicion= new Point(0, 0);
	private static SpritesMapa sprite;
	
	public static int rectanguloAx= 0;
	public static int rectanguloAy= 0;
	public static Rectangle paredArriba;
	public static int rectanguloDx= Constantes.ANCHOMAPA;
	public static int rectanguloDy= 0;
	public static Rectangle paredDerecha;
	public static int rectanguloIx= 0;
	public static int rectanguloIy= 0;
	public static Rectangle paredIzquierda;
	public static int rectanguloAbx= 0;
	public static int rectanguloAby= Constantes.ALTOMAPA;
	public static Rectangle paredAbajo;
	
	public Mapa(int ancho, int alto, String url) {
		super(ancho, alto, url);
		cargarImagen(ancho, alto, url);
		rectanguloAx= 0;
		rectanguloAy= 0;
		rectanguloDx= Constantes.ANCHOMAPA;
		rectanguloDy= 0;
		rectanguloIx= 0;
		rectanguloIy= 0;
		rectanguloAbx= 0;
		rectanguloAby= Constantes.ALTOMAPA;
	}
	
	public void cargarImagen(int ancho, int alto, String url) {
		sprite=new SpritesMapa(ancho, alto, url);
		
	}
	
	public void dibujar(Graphics2D g)
	{	
	
			//System.out.println(GestorJuego.jugador.getPosicion().x);
		//if(GestorJuego.jugador.getPosicion().x== 400) {
			//posicion.x=-100;
			//System.out.println("dwadadwa");
		//}
		DibujosBasicos.pintarImagenMapa(g, GestorJuego.mapa.sprite,this);
		//g.drawLine(400, 0, 400, 500);
	}
	
	public static Point getPosicion() {
		return posicion;
	}

	public static void setPosicion(Point posicion) {
		Mapa.posicion = posicion;
	}
	
	
	
	
}
