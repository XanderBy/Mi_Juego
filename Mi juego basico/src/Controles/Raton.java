package Controles;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.midi.Synthesizer;

import CosasBasicas.AccionesBasicas;
import constantes.Constantes;
import gestores.GestorEscape;
import gestores.GestorInventario;
import gestores.GestorJuego;
import gestores.GestorMenuPrincipal;
import gestores.GestorOpciones;
import objetos.Objetos;
import visual.SuperficieDibujo;

public class Raton implements MouseListener {

	public static Point puntaRaton;
	private Rectangle puntero;
	private SuperficieDibujo sd;
	private GestorMenuPrincipal gmp = new GestorMenuPrincipal();
	public static Objetos recuadroInventario = null;
	public static Objetos objetoMover = null;
	public Point posicionObjetos;
	public static Dimension tamanoPantalla;

	public void actualizar() {

		SuperficieDibujo.arraySuperficie[0].actualizar();
		puntaRaton = SuperficieDibujo.arraySuperficie[0].posicionRaton;
		// System.out.println("posicion raton:" + puntaRaton);
		if (puntaRaton == null) {
			puntaRaton = new Point(0, 0);
		}
		puntero = new Rectangle((int) puntaRaton.getX(), (int) puntaRaton.getY(), 2, 2);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (GestorMenuPrincipal.activoMenuPrincipal == true) {
			GestorJuego.contadorJugador = 0;
			GestorInventario.activoInventario = false;
			GestorJuego.activoJuego = false;
			GestorEscape.activoEscape = false;
			GestorOpciones.activoOpciones = false;

			if (puntero.intersects(gmp.nuevaPartida)) {
				GestorJuego.activoJuego = true;
				Constantes.dondeEncuentraMenu = false;
			}
			if (puntero.intersects(GestorMenuPrincipal.salir)) {
				System.exit(0);
			}
			if (puntero.intersects(GestorMenuPrincipal.opciones)) {
				GestorOpciones.activoOpciones = true;

			}
		}

		if (GestorJuego.activoJuego == true) {
			GestorMenuPrincipal.activoMenuPrincipal = false;
			GestorInventario.activoInventario = false;
			GestorEscape.activoEscape = false;
			GestorOpciones.activoOpciones = false;
			if (puntero.intersects(GestorJuego.rectangulo)) {
				System.out.println("Hola");
			}

		}

		if (GestorEscape.activoEscape == true) {
			GestorMenuPrincipal.activoMenuPrincipal = false;
			GestorInventario.activoInventario = false;
			GestorJuego.activoJuego = false;
			GestorOpciones.activoOpciones = false;
			if (puntero.intersects(GestorEscape.salirJuego)) {
				System.exit(0);
			}

			if (puntero.intersects(GestorEscape.opciones)) {

				GestorOpciones.activoOpciones = true;
			}

			if (puntero.intersects(GestorEscape.salirMenu)) {
				System.out.println("Hola");
				Constantes.dondeEncuentraMenu = true;
				GestorMenuPrincipal.activoMenuPrincipal = true;

			}
		}

		if (GestorOpciones.activoOpciones == true) {
			GestorEscape.activoEscape = false;
			GestorMenuPrincipal.activoMenuPrincipal = false;

			if (puntero.intersects(GestorOpciones.cerrar)) {
				GestorOpciones.activoOpciones = false;
				if (Constantes.dondeEncuentraMenu == true) {
					GestorMenuPrincipal.activoMenuPrincipal = true;
				} else {
					GestorEscape.activoEscape = true;
				}
			}

			if (puntero.intersects(GestorOpciones.p1920x1080)) {
				tamanoPantalla = new Dimension(1920, 1080);
				Constantes.arrayPantalla.get(0).setSize(tamanoPantalla);
				Constantes.arrayPantalla.get(0).setLocation(0, 0);
				// SuperficieDibujo.arraySuperficie[0].setSize(tamanoPantalla);
				Constantes.ALTO = 1080;
				Constantes.ANCHO = 1920;
			}
		}

		if (GestorInventario.activoInventario == true) {
			GestorMenuPrincipal.activoMenuPrincipal = false;
			GestorJuego.activoJuego = false;
			GestorEscape.activoEscape = false;
			GestorOpciones.activoOpciones = false;

			if (GestorInventario.poderMover == true) {
				for (int i=0; i<GestorInventario.recuadros.length; i++) {
					System.out.println(GestorInventario.recuadros[i]);
				
						if (puntero.intersects(GestorInventario.recuadros[i])) {
							System.out.println(objetoMover);
							// posicionObjetos=GestorInventario.moverObjeto02.getLocation();
							// objetoMover.posicion=GestorInventario.moverObjeto02.getLocation();

							if (GestorJuego.jugador.inventarioArray[i] == null) {
								for (int j = 0; j < GestorJuego.jugador.inventarioArray.length; j++) {
									if (GestorJuego.jugador.inventarioArray[j] == objetoMover) {
										GestorJuego.jugador.inventarioArray[j] = null;
										break;
									}
								}
								GestorJuego.jugador.inventarioArray[i] = objetoMover;
								GestorInventario.poderMover = false;
							}

						}
					
				}
				
			}

			try {
				if (puntero.intersects(GestorInventario.mover)) {
					GestorInventario.poderMover = true;
				}
				if (puntero.intersects(GestorInventario.soltar)) {
					for (int i = 0; i < GestorJuego.jugador.inventarioArray.length; i++) {
						// GestorJuego.jugador.inventarioArray.remove(recuadroInventario);
						if (GestorJuego.jugador.inventarioArray[i] == recuadroInventario) {
							GestorJuego.jugador.inventarioArray[i] = null;
						}
					}

					recuadroInventario.cogido = false;
					posicionObjetos = new Point(AccionesBasicas.escalarPantallaX(200),
							AccionesBasicas.escalarPantallaY(200));
					recuadroInventario.posicion = posicionObjetos;

					recuadroInventario = null;
				}
				if (puntero.intersects(GestorInventario.utilizar)) {

				}
			} catch (NullPointerException ee) {

			}

			if (e.getButton() == e.BUTTON3) {
				for (Objetos a : GestorJuego.jugador.inventarioArray) {
					try {
						if (puntero.intersects(a.getAreaObjetoInfluencia())) {
							System.out.println(23111111);
							recuadroInventario = a;
							objetoMover = a;
							break;
						}
					} catch (NullPointerException ee) {
						// TODO: handle exception

					}

				}
			}

			if (e.getButton() == e.BUTTON1) {
				for (Objetos a : GestorJuego.jugador.inventarioArray) {
					try {
						if (!puntero.intersects(a.getAreaObjetoInfluencia())) {

							recuadroInventario = null;
						}
					} catch (Exception ee) {

					}

				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
