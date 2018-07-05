package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;

	protected int[] cuadros;

	public Mapa(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		cuadros = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) {
		cargarRuta(ruta);
	}

	protected void generarMapa() {

	}

	public void cargarRuta(String ruta) {

	}

	public void actualizar() {

	}

	public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {

		pantalla.setDiferencia(compensacionX, compensacionY);
		int o = compensacionX >> 5, e = (compensacionX + pantalla.getAncho() + Cuadro.lado) >> 5,
				n = compensacionY >> 5, s = (compensacionY + pantalla.getAlto() + Cuadro.lado) >> 5;
		// si quisiera que se moviera el personaje de cuadro en cuadro no lo dividiria
		// entre 32

		for (int y = n; y < s; y++) {
			for (int x = o; x < e; x++) {
				obtenCuadro(x, y).mostrar(x, y, pantalla);
			}
		}

	}

	public Cuadro obtenCuadro(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Cuadro.VACIO;
		} else {
			switch (cuadros[x + y * ancho]) {
			case 0:
				return Cuadro.ASFALTO;
			case 1:
			case 2:
			case 3:
			default:
				return Cuadro.VACIO;
			}
		}
	}

}
