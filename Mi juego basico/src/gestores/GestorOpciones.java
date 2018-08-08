package gestores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;

public class GestorOpciones {
	public static boolean activoOpciones=false;
	
	public static Rectangle cerrar;
	
	public void dibujar(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constantes.ANCHO,Constantes.ALTO);
		
		g.setColor(Color.RED);
		g.fillRect((Constantes.ANCHO/2)+(Constantes.ANCHO/3), 0, Constantes.ANCHO/20,Constantes.ALTO/20);
		cerrar=new Rectangle((Constantes.ANCHO/2)+(Constantes.ANCHO/3), 0, Constantes.ANCHO/20,Constantes.ALTO/20);
		
		DibujosBasicos.pintarTexto(g,Constantes.ANCHO/10, Constantes.ALTO/5, "RESOLUCION");
		g.setColor(Color.RED);
		g.drawRect(Constantes.ANCHO/10, (Constantes.ALTO/5) + (Constantes.ALTO/30),Constantes.ANCHO/5, Constantes.ALTO/5);
		
		DibujosBasicos.pintarTexto(g,Constantes.ANCHO/2, Constantes.ALTO/5, "SONIDO");
		g.setColor(Color.RED);
		g.drawRect(Constantes.ANCHO/2, (Constantes.ALTO/5) + (Constantes.ALTO/30),Constantes.ANCHO/5, Constantes.ALTO/15);
		
	}
}
