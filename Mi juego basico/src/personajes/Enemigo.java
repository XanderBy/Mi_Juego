package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import interfaces.MetodosEntidades;

public class Enemigo extends Entidad implements MetodosEntidades
{

	public Enemigo(int ancho, int alto, Point posicionInicio, int vida, int resistencia,
			int velocidadMovimiento, String urlQuieto) 
	{
		super(ancho, alto, posicionInicio, vida, resistencia, velocidadMovimiento, urlQuieto);
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
