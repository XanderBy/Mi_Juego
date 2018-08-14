package dibujadoBasePantalla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import CosasBasicas.DibujosBasicos;
import gestores.GestorJuego;
import visual.SuperficieDibujo;

public class ParteInferior {
	
	private static int posicionX;
	private static int posicionY;
	
	public static void dibujar(Graphics2D g) 
	{	
		g.setColor(Color.BLACK);
		g.fillRect(0, SuperficieDibujo.arraySuperficie[0].getHeight()/5, SuperficieDibujo.arraySuperficie[0].getWidth(), SuperficieDibujo.arraySuperficie[0].getHeight()/2);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Mia", Font.ITALIC, 6));
		g.drawString("Vida: ", SuperficieDibujo.arraySuperficie[0].getWidth()/200,(SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27);
		g.drawString(String.valueOf(GestorJuego.jugador.getVida()), SuperficieDibujo.arraySuperficie[0].getWidth()/25,(SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27);	
		g.drawString("Estamina: ", SuperficieDibujo.arraySuperficie[0].getWidth()/200, (SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/35);
		g.drawString(String.valueOf(GestorJuego.jugador.getResistencia()), SuperficieDibujo.arraySuperficie[0].getWidth()/25,(SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/35);	
		g.drawString("Armadura: ", SuperficieDibujo.arraySuperficie[0].getWidth()/200, (SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/50);
		g.drawString(String.valueOf(GestorJuego.jugador.getArmadura()), SuperficieDibujo.arraySuperficie[0].getWidth()/25, (SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/50);
		
		for (int i = 0; i < 3; i++) {
			try
			{
				if(i==0) 
				{
					posicionX=SuperficieDibujo.arraySuperficie[0].getWidth()/9 - SuperficieDibujo.arraySuperficie[0].getWidth()/30;
					posicionY=(SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27;
					g.drawImage(GestorJuego.jugador.inventarioArray[i].sprite.imagen, posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].sprite.introducirImagenesArray(GestorJuego.jugador.inventarioArray[i].sprite.imagen), null);
					g.drawRect(posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].ancho, GestorJuego.jugador.inventarioArray[i].alto);
					
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(i==1)
				{
					posicionX=SuperficieDibujo.arraySuperficie[0].getWidth()/9;
					posicionY=(SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27;
					g.drawImage(GestorJuego.jugador.inventarioArray[i].sprite.imagen, posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].sprite.introducirImagenesArray(GestorJuego.jugador.inventarioArray[i].sprite.imagen), null);
					g.drawRect(posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].ancho, GestorJuego.jugador.inventarioArray[i].alto);
				
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
				if(i==2) 
				{
					posicionX=SuperficieDibujo.arraySuperficie[0].getWidth()/6 - SuperficieDibujo.arraySuperficie[0].getWidth()/45;
					posicionY=(SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27;
					g.drawImage(GestorJuego.jugador.inventarioArray[i].sprite.imagen, posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].sprite.introducirImagenesArray(GestorJuego.jugador.inventarioArray[i].sprite.imagen), null);
					g.drawRect(posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].ancho, GestorJuego.jugador.inventarioArray[i].alto);
				
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
				
			
			
		}
		
		posicionX=0;
		posicionY=0;
		
		g.setColor(Color.white);
		g.drawRect(SuperficieDibujo.arraySuperficie[0].getWidth()/9 - SuperficieDibujo.arraySuperficie[0].getWidth()/30, (SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27, 25, 25);
		g.drawRect(SuperficieDibujo.arraySuperficie[0].getWidth()/9, (SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27, 25, 25);
		g.drawRect(SuperficieDibujo.arraySuperficie[0].getWidth()/6 - SuperficieDibujo.arraySuperficie[0].getWidth()/45, (SuperficieDibujo.arraySuperficie[0].getHeight()/4) - SuperficieDibujo.arraySuperficie[0].getHeight()/27, 25, 25);
		
	}
}
