
import Controles.Raton;
import Controles.Teclado;
import constantes.Constantes;
import visual.Pantalla;
import visual.SuperficieDibujo;

public class BuclePrincipal implements Runnable {
	//Para saber si esta funcionando el juego
	private static boolean corriendo = false;
	
	//hilo principal para el bucle
	private Thread hilo = new Thread(this);
	
	//son todas las teclas que e instanciado
	private static Teclado teclado = new Teclado();
	
	//El raton
	private static Raton raton = new Raton();
	
	//Donde se dibuja todo
	static SuperficieDibujo sd = new SuperficieDibujo(Constantes.ANCHO, Constantes.ALTO, teclado, raton);
	
	//La pantalla donde se dibuja todo el tamano etc...
	private Pantalla pantalla = new Pantalla(Constantes.ANCHO, Constantes.ALTO, sd);

	// para los fps
	// -
	private static int fps = 0;
	private static int aps;
	// -

	public void actualizar() {
		aps++;
		dibujar();
		raton.actualizar();

	}

	@Override
	public void run() {
		SuperficieDibujo.getArraySuperficie()[0] = sd;
		Constantes.arrayPantalla.add(pantalla);
		// -
		final int NS_POR_SEGUNDO = 1000000000;
		final int APS_OBJETIVO = 120;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		double tiempoTranscurrido;
		double delta = 0;
		// -

		while (corriendo) {

			// -
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				// Menos actualizar que eso es obligatorio
				actualizar();
				delta--;
			}

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				System.out.println("Fps: " + fps);
				fps = 0;
				aps = 0;
				referenciaContador = System.nanoTime();
			}
			// -
		}
		parar();

	}

	public void iniciar() {
		hilo.start();
		BuclePrincipal.corriendo = true;
	}

	public void parar() {

		try {
			corriendo = false;
			hilo.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dibujar() {
		fps++;
		sd.dibujar();
	}

	public static void main(String args[]) {
		BuclePrincipal bp = new BuclePrincipal();
		bp.iniciar();
	}

}
