package visual;

import java.awt.Window;

import javax.swing.JFrame;


public class Pantalla extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Pantalla(int ancho, int alto, SuperficieDibujo superficieDibujo) 
	{
		this.setUndecorated(true);
		this.setSize(ancho, alto);
		this.setTitle("CatBie");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setFocusable(true);
		this.add(superficieDibujo);
		this.pack();
		this.setLocationRelativeTo(null);
		
		
	}

}
