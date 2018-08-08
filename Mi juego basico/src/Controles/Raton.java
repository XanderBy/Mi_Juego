package Controles;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import CosasBasicas.AccionesBasicas;
import gestores.GestorEscape;
import gestores.GestorInventario;
import gestores.GestorJuego;
import gestores.GestorMenuPrincipal;
import gestores.GestorOpciones;
import objetos.Objetos;
import visual.SuperficieDibujo;

public class Raton implements MouseListener
{	
	
	public static Point puntaRaton;
	private Rectangle puntero;
	private SuperficieDibujo sd;
	private GestorMenuPrincipal gmp=new GestorMenuPrincipal();
	public static Objetos recuadroInventario=null;
	public Point posicionObjetos;
	
	public void actualizar()
	{	
		
		
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
		if(GestorMenuPrincipal.activoMenuPrincipal==true) 
		{	
			GestorInventario.activoInventario=false;
			GestorJuego.activoJuego=false;
			GestorEscape.activoEscape=false;
			GestorOpciones.activoOpciones=false;
			
			if(puntero.intersects(gmp.nuevaPartida)) {
				GestorJuego.activoJuego=true;
			}
			if(puntero.intersects(GestorMenuPrincipal.salir)) {
				System.exit(0);
			}
			if(puntero.intersects(GestorMenuPrincipal.opciones)) {
				GestorOpciones.activoOpciones=true;
				
			}
		}
		
		
		if(GestorJuego.activoJuego==true) {
			GestorMenuPrincipal.activoMenuPrincipal=false;
			GestorInventario.activoInventario=false;
			GestorEscape.activoEscape=false;
			GestorOpciones.activoOpciones=false;
			if(puntero.intersects(GestorJuego.rectangulo)) {
				System.out.println("Hola");
			}
				
			
			
			
		}
		
		
		if(GestorEscape.activoEscape==true) {
			GestorMenuPrincipal.activoMenuPrincipal=false;
			GestorInventario.activoInventario=false;
			GestorJuego.activoJuego=false;
			GestorOpciones.activoOpciones=false;
			if(puntero.intersects(GestorEscape.salir)) {
				System.exit(0);
			}
			if(puntero.intersects(GestorEscape.opciones)) {
				GestorOpciones.activoOpciones=true;
			}
		}
		
		
		if(GestorOpciones.activoOpciones==true) 
		{

			if(puntero.intersects(GestorOpciones.cerrar))
			{
				GestorOpciones.activoOpciones=false;
			}
			
		}
		
		
		if(GestorInventario.activoInventario==true) 
		{
			GestorMenuPrincipal.activoMenuPrincipal=false;
			GestorJuego.activoJuego=false;
			GestorEscape.activoEscape=false;
			GestorOpciones.activoOpciones=false;
			
			if(GestorInventario.poderMover==true)
			{
				
				if(puntero.intersects(GestorInventario.moverObjeto)) 
				{
					posicionObjetos=GestorInventario.moverObjeto.getLocation();
					GestorInventario.poderMover=false;
					System.out.println("Hola");
				}
			}
			
			try
			{
				if(puntero.intersects(GestorInventario.mover)) 
				{
					GestorInventario.poderMover=true;
				}
				if(puntero.intersects(GestorInventario.soltar)) 
				{
					for (int i = 0; i < GestorJuego.jugador.inventarioArray.length; i++) {
						//GestorJuego.jugador.inventarioArray.remove(recuadroInventario);
						if(GestorJuego.jugador.inventarioArray[i]==recuadroInventario)
						{
							GestorJuego.jugador.inventarioArray[i]=null;
						}
					}
					
					recuadroInventario.cogido=false;
					posicionObjetos=new Point(AccionesBasicas.escalarPantallaX(200), AccionesBasicas.escalarPantallaY(200));
					recuadroInventario.posicion=posicionObjetos;
					
					recuadroInventario=null;
				}
				if(puntero.intersects(GestorInventario.utilizar)) 
				{
					
				}
			}catch(NullPointerException ee) {
				
			}
			
			if(e.getButton()== e.BUTTON3)
			{
				for (Objetos a : GestorJuego.jugador.inventarioArray) 
				{	
					
					if (puntero.intersects(a.getAreaObjetoInfluencia())) {
						System.out.println(23111111);
						recuadroInventario=a;
						break;
					}
				}
			}
			
			if(e.getButton()== e.BUTTON1)
			{
				for (Objetos a : GestorJuego.jugador.inventarioArray) 
				{	
					try
					{
						if (!puntero.intersects(a.getAreaObjetoInfluencia())) {
							
							recuadroInventario=null;
						}
					}catch (Exception ee) 
					{
						
					}
					
				}
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
