package gestores;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;
import dibujadoBasePantalla.ParteInferior;
import objetos.TipoObjetos;
import objetos.armas.Armas;
import objetos.balas.Bala;
import objetos.objeto.ObjetoEstamina;
import objetos.objeto.ObjetoVida;
import objetos.objeto.Objetos;
import personajes.Enemigo;
import personajes.Jugador;
import visual.Mapa;

public class GestorJuego extends GestorPadre
{	
	
	private static Point posicionObjeto1=new Point(AccionesBasicas.escalarPantallaX(300), AccionesBasicas.escalarPantallaY(300));
	private static Point posicionObjeto2=new Point(AccionesBasicas.escalarPantallaX(500), AccionesBasicas.escalarPantallaY(400));
	
	public static Point posicionJugador= new Point(AccionesBasicas.escalarPantallaX(200), AccionesBasicas.escalarPantallaY(200));
	public static Point posicionEnemigo1= new Point(AccionesBasicas.escalarPantallaX(500), AccionesBasicas.escalarPantallaY(500));
	
	//Principal---
	public static int contadorJugador=0;
	public static Jugador jugador= new Jugador(30, 55, posicionJugador, 100, 50, 0, Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,Constantes.velocidadGeneral,"C:\\\\Users\\\\alexi\\\\Desktop\\\\personaje.gif");
	public static Mapa mapa= new Mapa(640, 640, "C:\\Users\\alexi\\Desktop\\descarga.png");
	public  static Enemigo enemigo1=new Enemigo(10, 10,  posicionEnemigo1, 10, 1, 1, 1, 1, "");
	//---
	
	
	public static Armas arma1=new Armas(posicionObjeto1, "C:\\Users\\alexi\\Desktop\\descarga.jpg", "C:\\Users\\alexi\\Desktop\\descarga.gif", 10, 14, TipoObjetos.ARMAS, 2); 
	public static ObjetoEstamina arma2=new ObjetoEstamina(posicionObjeto2, "C:\\Users\\alexi\\Desktop\\descarga.jpg", "C:\\Users\\alexi\\Desktop\\descarga.gif", 10, 14, TipoObjetos.ESTAMINA,10); 
	
	public static Rectangle rectangulo;
	
	
	
	public static boolean activoJuego=false;
	
	public static ArrayList<Enemigo> enemigos=new ArrayList<Enemigo>();
	public static ArrayList<Rectangle> colisiones=new ArrayList<Rectangle>();
	public static ArrayList<Objetos> objetosMapa=new ArrayList<Objetos>();
	
	//Prueba
	public static int rectangulo1x= 250;
	public static int rectangulo1y= 250;
	//Acaba la prueba
	
	//Aqui lo que pase mientras se juega
	@Override
	public void dibujar(Graphics2D g) {
		
			
		if(contadorJugador==0) {
			enemigos.add(enemigo1);
			//Se volverian a generar los objetos
			Constantes.volverTodoCero();
			contadorJugador++;
		}
		g.scale(Constantes.ESCALAX, Constantes.ESCALAY);
		
		//Importante
		mapa.dibujar(g);
		dibujarArmas(g);
		jugador.dibujar(g);
		enemigo1.dibujar(g);
		
		Mapa.paredAbajo= new Rectangle(Mapa.rectanguloAbx,Mapa.rectanguloAby, Constantes.ANCHOMAPA, 3);
		Mapa.paredIzquierda= new Rectangle(Mapa.rectanguloIx,Mapa.rectanguloIy, 3, Constantes.ALTOMAPA);
		Mapa.paredArriba= new Rectangle(Mapa.rectanguloAx,Mapa.rectanguloAy, Constantes.ANCHOMAPA, 3);
		Mapa.paredDerecha= new Rectangle(Mapa.rectanguloDx,Mapa.rectanguloDy, 3, Constantes.ALTOMAPA);
		//---
		//Prueba
		rectangulo= new Rectangle(rectangulo1x,rectangulo1y,50,50);
		g.drawRect(rectangulo.x, rectangulo.y, 50, 50);
		//---

		recorrerArrayBalaMover(g);
		
		
		g.drawRect(Mapa.rectanguloAbx,Mapa.rectanguloAby, Constantes.ANCHOMAPA, 3);
		g.drawRect(Mapa.rectanguloAx,Mapa.rectanguloAy, 3, Constantes.ALTOMAPA);
		g.drawRect(Mapa.rectanguloDx,Mapa.rectanguloDy, 3, Constantes.ALTOMAPA);
		g.drawRect(Mapa.rectanguloIx,Mapa.rectanguloIy, Constantes.ANCHOMAPA, 3);
		
		
		
		
	}
	public void dibujarArmas(Graphics2D g) 
	{
		arma1.dibujar(g, arma1);
		arma2.dibujar(g, arma2);
	}
	public static void cargarArrayColisiones() 
	{
		colisiones.add(rectangulo);
		colisiones.add(Mapa.paredArriba);
		colisiones.add(Mapa.paredAbajo);
		colisiones.add(Mapa.paredIzquierda);
		colisiones.add(Mapa.paredDerecha);
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
	public static Rectangle getRectangulo() {
		return rectangulo;
	}
	public static void setRectangulo(Rectangle rectangulo) {
		GestorJuego.rectangulo = rectangulo;
	}
}
