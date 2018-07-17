package gestores;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import CosasBasicas.AccionesBasicas;
import constantes.Constantes;
import personajes.Jugador;
import visual.Mapa;

public class GestorJuego extends GestorPadre
{	

	private static Point posicionJugador= new Point(300, 255);
	public static Jugador jugador= new Jugador(135, 135, posicionJugador, 10, 10, Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,"C:\\\\Users\\\\alexi\\\\Desktop\\\\descarga.gif");
	
	public static Mapa mapa= new Mapa(640, 640, "C:\\Users\\alexi\\Desktop\\descarga.png");
	public static Rectangle rectangulo;
	public static boolean activoJuego=false;
	public static ArrayList<Rectangle> colisiones=new ArrayList<Rectangle>();
	
	public static int rectangulo1x= 250;
	public static int rectangulo1y= 250;
	
	//Aqui lo que pase mientras se juega
	@Override
	public void dibujar(Graphics2D g) {
		
		//g.fillRect(0, 0, 2000, 1000);
		//g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		mapa.dibujar(g);
		//rectangulo= new Rectangle(AccionesBasicas.escalarPantallaX(250),AccionesBasicas.escalarPantallaY(250),AccionesBasicas.escalarPantallaX(50),AccionesBasicas.escalarPantallaY(50));
		
		rectangulo= new Rectangle(rectangulo1x,rectangulo1y,50,50);
		g.drawRect(rectangulo.x, rectangulo.y, 50, 50);
		jugador.dibujar(g);
		
	}
	public static void cargarArray() 
	{
		colisiones.add(rectangulo);
	}
	public static void eliminarArrar()
	{
		colisiones.remove(0);
	}
}
