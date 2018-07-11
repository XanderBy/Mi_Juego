package visual;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Controles.Teclado;
import constantes.Constantes;

public class SuperficieDibujo extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferStrategy buffer;
	private Graphics g;
	private Dimension dimension;
	
	
	
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
		
		
		g.dispose();
		
		buffer.show();
	}

}
