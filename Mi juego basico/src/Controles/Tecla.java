package Controles;

import visual.SuperficieDibujo;

public class Tecla extends Teclado
{	
	
	public static void acciones(Teclado teclado) 
	{
		if(teclado.teclado[0]==true) 
		{	
			SuperficieDibujo.jugador.moverArriba(SuperficieDibujo.jugador.getPosicion(), SuperficieDibujo.jugador.getVelocidadMovimiento());
		}
		if(teclado.teclado[1]==true) 
		{	
			SuperficieDibujo.jugador.moverAbajo(SuperficieDibujo.jugador.getPosicion(), SuperficieDibujo.jugador.getVelocidadMovimiento());
		}
		if(teclado.teclado[2]==true) 
		{	
			SuperficieDibujo.jugador.moverIzquierda(SuperficieDibujo.jugador.getPosicion(), SuperficieDibujo.jugador.getVelocidadMovimiento());
			//Pasara x cosas
		}
		if(teclado.teclado[3]==true) 
		{	
			SuperficieDibujo.jugador.moverDerecha(SuperficieDibujo.jugador.getPosicion(), SuperficieDibujo.jugador.getVelocidadMovimiento());
			//Pasara x cosas
		}
		
	}
}
