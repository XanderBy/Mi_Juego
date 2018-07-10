
import java.awt.Graphics;

import visual.Pantalla;

public class BuclePrincipal implements Runnable {
	private static boolean corriendo = false;
	private Thread hilo = new Thread(this);
	Pantalla pantalla = new Pantalla(500, 500);

	public void actualizar() {

		while (corriendo) {
			System.out.println("Hola");
		}
		parar();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void iniciar() {

		hilo.start();
		BuclePrincipal.corriendo = true;

		actualizar();
	}

	public void parar() {

		try {
			corriendo = false;
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dibujar(Graphics g) {
	}

	public static void main(String args[]) {
		BuclePrincipal bp = new BuclePrincipal();
		bp.iniciar();
	}

}
