package pantalla;

import java.util.ArrayList;

public class Pantalla {
	//Atributos
	private int ancho;
	private int alto;
	private ArrayList <Integer> pixeles;
	//Constructor
	public Pantalla(int ancho, int alto) {
		this.alto=alto;
		this.ancho=ancho;
	}
	
	//Metodos
	public void limpiar() {
		pixeles.removeAll(pixeles);
	}
	public void mostrar() {
		for (int x = 0; x < pixeles.size(); x++) {
			for (int y = 0; y < pixeles.size(); y++) {
				//Aqui se deberia de cargar el mapa en el array pixeles
			}
		}
	}
	//Getter-Setter

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
}
