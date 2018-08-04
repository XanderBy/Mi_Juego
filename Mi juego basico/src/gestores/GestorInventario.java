package gestores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import Controles.Raton;
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
		//g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		
		g.setColor(Color.WHITE);
		//Superficie Dibujada
		for (int i = 0; i < 3; i++) 
		{
			contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			contY+= SuperficieDibujo.arraySuperficie[0].getHeight()/4;
			for (int j = 0; j < 3; j++) 
			{
				
				g.drawRect(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
				contX+= SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			}
		}
		contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
		contY=0;
		int largo=0;
		if(GestorJuego.jugador.inventarioArray.size()<=3)
		{
			largo=1;
		}
		if(3 < GestorJuego.jugador.inventarioArray.size() && GestorJuego.jugador.inventarioArray.size()<=6)
		{
			largo=2;
		}
		if(6 < GestorJuego.jugador.inventarioArray.size() && GestorJuego.jugador.inventarioArray.size()<=9)
		{
			largo=3;
		}
		int ancho=0;
		if(GestorJuego.jugador.inventarioArray.size()<=3)
		{
			ancho=2;
		}
		if(3 < GestorJuego.jugador.inventarioArray.size() && GestorJuego.jugador.inventarioArray.size()<=6)
		{
			ancho=3;
		}
		if(6 < GestorJuego.jugador.inventarioArray.size() && GestorJuego.jugador.inventarioArray.size()<=9)
		{
			ancho=4;
		}

		//objetos dibujados
		for (int i = 0; i < largo; i++) 
		{
			contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			contY+= SuperficieDibujo.arraySuperficie[0].getHeight()/4;
			for (int j = 0; j < ancho; j++) 
			{
				if(i+j == (GestorJuego.jugador.inventarioArray.size())) {
					break;
				}
				Point posicionNueva=new Point(contX, contY);
					
					GestorJuego.jugador.inventarioArray.get(i+j).posicion=posicionNueva;
					//System.out.println(posicionNueva);
					g.drawImage(GestorJuego.jugador.inventarioArray.get(i+j).spriteInventario.imagen, GestorJuego.jugador.inventarioArray.get(i+j).posicion.x, GestorJuego.jugador.inventarioArray.get(i+j).posicion.y, GestorJuego.jugador.inventarioArray.get(i+j).spriteInventario.introducirImagenesArray(GestorJuego.jugador.inventarioArray.get(i+j).spriteInventario.imagen), null);
					  
					GestorJuego.jugador.inventarioArray.get(i+j).areaObjetoInfluencia= new Rectangle(GestorJuego.jugador.inventarioArray.get(i+j).posicion.x, GestorJuego.jugador.inventarioArray.get(i+j).posicion.y, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
					
					
				contX+= SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			}
		}
		contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
		contY=0;
		if(Raton.recuadroInventario!=null) {
			g.setColor(Color.GREEN);
			g.fillRect(Raton.recuadroInventario.posicion.x + 10, Raton.recuadroInventario.posicion.y + 10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
			
		}
		
	}

}
