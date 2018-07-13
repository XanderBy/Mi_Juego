package personajes;

import java.awt.Point;

import CosasBasicas.AtributosBasicos;
import CosasBasicas.Sprites;

public class Entidad extends AtributosBasicos
{	
	//Faltaria añadir al constructor los url
	private String urlQuieto;
	private String urlDerecha;
	private String urlArriba;
	private String urlIzquierda;
	private String urlAbajo;
	private int vida;
	private int resistencia;
	private int velocidadMovimiento;
	private Point posicion;
		
	
	public Entidad(String urlQuieto, int ancho, int alto, Point posicion, int vida, int resistencia,
			int velocidadMovimiento) {
		super();
		this.urlQuieto = urlQuieto;
		this.setAncho(ancho);
		this.setAlto(alto);
		this.posicion=posicion;
		this.vida = vida;
		this.resistencia = resistencia;
		this.velocidadMovimiento = velocidadMovimiento;
		cargarImagen(ancho, alto, urlQuieto);
	}

	

	public String getUrlQuieto() {
		return urlQuieto;
	}

	public void setUrlQuieto(String urlQuieto) {
		this.urlQuieto = urlQuieto;
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

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}
	
	
	
	
	
}
