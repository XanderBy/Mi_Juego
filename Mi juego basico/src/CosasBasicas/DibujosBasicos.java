package CosasBasicas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import objetos.Armas;
import personajes.Jugador;
import visual.Mapa;

public class DibujosBasicos 
{
	
	public static void pintarRectangulo(Graphics g, int ancho, int alto,int posicionX, int posicionY)//Color color 
	{
		Rectangle rectangulo=new Rectangle(posicionX, posicionY, ancho, alto);
		g.setColor(Color.RED);
		g.fillRect(posicionX, posicionY, ancho, alto);
		
		
	}
	
	public static void pintarImagenJugador(Graphics2D g, Sprites sprite, Jugador jugador)
	{
		g.drawImage(sprite.imagen, jugador.getPosicion().x, jugador.getPosicion().y, sprite.introducirImagenesArray(sprite.imagen), null);
	}
	public static void pintarImagenArmas(Graphics2D g, Sprites sprite, Armas armas)
	{

		g.drawImage(sprite.imagen, armas.posicion.x, armas.posicion.y, sprite.introducirImagenesArray(sprite.imagen), null);
		g.drawRect(armas.posicion.x, armas.posicion.y, armas.ancho, armas.alto);
	}
	public static void pintarImagenMapa(Graphics2D g, SpritesMapa sprite, Mapa mapa)
	{
		g.drawImage(sprite.imagen, mapa.getPosicion().x, mapa.getPosicion().y, sprite.introducirImagenesArrayMapa(sprite.imagen), null);
	}
	public static void pintarTexto(Graphics g, int posicionX, int posicionY, String texto) 
	{	
		g.setColor(Color.WHITE);
		g.drawString(texto, posicionX, posicionY);
	}
	public static void pintarRectanguloColor(Graphics g, int ancho, int alto,int posicionX, int posicionY, Color color)//Color color 
	{
		g.setColor(color);
		g.fillRect(posicionX, posicionY, ancho, alto);
	}
	public static void pintarBoton(Graphics g, int ancho, int alto,int posicionX, int posicionY, Color color)//Color color 
	{
		
		Rectangle nombre=new Rectangle(posicionX, posicionY, ancho, alto);
		g.setColor(color);
		g.fillRect(posicionX, posicionY, ancho, alto);
		
		
	}
}
