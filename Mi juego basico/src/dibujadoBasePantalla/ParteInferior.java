package dibujadoBasePantalla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import CosasBasicas.DibujosBasicos;
import constantes.Constantes;
import gestores.GestorJuego;
import personajes.Jugador;
import visual.SuperficieDibujo;

public class ParteInferior {

	private static int posicionX;
	private static int posicionY;

	public static void dibujar(Graphics2D g) {
		g.setColor(Color.BLACK);
		
		
		
		g.fillRect(0,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 2)
						- SuperficieDibujo.arraySuperficie[0].getHeight() / 10,
				SuperficieDibujo.arraySuperficie[0].getWidth(), SuperficieDibujo.arraySuperficie[0].getHeight() / 2);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Mia", Font.ITALIC, 10));
		g.drawString("Contador de muertes: "+Jugador.contadorMuertes, 0,SuperficieDibujo.arraySuperficie[0].getHeight()/80);
		g.drawString("Vida: ", SuperficieDibujo.arraySuperficie[0].getWidth() / 200,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200);
		g.drawString(String.valueOf(GestorJuego.jugador.getVida()), SuperficieDibujo.arraySuperficie[0].getWidth() / 19,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200);
		g.drawString("Estamina: ", SuperficieDibujo.arraySuperficie[0].getWidth() / 200,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 40);
		g.drawString(String.valueOf(GestorJuego.jugador.getResistencia()),
				SuperficieDibujo.arraySuperficie[0].getWidth() / 19,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 40);
		g.drawString("Armadura: ", SuperficieDibujo.arraySuperficie[0].getWidth() / 200,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 21);
		g.drawString(String.valueOf(GestorJuego.jugador.getArmadura()),
				SuperficieDibujo.arraySuperficie[0].getWidth() / 19,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 21);

		for (int i = 0; i < 3; i++) {
			try {
				if (i == 0) {
					posicionX = SuperficieDibujo.arraySuperficie[0].getWidth() / 5
							- SuperficieDibujo.arraySuperficie[0].getWidth() / 20;
					posicionY = (SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
							+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
							+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200;
					g.drawImage(GestorJuego.jugador.inventarioArray[i].sprite.imagen, posicionX, posicionY,
							GestorJuego.jugador.inventarioArray[i].sprite.introducirImagenesArray(
									GestorJuego.jugador.inventarioArray[i].sprite.imagen),
							null);
					g.drawRect(posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].ancho,
							GestorJuego.jugador.inventarioArray[i].alto);

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if (i == 1) {
					posicionX = SuperficieDibujo.arraySuperficie[0].getWidth() / 3
							- SuperficieDibujo.arraySuperficie[0].getWidth() / 10;
					posicionY = (SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
							+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
							+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200;
					g.drawImage(GestorJuego.jugador.inventarioArray[i].sprite.imagen, posicionX, posicionY,
							GestorJuego.jugador.inventarioArray[i].sprite.introducirImagenesArray(
									GestorJuego.jugador.inventarioArray[i].sprite.imagen),
							null);
					g.drawRect(posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].ancho,
							GestorJuego.jugador.inventarioArray[i].alto);

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if (i == 2) {
					posicionX = SuperficieDibujo.arraySuperficie[0].getWidth() / 2
							- SuperficieDibujo.arraySuperficie[0].getWidth() / 5
							+ SuperficieDibujo.arraySuperficie[0].getWidth() / 60;
					posicionY = (SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
							+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
							+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200;
					g.drawImage(GestorJuego.jugador.inventarioArray[i].sprite.imagen, posicionX, posicionY,
							GestorJuego.jugador.inventarioArray[i].sprite.introducirImagenesArray(
									GestorJuego.jugador.inventarioArray[i].sprite.imagen),
							null);
					g.drawRect(posicionX, posicionY, GestorJuego.jugador.inventarioArray[i].ancho,
							GestorJuego.jugador.inventarioArray[i].alto);

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		posicionX = 0;
		posicionY = 0;

		g.setColor(Color.white);
		g.drawRect(
				SuperficieDibujo.arraySuperficie[0].getWidth() / 5
						- SuperficieDibujo.arraySuperficie[0].getWidth() / 20,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200,
				Constantes.ANCHO / 25, Constantes.ANCHO / 25);
		g.drawRect(
				SuperficieDibujo.arraySuperficie[0].getWidth() / 3
						- SuperficieDibujo.arraySuperficie[0].getWidth() / 10,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200,
				Constantes.ANCHO / 25, Constantes.ANCHO / 25);
		g.drawRect(
				SuperficieDibujo.arraySuperficie[0].getWidth() / 2 - SuperficieDibujo.arraySuperficie[0].getWidth() / 5
						+ SuperficieDibujo.arraySuperficie[0].getWidth() / 60,
				(SuperficieDibujo.arraySuperficie[0].getHeight() / 4)
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 6
						+ SuperficieDibujo.arraySuperficie[0].getHeight() / 200,
				Constantes.ANCHO / 25, Constantes.ANCHO / 25);

	}
}
