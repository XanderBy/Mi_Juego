package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import pantalla.Pantalla;
import personajes.Jugador;

public class Juego extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 800;
	private static final int ALTO = 400;
	private static boolean corriendo = false;
	
	private static JFrame ventana;
	Thread thread;
	// Jugador jugador=new Jugador(100, 2, 50, 50, "fesfes");
	

	public Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		Pantalla pantalla = new Pantalla(ANCHO, ALTO);
		ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setUndecorated(false);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	@Override
	public void run() {
		actualizar();
	}

	public void iniciar() {
		corriendo = true;
		thread = new Thread(this);
		thread.start();
		
	}

	public void parar() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		corriendo = false;
	}

	public void dibujar() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, 500, 500);

		g.dispose();
		bs.show();
	}

	public void actualizar() {

		while (corriendo) {
			// Controles.actualizar();

			System.out.println("Hola");
		}

	}

	public static void main(String args[]) {
		new Juego().iniciar();
	}

}
