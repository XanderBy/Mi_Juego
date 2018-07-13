package visual;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

import Controles.Raton;
import Controles.Teclado;
import CosasBasicas.Sprites;
import constantes.Constantes;
import personajes.Jugador;

public class SuperficieDibujo extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferStrategy buffer;
	private Graphics2D g;
	private Dimension dimension;
	public static Point posicionRaton;
	public static SuperficieDibujo[] arraySuperficie= new SuperficieDibujo[1];
	//Prueba esto se borrará
	//-
	private Sprites sprite= new Sprites(99, 140, "C:\\Users\\alexi\\Desktop\\descarga.jpg");
	public static Rectangle rectangulo;
	//-
	public SuperficieDibujo(int ancho, int alto, Teclado teclado, Raton raton) 
	{
		setPreferredSize(dimension= new Dimension(ancho, alto));
		
		this.addKeyListener(teclado);
		this.addMouseListener(raton);
	}
	
	public void actualizar() {
		posicionRaton=this.getMousePosition();
	}
	
	
	public void dibujar() 
	{
		buffer= getBufferStrategy();
		if(buffer==null) 
		{
			createBufferStrategy(3);
			return;
		}
		g= (Graphics2D) buffer.getDrawGraphics();
		
		g.clearRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		g.drawRect(250, 250, 50, 50);
		rectangulo= new Rectangle(250, 250, 50, 50);
		// g.scale(1.5, 1.5);
		g.drawImage((Image) sprite.imagen, 100, 100, 99, 140,(Color) sprite.introducirImagenesArray(sprite.imagen, 99, 140), null);
		
		
		g.dispose();
		
		buffer.show();
		//repaint(0, 0, Constantes.ANCHO, Constantes.ALTO);
	}
	public static SuperficieDibujo[] getArraySuperficie() {
		return arraySuperficie;
	}

	public static void setArraySuperficie(SuperficieDibujo[] arraySuperficie) {
		SuperficieDibujo.arraySuperficie = arraySuperficie;
	}
}
