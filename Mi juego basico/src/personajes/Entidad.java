package personajes;

import java.awt.Point;

import CosasBasicas.Sprites;

public class Entidad 
{
	private String url;
	private int ancho;
	private int alto;
	private Point posicionInicio;
	private int vida;
	private int resistencia;
	private int velocidadMovimiento;
		
	
	public Entidad(String url, int ancho, int alto, Point posicionInicio, int vida, int resistencia,
			int velocidadMovimiento) {
		super();
		this.url = url;
		this.ancho = ancho;
		this.alto = alto;
		this.posicionInicio = posicionInicio;
		this.vida = vida;
		this.resistencia = resistencia;
		this.velocidadMovimiento = velocidadMovimiento;
		cargarImagen(ancho, alto, url);
	}

	public void cargarImagen(int ancho, int alto, String url) {
		Sprites sprite=new Sprites(ancho, alto, url);
		
	}
	
	
	
	
}
