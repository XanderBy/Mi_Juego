package personajes;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import Controles.Tecla;
import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import constantes.Constantes;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;
import objetos.balas.Bala;

public class Enemigo extends Entidad implements MetodosEntidades {
	private boolean moverse = false;
	private boolean dispararAJugador = false;
	public Rectangle areaCuerpo;
	public Rectangle areaDano;
	public Rectangle areaActivacion;
	private long tiempoAhora = 0;
	private int contIzquierda = 0;
	private int contDerecha = 0;
	private int contArriba = 0;
	private int contAbajo = 0;
	public int donde = 4;
	public int velocidadDisparo;

	public Enemigo(int ancho, int alto, Point posicion, int vida, int velocidadMovimientoXIzquierda,
			int velocidadMovimientoYArriba, int velocidadMovimientoXDerecha, int velocidadMovimientoYAbajo,
			String urlQuieto, int velocidadDisparo) {
		super(ancho, alto, posicion, vida, velocidadMovimientoXIzquierda, velocidadMovimientoYArriba,
				velocidadMovimientoXDerecha, velocidadMovimientoYAbajo, urlQuieto);
		this.velocidadDisparo = velocidadDisparo;
		derecha = new Sprites(50, 50, "src/recursos/enemigo/enemigoDerechaQuieto.gif");
		izquierda = new Sprites(50, 50, "src/recursos/enemigo/enemigoIzquierdaQuieto.gif");
		arriba = new Sprites(50, 50, "src/recursos/enemigo/enemigoArribaQuieto.gif");
		abajo = new Sprites(50, 50, "src/recursos/enemigo/enemigoQuieto.gif");
		Sprites derecha1 = new Sprites(50, 50, "src/recursos/enemigo/enemigoDerecha1.gif");
		Sprites derecha2 = new Sprites(50, 50, "src/recursos/enemigo/enemigoDerecha2.gif");
		Sprites arriba1 = new Sprites(50, 50, "src/recursos/enemigo/enemigoArriba1.gif");
		Sprites arriba2 = new Sprites(50, 50, "src/recursos/enemigo/enemigoArriba2.gif");
		Sprites izquierda1 = new Sprites(50, 50, "src/recursos/enemigo/enemigoIzquierda1.gif");
		Sprites izquierda2 = new Sprites(50, 50, "src/recursos/enemigo/enemigoIzquierda2.gif");
		Sprites abajo1 = new Sprites(50, 50, "src/recursos/enemigo/enemigoAbajo1.gif");
		Sprites abajo2 = new Sprites(50, 50, "src/recursos/enemigo/enemigoAbajo2.gif");
		this.imagenesDerecha.add(derecha1);
		this.imagenesDerecha.add(derecha2);
		this.imagenesIzquierda.add(izquierda1);
		this.imagenesIzquierda.add(izquierda2);
		this.imagenesArriba.add(arriba1);
		this.imagenesArriba.add(arriba2);
		this.imagenesAbajo.add(abajo1);
		this.imagenesAbajo.add(abajo2);
		// TODO Auto-generated constructor stub
	}

	public void actualizar() {
		try {
			for (Bala a : Bala.ArrayBalas) {
				if (a.entidadCreadora instanceof Jugador) {
					for (Enemigo ss : GestorJuego.enemigos) {

						if (a.rectangulo.intersects(ss.areaCuerpo)) {
							System.out.println("Ha dado");
							ss.dano(1);
							a.rectangulo.setLocation(10000000, 10000000);
							Bala.ArrayBalas.remove(a);
							a = null;
						}
						if (ss.getVida() == 0) {
							Jugador.contadorMuertes++;
							morir();
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		disparar();
	}

	@Override
	public void dibujar(Graphics2D g) {
		if (this.donde == 1) {

			DibujosBasicos.pintarImagenEnemigo(g, this.imagenesIzquierda.get(contIzquierda), this);
		}
		if (this.donde == 2) {

			DibujosBasicos.pintarImagenEnemigo(g, this.imagenesDerecha.get(contDerecha), this);
		}
		if (this.donde == 3) {

			DibujosBasicos.pintarImagenEnemigo(g, this.imagenesArriba.get(contArriba), this);
		}
		if (this.donde == 4) {

			DibujosBasicos.pintarImagenEnemigo(g, this.imagenesAbajo.get(contAbajo), this);
		}
		this.moverse();

		g.setFont(new Font("Mia", Font.ITALIC, 6));
		DibujosBasicos.pintarTexto(g, this.getPosicion().x, this.getPosicion().y - (this.getPosicion().y / 20),
				String.valueOf(this.getVida()));
		areaCuerpo = new Rectangle(this.getPosicion().x, this.getPosicion().y, this.getAncho(), this.getAlto());

		areaActivacion = new Rectangle(this.getPosicion().x - ((this.getAncho() * 12) / 2),
				this.getPosicion().y - ((this.getAlto() * 12) / 2), this.getAncho() * 20, this.getAlto() * 20);
		g.draw(areaActivacion);

		this.actualizar();

	}

	@Override
	public void dano(int dano) {
		this.setVida(this.getVida() - dano);
	}

	public void morir() {
		GestorJuego.enemigos.remove(this);
		this.setPosicion(Constantes.DESAPARECER);
	}

	public void moverse() {

		tiempoAhora++;

		Point posicionJugador = GestorJuego.jugador.getPosicion();
		int posicionEnemigoX = (int) this.getPosicion().getX();
		int posicionEnemigoY = (int) this.getPosicion().getY();
		Point posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);

		if (this.moverse) {
			int aleatorio = (int) (Math.random() * 2) + 1;
			switch (aleatorio) {
			case 1:

				// IZQUIERDA
				if (this.getPosicion().x > posicionJugador.getX() && tiempoAhora == 50) {

					contIzquierda++;
					if (contIzquierda == 2) {
						contIzquierda = 0;
					}
					this.donde = 1;

					posicionEnemigoX = posicionEnemigoX - 1;
					posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
					this.setPosicion(posicionEnemigoNueva);
					tiempoAhora = 0;
				}
				// DERECHA
				if (this.getPosicion().x < posicionJugador.getX() && tiempoAhora == 50) {

					contDerecha++;
					if (contDerecha == 2) {
						contDerecha = 0;
					}
					this.donde = 2;

					posicionEnemigoX = posicionEnemigoX + 1;
					posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
					this.setPosicion(posicionEnemigoNueva);
					tiempoAhora = 0;
				}
				break;
			case 2:
				// Arriba

				if (this.getPosicion().y > posicionJugador.getY() && tiempoAhora == 50) {
					contArriba++;
					if (contArriba == 2) {
						contArriba = 0;
					}
					this.donde = 3;
					posicionEnemigoY = posicionEnemigoY - 1;
					posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
					this.setPosicion(posicionEnemigoNueva);
					tiempoAhora = 0;
				}
				// Abajo
				if (this.getPosicion().y < posicionJugador.getY() && tiempoAhora == 50) {
					contAbajo++;
					if (contAbajo == 2) {
						contAbajo = 0;
					}
					this.donde = 4;

					posicionEnemigoY = posicionEnemigoY + 1;
					posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
					this.setPosicion(posicionEnemigoNueva);
					tiempoAhora = 0;
				}
				break;

			default:
				break;
			}
		}else {
			int aleatorio = (int) (Math.random() * 4) + 1;
			switch (aleatorio) {
			case 1:

				// IZQUIERDA
				if(tiempoAhora == 50) {
					contIzquierda++;
					if (contIzquierda == 2) {
						contIzquierda = 0;
					}
					this.donde = 1;

					posicionEnemigoX = posicionEnemigoX - 1;
					posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
					this.setPosicion(posicionEnemigoNueva);
					tiempoAhora = 0;
				}
				break;
			case 2:
				// Arriba
				if(tiempoAhora == 50) {
					contArriba++;
					if (contArriba == 2) {
						contArriba = 0;
					}
					this.donde = 3;
					posicionEnemigoY = posicionEnemigoY - 1;
					posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
					this.setPosicion(posicionEnemigoNueva);
					tiempoAhora = 0;
				}
				break;
			case 3:
				//Derecha
				if(tiempoAhora == 50) {
				contDerecha++;
				if (contDerecha == 2) {
					contDerecha = 0;
				}
				this.donde = 2;

				posicionEnemigoX = posicionEnemigoX + 1;
				posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora = 0;
				}
				break;
			case 4:
				//Abajo
				if(tiempoAhora == 50) {
				contAbajo++;
				if (contAbajo == 2) {
					contAbajo = 0;
				}
				this.donde = 4;

				posicionEnemigoY = posicionEnemigoY + 1;
				posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora = 0;
				}
				break;
			default:
				break;
			}

		}
		if (tiempoAhora == 50) {
			tiempoAhora = 0;
		}

	}

	public void disparar() {
		Point posicionJugador = GestorJuego.jugador.getPosicion();
		if (posicionJugador.y <= this.getPosicion().getY()
				&& posicionJugador.y + GestorJuego.jugador.getAlto() >= this.getPosicion().getY()
				&& this.getPosicion().x > posicionJugador.getX()) {
			Point posicionBala = new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala = new Bala(posicionBala, "oeste", this);

		}
		if (posicionJugador.y <= this.getPosicion().getY()
				&& posicionJugador.y + GestorJuego.jugador.getAlto() >= this.getPosicion().getY()
				&& this.getPosicion().x < posicionJugador.getX()) {
			Point posicionBala = new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala = new Bala(posicionBala, "este", this);

		}
		if (posicionJugador.x <= this.getPosicion().getX()
				&& posicionJugador.x + GestorJuego.jugador.getAncho() >= this.getPosicion().getX()
				&& this.getPosicion().y > posicionJugador.getY()) {
			Point posicionBala = new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala = new Bala(posicionBala, "norte", this);

		}
		if (posicionJugador.x <= this.getPosicion().getX()
				&& posicionJugador.x + GestorJuego.jugador.getAncho() >= this.getPosicion().getX()
				&& this.getPosicion().y < posicionJugador.getY()) {
			Point posicionBala = new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala = new Bala(posicionBala, "sur", this);

		}
	}

	public boolean isMoverse() {
		return moverse;
	}

	public void setMoverse(boolean moverse) {
		this.moverse = moverse;
	}

	public boolean isDispararAJugador() {
		return dispararAJugador;
	}

	public void setDispararAJugador(boolean dispararAJugador) {
		this.dispararAJugador = dispararAJugador;
	}
	
}
