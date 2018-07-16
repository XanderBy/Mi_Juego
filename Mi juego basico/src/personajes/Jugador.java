package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;

public class Jugador extends Entidad implements MetodosEntidades
{
	public static Rectangle areaJugador1;
	public static Rectangle areaJugador2;
	public static Rectangle areaJugador3;
	public static Rectangle areaJugador4;
	public static Rectangle areaJugador5;
	public static Rectangle areaJugador6;
	public static Rectangle areaJugador7;
	public static Rectangle areaJugador8;
	
	public Jugador(int ancho, int alto, Point posicion, int vida, int resistencia,
			int velocidadMovimiento, String urlQuieto) {
		super(ancho, alto, posicion, vida, resistencia, velocidadMovimiento, urlQuieto);
		// TODO Auto-generated constructor stub
		
	}
	
	public void moverArriba(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y=GestorJuego.mapa.posicion.y +velocidadMovimiento;
		AccionesBasicas.correccionYPositivo(velocidadMovimiento);
		colision();
		//posicion.y=posicion.y - velocidadMovimiento;
	}
	public void moverAbajo(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y=GestorJuego.mapa.posicion.y -velocidadMovimiento;
		AccionesBasicas.correccionYNegativo(velocidadMovimiento);
		colision();
		//posicion.y=posicion.y + velocidadMovimiento;
	}
	public void moverIzquierda(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x=GestorJuego.mapa.posicion.x +velocidadMovimiento;
		AccionesBasicas.correccionXPositivo(velocidadMovimiento);
		//posicion.x=posicion.x - velocidadMovimiento;
		colision();
	}
	public void moverDerecha(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x=GestorJuego.mapa.posicion.x -velocidadMovimiento;
		AccionesBasicas.correccionXNegativo(velocidadMovimiento);
		//posicion.x=posicion.x + velocidadMovimiento;
		colision();
	}
	public static void colision() 
	{	
		GestorJuego.cargarArray();
		//areaJugador8= new Rectangle(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y+GestorJuego.jugador.getAlto()/2 , 2, 2);
		//GestorJuego.rectangulo= new Rectangle(GestorJuego.rectangulo1x,GestorJuego.rectangulo1y,50,50);
		for (Rectangle a: GestorJuego.colisiones) {
			if(areaJugador8.intersects(a)) {
				System.out.println("Holaaaa");
			}
		}
		GestorJuego.eliminarArrar();
	}
	@Override
	public void dibujar(Graphics2D g) 
	{	
		
		//DibujosBasicos.pintarRectangulo(g, this.getAncho(), this.getAlto(), this.getPosicion().x, this.getPosicion().y);		
		DibujosBasicos.pintarImagenJugador(g, this.getSprite(), this);
		areaJugador1= new Rectangle(this.getPosicion().x, this.getPosicion().y, 2, 2);
		g.drawRect(this.getPosicion().x, this.getPosicion().y, 2, 2);
		areaJugador2= new Rectangle(this.getPosicion().x+ this.getAncho()/2, this.getPosicion().y, 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()/2, this.getPosicion().y, 2, 2);
		areaJugador3= new Rectangle(this.getPosicion().x+ this.getAncho(), this.getPosicion().y, 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho(), this.getPosicion().y, 2, 2);
		areaJugador4= new Rectangle(this.getPosicion().x+ this.getAncho(), this.getPosicion().y+this.getAlto()/2 , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho(), this.getPosicion().y+ this.getAlto()/2, 2, 2);
		areaJugador5= new Rectangle(this.getPosicion().x+ this.getAncho(), this.getPosicion().y+this.getAlto() , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho(), this.getPosicion().y+ this.getAlto(), 2, 2);
		areaJugador6= new Rectangle(this.getPosicion().x+ this.getAncho()/2, this.getPosicion().y+this.getAlto() , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()/2, this.getPosicion().y+ this.getAlto(), 2, 2);
		areaJugador7= new Rectangle(this.getPosicion().x, this.getPosicion().y+this.getAlto() , 2, 2);
		g.drawRect(this.getPosicion().x, this.getPosicion().y+ this.getAlto(), 2, 2);
		areaJugador8= new Rectangle(this.getPosicion().x, this.getPosicion().y+this.getAlto()/2 , 2, 2);
		g.drawRect(this.getPosicion().x, this.getPosicion().y+ this.getAlto()/2, 2, 2);
		
	}

	@Override
	public void dano(int dano) 
	{
		this.setVida(this.getVida() - dano);
	}
}
