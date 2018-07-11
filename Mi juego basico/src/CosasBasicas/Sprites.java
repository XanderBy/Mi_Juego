package CosasBasicas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites 
{
	//Esta clase es dudosa creo que seria mejor coger la misma imagen
	private int ancho;
	private int alto;
	private int[] pixeles= new int[ancho * alto];
	private BufferedImage imagen;
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
		introducirImagenesArray(imagen);
	}
	
	public void introducirImagenesArray(BufferedImage imagen) 
	{
		for (int x = 0; x < pixeles.length; x++) 
		{
			for (int y = 0; y < pixeles.length; y++) 
			{
				pixeles[(x*y)+1]= imagen.getRGB(x, y);
			}
			
			
		}
	}
	
}
