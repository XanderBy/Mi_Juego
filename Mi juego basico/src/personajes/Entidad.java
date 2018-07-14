package personajes;

import java.awt.Image;
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
	private Sprites sprite;
	private int vida;
	private int resistencia;
	private int velocidadMovimiento;
	private Point posicion;
	private int ancho;
	private int alto;
		
	
	public Entidad(int ancho, int alto, Point posicion, int vida, int resistencia,
			int velocidadMovimiento, String urlQuieto) {
		super();
		this.ancho=ancho;
		this.alto=alto;
		this.posicion=posicion;
		this.vida = vida;
		this.resistencia = resistencia;
		this.velocidadMovimiento = velocidadMovimiento;
		this.urlQuieto=urlQuieto;
		cargarImagen(ancho, alto, urlQuieto);
	}

	public void cargarImagen(int ancho, int alto, String url) {
		this.sprite=new Sprites(ancho, alto, url);
		
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

	public Sprites getSprite() {
		return sprite;
	}

	public void setSprite(Sprites sprite) {
		this.sprite = sprite;
	}
	
	
	
}
