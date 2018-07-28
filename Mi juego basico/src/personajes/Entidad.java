package personajes;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

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
	private int velocidadMovimientoXIzquierda;
	private int velocidadMovimientoYArriba;
	private int velocidadMovimientoXDerecha;
	private int velocidadMovimientoYAbajo;
	private Point posicion;
	private int ancho;
	private int alto;
	public ArrayList<Sprites> imagenesDerecha=new ArrayList<Sprites>();
	public ArrayList<Sprites> imagenesAbajo=new ArrayList<Sprites>();
	public ArrayList<Sprites> imagenesIzquierda=new ArrayList<Sprites>();
	public ArrayList<Sprites> imagenesArriba=new ArrayList<Sprites>();
	
	public Entidad(int ancho, int alto, Point posicion, int vida,
			int velocidadMovimientoXIzquierda,int velocidadMovimientoYArriba,int velocidadMovimientoXDerecha,int velocidadMovimientoYAbajo, String urlQuieto) {
		super();
		this.ancho=ancho;
		this.alto=alto;
		this.posicion=posicion;
		this.vida = vida;
		this.velocidadMovimientoXIzquierda = velocidadMovimientoXIzquierda;
		this.velocidadMovimientoYArriba = velocidadMovimientoYArriba;
		this.velocidadMovimientoXDerecha = velocidadMovimientoXDerecha;
		this.velocidadMovimientoYAbajo = velocidadMovimientoYAbajo;
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

	public int getVelocidadMovimientoXIzquierda() {
		return velocidadMovimientoXIzquierda;
	}

	public void setVelocidadMovimientoXIzquierda(int velocidadMovimientoXIzquierda) {
		this.velocidadMovimientoXIzquierda = velocidadMovimientoXIzquierda;
	}

	public int getVelocidadMovimientoYArriba() {
		return velocidadMovimientoYArriba;
	}

	public void setVelocidadMovimientoYArriba(int velocidadMovimientoYArriba) {
		this.velocidadMovimientoYArriba = velocidadMovimientoYArriba;
	}

	public int getVelocidadMovimientoXDerecha() {
		return velocidadMovimientoXDerecha;
	}

	public void setVelocidadMovimientoXDerecha(int velocidadMovimientoXDerecha) {
		this.velocidadMovimientoXDerecha = velocidadMovimientoXDerecha;
	}

	public int getVelocidadMovimientoYAbajo() {
		return velocidadMovimientoYAbajo;
	}

	public void setVelocidadMovimientoYAbajo(int velocidadMovimientoYAbajo) {
		this.velocidadMovimientoYAbajo = velocidadMovimientoYAbajo;
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
