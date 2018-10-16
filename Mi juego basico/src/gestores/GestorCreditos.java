package gestores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import CosasBasicas.DibujosBasicos;
import constantes.Constantes;

public class GestorCreditos {
	public static boolean GestorCreditosActivo=false;
	
	
	public void dibujar(Graphics2D g) {
		DibujosBasicos.pintarRectanguloColor(g, Constantes.ANCHO, Constantes.ALTO, 0, 0, Color.BLACK);
		g.setFont(new Font("Mia", Font.ITALIC, 20));
		DibujosBasicos.pintarTexto(g, Constantes.ANCHO/3, Constantes.ALTO/3, "Todo hecho por Alejandro Márquez Ojeda");
	}
}
