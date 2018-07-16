package Controles;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gestores.GestorJuego;
import gestores.GestorMenuPrincipal;
import visual.SuperficieDibujo;

public class Raton implements MouseListener
{	
	
	public static Point puntaRaton;
	private Rectangle puntero;
	private SuperficieDibujo sd;
	private GestorMenuPrincipal gmp=new GestorMenuPrincipal();
	
	public void actualizar()
	{	
		//Esta mal coge la posicion de la pantalla
		SuperficieDibujo.arraySuperficie[0].actualizar();
		puntaRaton=SuperficieDibujo.arraySuperficie[0].posicionRaton;
		//System.out.println("posicion raton:" + puntaRaton);
		if(puntaRaton==null) {
			puntaRaton=new Point(0, 0);
		}
		puntero= new Rectangle((int) puntaRaton.getX(),(int) puntaRaton.getY(), 2, 2);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{	
		if(GestorMenuPrincipal.activoMenuPrincipal==true) {
			if(puntero.intersects(gmp.nuevaPartida)) {
				GestorJuego.activoJuego=true;
				System.out.println("Hola");
			}
		}
		if(GestorJuego.activoJuego==true) {
			GestorMenuPrincipal.activoMenuPrincipal=false;
			if(puntero.intersects(GestorJuego.rectangulo)) {
				System.out.println("Hola");
			}
			
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
