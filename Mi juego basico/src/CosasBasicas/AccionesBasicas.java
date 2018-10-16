package CosasBasicas;

import java.awt.Point;
import java.awt.Rectangle;

import constantes.Constantes;
import gestores.GestorJuego;
import objetos.balas.Bala;
import objetos.objeto.Objetos;
import personajes.Enemigo;
import personajes.Jugador;
import visual.Casa;
import visual.Mapa;

public class AccionesBasicas {

	public static int escalarPantallaX(int numero) {
		return (int) (numero / Constantes.ESCALAX);
	}

	public static int escalarPantallaY(int numero) {
		return (int) (numero / Constantes.ESCALAY);
	}

	public static void correccionXPositivo(int velocidad) {

		GestorJuego.rectangulo1x = GestorJuego.rectangulo1x + velocidad;
		Mapa.rectanguloIx = Mapa.rectanguloIx + velocidad;
		Mapa.rectanguloAbx = Mapa.rectanguloAbx + velocidad;
		Mapa.rectanguloAx = Mapa.rectanguloAx + velocidad;
		Mapa.rectanguloDx = Mapa.rectanguloDx + velocidad;

		try {
			for (Object a : GestorJuego.objetosMapaFijo) {
				((Casa) a).setPosicionX(((Casa) a).getPosicionX() + velocidad);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			for (Enemigo a : GestorJuego.enemigos) {

				Point posicion = new Point(a.getPosicion().x + velocidad, a.getPosicion().y);
				a.setPosicion(posicion);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		for (Bala a : Bala.ArrayBalas) {
			if (a.entidadCreadora instanceof Enemigo) {

				a.posicion.x = a.posicion.x + velocidad;

			}
			if (a.entidadCreadora instanceof Jugador) {

				a.posicion.x = a.posicion.x + velocidad;
			}

		}

		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) {
			if (a.cogido == false) {
				a.posicion.x = a.posicion.x + velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();

	}

	public static void correccionXNegativo(int velocidad) {

		GestorJuego.rectangulo1x = GestorJuego.rectangulo1x - velocidad;
		Mapa.rectanguloIx = Mapa.rectanguloIx - velocidad;
		Mapa.rectanguloAbx = Mapa.rectanguloAbx - velocidad;
		Mapa.rectanguloAx = Mapa.rectanguloAx - velocidad;
		Mapa.rectanguloDx = Mapa.rectanguloDx - velocidad;

		try {
			for (Object a : GestorJuego.objetosMapaFijo) {

				((Casa) a).setPosicionX(((Casa) a).getPosicionX() - velocidad);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			for (Enemigo a : GestorJuego.enemigos) {

				Point posicion = new Point(a.getPosicion().x - velocidad, a.getPosicion().y);
				a.setPosicion(posicion);
			}

		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		for (Bala a : Bala.ArrayBalas) {
			if (a.entidadCreadora instanceof Enemigo) {

				a.posicion.x = a.posicion.x - velocidad;

			}

			if (a.entidadCreadora instanceof Jugador) {

				a.posicion.x = a.posicion.x - velocidad;
			}
		}
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) {
			if (a.cogido == false) {
				a.posicion.x = a.posicion.x - velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();

	}

	public static void correccionYPositivo(int velocidad) {

		GestorJuego.rectangulo1y = GestorJuego.rectangulo1y + velocidad;
		Mapa.rectanguloIy = Mapa.rectanguloIy + velocidad;
		Mapa.rectanguloAby = Mapa.rectanguloAby + velocidad;
		Mapa.rectanguloAy = Mapa.rectanguloAy + velocidad;
		Mapa.rectanguloDy = Mapa.rectanguloDy + velocidad;

		try {
			for (Object a : GestorJuego.objetosMapaFijo) {
				((Casa) a).setPosicionY(((Casa) a).getPosicionY() + velocidad);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			for (Enemigo a : GestorJuego.enemigos) {

				Point posicion = new Point(a.getPosicion().x, a.getPosicion().y + velocidad);
				a.setPosicion(posicion);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		for (Bala a : Bala.ArrayBalas) {

			if (a.entidadCreadora instanceof Enemigo) {
				a.posicion.y = a.posicion.y + velocidad;

			}
			if (a.entidadCreadora instanceof Jugador) {

				a.posicion.y = a.posicion.y + velocidad;
			}
		}
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) {
			if (a.cogido == false) {
				a.posicion.y = a.posicion.y + velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();

	}

	public static void correccionYNegativo(int velocidad) {

		GestorJuego.rectangulo1y = GestorJuego.rectangulo1y - velocidad;
		Mapa.rectanguloIy = Mapa.rectanguloIy - velocidad;
		Mapa.rectanguloAby = Mapa.rectanguloAby - velocidad;
		Mapa.rectanguloAy = Mapa.rectanguloAy - velocidad;
		Mapa.rectanguloDy = Mapa.rectanguloDy - velocidad;

		try {
			for (Object a : GestorJuego.objetosMapaFijo) {
				((Casa) a).setPosicionY(((Casa) a).getPosicionY() - velocidad);

			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			for (Enemigo a : GestorJuego.enemigos) {

				Point posicion = new Point(a.getPosicion().x, a.getPosicion().y - velocidad);
				a.setPosicion(posicion);
			}
		} catch (IndexOutOfBoundsException e) {
		}
		for (Bala a : Bala.ArrayBalas) {
			if (a.entidadCreadora instanceof Enemigo) {

				a.posicion.y = a.posicion.y - velocidad;

			}
			if (a.entidadCreadora instanceof Jugador) {

				a.posicion.y = a.posicion.y - velocidad;
			}
		}
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) {
			if (a.cogido == false) {
				a.posicion.y = a.posicion.y - velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();

	}
}
