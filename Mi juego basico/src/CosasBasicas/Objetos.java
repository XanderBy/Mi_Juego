package CosasBasicas;

import java.awt.Rectangle;

import gestores.GestorJuego;
import visual.Casa;

public interface Objetos {
	
	public static void introducirObjetosArray(Object casa) {
		try {
			GestorJuego.objetosMapaFijo.add(casa);
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		
	}
	
	public static void borrarObjetosArray(Object casa) {
		try {
			GestorJuego.objetosMapaFijo.remove(casa);
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		
	}
	public static void introducirObjetosColisionArray(Rectangle rectangulo) {
		try {
			GestorJuego.colisiones.add(rectangulo);
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		
	}
	
	public static void borrarObjetosColisionArray(Rectangle rectangulo) {
		try {
			GestorJuego.colisiones.remove(rectangulo);
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		
	}
}
