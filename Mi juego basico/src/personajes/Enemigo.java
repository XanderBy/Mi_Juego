package personajes;

import java.awt.Graphics2D;
import java.awt.Point;

import CosasBasicas.DibujosBasicos;
import interfaces.MetodosEntidades;

public class Enemigo extends Entidad implements MetodosEntidades
{

	public Enemigo(String url, int ancho, int alto, Point posicionInicio, int vida, int resistencia,
			int velocidadMovimiento) 
	{
		super(url, ancho, alto, posicionInicio, vida, resistencia, velocidadMovimiento);
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
