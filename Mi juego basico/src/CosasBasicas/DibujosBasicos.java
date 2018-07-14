package CosasBasicas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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
	public static void pintarImagenMapa(Graphics2D g, Sprites sprite, Mapa mapa)
	{
		g.drawImage(sprite.imagen, mapa.getPosicion().x, mapa.getPosicion().y, sprite.introducirImagenesArray(sprite.imagen), null);
	}
	public void pintarTexto(Graphics g, int posicionX, int posicionY, String texto) 
	{
		g.drawString(texto, posicionX, posicionY);
	}
	
}
