package gestores;

import java.awt.Color;
import java.awt.Graphics2D;

import constantes.Constantes;

public class GestorInventario extends GestorPadre {
	public static boolean activoInventario=false;
	@Override
	public void dibujar(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		
	}

}
