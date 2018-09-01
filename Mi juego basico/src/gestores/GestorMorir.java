package gestores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;

public class GestorMorir extends GestorPadre {
	public static boolean gestorMorirActivo = false;

	@Override
	public void dibujar(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		g.setFont(new Font("Mia", Font.ITALIC, 20));
		DibujosBasicos.pintarTexto(g, (Constantes.ANCHO / 2) - Constantes.ANCHO / 12, Constantes.ALTO / 2,
				"ESTAS MUERTO");
	}

}
