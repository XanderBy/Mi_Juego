package visual;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import CosasBasicas.Objetos;
import CosasBasicas.Sprites;

public class Casa implements Objetos {
	private Rectangle areaCasa;
	private int posicionX;
	private int posicionY;
	private int ancho;
	private int alto;
	private String url;
	private Sprites sprite;
	
	
	public Casa(int posicionX, int posicionY, int ancho, int alto, String url) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
		this.url = url;
		this.sprite=new Sprites(ancho, alto, url);
		
		
	}
	
	public void dibujar(Graphics2D g) {
		try {
			Objetos.borrarObjetosArray(this);
			Objetos.borrarObjetosColisionArray(areaCasa);
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		this.areaCasa=new Rectangle(this.posicionX, this.posicionY, this.ancho, this.alto);
		Objetos.introducirObjetosArray(this);
		Objetos.introducirObjetosColisionArray(areaCasa);
		g.drawImage(this.sprite.imagen, this.posicionX, this.posicionY, this.ancho, this.alto, null);
	}

	public Rectangle getAreaCasa() {
		return areaCasa;
	}

	public void setAreaCasa(Rectangle areaCasa) {
		this.areaCasa = areaCasa;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Sprites getSprite() {
		return sprite;
	}

	public void setSprite(Sprites sprite) {
		this.sprite = sprite;
	}
	
	 
	
}
