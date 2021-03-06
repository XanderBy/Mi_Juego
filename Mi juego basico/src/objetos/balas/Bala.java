package objetos.balas;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import Controles.Tecla;
import objetos.armas.Armas;
import personajes.Enemigo;
import personajes.Entidad;
import personajes.Jugador;

public class Bala {
	public Point posicion;
	public int X=0;
	public int Y=0;
	public Rectangle rectangulo;
	public final String direccion;
	public int contador = 0;
	public int contadorVida = 0;
	public static ArrayList<Bala> ArrayBalas = new ArrayList<Bala>();
	public Entidad entidadCreadora;

	public Bala(Point posicion, String direccion, Entidad entidadCreadora) {
		super();
		this.posicion = posicion;
		this.X=posicion.x;
		this.Y=posicion.y;
		this.direccion = direccion;
		this.entidadCreadora = entidadCreadora;
		rectangulo = new Rectangle(posicion.x, posicion.y, 2, 2);
		ArrayBalas.add(this);
		if (this.entidadCreadora instanceof Jugador) {
			Tecla.esperarArma = 0;
		}
	}

	public void recorridoBala(Bala bala, Graphics2D g, Enemigo enemigo) {
		switch (direccion) {
		case "norte":

			if (this.entidadCreadora instanceof Jugador) {
				bala.posicion.y = bala.posicion.y - ((Armas) Tecla.objetoElegido).velocidadDisparo;

			}
			if (this.entidadCreadora instanceof Enemigo) {
				bala.posicion.y -= enemigo.velocidadDisparo;
			}

			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			//System.out.println(bala.contador);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);

			bala.contadorVida++;
			break;
		case "sur":
			if (this.entidadCreadora instanceof Jugador) {
				bala.posicion.y = bala.posicion.y + ((Armas) Tecla.objetoElegido).velocidadDisparo;

			}
			if (this.entidadCreadora instanceof Enemigo) {
				bala.posicion.y++;
			}
			//bala.posicion.y++;
			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;

		case "este":
			if (this.entidadCreadora instanceof Jugador) {
				bala.posicion.x = bala.posicion.x + ((Armas) Tecla.objetoElegido).velocidadDisparo;

			}
			if (this.entidadCreadora instanceof Enemigo) {
				bala.posicion.x++;
			}

			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;

		case "oeste":
			if (this.entidadCreadora instanceof Jugador) {
				bala.posicion.x = bala.posicion.x - ((Armas) Tecla.objetoElegido).velocidadDisparo;

			}
			if (this.entidadCreadora instanceof Enemigo) {
				bala.posicion.x--;
			}

			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;
		default:
			System.out.println("Error direccion bala!!");
			break;
		}

	}

}
