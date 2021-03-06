package CosasBasicas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import constantes.Constantes;

public class Sprites 
{

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

		}
		pixeles=new int[ancho * alto];
		introducirImagenesArray(imagen);
	}
	
	public Color introducirImagenesArray(BufferedImage imagen) 
	{	
		
			for (int x = 0; x < this.ancho; x++) 
			{
				for (int y = 0; y < this.alto; y++) 
				{	
					
					
					if(imagen.getTransparency()==2) {
						return null;
						
					}else {

					return Color.getColor("", this.pixeles[(x*y)]= imagen.getRGB(x, y));
					}
					
					
				}
					
				
			}
		return null;
	}
	
}
