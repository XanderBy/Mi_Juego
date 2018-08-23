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
	public Rectangle rectangulo;
	public final String direccion;
	public static int contador = 0;
	public int contadorVida = 0;
	public static ArrayList<Bala> ArrayBalas = new ArrayList<Bala>();
	public Entidad entidadCreadora;
	public Bala(Point posicion, String direccion, Entidad entidadCreadora) {
		super();
		this.posicion = posicion;
		this.direccion = direccion;
		this.entidadCreadora=entidadCreadora;
		rectangulo = new Rectangle(posicion.x, posicion.y, 2, 2);
		ArrayBalas.add(this);
	}

	public void recorridoBala(Bala bala, Graphics2D g) {
		switch (direccion) {
		case "norte":
			System.out.println(this.entidadCreadora);
			if(this.entidadCreadora instanceof Jugador) {
					System.out.println("Hola");
					bala.posicion.y=bala.posicion.y - ((Armas) Tecla.objetoElegido).velocidadDisparo;
				
				
			}
			if(this.entidadCreadora instanceof Enemigo) {
				bala.posicion.y--;
			}
			
			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;
		case "sur":
			if(this.entidadCreadora instanceof Jugador) {
				System.out.println("Hola");
				bala.posicion.y=bala.posicion.y + ((Armas) Tecla.objetoElegido).velocidadDisparo;
			
			
		}
		if(this.entidadCreadora instanceof Enemigo) {
			bala.posicion.y++;
		}
			bala.posicion.y++;
			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;

		case "este":
			if(this.entidadCreadora instanceof Jugador) {
				System.out.println("Hola");
				bala.posicion.x=bala.posicion.x + ((Armas) Tecla.objetoElegido).velocidadDisparo;
			
			
		}
		if(this.entidadCreadora instanceof Enemigo) {
			bala.posicion.x++;
		}
			
			rectangulo = new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;

		case "oeste":
			if(this.entidadCreadora instanceof Jugador) {
				System.out.println("Hola");
				bala.posicion.x=bala.posicion.x - ((Armas) Tecla.objetoElegido).velocidadDisparo;
			
			
		}
		if(this.entidadCreadora instanceof Enemigo) {
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
