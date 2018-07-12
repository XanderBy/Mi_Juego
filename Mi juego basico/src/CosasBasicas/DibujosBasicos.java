package CosasBasicas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DibujosBasicos 
{
	
	public void pintarRectangulo(Graphics g, int ancho, int alto,int posicionX, int posicionY, Color color) 
	{
		Rectangle rectangulo=new Rectangle(posicionX, posicionY, ancho, alto);
		g.setColor(color);
		g.fillRect(posicionX, posicionY, ancho, alto);
		
		
	}
	public void pintarTexto(Graphics g, int posicionX, int posicionY, String texto) 
	{
		g.drawString(texto, posicionX, posicionY);
	}
	
}
