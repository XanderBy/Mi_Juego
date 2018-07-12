package visual;

import javax.swing.JFrame;


public class Pantalla extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Pantalla(int ancho, int alto, SuperficieDibujo superficieDibujo) 
	{
		this.setSize(ancho, alto);
		this.setTitle("Juego Prueba");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.isFocusable();
		this.add(superficieDibujo);
		this.pack();
		this.setLocationRelativeTo(null);
		
	}

}
