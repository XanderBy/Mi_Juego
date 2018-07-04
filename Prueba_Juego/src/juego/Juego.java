package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import graficos.Pantalla;
import mapa.Mapa;
import mapa.MapaGenerado;

public class Juego extends Canvas implements Runnable {

	// Runnable es la interface para los hilos
	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static JFrame ventana;
	// private static final String titulo = "Prueba";

	private static String CONTADOR_FPS = "";
	private static String CONTADOR_APS = "";

	private static Thread thread;
	private static volatile boolean running = false;// no puede utilizarlo de forma simultanea los dos threads
	private static int aps = 0;
	private static int fps = 0;
	private static Teclado teclado;
	private static Pantalla pantalla;

	private static Mapa mapa;

	private static int x = 0;
	private static int y = 0;
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();// devuelve los
	// pixeles de la imagen
	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);
		mapa = new MapaGenerado(128, 128);
		teclado = new Teclado();
		addKeyListener(teclado);
		ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());// No se que es
		ventana.add(this, BorderLayout.CENTER);// BorderLayout añade el canvas en el centro de la pantalla
		ventana.setUndecorated(true);
		ventana.pack();// para que vaya todo como lo hemos puesto como por ejemplo el tamaño de ventana
						// etc...
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setIconImage(icono.getImage());

	}

	public void update() {
		teclado.actualizar();
		if (teclado.arriba) {// Lo que hago es mover el mapa
			y--;
		}
		if (teclado.abajo) {
			y++;
		}
		if (teclado.izquierda) {
			x--;
		}
		if (teclado.derecha) {
			x++;
		}
		if (teclado.salir) {
			System.exit(0);
		}
		aps++;
	}

	public void draw() {
		BufferStrategy estrategia = getBufferStrategy();

		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}

		pantalla.limpiar();
		mapa.mostrar(x, y, pantalla);

		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);// te copia de un array a otro array del que
																			// vas a copiar, posicion inicial, array en
																			// el que lo vas a pegar, posicion inicial

		// for (int i = 0; i < pixeles.length; i++) {
		// pixeles[i] = pantalla.pixeles[i];
		// }

		Graphics g = estrategia.getDrawGraphics();// el encargado de dibujar las cosas
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.fillRect(ANCHO / 2, ALTO / 2, 32, 32);

		g.drawString(CONTADOR_APS, 10, 20);
		g.drawString(CONTADOR_FPS, 10, 40);

		g.dispose();// Cuando se haya dibujado borrara la memoria de g
		estrategia.show();

		fps++;
	}

	@Override
	public synchronized void run() { // hace que no pueda manipular el boolean los dos metodos a la vez
		final int NS_POR_SEGUNDO = 1000000000;// Cuantos nanosegundos hay en un segundo
		final byte APS_OBJETIVO = 60;// cuantas actualizaciones queremos tener por segundo
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;// Cuantos nanosegundos transcurren por
																			// actualizacion

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		double tiempoTranscurrido;
		double delta = 0;
		requestFocus();
		// TODO Auto-generated method stub
		System.out.println(thread.isAlive());
		while (running) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while (delta >= 1) {
				update();
				delta--;
			}
			draw();
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				CONTADOR_APS = "APS: " + aps;
				CONTADOR_FPS = "FPS: " + fps;
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}

	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Graficos");// El nombre de este hilo es Graficos lo unico que sirve es
												// paramonitorizarlo
		thread.start();

	}

	public void stop() {
		try {
			running = false;
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Juego().start();
	}

}
