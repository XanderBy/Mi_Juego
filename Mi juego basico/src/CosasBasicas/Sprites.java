package CosasBasicas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import constantes.Constantes;

public class Sprites 
{
	//Esta clase es dudosa creo que seria mejor coger la misma imagen
	private int ancho;
	private int alto;
	private int[] pixeles;
	public BufferedImage imagen;
	public Sprites(int ancho, int alto, String url) 
	{
		try 
		{
			imagen= ImageIO.read(new File(url));
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pixeles=new int[imagen.getWidth() * imagen.getHeight()];
		introducirImagenesArray(imagen);
	}
	
	public Color introducirImagenesArray(BufferedImage imagen) 
	{	
		
		for (int x = 0; x < Constantes.ANCHO; x++) 
		{
			for (int y = 0; y < Constantes.ALTO; y++) 
			{	
				//De momento dibujaría todo el mapa
				if(ancho > Constantes.ANCHO) {
					
					break;
				}
				return Color.getColor("", this.pixeles[(x*y)]= imagen.getRGB(x, y));
				
				
				
			}
				
			
		}
		return null;
	}
	
}
