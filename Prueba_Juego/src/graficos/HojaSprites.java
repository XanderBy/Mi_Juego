package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	// Clase que contendran los sprites
	private final int ancho;
	private final int alto;
	public final int[] pixeles;

	// Coleccion de Hojas de sprite
	public static HojaSprites desierto = new HojaSprites("/texturas/desierto.png", 320, 320);
	// fin de la coleccion

	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.alto = alto;
		this.ancho = ancho;

		pixeles = new int[ancho * alto];
		try {
			BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
}
