package principal.control;

import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import principal.Constantes;
import principal.graficos.SuperficieDibujo;
import principal.herramientas.CargadorRecursos;

public class Raton extends MouseAdapter {
	
	//Principalmente representa al cursor
	private final Cursor cursor;
	
	//Representa una ubicacion exacta
	private Point posicion;
	
	private boolean click;
	private boolean click2;


	public Raton(final SuperficieDibujo sd) {
		//vinculas diferentes elementos
		Toolkit configuracion = Toolkit.getDefaultToolkit();
		
		//Carga la imagen del raton
		final BufferedImage iconoCargado = CargadorRecursos
				.cargarImagenCompatibleTranslucida(Constantes.RUTA_ICONO_RATON);

		
		//
		BufferedImage icono = iconoCargado;
		
		//posicion de la punta del cursor
		Point punta = new Point(0, 0);
		
		//al cursor estas cargando el icono el punto donde clicarias, y el nombre del cursor
		this.cursor = configuracion.createCustomCursor(icono, punta, "Cursor por defecto");
		
		posicion = new Point();
		actualizarPosicion(sd);

		click = false;
		click2 = false;
	}
	//vas actualizando
	public void actualizar(final SuperficieDibujo sd) {
		actualizarPosicion(sd);

	}
	//Sobra literalmente no sirve para nada
	//public void dibujar(final Graphics g) {
		//DatosDebug.enviarDato("RX: " + posicion.getX());
		//DatosDebug.enviarDato("RY: " + posicion.getY());
	//}
	
	//
	public Cursor obtenerCursor() {
		return this.cursor;
	}
	//Actualizas la posicion
	private void actualizarPosicion(final SuperficieDibujo sd) {
		//coges la posicion actual
		final Point posicionInicial = MouseInfo.getPointerInfo().getLocation();
		
		//Conviertes la posicion del raton en la posicion en la pantalla dibujada
		SwingUtilities.convertPointFromScreen(posicionInicial, sd);
		
		//actualizar la posicion
		posicion.setLocation(posicionInicial.getX(), posicionInicial.getY());
	}
	
	//obtienes la posicion 
	public Point obtenerPuntoPosicion() {
		return posicion;
	}
	
	//haces del raton un rectangulo para cuando presiones botones saber si se encuentra encima del boton
	public Rectangle obtenerRectanguloPosicion() {
		final Rectangle area = new Rectangle(obtenerPuntoPosicion().x, obtenerPuntoPosicion().y, 1, 1);

		return area;
	}
	//presionas el boton derecho o izquierdo del raton
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			click = true;
		} else if (SwingUtilities.isRightMouseButton(e)) {
			click2 = true;
		}
	}
	//Sueltas el boton derecho o izquierdo del raton
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			click = false;
		} else if (SwingUtilities.isRightMouseButton(e)) {
			click2 = false;
		}
	}
	//obtienes si has clicado o soltado el boton izquierdo
	public boolean obtenerClick() {
		return click;
	}
	//obtienes si has clicado o soltado el boton derecho
	public boolean obtenerClick2() {
		return click2;
	}
}