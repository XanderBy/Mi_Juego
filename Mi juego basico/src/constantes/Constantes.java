package constantes;

import java.awt.Point;
import java.util.ArrayList;

import gestores.GestorJuego;
import personajes.Jugador;
import visual.Mapa;
import visual.Pantalla;

public class Constantes {
	public static int ANCHO = 1080;
	public static int ALTO = 720;

	public static final double ESCALAX = 2;
	public static final double ESCALAY = 2;

	public static int velocidadGeneral = 2;

	public static final int ANCHOMAPA = 640;
	public static final int ALTOMAPA = 640;

	public static ArrayList<Pantalla> arrayPantalla = new ArrayList<Pantalla>();

	public static boolean dondeEncuentraMenu = true;

	public static final int ESTAMINA = 10;
	public static final int VIDA = 10;
	public static final int VELOCIDAD = 10;

	public static final Point DESAPARECER = new Point(111111111, 111111111);

	public static final Point posicionSpawn1 = null;
	public static final Point posicionSpawn2 = null;
	public static final Point posicionSpawn3 = null;
	public static final Point posicionSpawn4 = null;

	public static void volverTodoCero() {
		GestorJuego.jugador = new Jugador(30, 55, GestorJuego.posicionJugador, 100, 50, 0, Constantes.velocidadGeneral,
				Constantes.velocidadGeneral, Constantes.velocidadGeneral, Constantes.velocidadGeneral,
				"src/recursos/personaje.gif");
		GestorJuego.mapa = new Mapa(640, 640, "src/recursos/descarga.png");
		GestorJuego.mapa.posicion = new Point(0, 0);
	}
}
