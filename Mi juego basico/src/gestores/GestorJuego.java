package gestores;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;
import dibujadoBasePantalla.ParteInferior;
import objetos.Armas;
import objetos.Bala;
import objetos.Objetos;
import personajes.Jugador;
import visual.Mapa;

public class GestorJuego extends GestorPadre
{	
	private static Point posicionObjeto1=new Point(AccionesBasicas.escalarPantallaX(300), AccionesBasicas.escalarPantallaY(300));
	private static Point posicionObjeto2=new Point(AccionesBasicas.escalarPantallaX(500), AccionesBasicas.escalarPantallaY(400));
	
	private static Point posicionJugador= new Point(AccionesBasicas.escalarPantallaX(200), AccionesBasicas.escalarPantallaY(200));
	
	//Principal---
	public static Jugador jugador= new Jugador(30, 55, posicionJugador, 100, 50, 0, Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,"C:\\\\Users\\\\alexi\\\\Desktop\\\\personaje.gif");
	public static Mapa mapa= new Mapa(640, 640, "C:\\Users\\alexi\\Desktop\\descarga.png");
	//---
	
	
	public static Armas arma1=new Armas(posicionObjeto1, "C:\\Users\\alexi\\Desktop\\descarga.jpg", "C:\\Users\\alexi\\Desktop\\descarga.gif", 10, 14); 
	public static Armas arma2=new Armas(posicionObjeto2, "C:\\Users\\alexi\\Desktop\\descarga.jpg", "C:\\Users\\alexi\\Desktop\\descarga.gif", 10, 14); 
	
	public static Rectangle rectangulo;
	
	public static int rectanguloAx= 0;
	public static int rectanguloAy= 0;
	public static Rectangle paredArriba;
	public static int rectanguloDx= Constantes.ANCHOMAPA;
	public static int rectanguloDy= 0;
	public static Rectangle paredDerecha;
	public static int rectanguloIx= 0;
	public static int rectanguloIy= 0;
	public static Rectangle paredIzquierda;
	public static int rectanguloAbx= 0;
	public static int rectanguloAby= Constantes.ALTOMAPA;
	public static Rectangle paredAbajo;
	
	public static boolean activoJuego=false;
	
	public static ArrayList<Rectangle> colisiones=new ArrayList<Rectangle>();
	public static ArrayList<Objetos> objetosMapa=new ArrayList<Objetos>();
	
	//Prueba
	public static int rectangulo1x= 250;
	public static int rectangulo1y= 250;
	//Acaba la prueba
	
	//Aqui lo que pase mientras se juega
	@Override
	public void dibujar(Graphics2D g) {
		
		g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		
		//Importante
		mapa.dibujar(g);
		dibujarArmas(g);
		jugador.dibujar(g);
		
		
		paredAbajo= new Rectangle(rectanguloAbx,rectanguloAby, Constantes.ANCHOMAPA, 3);
		paredIzquierda= new Rectangle(rectanguloIx,rectanguloIy, 3, Constantes.ALTOMAPA);
		paredArriba= new Rectangle(rectanguloAx,rectanguloAy, Constantes.ANCHOMAPA, 3);
		paredDerecha= new Rectangle(rectanguloDx,rectanguloDy, 3, Constantes.ALTOMAPA);
		//---
		//Prueba
		rectangulo= new Rectangle(rectangulo1x,rectangulo1y,50,50);
		g.drawRect(rectangulo.x, rectangulo.y, 50, 50);
		//---

		recorrerArrayBalaMover(g);
		
		
		g.drawRect(rectanguloAbx,rectanguloAby, Constantes.ANCHOMAPA, 3);
		g.drawRect(rectanguloAx,rectanguloAy, 3, Constantes.ALTOMAPA);
		g.drawRect(rectanguloDx,rectanguloDy, 3, Constantes.ALTOMAPA);
		g.drawRect(rectanguloIx,rectanguloIy, Constantes.ANCHOMAPA, 3);
		
		
		
		
	}
	public void dibujarArmas(Graphics2D g) 
	{
		arma1.dibujar(g, arma1);
		arma2.dibujar(g, arma2);
	}
	public static void cargarArrayColisiones() 
	{
		colisiones.add(rectangulo);
		colisiones.add(paredArriba);
		colisiones.add(paredAbajo);
		colisiones.add(paredIzquierda);
		colisiones.add(paredDerecha);
	}
	public static void eliminarArrayColisiones()
	{	
		colisiones.removeAll(colisiones);
	}
	public static void cargarArrayObjetos() {
		objetosMapa.add(arma1);
		objetosMapa.add(arma2);
	}
	public static void eliminarArrayObjetos() {
		objetosMapa.removeAll(objetosMapa);
	}
	public static void recorrerArrayBalaMover(Graphics2D g) {
		try
		{
		for (Bala bala : Bala.ArrayBalas) {
			
			Bala.contador++;
			
			if(Bala.contador!=100)
			{
				bala.recorridoBala(bala, g);
			}else
			{
				Bala.ArrayBalas.remove(bala);
				
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
