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
		GestorJuego.rectanguloIx= GestorJuego.rectanguloIx + velocidad;
		GestorJuego.rectanguloAbx= GestorJuego.rectanguloAbx + velocidad;
		GestorJuego.rectanguloAx= GestorJuego.rectanguloAx + velocidad;
		GestorJuego.rectanguloDx= GestorJuego.rectanguloDx + velocidad;
	}
	public static void correccionXNegativo(int velocidad) 
	{
		//GestorJuego.rectangulo.x=GestorJuego.rectangulo.x - velocidad;
		GestorJuego.rectangulo1x=GestorJuego.rectangulo1x - velocidad;
		GestorJuego.rectanguloIx= GestorJuego.rectanguloIx - velocidad;
		GestorJuego.rectanguloAbx= GestorJuego.rectanguloAbx - velocidad;
		GestorJuego.rectanguloAx= GestorJuego.rectanguloAx - velocidad;
		GestorJuego.rectanguloDx= GestorJuego.rectanguloDx - velocidad;
	}
	public static void correccionYPositivo(int velocidad) 
	{
		//GestorJuego.rectangulo.y=GestorJuego.rectangulo.y + velocidad;
		GestorJuego.rectangulo1y=GestorJuego.rectangulo1y + velocidad;
		GestorJuego.rectanguloIy= GestorJuego.rectanguloIy + velocidad;
		GestorJuego.rectanguloAby= GestorJuego.rectanguloAby + velocidad;
		GestorJuego.rectanguloAy= GestorJuego.rectanguloAy + velocidad;
		GestorJuego.rectanguloDy= GestorJuego.rectanguloDy + velocidad;
	}
	public static void correccionYNegativo(int velocidad) 
	{
		//GestorJuego.rectangulo.y=GestorJuego.rectangulo.y - velocidad;
		GestorJuego.rectangulo1y=GestorJuego.rectangulo1y - velocidad;
		GestorJuego.rectanguloIy= GestorJuego.rectanguloIy - velocidad;
		GestorJuego.rectanguloAby= GestorJuego.rectanguloAby - velocidad;
		GestorJuego.rectanguloAy= GestorJuego.rectanguloAy - velocidad;
		GestorJuego.rectanguloDy= GestorJuego.rectanguloDy - velocidad;
	}
}
