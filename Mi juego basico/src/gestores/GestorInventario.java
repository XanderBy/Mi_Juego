package gestores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;
import objetos.Armas;
import visual.SuperficieDibujo;

public class GestorInventario extends GestorPadre {
	public static boolean activoInventario=false;
	
	private static int contX=0;
	private static int contY=0;
	@Override
	public void dibujar(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		
		g.setColor(Color.WHITE);
		for (int i = 0; i < 3; i++) 
		{
			contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			contY+= SuperficieDibujo.arraySuperficie[0].getHeight()/4;
			for (int j = 0; j < 3; j++) 
			{
				
				g.drawRect(AccionesBasicas.escalarPantallaX(contX), AccionesBasicas.escalarPantallaY(contY), 25, 25);
				contX+= SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			}
		}
		contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
		contY=0;
		
		
		for (int i = 0; i < GestorJuego.jugador.inventarioArray.size(); i++) 
		{
			contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			contY+= SuperficieDibujo.arraySuperficie[0].getHeight()/4;
			for (int j = 0; j < GestorJuego.jugador.inventarioArray.size(); j++) 
			{
				Point posicionNueva=new Point(AccionesBasicas.escalarPantallaX(contX), AccionesBasicas.escalarPantallaY(contY));
				
				GestorJuego.jugador.inventarioArray.get(i+j).posicion=posicionNueva;
				DibujosBasicos.pintarImagenArmas(g, GestorJuego.jugador.inventarioArray.get(i+j).sprite,(Armas) GestorJuego.jugador.inventarioArray.get(i+j));
				contX+= SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			}
		}
		contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
		contY=0;
		
		
	}

}
