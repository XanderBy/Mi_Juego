package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
	public static boolean[] tecladoPulsado = new boolean[11];

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			tecladoPulsado[0] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_W:
			tecladoPulsado[1] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_S:
			tecladoPulsado[2] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_A:
			tecladoPulsado[3] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_D:
			tecladoPulsado[4] = true;
			Tecla.acciones(this);

			break;
		case KeyEvent.VK_I:
			tecladoPulsado[5] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_ESCAPE:
			tecladoPulsado[6] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_E:
			tecladoPulsado[7] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_1:
			tecladoPulsado[8] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_2:
			tecladoPulsado[9] = true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_3:
			tecladoPulsado[10] = true;
			Tecla.acciones(this);
			break;

		default:
			System.out.println("tecla introducida no valida");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			tecladoPulsado[1] = false;
			break;
		case KeyEvent.VK_S:
			tecladoPulsado[2] = false;
			break;
		case KeyEvent.VK_A:
			tecladoPulsado[3] = false;
			break;
		case KeyEvent.VK_D:
			tecladoPulsado[4] = false;
			break;
		case KeyEvent.VK_I:
			tecladoPulsado[5] = false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_ESCAPE:
			tecladoPulsado[6] = false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_E:
			tecladoPulsado[7] = false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_SPACE:
			Tecla.acciones(this);
			tecladoPulsado[0] = false;
			break;
		case KeyEvent.VK_1:
			tecladoPulsado[8] = false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_2:
			tecladoPulsado[9] = false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_3:
			tecladoPulsado[10] = false;
			Tecla.acciones(this);
			break;
		default:
			System.out.println("tecla soltada no valida");
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
