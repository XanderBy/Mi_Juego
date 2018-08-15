package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import CosasBasicas.DibujosBasicos;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;

public class Enemigo extends Entidad implements MetodosEntidades
{

	private long tiempoAhora= 0;
	public Enemigo(int ancho, int alto, Point posicion, int vida, int velocidadMovimientoXIzquierda,
			int velocidadMovimientoYArriba, int velocidadMovimientoXDerecha, int velocidadMovimientoYAbajo,
			String urlQuieto) {
		super(ancho, alto, posicion, vida, velocidadMovimientoXIzquierda, velocidadMovimientoYArriba,
				velocidadMovimientoXDerecha, velocidadMovimientoYAbajo, urlQuieto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics2D g) 
	{
		DibujosBasicos.pintarRectangulo(g, this.getAncho(), this.getAlto(), this.getPosicion().x, this.getPosicion().y);
		
		this.moverse();
	}

	@Override
	public void dano(int dano) 
	{
		this.setVida(this.getVida() - dano);
	}
	public void moverse() 
	{
		
		tiempoAhora++;
		//System.out.println(tiempoAhora);
		Point posicionJugador=GestorJuego.jugador.getPosicion();
		int posicionEnemigoX= (int) this.getPosicion().getX();
		int posicionEnemigoY= (int) this.getPosicion().getY();
		Point posicionEnemigoNueva=new Point(posicionEnemigoX, posicionEnemigoY);
		//System.out.println(this.getPosicion() + "     " + posicionJugador);
		int aleatorio= (int) (Math.random() * 2) + 1;
		switch (aleatorio) {
		case 1:
			System.out.println(this.getPosicion().x);
			if(this.getPosicion().x > posicionJugador.getX() && tiempoAhora== 100) 
			{
				System.out.println("wdaaaa");
				posicionEnemigoX=posicionEnemigoX-1;
				posicionEnemigoNueva=new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora= 0;
			}
			if(this.getPosicion().x < posicionJugador.getX()&& tiempoAhora== 100)
			{
				posicionEnemigoX=posicionEnemigoX+1;
				posicionEnemigoNueva=new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora= 0;
			}
			break;
		case 2:
			if(this.getPosicion().y > posicionJugador.getY()&& tiempoAhora== 100) 
			{
				posicionEnemigoY=posicionEnemigoY-1;
				posicionEnemigoNueva=new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora= 0;
			}
			if(this.getPosicion().y < posicionJugador.getY()&& tiempoAhora== 100)
			{
				posicionEnemigoY=posicionEnemigoY+1;
				posicionEnemigoNueva=new Point(posicionEnemigoX, posicionEnemigoY);
				this.setPosicion(posicionEnemigoNueva);
				tiempoAhora= 0;
			}
			break;

		default:
			break;
		}
		if(tiempoAhora==100) {
			tiempoAhora=0;
		}
		
		
	}

}
