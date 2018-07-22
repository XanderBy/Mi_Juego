package Controles;

import gestores.GestorEscape;
import gestores.GestorInventario;
import gestores.GestorJuego;
import objetos.Objetos;

public class Tecla extends Teclado
{	
	
	public static void acciones(Teclado teclado) 
	{
		if(teclado.teclado[0]==true) 
		{	
			GestorJuego.jugador.moverArriba(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoYArriba());
			
		}
		if(teclado.teclado[1]==true) 
		{	
			GestorJuego.jugador.moverAbajo(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoYAbajo());
			
		}
		if(teclado.teclado[2]==true) 
		{	
			
			GestorJuego.jugador.moverIzquierda(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoXIzquierda());
			//Pasara x cosas
			
		}
		if(teclado.teclado[3]==true) 
		{	
			GestorJuego.jugador.moverDerecha(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimientoXDerecha());
			//Pasara x cosas
			
		}
		if(teclado.teclado[4]==true) 
		{	
			if(GestorInventario.activoInventario==true) {
				GestorInventario.activoInventario=false;
				GestorJuego.activoJuego=true;
			}else {
				GestorInventario.activoInventario=true;
				GestorJuego.activoJuego=false;
			}
			
		}
		if(teclado.teclado[5]==true) 
		{	
			if(GestorEscape.activoEscape==true) {
				GestorEscape.activoEscape=false;
				GestorJuego.activoJuego=true;
			}else {
				GestorEscape.activoEscape=true;
				GestorJuego.activoJuego=false;
			}
			
		}
		if(teclado.teclado[6]==true) 
		{	
			System.out.println("el inventario del personaje es" + GestorJuego.jugador.inventarioArray.size());
			
			for (Objetos a : GestorJuego.objetosMapa) {
				if(GestorJuego.jugador.areaJugadorInfluencia.intersects(a.areaObjetoInfluencia)) {
					GestorJuego.jugador.cogerObjetos(a);
					System.out.println("el inventario del personaje es" + GestorJuego.jugador.inventarioArray.size());
					a.cogido=true;
				}
			}
		}
	}
}
