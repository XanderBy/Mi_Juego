package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.Constantes;
import principal.GestorPrincipal;
import principal.control.GestorControles;
import principal.control.Raton;
import principal.herramientas.DatosDebug;
import principal.herramientas.DibujoDebug;
import principal.maquinaestado.GestorEstados;

public class SuperficieDibujo extends Canvas {

	private static final long serialVersionUID = -6227038142688953660L;

	private int ancho;
	private int alto;

	// creas un raton para que aparezca
	private Raton raton;

	public SuperficieDibujo(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		this.raton = new Raton(this);

		// Sirve para que utilice el buffer los espacios de memoria asignados para pintar
		setIgnoreRepaint(true);
		
		//por así decirlo inicias el cursor
		setCursor(raton.obtenerCursor());
		//
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(GestorControles.teclado);
		addMouseListener(raton);
		
		// sirve para cuando inicias el juego te hace focus y no tienes que darle click
		setFocusable(true);
		requestFocus();
	}
	//vas actualizando el raton 
	public void actualizar() {
		raton.actualizar(this);
	}
	
	//Dibuja todo lo que haya en la superficie de dibujo
	public void dibujar(final GestorEstados ge) {
		//Son los espacios en memoria que se le deja para que dibuje la superficie
		final BufferStrategy buffer = getBufferStrategy();
		
		if (buffer == null) {
			createBufferStrategy(2);
			return;
		}
		//Le asignas los espacios para dibujar
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		
		DibujoDebug.reiniciarContadorObjetos();
		
		//Coges la fuente de la letra
		g.setFont(Constantes.FUENTE_PIXEL);
		
		//Dibuja un recuadro negro para cuando llegas al borde veas negro
		DibujoDebug.dibujarRectanguloRelleno(g, 0, 0, Constantes.ANCHO_PANTALLA_COMPLETA, Constantes.ALTO_PANTALLA_COMPLETA, Color.black);
		
		
		//Te acerca el dibujo
		if (Constantes.FACTOR_ESCALADO_X != 1.0 || Constantes.FACTOR_ESCALADO_Y != 1.0) {
			g.scale(Constantes.FACTOR_ESCALADO_X, Constantes.FACTOR_ESCALADO_Y);
		}
		
		//Aqui te dibuja todo los que hay en la pantalla segun en que estado se encuentre
		ge.dibujar(g);
		
		//hago que las letras sean blancas
		g.setColor(Color.white);
		
		//Dibuja los datos que aparecen a la izquierda arriba
		DibujoDebug.dibujarString(g, "FPS: " + GestorPrincipal.obtenerFPS(), 20, 20);
		DibujoDebug.dibujarString(g, "APS: " + GestorPrincipal.obtenerAPS(), 20, 30);

		DatosDebug.enviarDato("ESCALA X: " + Constantes.FACTOR_ESCALADO_X);
		DatosDebug.enviarDato("ESCALA Y: " + Constantes.FACTOR_ESCALADO_Y);
		DatosDebug.enviarDato("OPF: " + DibujoDebug.obtenerContadorObjetos());

		if (GestorControles.teclado.debug) {
			DatosDebug.dibujarDatos(g);
		} else {
			DatosDebug.vaciarDatos();
		}
		
		//va mejor no estando sincronizado
		//Toolkit.getDefaultToolkit().sync();
		
		
		//borra lo dibujado
		g.dispose();
		
		
		//muestra todo lo almacenado en la memoria del bufferStrategy
		buffer.show();
	}

	public int obtenerAncho() {
		return ancho;
	}

	public int obtenerAlto() {
		return alto;
	}

	public Raton obtenerRaton() {
		return raton;
	}
}