package gestores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;

public class GestorMenuPrincipal extends GestorPadre
{	
	public static boolean activoMenuPrincipal=true;
	public static Rectangle nuevaPartida;
	public static Rectangle opciones;
	public static Rectangle creditos;
	public static Rectangle salir;
	//Aqui lo que pase mientras estas con el menu
	@Override
	public void dibujar(Graphics2D g) {
		DibujosBasicos.pintarRectanguloColor(g, Constantes.ANCHO, Constantes.ALTO, 0, 0, Color.BLACK);
		
		
		
		g.setColor(Color.red);
		nuevaPartida=new Rectangle(Constantes.ANCHO/3, Constantes.ALTO/5, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, Constantes.ALTO/5, Constantes.ANCHO/3, Constantes.ANCHO/18);
		DibujosBasicos.pintarTexto(g, (Constantes.ANCHO - (Constantes.ANCHO/13))/2, (Constantes.ALTO/4), "Nueva Partida");
		
		g.setColor(Color.red);
		opciones=new Rectangle(Constantes.ANCHO/3, (Constantes.ALTO + (Constantes.ALTO/2))/4, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO + (Constantes.ALTO/2))/4, Constantes.ANCHO/3, Constantes.ANCHO/18);
		
		creditos=new Rectangle( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/3, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/3, Constantes.ANCHO/3, Constantes.ANCHO/18);
		
		salir=new Rectangle( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/2, Constantes.ANCHO/3, Constantes.ANCHO/18);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+ (Constantes.ALTO/2))/2, Constantes.ANCHO/3, Constantes.ANCHO/18);
		}

}
