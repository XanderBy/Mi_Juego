package gestores;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import CosasBasicas.AccionesBasicas;
import armas.Objetos;
import constantes.Constantes;
import personajes.Jugador;
import visual.Mapa;

public class GestorJuego extends GestorPadre
{	

	private static Point posicionJugador= new Point(AccionesBasicas.escalarPantallaX(200), AccionesBasicas.escalarPantallaY(200));
	public static Jugador jugador= new Jugador(30, 55, posicionJugador, 10, 10, Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,"C:\\\\Users\\\\alexi\\\\Desktop\\\\personaje.gif");
	
	public static Mapa mapa= new Mapa(640, 640, "C:\\Users\\alexi\\Desktop\\descarga.png");
	public static Rectangle rectangulo;
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
	
	public static boolean activoJuego=false;
	public static ArrayList<Rectangle> colisiones=new ArrayList<Rectangle>();
	public static ArrayList<Objetos> objetosMapa=new ArrayList<Objetos>();
	
	public static int rectangulo1x= 250;
	public static int rectangulo1y= 250;
	
	//Aqui lo que pase mientras se juega
	@Override
	public void dibujar(Graphics2D g) {
		
		//g.fillRect(0, 0, 2000, 1000);
		g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		mapa.dibujar(g);
		//rectangulo= new Rectangle(AccionesBasicas.escalarPantallaX(250),AccionesBasicas.escalarPantallaY(250),AccionesBasicas.escalarPantallaX(50),AccionesBasicas.escalarPantallaY(50));
		
		rectangulo= new Rectangle(rectangulo1x,rectangulo1y,50,50);
		g.drawRect(rectangulo.x, rectangulo.y, 50, 50);
		jugador.dibujar(g);
		paredAbajo= new Rectangle(rectanguloAbx,rectanguloAby, Constantes.ANCHOMAPA, 3);
		paredIzquierda= new Rectangle(rectanguloIx,rectanguloIy, 3, Constantes.ALTOMAPA);
		paredArriba= new Rectangle(rectanguloAx,rectanguloAy, Constantes.ANCHOMAPA, 3);
		paredDerecha= new Rectangle(rectanguloDx,rectanguloDy, 3, Constantes.ALTOMAPA);
		g.drawRect(rectanguloAbx,rectanguloAby, Constantes.ANCHOMAPA, 3);
		g.drawRect(rectanguloAx,rectanguloAy, 3, Constantes.ALTOMAPA);
		g.drawRect(rectanguloDx,rectanguloDy, 3, Constantes.ALTOMAPA);
		g.drawRect(rectanguloIx,rectanguloIy, Constantes.ANCHOMAPA, 3);
		
	}
	public static void cargarArrayColisiones() 
	{
		colisiones.add(rectangulo);
		colisiones.add(paredArriba);
		colisiones.add(paredAbajo);
		colisiones.add(paredIzquierda);
		colisiones.add(paredDerecha);
	}
	public static void eliminarArrayColisiones()
	{	
		colisiones.removeAll(colisiones);
		//colisiones.remove(0);
		//colisiones.remove(1);
		//colisiones.remove(2);
		//colisiones.remove(3);
		//colisiones.remove(4);
	}
	public static void cargarArrayObjetos() {
		
	}
	public static void eliminarArrayObjetos() {
		objetosMapa.removeAll(objetosMapa);
	}
}
