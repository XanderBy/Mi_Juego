package CosasBasicas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		introducirImagenesArray(imagen, imagen.getWidth(), imagen.getHeight());
	}
	
	public Color introducirImagenesArray(BufferedImage imagen, int ancho, int alto) 
	{	
		
		for (int x = 0; x < ancho; x++) 
		{
			for (int y = 0; y < alto; y++) 
			{	
				return Color.getColor("", this.pixeles[(x*y)]= imagen.getRGB(x, y));
				
				
			}
				
			
		}
		return null;
	}
	
}
