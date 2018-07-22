package objetos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;

public class Objetos 
{
	public Point posicion;
	public Rectangle areaObjetoInfluencia;
	private String url;
	public Sprites sprite;
	private int ancho;
	private int alto;
	public boolean cogido=false;
	
	
	public Objetos(Point posicion, String url, int ancho, int alto) 
	{
		super();
		this.posicion = posicion;
		this.url = url;
		this.ancho = ancho;
		this.alto = alto;
		cargarImagen(ancho, alto, url);
		areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		cogido=false;
	}


	public void cargarImagen(int ancho, int alto, String url) 
	{
		sprite= new Sprites(ancho, alto, url);
	}
	
	public void dibujar(Graphics2D g, Armas arma) 
	{
		if(cogido==false)
		{
			DibujosBasicos.pintarImagenArmas(g, arma.sprite, arma);
		}
	}
	
}
