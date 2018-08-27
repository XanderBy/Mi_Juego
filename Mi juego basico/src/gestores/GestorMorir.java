package gestores;

import java.awt.Color;
import java.awt.Graphics2D;

import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;

public class GestorMorir extends GestorPadre {
	public static boolean gestorMorirActivo=false;
	@Override
	public void dibujar(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		DibujosBasicos.pintarTexto(g, Constantes.ANCHO/2, Constantes.ALTO/2, "ESTAS MUERTO");
	}

}
