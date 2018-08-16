package Controles;

import java.awt.Point;
import java.util.ArrayList;

import gestores.GestorEscape;
import gestores.GestorInventario;
import gestores.GestorJuego;
import gestores.GestorMenuPrincipal;
import gestores.GestorOpciones;
import objetos.Bala;
import objetos.Objetos;

public class Tecla extends Teclado
{	
	public static String direccion;
	public static int contDerecha=0;
	private static int espera=0;
	
	public static ArrayList<Bala> arrayBalas=new ArrayList<Bala>();
	
	public static void acciones(Teclado teclado) 
	{
		if(GestorMenuPrincipal.activoMenuPrincipal==false && GestorEscape.activoEscape==false && GestorInventario.activoInventario==false && GestorOpciones.activoOpciones==false)
		{
			if(teclado.tecladoPulsado[1]==true) 
			{	
				GestorJuego.jugador.moverArriba(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoYArriba());
				direccion="norte";
				if(teclado.tecladoPulsado[0]==true) {

					Point posicionBala=new Point(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y);
					Bala bala= new Bala(posicionBala, Tecla.direccion);
					
				}
			}
			if(teclado.tecladoPulsado[2]==true) 
			{	
				GestorJuego.jugador.moverAbajo(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoYAbajo());
				direccion="sur";
				if(teclado.tecladoPulsado[0]==true) {

					Point posicionBala=new Point(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y);
					Bala bala= new Bala(posicionBala, Tecla.direccion);
					
				}
			}
			if(teclado.tecladoPulsado[3]==true) 
			{	
				
				GestorJuego.jugador.moverIzquierda(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoXIzquierda());
				//Pasara x cosas
				direccion="oeste";
				if(teclado.tecladoPulsado[0]==true) {

					Point posicionBala=new Point(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y);
					Bala bala= new Bala(posicionBala, Tecla.direccion);
					
				}
			}
			
			if(teclado.tecladoPulsado[4]==true) 
			{	
				GestorJuego.jugador.moverDerecha(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoXDerecha());
				
				//Pasara x cosas
				if(espera==5)
				{
					contDerecha++;
					if(contDerecha == 2)
					{
						contDerecha=0;
					}
					espera=0;
				}
					espera++;
				
				
				
				direccion="este"; 
						if(teclado.tecladoPulsado[0]==true) {

							Point posicionBala=new Point(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y);
							Bala bala= new Bala(posicionBala, Tecla.direccion);
							
						}
				
			}
			if(teclado.tecladoPulsado[5]==true) 
			{	
				if(GestorInventario.activoInventario==true) {
					GestorInventario.activoInventario=false;
					GestorJuego.activoJuego=true;
				}else {
					GestorInventario.activoInventario=true;
					GestorJuego.activoJuego=false;
				}
				
			}
			if(teclado.tecladoPulsado[6]==true) 
			{	
				if(GestorEscape.activoEscape==true) {
					GestorEscape.activoEscape=false;
					GestorJuego.activoJuego=true;
				}else {
					GestorEscape.activoEscape=true;
					GestorJuego.activoJuego=false;
				}
				
			}
			if(teclado.tecladoPulsado[7]==true) 
			{	
				System.out.println("el inventario del personaje es" + GestorJuego.jugador.inventarioArray.length);
				GestorJuego.cargarArrayObjetos();
				//System.out.println(GestorJuego.objetosMapa.size());
				for (Objetos a : GestorJuego.objetosMapa) 
				{
					System.out.println(a.getAreaObjetoInfluencia());
					if(GestorJuego.jugador.areaJugadorInfluencia.intersects(a.getAreaObjetoInfluencia())) 
					{
						
						GestorJuego.jugador.cogerObjetos(a);
						System.out.println("el inventario del personaje es" + GestorJuego.jugador.inventarioArray.length);
						a.setCogido(true);
						
						break;
					}
					}
				GestorJuego.eliminarArrayObjetos();
			}
			if(teclado.tecladoPulsado[0]==true) 
			{	
				Point posicionBala=new Point(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y);
				Bala bala= new Bala(posicionBala, Tecla.direccion);
				Tecla.arrayBalas.add(bala);
				
			}
		}else
		{
			if(teclado.tecladoPulsado[5]==true) 
			{	
				if(GestorInventario.activoInventario==true) {
					GestorInventario.activoInventario=false;
					GestorJuego.activoJuego=true;
				}else {
					GestorInventario.activoInventario=true;
					GestorJuego.activoJuego=false;
				}
				
			}
			if(GestorEscape.activoEscape==true) {
				if(teclado.tecladoPulsado[6]==true) 
				{	
					if(GestorEscape.activoEscape==true) {
						GestorEscape.activoEscape=false;
						GestorJuego.activoJuego=true;
					}else {
						GestorEscape.activoEscape=true;
						GestorJuego.activoJuego=false;
					}
			}
			
				
			}
		}
		
	}
}
