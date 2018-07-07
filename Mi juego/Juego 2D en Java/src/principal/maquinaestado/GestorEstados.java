package principal.maquinaestado;

import java.awt.Graphics;

import principal.graficos.SuperficieDibujo;
import principal.maquinaestado.estados.juego.GestorJuego;
import principal.maquinaestado.estados.menujuego.GestorMenu;

public class GestorEstados {
	// Esta clase principalmente lo que hace es cambiar si estas con el inventario,
	// jugando etc...

	// Son los diferentes estados que existen
	private EstadoJuego[] estados;

	// Estado del juego actual
	private EstadoJuego estadoActual;

	/* Al crear un gestor de estado en una superficie 
	 * de dibujo ocurren los dos metodos de dentro
	 */
	public GestorEstados(final SuperficieDibujo sd) {
		iniciarEstados(sd);
		iniciarEstadoActual();
	}
	//Metes todos los estados existentes
	private void iniciarEstados(final SuperficieDibujo sd) {
		estados = new EstadoJuego[2];
		estados[0] = new GestorJuego();
		estados[1] = new GestorMenu(sd);
		// Añadir e iniciar los demás estados a medida que los creemos
	}
	
	private void iniciarEstadoActual() {
		estadoActual = estados[0];
	}

	public void actualizar() {
		estadoActual.actualizar();
	}

	// este metodo no tine sentido porque se llama as� mismo
	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);
	}

	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
	}

	public EstadoJuego obtenerEstadoActual() {
		return estadoActual;
	}
}