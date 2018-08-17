package gestores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import Controles.Raton;
import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;
import objetos.Armas;
import visual.SuperficieDibujo;

public class GestorInventario extends GestorPadre {
	public static boolean activoInventario = false;

	private static int contX = 0;
	private static int contY = 0;
	private static int contadorInventario = -1;
	private static int contador = 0;

	public static boolean poderMover = false;
	public static Rectangle moverObjeto00 = null;
	public static Rectangle moverObjeto01 = null;
	public static Rectangle moverObjeto02 = null;
	public static Rectangle moverObjeto10 = null;
	public static Rectangle moverObjeto11 = null;
	public static Rectangle moverObjeto12 = null;
	public static Rectangle moverObjeto20 = null;
	public static Rectangle moverObjeto21 = null;
	public static Rectangle moverObjeto22 = null;
	public static Rectangle moverObjeto30 = null;
	public static Rectangle moverObjeto31 = null;
	public static Rectangle moverObjeto32 = null;

	public static Rectangle[] recuadros = { moverObjeto00, moverObjeto01, moverObjeto02, moverObjeto10, moverObjeto11,
			moverObjeto12, moverObjeto20, moverObjeto21, moverObjeto22, moverObjeto30, moverObjeto31, moverObjeto32 };

	public static Rectangle mover;
	public static Rectangle soltar;
	public static Rectangle utilizar;

	@Override
	public void dibujar(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Constantes.ANCHO, Constantes.ALTO);
		// g.scale(Constantes.ESCALAX, Constantes.ESCALAY);

		g.setColor(Color.WHITE);
		// Superficie Dibujada
		for (int i = 0; i < 3; i++) {
			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 4;
			for (int j = 0; j < 3; j++) {

				g.drawRect(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
						SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
				contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			}
		}

		contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
		contY = 0;

		// Armaduras
		contX = (SuperficieDibujo.arraySuperficie[0].getWidth() / 4)
				+ (SuperficieDibujo.arraySuperficie[0].getWidth() / 2);
		for (int i = 0; i < 3; i++) {
			contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 5;
			g.drawRect(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);

		}

		contY = 0;

		// System.out.println("------------------------------");
		for (int i = 0; i < GestorJuego.jugador.inventarioArray.length; i++) {
			// System.out.println("Objeto" + GestorJuego.jugador.inventarioArray[i]);
		}
		// System.out.println("------------------------------");
		// objetos dibujados
		for (int i = 0; i < 3; i++) {
			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 4;

			for (int j = 0; j < 3; j++) {
				if (contadorInventario == (GestorJuego.jugador.inventarioArray.length - 1)) {
					break;
				}
				contadorInventario++;
				if (GestorJuego.jugador.inventarioArray[contadorInventario] != null) {
					try {
						Point posicionNueva = new Point(contX, contY);
						// System.out.println(posicionNueva);
						GestorJuego.jugador.inventarioArray[contadorInventario].posicion = posicionNueva;
						// System.out.println(posicionNueva);
						g.drawImage(GestorJuego.jugador.inventarioArray[contadorInventario].spriteInventario.imagen,
								GestorJuego.jugador.inventarioArray[contadorInventario].posicion.x,
								GestorJuego.jugador.inventarioArray[contadorInventario].posicion.y,
								GestorJuego.jugador.inventarioArray[contadorInventario].spriteInventario
										.introducirImagenesArray(
												GestorJuego.jugador.inventarioArray[contadorInventario].spriteInventario.imagen),
								null);
						// System.out.println(GestorJuego.jugador.inventarioArray[contadorInventario].posicion.x
						// + " " + GestorJuego.jugador.inventarioArray[contadorInventario].posicion.y);
						GestorJuego.jugador.inventarioArray[contadorInventario].areaObjetoInfluencia = new Rectangle(
								GestorJuego.jugador.inventarioArray[contadorInventario].posicion.x,
								GestorJuego.jugador.inventarioArray[contadorInventario].posicion.y,
								SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
								SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			}

		}
		contadorInventario = -1;
		contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
		contY = 0;
		if (Raton.recuadroInventario != null) {
			g.setColor(Color.GREEN);
			g.drawRect(Raton.recuadroInventario.posicion.x, Raton.recuadroInventario.posicion.y,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			g.setColor(Color.BLACK);
			g.fillRect(Raton.recuadroInventario.posicion.x, 10, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 30);
			soltar = new Rectangle(Raton.recuadroInventario.posicion.x, 10,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 30);

			g.fillRect(Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth() / 7, 10,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 30);
			mover = new Rectangle(
					Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth() / 7, 10,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 30);

			g.fillRect(Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth() / 3, 10,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 30);
			utilizar = new Rectangle(
					Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth() / 3, 10,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 30);

			g.setColor(Color.white);
			DibujosBasicos.pintarTexto(g, Raton.recuadroInventario.posicion.x, 30, "Soltar");
			DibujosBasicos.pintarTexto(g,
					Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth() / 7, 30,
					"Mover");
			DibujosBasicos.pintarTexto(g,
					Raton.recuadroInventario.posicion.x + SuperficieDibujo.arraySuperficie[0].getWidth() / 3, 30,
					"Utilizar");

		}
		if (poderMover == true) {
			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY = 0;
			g.setColor(Color.ORANGE);
			// Superficie Dibujada
			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 4;

			moverObjeto00 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			moverObjeto01 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			moverObjeto02 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);

			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 4;
			moverObjeto10 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			moverObjeto11 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			moverObjeto12 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);

			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 4;
			moverObjeto20 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			moverObjeto21 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			moverObjeto22 = new Rectangle(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
					SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
			if(contador==0) {
				AnadirRecuadros();
				contador++;
			}
			contY = 0;
			g.setColor(Color.ORANGE);
			for (int i = 0; i < 3; i++) {
				contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
				contY += SuperficieDibujo.arraySuperficie[0].getHeight() / 4;
				for (int j = 0; j < 3; j++) {
					g.drawRect(contX, contY, SuperficieDibujo.arraySuperficie[0].getWidth() / 9,
							SuperficieDibujo.arraySuperficie[0].getWidth() / 9);
					contX += SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
				}
			}
			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY = 0;

			contX = SuperficieDibujo.arraySuperficie[0].getWidth() / 9;
			contY = 0;
		}

	}

	public void AnadirRecuadros() {
		recuadros[0] = moverObjeto00;
		recuadros[1] = moverObjeto01;
		recuadros[2] = moverObjeto02;
		recuadros[3] = moverObjeto10;
		recuadros[4] = moverObjeto11;
		recuadros[5] = moverObjeto12;
		recuadros[6] = moverObjeto20;
		recuadros[7] = moverObjeto21;
		recuadros[8] = moverObjeto22;
		recuadros[9] = moverObjeto30;
		recuadros[10] = moverObjeto31;
		recuadros[11] = moverObjeto32;
	}
	public void eliminarRecuadros() {
		recuadros[0] = null;
		recuadros[1] = null;
		recuadros[2] = null;
		recuadros[3] = null;
		recuadros[4] = null;
		recuadros[5] = null;
		recuadros[6] = null;
		recuadros[7] = null;
		recuadros[8] = null;
		recuadros[9] = null;
		recuadros[10] = null;
		recuadros[11] = null;
	}
}
