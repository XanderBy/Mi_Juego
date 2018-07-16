package visual;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import Controles.Raton;
import Controles.Teclado;
import constantes.Constantes;
import gestores.GestorJuego;
import gestores.GestorMenuPrincipal;

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
	private GestorJuego gj=new GestorJuego();
	private GestorMenuPrincipal gmp=new GestorMenuPrincipal();
	//Prueba esto puede que se borré
	//-
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
		
		if(GestorMenuPrincipal.activoMenuPrincipal==true) 
		{
			gmp.dibujar(g);
		}
		if(GestorJuego.activoJuego==true) 
		{
			gj.dibujar(g);
		}
		
		
		
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
