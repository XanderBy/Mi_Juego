package Controles;

import gestores.GestorJuego;

public class Tecla extends Teclado
{	
	
	public static void acciones(Teclado teclado) 
	{
		if(teclado.teclado[0]==true) 
		{	
			GestorJuego.jugador.moverArriba(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimiento());
		}
		if(teclado.teclado[1]==true) 
		{	
			GestorJuego.jugador.moverAbajo(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimiento());
		}
		if(teclado.teclado[2]==true) 
		{	
			GestorJuego.jugador.moverIzquierda(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimiento());
			//Pasara x cosas
		}
		if(teclado.teclado[3]==true) 
		{	
			GestorJuego.jugador.moverDerecha(GestorJuego.jugador.getPosicion(), GestorJuego.jugador.getVelocidadMovimiento());
			//Pasara x cosas
		}
		
	}
}
