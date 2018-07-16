package CosasBasicas;

import constantes.Constantes;
import gestores.GestorJuego;

public class AccionesBasicas {
	
	public static int escalarPantallaX(int numero)
	{
		return (int) (numero*Constantes.ESCALAX);
	}
	public static int escalarPantallaY(int numero)
	{
		return (int) (numero*Constantes.ESCALAY);
	}
	public static void correccionXPositivo(int velocidad) 
	{
		//GestorJuego.rectangulo.x=GestorJuego.rectangulo.x +velocidad;
		GestorJuego.rectangulo1x=GestorJuego.rectangulo1x + velocidad;
	}
	public static void correccionXNegativo(int velocidad) 
	{
		//GestorJuego.rectangulo.x=GestorJuego.rectangulo.x - velocidad;
		GestorJuego.rectangulo1x=GestorJuego.rectangulo1x - velocidad;
	}
	public static void correccionYPositivo(int velocidad) 
	{
		//GestorJuego.rectangulo.y=GestorJuego.rectangulo.y + velocidad;
		GestorJuego.rectangulo1y=GestorJuego.rectangulo1y + velocidad;
	}
	public static void correccionYNegativo(int velocidad) 
	{
		//GestorJuego.rectangulo.y=GestorJuego.rectangulo.y - velocidad;
		GestorJuego.rectangulo1y=GestorJuego.rectangulo1y - velocidad;
	}
}
