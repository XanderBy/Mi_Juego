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
		DibujosBasicos.pintarRectanguloColor(g, AccionesBasicas.escalarPantallaX(Constantes.ANCHO), AccionesBasicas.escalarPantallaY(Constantes.ALTO), 0, 0, Color.BLACK);
		
		
		
		g.setColor(Color.red);
		nuevaPartida=new Rectangle(Constantes.ANCHO/3, Constantes.ALTO/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		g.fillRect( Constantes.ANCHO/3, Constantes.ALTO/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		DibujosBasicos.pintarTexto(g, (Constantes.ANCHO/3)+35, (Constantes.ALTO/3)+30, "Nueva Partida");
		
		g.setColor(Color.red);
		opciones=new Rectangle(Constantes.ANCHO/3, (Constantes.ALTO+250)/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+250)/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		
		creditos=new Rectangle( Constantes.ANCHO/3, (Constantes.ALTO+500)/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+500)/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		
		salir=new Rectangle( Constantes.ANCHO/3, (Constantes.ALTO+750)/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		g.fillRect( Constantes.ANCHO/3, (Constantes.ALTO+750)/3, Constantes.ANCHO/3, Constantes.ANCHO/12);
		}

}
