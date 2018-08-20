package objetos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import objetos.armas.Armas;

public class Objetos 
{
	public Point posicion;
	public Rectangle areaObjetoInfluencia;
	private String url;
	private String urlInventario;
	public Sprites sprite;
	public Sprites spriteInventario;
	public int ancho;
	public int alto;
	public boolean cogido=false;
	public TipoObjetos tipoObjeto;
	
	public Objetos(Point posicion, String url,String urlInventario, int ancho, int alto, TipoObjetos tipoObjetos) 
	{
		super();
		this.posicion = posicion;
		this.url = url;
		this.urlInventario = urlInventario;
		this.ancho = ancho;
		this.alto = alto;
		this.tipoObjeto=tipoObjetos;
		cargarImagen(ancho, alto, url);
		cargarImagenInventario(ancho, alto, urlInventario);
		this.areaObjetoInfluencia=new Rectangle(posicion.x, posicion.y, ancho, alto);
		this.cogido=false;
	}


	public void cargarImagen(int ancho, int alto, String url) 
	{
		sprite= new Sprites(ancho, alto, url);
	}
	
	public void cargarImagenInventario(int ancho, int alto, String urlInventario) 
	{
		spriteInventario= new Sprites(ancho, alto, urlInventario);
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


	public TipoObjetos getTipoObjeto() {
		return tipoObjeto;
	}


	public void setTipoObjeto(TipoObjetos tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}
	
}
