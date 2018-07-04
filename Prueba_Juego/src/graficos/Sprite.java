package graficos;

public class Sprite {
	private final int tamano;
	private int x;
	private int y;
	private HojaSprites hoja;
	public int[] pixeles;

	// Coleccion sprites
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto);
	// fin de la coleccion

	public Sprite(final int tamano, final int columna, final int fila, final HojaSprites hoja) {
		super();
		this.tamano = tamano;
		pixeles = new int[tamano * tamano];
		this.hoja = hoja;
		this.x = columna * tamano;
		this.y = fila * tamano;

		for (int i = 0; i < tamano; i++) {
			for (int j = 0; j < tamano; j++) {
				pixeles[i + j * tamano] = hoja.pixeles[(j + x) + (i + y) * hoja.getAncho()];
			}
		}
	}

	public Sprite(final int tamano, final int color) {
		this.tamano = tamano;
		pixeles = new int[tamano * tamano];

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;

		}
	}

	public int getTamano() {
		return tamano;
	}

}
