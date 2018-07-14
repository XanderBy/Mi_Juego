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
	private static Point posicionJugador= new Point(50, 50);
	public static SuperficieDibujo[] arraySuperficie= new SuperficieDibujo[1];
	//Prueba esto puede que se borré
	//-
	public static Mapa mapa= new Mapa(640, 640, "C:\\Users\\alexi\\Desktop\\descarga.png");
	public static Rectangle rectangulo;
	public static Jugador jugador= new Jugador(135, 135, posicionJugador, 10, 10, 1,"C:\\\\Users\\\\alexi\\\\Desktop\\\\descarga.gif");
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
		g.scale(3, 1.5);
		
		mapa.dibujar(g);
		rectangulo= new Rectangle(250, 250, 50, 50);
		g.drawRect(250, 250, 50, 50);
		jugador.dibujar(g);
		
		g.dispose();
		buffer.show();
	}
	public static SuperficieDibujo[] getArraySuperficie() {
		return arraySuperficie;
	}

	public static void setArraySuperficie(SuperficieDibujo[] arraySuperficie) {
		SuperficieDibujo.arraySuperficie = arraySuperficie;
	}
}
