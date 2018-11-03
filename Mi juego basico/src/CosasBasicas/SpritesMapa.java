package CosasBasicas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;

import constantes.Constantes;

public class SpritesMapa {
	private int ancho;
	private int alto;
	private int[] pixeles;
	private String url;
	public BufferedImage imagen;

	public SpritesMapa(int ancho, int alto, String url) {
		this.url=url;
		try {
			
			imagen =ImageIO.read(new File(this.url));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pixeles = new int[imagen.getWidth() * imagen.getHeight()];
		introducirImagenesArrayMapa(imagen);
	}

	public Color introducirImagenesArrayMapa(BufferedImage imagen) {

		for (int x = 0; x < Constantes.ANCHO; x++) {
			for (int y = 0; y < Constantes.ALTO; y++) {
				// De momento dibujaría todo el mapa
				if (ancho > Constantes.ANCHO) {

					break;
				} else {

					return Color.getColor("", this.pixeles[(x * y)] = imagen.getRGB(x, y));
				}

			}

		}

		return null;
	}

}
