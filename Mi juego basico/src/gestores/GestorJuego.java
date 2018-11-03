package gestores;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import Controles.Tecla;
import CosasBasicas.AccionesBasicas;
import constantes.Constantes;
import objetos.TipoObjetos;
import objetos.armas.Armas;
import objetos.balas.Bala;
import objetos.objeto.ObjetoEstamina;
import objetos.objeto.Objetos;
import personajes.Enemigo;
import personajes.Jugador;
import visual.Casa;
import visual.Mapa;

public class GestorJuego extends GestorPadre {
	public static int contPrueba = 0;
	private static Point posicionObjeto1 = new Point(AccionesBasicas.escalarPantallaX(300),
			AccionesBasicas.escalarPantallaY(300));
	private static Point posicionObjeto2 = new Point(AccionesBasicas.escalarPantallaX(500),
			AccionesBasicas.escalarPantallaY(400));
	private static Point posicionCasa1 = new Point(AccionesBasicas.escalarPantallaX(150),
			AccionesBasicas.escalarPantallaY(900));
	private static Point posicionCasa2 = new Point(AccionesBasicas.escalarPantallaX(150),
			AccionesBasicas.escalarPantallaY(350));
	private static Point posicionCasa3 = new Point(AccionesBasicas.escalarPantallaX(1030),
			AccionesBasicas.escalarPantallaY(420));
	private static Point posicionCasa4 = new Point(AccionesBasicas.escalarPantallaX(1000),
			AccionesBasicas.escalarPantallaY(950));
	private static Point posicionCasa5 = new Point(AccionesBasicas.escalarPantallaX(700),
			AccionesBasicas.escalarPantallaY(910));
	private static Point posicionCasa6 = new Point(AccionesBasicas.escalarPantallaX(730),
			AccionesBasicas.escalarPantallaY(320));

	public static Point posicionJugador = new Point(AccionesBasicas.escalarPantallaX(Constantes.ANCHO / 3),
			AccionesBasicas.escalarPantallaY(Constantes.ALTO / 3));
	public static Point posicionEnemigo1 = new Point(AccionesBasicas.escalarPantallaX(500),
			AccionesBasicas.escalarPantallaY(500));
	public static Point posicionEnemigo2 = new Point(AccionesBasicas.escalarPantallaX(550),
			AccionesBasicas.escalarPantallaY(500));

	// Principal---
	public static int contadorJugador = 0;
	public static Jugador jugador = new Jugador(55, 75, posicionJugador, 100, 50, 0, Constantes.velocidadGeneral,
			Constantes.velocidadGeneral, Constantes.velocidadGeneral, Constantes.velocidadGeneral,
			"src/recursos/personaje.gif");
	public static Mapa mapa = new Mapa(2560, 2560, "src/recursos/prueba.png");
	public static Enemigo enemigo1 = new Enemigo(10, 10, posicionEnemigo1, 10, 1, 1, 1, 1,
			"src/recursos/enemigo/enemigoQuieto.gif", 2);
	public static Enemigo enemigo2 = new Enemigo(10, 10, posicionEnemigo2, 10, 1, 1, 1, 1,
			"src/recursos/enemigo/enemigoQuieto.gif", 2);

	// ---

	public static Armas arma1 = new Armas(posicionObjeto1, "src/recursos/descarga.jpg", "src/recursos/descarga.jpg", 10,
			14, TipoObjetos.ARMAS, 50, 10);
	public static ObjetoEstamina arma2 = new ObjetoEstamina(posicionObjeto2, "src/recursos/descarga.jpg",
			"src/recursos/descarga.jpg", 10, 14, TipoObjetos.ESTAMINA, 10);

	public static Casa casa1 = new Casa(posicionCasa1.x, posicionCasa1.y, 148, 176, "src/recursos/casaAzul.gif");
	public static Casa casa2 = new Casa(posicionCasa2.x, posicionCasa2.y, 148, 176, "src/recursos/casaVerde.gif");
	public static Casa casa3 = new Casa(posicionCasa3.x, posicionCasa3.y, 180, 140, "src/recursos/casaBlanca.png");
	public static Casa casa4 = new Casa(posicionCasa4.x, posicionCasa4.y, 180, 140, "src/recursos/casaGris.png");
	public static Casa casa5 = new Casa(posicionCasa5.x, posicionCasa5.y, 148, 176, "src/recursos/casaVerde.gif");
	public static Casa casa6 = new Casa(posicionCasa6.x, posicionCasa6.y, 148, 176, "src/recursos/casaAzul.gif");

	public static boolean activoJuego = false;

	public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
	public static ArrayList<Rectangle> colisiones = new ArrayList<Rectangle>();
	public static ArrayList<Objetos> objetosMapa = new ArrayList<Objetos>();
	public static ArrayList<Object> objetosMapaFijo = new ArrayList<Object>();

	// Prueba
	public static int rectangulo1x = 250;
	public static int rectangulo1y = 250;
	// Acaba la prueba

	// Aqui lo que pase mientras se juega
	@Override
	public void dibujar(Graphics2D g) {

		if (contadorJugador == 0) {
			enemigos.add(enemigo1);
			enemigos.add(enemigo2);
			// Se volverian a generar los objetos
			Constantes.volverTodoCero();
			contadorJugador++;
		}
		g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		
		// Importante
		mapa.dibujar(g);
		dibujarArmas(g);
		//
		jugador.dibujar(g);
		enemigo1.dibujar(g);
		enemigo2.dibujar(g);
		casa1.dibujar(g);
		casa2.dibujar(g);
		casa3.dibujar(g);
		casa4.dibujar(g);
		casa5.dibujar(g);
		casa6.dibujar(g);

		try {
			// Esto sirve para que no dispare seguido es el contador que va aumentado hasta
			// el tiempo que tenga cada arma
			if (Tecla.esperarArma != ((Armas) Tecla.objetoElegido).esperaDisparo) {
				Tecla.esperarArma++;
			}
		} catch (NullPointerException | ClassCastException e) {
			// TODO: handle exception
		}

		// System.out.println(Tecla.esperarArma);

		Mapa.paredAbajo = new Rectangle(Mapa.rectanguloAbx, Mapa.rectanguloAby, Constantes.ANCHOMAPA, 3);
		Mapa.paredIzquierda = new Rectangle(Mapa.rectanguloIx, Mapa.rectanguloIy, 3, Constantes.ALTOMAPA);
		Mapa.paredArriba = new Rectangle(Mapa.rectanguloAx, Mapa.rectanguloAy, Constantes.ANCHOMAPA, 3);
		Mapa.paredDerecha = new Rectangle(Mapa.rectanguloDx, Mapa.rectanguloDy, 3, Constantes.ALTOMAPA);
		// ---
		// Prueba
		// ---

		recorrerArrayBalaMover(g);

		g.drawRect(Mapa.rectanguloAbx, Mapa.rectanguloAby, Constantes.ANCHOMAPA, 3);
		g.drawRect(Mapa.rectanguloAx, Mapa.rectanguloAy, 3, Constantes.ALTOMAPA);
		g.drawRect(Mapa.rectanguloDx, Mapa.rectanguloDy, 3, Constantes.ALTOMAPA);
		g.drawRect(Mapa.rectanguloIx, Mapa.rectanguloIy, Constantes.ANCHOMAPA, 3);

	}

	public void dibujarArmas(Graphics2D g) {
		arma1.dibujar(g, arma1);
		arma2.dibujar(g, arma2);
	}

	public static void cargarArrayColisiones() {
		// colisiones.add(GestorJuego.casa1.getAreaCasa());
		colisiones.add(Mapa.paredArriba);
		colisiones.add(Mapa.paredAbajo);
		colisiones.add(Mapa.paredIzquierda);
		colisiones.add(Mapa.paredDerecha);
	}

	public static void eliminarArrayColisiones() {
		colisiones.remove(Mapa.paredArriba);
		colisiones.remove(Mapa.paredAbajo);
		colisiones.remove(Mapa.paredDerecha);
		colisiones.remove(Mapa.paredIzquierda);
	}

	public static void cargarArrayObjetos() {
		objetosMapa.add(arma1);
		objetosMapa.add(arma2);
	}

	public static void eliminarArrayObjetos() {
		objetosMapa.removeAll(objetosMapa);
	}

	public static void recorrerArrayBalaMover(Graphics2D g) {
		try {
			// Disparar cuando haya algun enemigo
			if (enemigos.size() != 0) {
				for (Enemigo enemigo : enemigos) {

					for (Bala bala : Bala.ArrayBalas) {

						bala.contador++;
						// System.out.println(bala.contador);
						if (bala.entidadCreadora instanceof Jugador) {
							contPrueba++;
						}

						if (bala.contador != 1000) {
							bala.recorridoBala(bala, g, enemigo);
						} else {
							Bala.ArrayBalas.remove(bala);
							bala = null;

						}

					}
					if (contPrueba == contPrueba) {
						contPrueba = 0;
						break;
					}

				}

			}
			if (enemigos.size() == 0) {
				// Disparar cuando no haya enemigos
				// System.out.println("Pasa esto cuando no hay enemigos");
				for (Bala bala : Bala.ArrayBalas) {

					bala.contador++;
					// System.out.println(bala.contador);
					if (bala.contador != 1000) {
						bala.recorridoBala(bala, g, null);
					} else {
						Bala.ArrayBalas.remove(bala);
						bala = null;

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
