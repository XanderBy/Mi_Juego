package personajes;

import java.awt.Graphics2D;

import controles.Controles;

public class Jugador extends Personaje {
	
	//Atributos
	private static String armas[]= new String[5];
	private static int contadorMuertes;
	private static Graphics2D g;
	
	public static final int danio=5;
	
	//Constructor
	public Jugador(int vida, int velocidad, int posicionX, int posicionY, String posicionImagen) {
		super(vida, velocidad, posicionX, posicionY, posicionImagen);
		// TODO Auto-generated constructor stub
	}
	
	//Metodos
	public void dano() {
		this.setVida(this.getVida()-danio);
	}
	public void cogerArma() {
		
	}
	public void disparar() {
		if(Controles.isDisparar()==true) {
			//Ocurriran cosas malas xD
		}
	}
	public void moverse() {
		if(Controles.isAbajo()==true) {
			this.setPosicionY(this.getPosicionY()+this.getVelocidad());
		}
		if(Controles.isArriba()==true) {
			this.setPosicionY(this.getPosicionY()-this.getVelocidad());
		}
		if(Controles.isDerecha()==true) {
			this.setPosicionX(this.getPosicionX()+this.getVelocidad());
		}
		if(Controles.isIzquierda()==true) {
			this.setPosicionX(this.getPosicionX()-this.getVelocidad());
		}
	}
	//Este dudo ahora mismo------------
	public void dibujar() {
		
	}
	
	//Getter-Setter
	public static String[] getArmas() {
		return armas;
	}

	public static void setArmas(String[] armas) {
		Jugador.armas = armas;
	}

	public static int getContadorMuertes() {
		return contadorMuertes;
	}

	public static void setContadorMuertes(int contadorMuertes) {
		Jugador.contadorMuertes = contadorMuertes;
	}
	
}
