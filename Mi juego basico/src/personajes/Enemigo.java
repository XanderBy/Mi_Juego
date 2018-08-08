package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import CosasBasicas.DibujosBasicos;
import interfaces.MetodosEntidades;

public class Enemigo extends Entidad implements MetodosEntidades
{

	
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
	}

	@Override
	public void dano(int dano) 
	{
		this.setVida(this.getVida() - dano);
	}

}
