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
	
	public static boolean poderMover=false;
	public static Rectangle moverObjeto;
	
	public static Rectangle mover;
	public static Rectangle soltar;
	public static Rectangle utilizar;
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
		
		//Armaduras
		contX=(SuperficieDibujo.arraySuperficie[0].getWidth()/4)+(SuperficieDibujo.arraySuperficie[0].getWidth()/2);
		for (int i = 0; i < 3; i++) 
		{
			contY+=SuperficieDibujo.arraySuperficie[0].getHeight()/5;
			g.drawRect(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
			
		}
		
		contY=0;
		int largo=0;
		if(GestorJuego.jugador.inventarioArray.length<=3)
		{
			largo=1;
		}
		if(3 < GestorJuego.jugador.inventarioArray.length && GestorJuego.jugador.inventarioArray.length<=6)
		{
			largo=2;
		}
		if(6 < GestorJuego.jugador.inventarioArray.length && GestorJuego.jugador.inventarioArray.length<=9)
		{
			largo=3;
		}
		int ancho=0;
		if(GestorJuego.jugador.inventarioArray.length<=3)
		{
			ancho=2;
		}
		if(3 < GestorJuego.jugador.inventarioArray.length && GestorJuego.jugador.inventarioArray.length<=6)
		{
			ancho=3;
		}
		if(6 < GestorJuego.jugador.inventarioArray.length && GestorJuego.jugador.inventarioArray.length<=9)
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
				if(i+j == (GestorJuego.jugador.inventarioArray.length)) {
					break;
				}
				try {
				Point posicionNueva=new Point(contX, contY);
					System.out.println(i+j);
					GestorJuego.jugador.inventarioArray[i+j].posicion=posicionNueva;
					//System.out.println(posicionNueva);
					g.drawImage(GestorJuego.jugador.inventarioArray[i+j].spriteInventario.imagen, GestorJuego.jugador.inventarioArray[i+j].posicion.x, GestorJuego.jugador.inventarioArray[i+j].posicion.y, GestorJuego.jugador.inventarioArray[i+j].spriteInventario.introducirImagenesArray(GestorJuego.jugador.inventarioArray[i+j].spriteInventario.imagen), null);
					  
					GestorJuego.jugador.inventarioArray[i+j].areaObjetoInfluencia= new Rectangle(GestorJuego.jugador.inventarioArray[i+j].posicion.x, GestorJuego.jugador.inventarioArray[i+j].posicion.y, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
				}catch (Exception e) {
					// TODO: handle exception
				}
					
				contX+= SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			}
		}
		contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
		contY=0;
		if(Raton.recuadroInventario!=null) 
		{
			g.setColor(Color.GREEN);
			g.drawRect(Raton.recuadroInventario.posicion.x, Raton.recuadroInventario.posicion.y, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
			g.setColor(Color.BLACK);
			g.fillRect(Raton.recuadroInventario.posicion.x,  10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/30);
			soltar=new Rectangle(Raton.recuadroInventario.posicion.x,  10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/30);
			
			g.fillRect(Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth()/7, 10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/30);
			mover=new Rectangle(Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth()/7, 10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/30);
			
			g.fillRect(Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth()/3, 10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/30);
			utilizar= new Rectangle(Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth()/3, 10, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/30);
			
			g.setColor(Color.white);
			DibujosBasicos.pintarTexto(g, Raton.recuadroInventario.posicion.x, 30, "Soltar");
			DibujosBasicos.pintarTexto(g, Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth()/7, 30, "Mover");
			DibujosBasicos.pintarTexto(g, Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth()/3, 30, "Utilizar");
			
		}
		if(poderMover==true) 
		{
			g.setColor(Color.ORANGE);
			//Superficie Dibujada
			for (int i = 0; i < 3; i++) 
			{
				contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
				contY+= SuperficieDibujo.arraySuperficie[0].getHeight()/4;
				for (int j = 0; j < 3; j++) 
				{
					moverObjeto=new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
					g.drawRect(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth()/9, SuperficieDibujo.arraySuperficie[0].getWidth()/9);
					contX+= SuperficieDibujo.arraySuperficie[0].getWidth()/9;
				}
			}
			contX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
			contY=0;
		}
		
	}

}
