package personajes;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Personaje {
	
	
	//Atributos
	private int vida;
	private int velocidad;
	private int posicionX;
	private int posicionY;
	private String posicionImagen;
	private static BufferedImage image;
	
	//Constructor
	public Personaje(int vida, int velocidad, int posicionX, int posicionY, String posicionImagen) {
		super();
		this.vida = vida;
		this.velocidad = velocidad;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.posicionImagen=posicionImagen;
		
		File archivo= new File(posicionImagen);
		try {
			image= ImageIO.read(archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Getters-Setters
	
	public int getVida() {
		return vida;
	}
	
	public String getPosicionImagen() {
		return posicionImagen;
	}
	public void setPosicionImagen(String posicionImagen) {
		this.posicionImagen = posicionImagen;
	}
	public static BufferedImage getImage() {
		return image;
	}
	public static void setImage(BufferedImage image) {
		Personaje.image = image;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
	
}
