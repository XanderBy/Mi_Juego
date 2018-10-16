package Controles;

import java.awt.Point;
import java.util.ArrayList;

import gestores.GestorCreditos;
import gestores.GestorEscape;
import gestores.GestorInventario;
import gestores.GestorJuego;
import gestores.GestorMenuPrincipal;
import gestores.GestorOpciones;
import objetos.armas.Armas;
import objetos.balas.Bala;
import objetos.objeto.Objetos;

public class Tecla extends Teclado {
	public static String direccion;
	public static int contDerecha = 0;
	public static int contIzquierda = 0;
	private static int espera = 0;
	public static int esperarArma = 0;
	public static Objetos objetoElegido = null;

	public static void acciones(Teclado teclado) {
		if (GestorMenuPrincipal.activoMenuPrincipal == false && GestorEscape.activoEscape == false
				&& GestorInventario.activoInventario == false && GestorOpciones.activoOpciones == false) {
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[1] == true) {
				GestorJuego.jugador.moverArriba(GestorJuego.jugador.getPosicion(),
						GestorJuego.jugador.getVelocidadMovimientoYArriba());
				direccion = "norte";
				if (teclado.tecladoPulsado[0] == true) {
					try {
						if (((Armas) objetoElegido).poderDisparar == true) {
							if (((Armas) objetoElegido).esperaDisparo <= esperarArma) {
								
								Point posicionBala = new Point(GestorJuego.jugador.getPosicion().x,
										GestorJuego.jugador.getPosicion().y);
								Bala bala = new Bala(posicionBala, Tecla.direccion, GestorJuego.jugador);
								System.out.println(Bala.ArrayBalas.size());
								esperarArma = 0;
							}
						}
					} catch (NullPointerException e) {
						// TODO: handle exception
					}

				}
			}
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[2] == true) {
				GestorJuego.jugador.moverAbajo(GestorJuego.jugador.getPosicion(),
						GestorJuego.jugador.getVelocidadMovimientoYAbajo());
				direccion = "sur";
				if (teclado.tecladoPulsado[0] == true) {
					try {
						if (((Armas) objetoElegido).poderDisparar == true) {
							if (((Armas) objetoElegido).esperaDisparo <= esperarArma) {
								Point posicionBala = new Point(GestorJuego.jugador.getPosicion().x,
										GestorJuego.jugador.getPosicion().y);
								Bala bala = new Bala(posicionBala, Tecla.direccion, GestorJuego.jugador);
								esperarArma = 0;
							}

						}
					} catch (NullPointerException e) {
						// TODO: handle exception
					}

				}
			}
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[3] == true) {

				GestorJuego.jugador.moverIzquierda(GestorJuego.jugador.getPosicion(),
						GestorJuego.jugador.getVelocidadMovimientoXIzquierda());

				if (espera == 4) {
					contIzquierda++;
					if (contIzquierda == 2) {
						contIzquierda = 0;
					}
					espera = 0;
				}
				espera++;

				// Pasara x cosas
				direccion = "oeste";
				if (teclado.tecladoPulsado[0] == true) {
					try {
						if (((Armas) objetoElegido).poderDisparar == true) {
							if (((Armas) objetoElegido).esperaDisparo <= esperarArma) {
								Point posicionBala = new Point(GestorJuego.jugador.getPosicion().x,
										GestorJuego.jugador.getPosicion().y);
								Bala bala = new Bala(posicionBala, Tecla.direccion, GestorJuego.jugador);
								esperarArma = 0;
							}

						}
					} catch (NullPointerException e) {
						// TODO: handle exception
					}

				}
			}
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[4] == true) {
				GestorJuego.jugador.moverDerecha(GestorJuego.jugador.getPosicion(),
						GestorJuego.jugador.getVelocidadMovimientoXDerecha());

				// Pasara x cosas es para la animacion
				if (espera == 4) {
					contDerecha++;
					if (contDerecha == 2) {
						contDerecha = 0;
					}
					espera = 0;
				}
				espera++;

				direccion = "este";
				if (teclado.tecladoPulsado[0] == true) {
					try {
						if (((Armas) objetoElegido).poderDisparar == true) {
							if (((Armas) objetoElegido).esperaDisparo <= esperarArma) {
								Point posicionBala = new Point(GestorJuego.jugador.getPosicion().x,
										GestorJuego.jugador.getPosicion().y);
								Bala bala = new Bala(posicionBala, Tecla.direccion, GestorJuego.jugador);
								esperarArma = 0;
							}
						}
					} catch (NullPointerException e) {
						// TODO: handle exception
					}

				}

			}
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[5] == true) {
				if (GestorInventario.activoInventario == true) {
					GestorInventario.activoInventario = false;
					GestorJuego.activoJuego = true;
				} else {
					GestorInventario.activoInventario = true;
					GestorJuego.activoJuego = false;
				}

			}
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[6] == true) {
				if(GestorJuego.activoJuego) {
					if(GestorEscape.activoEscape == false){
						GestorEscape.activoEscape = true;
						GestorJuego.activoJuego = false;
					}
					
				}else {
					if (GestorEscape.activoEscape == true) {
						GestorEscape.activoEscape = false;
						GestorJuego.activoJuego = true;
					}
				}
				
				
				if(GestorCreditos.GestorCreditosActivo==true) {
					GestorCreditos.GestorCreditosActivo=false;
					GestorMenuPrincipal.activoMenuPrincipal=true;
				}

			}
			// ------------------------------------------------------------------
			if (teclado.tecladoPulsado[7] == true) {
				GestorJuego.cargarArrayObjetos();
				for (Objetos a : GestorJuego.objetosMapa) {
					System.out.println(a.getAreaObjetoInfluencia());
					if (GestorJuego.jugador.areaJugadorInfluencia.intersects(a.getAreaObjetoInfluencia())) {

						GestorJuego.jugador.cogerObjetos(a);
						a.setCogido(true);

						break;
					}
				}
				GestorJuego.eliminarArrayObjetos();
			}
			// ------------------------------------------------------------------
			//Disparar
			if (teclado.tecladoPulsado[0] == true) {
				try {
					if (((Armas) objetoElegido).poderDisparar == true) {


						((Armas) objetoElegido).disparando = true;
						if (((Armas) objetoElegido).esperaDisparo <= esperarArma) {
							Point posicionBala = new Point(GestorJuego.jugador.getPosicion().x,
									GestorJuego.jugador.getPosicion().y);

							Bala bala = new Bala(posicionBala, Tecla.direccion, GestorJuego.jugador);

							esperarArma = 0;
						}
					}

				} catch (NullPointerException e) {
					// TODO: handle exception
				}

			}
			// 1
			if (teclado.tecladoPulsado[8] == true) {
				GestorJuego.jugador.inventarioArray[0].usar = true;
				objetoElegido = GestorJuego.jugador.inventarioArray[0];
				GestorJuego.jugador.inventarioArray[0].actualizar();
			}
			// 2
			if (teclado.tecladoPulsado[9] == true) {
				GestorJuego.jugador.inventarioArray[1].usar = true;
				objetoElegido = GestorJuego.jugador.inventarioArray[1];
				GestorJuego.jugador.inventarioArray[1].actualizar();
			}
			// 3
			if (teclado.tecladoPulsado[10] == true) {
				GestorJuego.jugador.inventarioArray[2].usar = true;
				objetoElegido = GestorJuego.jugador.inventarioArray[2];
				GestorJuego.jugador.inventarioArray[2].actualizar();

			}
		} else {
			if (teclado.tecladoPulsado[5] == true) {
				if (GestorInventario.activoInventario == true) {
					GestorInventario.activoInventario = false;
					GestorJuego.activoJuego = true;
				} else {
					GestorInventario.activoInventario = true;
					GestorJuego.activoJuego = false;
				}

			}
			if (GestorEscape.activoEscape == true) {
				if (teclado.tecladoPulsado[6] == true) {
					if (GestorEscape.activoEscape == true) {
						GestorEscape.activoEscape = false;
						GestorJuego.activoJuego = true;
					} else {
						GestorEscape.activoEscape = true;
						GestorJuego.activoJuego = false;
					}
				}

			}
		}

	}
}
