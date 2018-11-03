package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import Controles.Tecla;
import Controles.Teclado;
import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import constantes.Constantes;
import gestores.GestorJuego;
import gestores.GestorMorir;
import interfaces.MetodosEntidades;
import objetos.balas.Bala;
import objetos.objeto.Objetos;

public class Jugador extends Entidad implements MetodosEntidades {

	private int resistencia;
	private int armadura;
	public static int contadorMuertes = 0;
	public static Rectangle areaJugador1;
	public static Rectangle areaJugador2;
	public static Rectangle areaJugador3;
	public static Rectangle areaJugador4;
	public static Rectangle areaJugadorInfluencia;
	public static Rectangle areaJugadorParaDano;

	// public static ArrayList <Objetos> inventarioArray=new ArrayList <Objetos>();
	public static Objetos[] inventarioArray = new Objetos[9];
	public static Objetos[] inventarioArmadurasArray = new Objetos[3];

	public static boolean booleanJugador1 = false;
	public static boolean booleanJugador2 = false;
	public static boolean booleanJugador3 = false;
	public static boolean booleanJugador4 = false;

	public Jugador(int ancho, int alto, Point posicion, int vida, int resistencia, int armadura,
			int velocidadMovimientoXIzquierda, int velocidadMovimientoYArriba, int velocidadMovimientoXDerecha,
			int velocidadMovimientoYAbajo, String urlQuieto) {
		super(ancho, alto, posicion, vida, velocidadMovimientoXIzquierda, velocidadMovimientoYArriba,
				velocidadMovimientoXDerecha, velocidadMovimientoYAbajo, urlQuieto);
		// TODO Auto-generated constructor stub
		this.resistencia = resistencia;
		this.armadura = armadura;
		Sprites derecha1 = new Sprites(55, 75, "src/recursos/1derecha.gif");
		Sprites derecha2 = new Sprites(55, 75, "src/recursos/2derecha.gif");
		Sprites izquierda1 = new Sprites(55, 75, "src/recursos/1izquierda.gif");
		Sprites izquierda2 = new Sprites(55, 75, "src/recursos/2izquierda.gif");
		this.imagenesDerecha.add(derecha1);
		this.imagenesDerecha.add(derecha2);
		this.imagenesIzquierda.add(izquierda1);
		this.imagenesIzquierda.add(izquierda2);

	}

	public void refrescarInventario() {
		for (Objetos a : inventarioArray) {
			a.getPosicion();
		}
	}

	public void moverArriba(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y = GestorJuego.mapa.posicion.y + velocidadMovimiento;
		AccionesBasicas.correccionYPositivo(velocidadMovimiento);
		colision();
		// posicion.y=posicion.y - velocidadMovimiento;
	}

	public void moverAbajo(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y = GestorJuego.mapa.posicion.y - velocidadMovimiento;
		AccionesBasicas.correccionYNegativo(velocidadMovimiento);
		colision();
		// posicion.y=posicion.y + velocidadMovimiento;
	}

	public void moverIzquierda(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x = GestorJuego.mapa.posicion.x + velocidadMovimiento;
		AccionesBasicas.correccionXPositivo(velocidadMovimiento);
		// posicion.x=posicion.x - velocidadMovimiento;
		colision();
	}

	public void moverDerecha(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x = GestorJuego.mapa.posicion.x - velocidadMovimiento;
		AccionesBasicas.correccionXNegativo(velocidadMovimiento);
		// posicion.x=posicion.x + velocidadMovimiento;
		colision();
	}

	public void colisionMover() {
		// lado izquierdo
		if (booleanJugador1 == true && booleanJugador4 == true && booleanJugador3 == true || booleanJugador1 == true
				|| booleanJugador1 == true && booleanJugador4 == true
				|| booleanJugador4 == true && booleanJugador3 == true) {
			this.setVelocidadMovimientoXIzquierda(0);

		} else {
			this.setVelocidadMovimientoXIzquierda(Constantes.velocidadGeneral);
		}
		// arriba
		if (booleanJugador1 == true && booleanJugador2 == true && booleanJugador4 == true
				|| booleanJugador1 == true && booleanJugador2 == true
				|| booleanJugador1 == true && booleanJugador4 == true) {
			this.setVelocidadMovimientoYArriba(0);
		} else {
			this.setVelocidadMovimientoYArriba(Constantes.velocidadGeneral);
		}
		// derecha
		if (booleanJugador1 == true && booleanJugador2 == true && booleanJugador3 == true
				|| booleanJugador1 == true && booleanJugador2 == true
				|| booleanJugador2 == true && booleanJugador3 == true) {
			this.setVelocidadMovimientoXDerecha(0);
		} else {
			this.setVelocidadMovimientoXDerecha(Constantes.velocidadGeneral);
		}
		// Abajo
		if (booleanJugador2 == true && booleanJugador3 == true && booleanJugador4 == true
				|| booleanJugador2 == true && booleanJugador3 == true
				|| booleanJugador3 == true && booleanJugador4 == true) {
			this.setVelocidadMovimientoYAbajo(0);
		} else {
			this.setVelocidadMovimientoYAbajo(Constantes.velocidadGeneral);
		}
	}

	public static void colision() {
		GestorJuego.cargarArrayColisiones();
		try {
			for (Rectangle a : GestorJuego.colisiones) {

				// System.out.println(GestorJuego.colisiones.size());
				if (areaJugador1.intersects(a)) {
					// GestorJuego.jugador.colisionMover();
					booleanJugador1 = true;
				}
				if (!areaJugador1.intersects(a)) {
					// GestorJuego.jugador.colisionMover();
					booleanJugador1 = false;
				}
				if (areaJugador2.intersects(a)) {
					booleanJugador2 = true;
				}
				if (!areaJugador2.intersects(a)) {
					booleanJugador2 = false;
				}
				if (areaJugador3.intersects(a)) {
					booleanJugador3 = true;
				}
				if (!areaJugador3.intersects(a)) {
					booleanJugador3 = false;
				}
				if (areaJugador4.intersects(a)) {
					booleanJugador4 = true;
				}
				if (!areaJugador4.intersects(a)) {
					booleanJugador4 = false;
				}
				if (booleanJugador1 == true || booleanJugador2 == true || booleanJugador3 == true
						|| booleanJugador4 == true) {

					GestorJuego.jugador.colisionMover();
					break;
				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

		GestorJuego.jugador.colisionMover();
		GestorJuego.eliminarArrayColisiones();
	}

	@Override
	public void dibujar(Graphics2D g) {
		try {
			for (Bala a : Bala.ArrayBalas) {
				if (a.contadorVida == 1000) {
					Bala.ArrayBalas.remove(a);
					a = null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		// Dano al jugador
		try {
			for (Bala a : Bala.ArrayBalas) {
				if (a.entidadCreadora instanceof Enemigo) {
					if (a.rectangulo.intersects(GestorJuego.jugador.areaJugadorParaDano)) {
						System.out.println("Ha dado");
						this.dano(1);
						a.rectangulo.setLocation(10000000, 10000000);
						Bala.ArrayBalas.remove(a);
						a = null;
					}
					if (this.getVida() == 0) {
						this.morir();
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		if (Teclado.tecladoPulsado[4] == true) {
			DibujosBasicos.pintarImagenJugador(g, GestorJuego.jugador.imagenesDerecha.get(Tecla.contDerecha),
					GestorJuego.jugador);
		} else if (Teclado.tecladoPulsado[3] == true) {
			DibujosBasicos.pintarImagenJugador(g, GestorJuego.jugador.imagenesIzquierda.get(Tecla.contIzquierda),
					GestorJuego.jugador);

		} else {
			DibujosBasicos.pintarImagenJugador(g, GestorJuego.jugador.imagenesDerecha.get(Tecla.contDerecha),
					GestorJuego.jugador);

		}

		areaJugadorParaDano = new Rectangle(this.getPosicion().x, this.getPosicion().y, this.getAncho(),
				this.getAlto());
		g.drawRect(this.getPosicion().x, this.getPosicion().y, this.getAncho(), this.getAlto());

		areaJugadorInfluencia = new Rectangle(this.getPosicion().x, this.getPosicion().y, this.getAncho(),
				this.getAlto());
		g.drawRect(this.getPosicion().x - (this.getPosicion().x / 4), this.getPosicion().y - (this.getPosicion().x / 4),
				this.getAncho() + (this.getPosicion().x / 2), this.getAlto() + (this.getPosicion().x / 2));

		areaJugador1 = new Rectangle(this.getPosicion().x, this.getPosicion().y, this.getAncho(), 2);
		g.drawRect(this.getPosicion().x, this.getPosicion().y, this.getAncho(), 2);

		areaJugador2 = new Rectangle(this.getPosicion().x + this.getAncho(), this.getPosicion().y, 2, this.getAlto());
		g.drawRect(this.getPosicion().x + this.getAncho(), this.getPosicion().y, 2, this.getAlto());

		areaJugador3 = new Rectangle(this.getPosicion().x, this.getPosicion().y + this.getAlto(), this.getAncho(), 2);
		g.drawRect(this.getPosicion().x, this.getPosicion().y + this.getAlto(), this.getAncho(), 2);

		areaJugador4 = new Rectangle(this.getPosicion().x, this.getPosicion().y, 2, this.getAlto());
		g.drawRect(this.getPosicion().x, this.getPosicion().y, 2, this.getAlto());
		try {
		for (Enemigo a : GestorJuego.enemigos) {
			if(this.areaJugadorInfluencia.intersects(a.areaActivacion)) {
				a.setMoverse(true);
			}else {
				a.setMoverse(false);
			}
		}
		}catch (NullPointerException e) {
			// TODO: handle exception
		}

	}

	public void morir() {
		GestorJuego.activoJuego = false;
		GestorMorir.gestorMorirActivo = true;
	}

	@Override
	public void dano(int dano) {
		this.setVida(this.getVida() - dano);
	}

	public void cogerObjetos(Objetos objeto) {
		for (int i = 0; i < inventarioArray.length; i++) {
			if (inventarioArray[i] == null) {
				inventarioArray[i] = objeto;
				break;
			}

		}

	}

	public void soltarObjetos(Objetos objeto) {
		// inventarioArray.remove(objeto);
		for (int i = 0; i < inventarioArray.length; i++) {
			if (inventarioArray[i] == objeto) {
				inventarioArray[i] = null;
				break;
			}

		}
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

}
