package dibujadoBasePantalla;

import java.awt.Color;
import java.awt.Graphics2D;
import visual.SuperficieDibujo;

public class ParteInferior {
	
	public static void dibujar(Graphics2D g) 
	{	
		g.setColor(Color.BLACK);
		g.fillRect(0, SuperficieDibujo.arraySuperficie[0].getHeight()/5, SuperficieDibujo.arraySuperficie[0].getWidth(), SuperficieDibujo.arraySuperficie[0].getHeight()/2);
	}
}
