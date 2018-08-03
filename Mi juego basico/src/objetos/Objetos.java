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
	public int ancho;
	public int alto;
	public boolean cogido=false;
	
	
	public Objetos(Point posicion, String url, int ancho, int alto) 
	{
		super();
		this.posicion = posicion;
		this.url = url;
		this.ancho = ancho;
		this.alto = alto;
		cargarImagen(ancho, alto, url);
		this.areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		this.cogido=false;
	}


	public void cargarImagen(int ancho, int alto, String url) 
	{
		sprite= new Sprites(ancho, alto, url);
	}
	
	public void dibujar(Graphics2D g, Objetos arma) 
	{
		if(arma.isCogido()==false)
		{
			//System.out.println("No cogido");
			DibujosBasicos.pintarImagenArmas(g, arma.sprite, (Armas) arma);
			arma.areaObjetoInfluencia=new Rectangle(this.posicion.x, this.posicion.y, this.ancho, this.alto);
		}else {
			try
			{
				arma.areaObjetoInfluencia=new Rectangle(100000, 100000, 0, 0);
			}catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
	}


	public Point getPosicion() {
		return posicion;
	}


	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}


	public boolean isCogido() {
		return cogido;
	}


	public void setCogido(boolean cogido) {
		this.cogido = cogido;
	}


	public Rectangle getAreaObjetoInfluencia() {
		return areaObjetoInfluencia;
	}


	public void setAreaObjetoInfluencia(Rectangle areaObjetoInfluencia) {
		this.areaObjetoInfluencia = areaObjetoInfluencia;
	}
	
}
