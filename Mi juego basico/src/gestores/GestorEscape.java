package gestores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import CosasBasicas.DibujosBasicos;
import constantes.Constantes;

public class GestorEscape extends GestorPadre {
	public static boolean activoEscape=false;
	public static Rectangle opciones;
	public static Rectangle salirMenu;
	public static Rectangle salirJuego;
	@Override
	public void dibujar(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		
		
		g.setColor(Color.red);
		opciones=new Rectangle(Constantes.ANCHO/3, (Constantes.ALTO + (Constantes.ALTO/2))/4, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO + (Constantes.ALTO/2))/4, Constantes.ANCHO/3, Constantes.ANCHO/18);
		
		salirMenu=new Rectangle( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/3, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/3, Constantes.ANCHO/3, Constantes.ANCHO/18);
		
		salirJuego=new Rectangle( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/2, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/2, Constantes.ANCHO/3, Constantes.ANCHO/18);
		
	}

}
