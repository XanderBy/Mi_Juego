package personajes;

import java.awt.Graphics2D;
import java.awt.Point;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;

public class Jugador extends Entidad implements MetodosEntidades
{

	public Jugador(int ancho, int alto, Point posicion, int vida, int resistencia,
			int velocidadMovimiento, String urlQuieto) {
		super(ancho, alto, posicion, vida, resistencia, velocidadMovimiento, urlQuieto);
		// TODO Auto-generated constructor stub
		
	}
	
	public void moverArriba(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y=GestorJuego.mapa.posicion.y +velocidadMovimiento;
		//posicion.y=posicion.y - velocidadMovimiento;
	}
	public void moverAbajo(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y=GestorJuego.mapa.posicion.y -velocidadMovimiento;
		//posicion.y=posicion.y + velocidadMovimiento;
	}
	public void moverIzquierda(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x=GestorJuego.mapa.posicion.x +velocidadMovimiento;
		
		//posicion.x=posicion.x - velocidadMovimiento;
	}
	public void moverDerecha(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x=GestorJuego.mapa.posicion.x -velocidadMovimiento;
		AccionesBasicas.correccionXPositivo(velocidadMovimiento);
		//posicion.x=posicion.x + velocidadMovimiento;
	}

	@Override
	public void dibujar(Graphics2D g) 
	{
		//DibujosBasicos.pintarRectangulo(g, this.getAncho(), this.getAlto(), this.getPosicion().x, this.getPosicion().y);		
		DibujosBasicos.pintarImagenJugador(g, this.getSprite(), this);
	}

	@Override
	public void dano(int dano) 
	{
		this.setVida(this.getVida() - dano);
	}
}
