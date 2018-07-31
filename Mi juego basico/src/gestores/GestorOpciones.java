package gestores;

import java.awt.Color;
import java.awt.Graphics2D;

import constantes.Constantes;

public class GestorOpciones {
	public static boolean activoOpciones=false;
	public void dibujar(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constantes.ANCHO,Constantes.ALTO);
	}
}
