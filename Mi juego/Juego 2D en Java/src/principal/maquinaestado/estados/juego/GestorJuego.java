package principal.maquinaestado.estados.juego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import principal.Constantes;
import principal.ElementosPrincipales;
import principal.herramientas.CargadorRecursos;
import principal.interfaz_usuario.MenuInferior;
import principal.maquinaestado.EstadoJuego;

public class GestorJuego implements EstadoJuego {
	// Esta gestor es cuando estas jugando directamente

	// La ruta de la imagen del logo
	//BufferedImage logo;

	// Es el menu inferior
	MenuInferior menuInferior;

	// Constructor
	public GestorJuego() {
		// Creas el menu inferior
		menuInferior = new MenuInferior();
		// Cargas el logo
		//logo = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_LOGOTIPO);

	}
	
	//Cuando se esta actualizando lo que se actualiza es esto
	public void actualizar() {

		ElementosPrincipales.jugador.actualizar();
		ElementosPrincipales.mapa.actualizar();
	}
	
	//Cuando se esta jugando lo que se dibuja es esto
	public void dibujar(Graphics g) {
		ElementosPrincipales.mapa.dibujar(g);
		ElementosPrincipales.jugador.dibujar(g);

		// Aqui te dibuja todo el menu inferior
		menuInferior.dibujar(g);

		//DibujoDebug.dibujarImagen(g, logo, 640 - logo.getWidth() - 5, 0 + 5);

	}
}