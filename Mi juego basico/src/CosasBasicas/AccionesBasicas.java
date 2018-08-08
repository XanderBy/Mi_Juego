package CosasBasicas;

import constantes.Constantes;
import gestores.GestorJuego;
import objetos.Objetos;
import visual.Mapa;

public class AccionesBasicas {
	
	public static int escalarPantallaX(int numero)
	{
		return (int) (numero/Constantes.ESCALAX);
	}
	public static int escalarPantallaY(int numero)
	{
		return (int) (numero/Constantes.ESCALAY);
	}
	public static void correccionXPositivo(int velocidad) 
	{
		//GestorJuego.rectangulo.x=GestorJuego.rectangulo.x +velocidad;
		GestorJuego.rectangulo1x=GestorJuego.rectangulo1x + velocidad;
		Mapa.rectanguloIx= Mapa.rectanguloIx + velocidad;
		Mapa.rectanguloAbx= Mapa.rectanguloAbx + velocidad;
		Mapa.rectanguloAx= Mapa.rectanguloAx + velocidad;
		Mapa.rectanguloDx= Mapa.rectanguloDx + velocidad;
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) 
		{
			if(a.cogido==false) 
			{
				a.posicion.x=a.posicion.x + velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();
	}
	public static void correccionXNegativo(int velocidad) 
	{
		//GestorJuego.rectangulo.x=GestorJuego.rectangulo.x - velocidad;
		GestorJuego.rectangulo1x=GestorJuego.rectangulo1x - velocidad;
		Mapa.rectanguloIx= Mapa.rectanguloIx - velocidad;
		Mapa.rectanguloAbx= Mapa.rectanguloAbx - velocidad;
		Mapa.rectanguloAx= Mapa.rectanguloAx - velocidad;
		Mapa.rectanguloDx= Mapa.rectanguloDx - velocidad;
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) 
		{
			if(a.cogido==false) 
			{
			a.posicion.x=a.posicion.x - velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();
		
	}
	public static void correccionYPositivo(int velocidad) 
	{
		//GestorJuego.rectangulo.y=GestorJuego.rectangulo.y + velocidad;
		GestorJuego.rectangulo1y=GestorJuego.rectangulo1y + velocidad;
		Mapa.rectanguloIy= Mapa.rectanguloIy + velocidad;
		Mapa.rectanguloAby= Mapa.rectanguloAby + velocidad;
		Mapa.rectanguloAy= Mapa.rectanguloAy + velocidad;
		Mapa.rectanguloDy= Mapa.rectanguloDy + velocidad;
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) 
		{
			if(a.cogido==false) 
			{
				a.posicion.y=a.posicion.y + velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();
	}
	public static void correccionYNegativo(int velocidad) 
	{
		//GestorJuego.rectangulo.y=GestorJuego.rectangulo.y - velocidad;
		GestorJuego.rectangulo1y=GestorJuego.rectangulo1y - velocidad;
		Mapa.rectanguloIy= Mapa.rectanguloIy - velocidad;
		Mapa.rectanguloAby= Mapa.rectanguloAby - velocidad;
		Mapa.rectanguloAy= Mapa.rectanguloAy - velocidad;
		Mapa.rectanguloDy= Mapa.rectanguloDy - velocidad;
		GestorJuego.cargarArrayObjetos();
		for (Objetos a : GestorJuego.objetosMapa) 
		{
			if(a.cogido==false) 
			{
				a.posicion.y=a.posicion.y - velocidad;
			}
		}
		GestorJuego.eliminarArrayObjetos();
	}
}
