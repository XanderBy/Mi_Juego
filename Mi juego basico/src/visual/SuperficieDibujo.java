package visual;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controles.Teclado;
import CosasBasicas.Sprites;
import constantes.Constantes;

public class SuperficieDibujo extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferStrategy buffer;
	private Graphics g;
	private Dimension dimension;
	Sprites sprite= new Sprites(99, 140, "C:\\Users\\alexi\\Desktop\\descarga.jpg");
	
	
	public SuperficieDibujo(int ancho, int alto, Teclado teclado) 
	{
		setPreferredSize(dimension= new Dimension(ancho, alto));

		this.addKeyListener(teclado);
	}
	
	public void dibujar() 
	{
		buffer= getBufferStrategy();
		if(buffer==null) 
		{
			createBufferStrategy(3);
			return;
		}
		g= buffer.getDrawGraphics();
		
		g.clearRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		g.drawRect(12, 12, 50, 50);
		
		g.drawImage((Image) sprite.imagen, 100, 100, 99, 140,(Color) sprite.introducirImagenesArray(sprite.imagen, 99, 140), null);
		g.dispose();
		
		buffer.show();
	}

}
