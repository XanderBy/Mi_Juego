package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import Controles.Tecla;
import CosasBasicas.DibujosBasicos;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;
import objetos.balas.Bala;

public class Enemigo extends Entidad implements MetodosEntidades {
	public Rectangle areaCuerpo;
	public Rectangle areaDano;
	private long tiempoAhora = 0;

	public Enemigo(int ancho, int alto, Point posicion, int vida, int velocidadMovimientoXIzquierda,
			int velocidadMovimientoYArriba, int velocidadMovimientoXDerecha, int velocidadMovimientoYAbajo,
			String urlQuieto) {
		super(ancho, alto, posicion, vida, velocidadMovimientoXIzquierda, velocidadMovimientoYArriba,
				velocidadMovimientoXDerecha, velocidadMovimientoYAbajo, urlQuieto);
		// TODO Auto-generated constructor stub
	}

	public void actualizar() {
		this.moverse();
		try {
			for (Bala a : Tecla.arrayBalas) {
				if (a.rectangulo.intersects(GestorJuego.enemigos.get(0).areaCuerpo)) {
					System.out.println("Ha dado");
					a.rectangulo = new Rectangle(111111111, 111111111, 0, 0);
					a = null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		disparar();
	}

	@Override
	public void dibujar(Graphics2D g) {
		DibujosBasicos.pintarRectangulo(g, this.getAncho(), this.getAlto(), this.getPosicion().x, this.getPosicion().y);
		areaCuerpo = new Rectangle(this.getPosicion().x, this.getPosicion().y, this.getAncho(), this.getAlto());
		actualizar();

	}

	@Override
	public void dano(int dano) {
		this.setVida(this.getVida() - dano);
	}

	public void moverse() {

		tiempoAhora++;
		// System.out.println(tiempoAhora);
		Point posicionJugador = GestorJuego.jugador.getPosicion();
		int posicionEnemigoX = (int) this.getPosicion().getX();
		int posicionEnemigoY = (int) this.getPosicion().getY();
		Point posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
		// System.out.println(this.getPosicion() + " " + posicionJugador);
		int aleatorio = (int) (Math.random() * 2) + 1;
		switch (aleatorio) {
		case 1:
			// System.out.println(this.getPosicion().x);
			if (this.getPosicion().x > posicionJugador.getX() && tiempoAhora == 100) {

				posicionEnemigoX = posicionEnemigoX - 1;
				posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora = 0;
			}
			if (this.getPosicion().x < posicionJugador.getX() && tiempoAhora == 100) {
				posicionEnemigoX = posicionEnemigoX + 1;
				posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora = 0;
			}
			break;
		case 2:
			if (this.getPosicion().y > posicionJugador.getY() && tiempoAhora == 100) {
				posicionEnemigoY = posicionEnemigoY - 1;
				posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora = 0;
			}
			if (this.getPosicion().y < posicionJugador.getY() && tiempoAhora == 100) {
				posicionEnemigoY = posicionEnemigoY + 1;
				posicionEnemigoNueva = new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora = 0;
			}
			break;

		default:
			break;
		}
		if (tiempoAhora == 100) {
			tiempoAhora = 0;
		}

	}
	public void disparar() {
		Point posicionJugador = GestorJuego.jugador.getPosicion();
		if(posicionJugador.y<=this.getPosicion().getY()&& posicionJugador.y+GestorJuego.jugador.getAlto()>=this.getPosicion().getY() && this.getPosicion().x > posicionJugador.getX()) {
			Point posicionBala=new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala= new Bala(posicionBala, "oeste",GestorJuego.enemigo1);
			Tecla.arrayBalas.add(bala);
		}
		if(posicionJugador.y<=this.getPosicion().getY()&& posicionJugador.y+GestorJuego.jugador.getAlto()>=this.getPosicion().getY() && this.getPosicion().x < posicionJugador.getX()) {
			Point posicionBala=new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala= new Bala(posicionBala, "este",GestorJuego.enemigo1);
			Tecla.arrayBalas.add(bala);
		}
		if(posicionJugador.x<=this.getPosicion().getX()&& posicionJugador.x+GestorJuego.jugador.getAncho()>=this.getPosicion().getX() && this.getPosicion().y > posicionJugador.getY()) {
			Point posicionBala=new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala= new Bala(posicionBala, "norte",GestorJuego.enemigo1);
			Tecla.arrayBalas.add(bala);
		}
		if(posicionJugador.x<=this.getPosicion().getX()&& posicionJugador.x+GestorJuego.jugador.getAncho()>=this.getPosicion().getX() && this.getPosicion().y < posicionJugador.getY()) {
			Point posicionBala=new Point(this.getPosicion().x, this.getPosicion().y);
			Bala bala= new Bala(posicionBala, "sur",GestorJuego.enemigo1);
			Tecla.arrayBalas.add(bala);
		}
	}

}
