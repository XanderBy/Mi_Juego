package constantes;

import java.awt.Point;
import java.util.ArrayList;

import gestores.GestorJuego;
import personajes.Jugador;
import visual.Mapa;
import visual.Pantalla;

public class Constantes {
	public static int ANCHO=1080;
	public static int ALTO=720;
	public static final double ESCALAX=4;
	public static final double ESCALAY=4;
	public static int velocidadGeneral=2;
	public static final int ANCHOMAPA=640;
	public static final int ALTOMAPA=640;
	public static ArrayList <Pantalla> arrayPantalla=new ArrayList<Pantalla>();
	public static boolean dondeEncuentraMenu=true;
	
	
	public static void volverTodoCero() {
		GestorJuego.jugador= new Jugador(30, 55, GestorJuego.posicionJugador, 100, 50, 0, Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,"C:\\\\Users\\\\alexi\\\\Desktop\\\\personaje.gif");
		GestorJuego.mapa= new Mapa(640, 640, "C:\\Users\\alexi\\Desktop\\descarga.png");
		GestorJuego.mapa.posicion=new Point(0, 0);
	}
}
