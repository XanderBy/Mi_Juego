package personajes;

import java.awt.Point;

import CosasBasicas.Sprites;

public class Entidad 
{	
	//Faltaria añadir al constructor los url
	private String urlQuieto;
	private String urlDerecha;
	private String urlArriba;
	private String urlIzquierda;
	private String urlAbajo;
	private int ancho;
	private int alto;
	private Point posicion;
	private int vida;
	private int resistencia;
	private int velocidadMovimiento;
		
	
	public Entidad(String urlQuieto, int ancho, int alto, Point posicion, int vida, int resistencia,
			int velocidadMovimiento) {
		super();
		this.urlQuieto = urlQuieto;
		this.ancho = ancho;
		this.alto = alto;
		this.posicion = posicion;
		this.vida = vida;
		this.resistencia = resistencia;
		this.velocidadMovimiento = velocidadMovimiento;
		cargarImagen(ancho, alto, urlQuieto);
	}

	public void cargarImagen(int ancho, int alto, String urlQuieto) {
		Sprites sprite=new Sprites(ancho, alto, urlQuieto);
		
	}

	public String getUrlQuieto() {
		return urlQuieto;
	}

	public void setUrlQuieto(String urlQuieto) {
		this.urlQuieto = urlQuieto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}

	public void setVelocidadMovimiento(int velocidadMovimiento) {
		this.velocidadMovimiento = velocidadMovimiento;
	}
	
	
	
	
}
