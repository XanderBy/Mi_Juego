package principal.maquinaestado;

import java.awt.Graphics;

public interface EstadoJuego {
	// Esta interface lo que dice principalmente es que todos los estados van a
	// tener como minimo esos dos metodos
	void actualizar();

	void dibujar(final Graphics g);
}