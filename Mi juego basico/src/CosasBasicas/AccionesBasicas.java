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
		GestorJuego.rectangulo1x=GestorJuego.rectangulo1x - velocidad;
	}
	public static void correccionXNegativo() 
	{
		
	}
	public static void correccionYPositivo() 
	{
		
	}
	public static void correccionYNegativo() 
	{
		
	}
}
