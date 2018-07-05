package controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {
	//Atributos
	public static boolean []  teclas=new boolean [5];
	
	private static boolean arriba=false;
	private static boolean abajo=false;
	private static boolean izquierda=false;
	private static boolean derecha=false;
	private static boolean disparar=false;
	
	public static void actualizar() {
		arriba=teclas[KeyEvent.VK_W];
		abajo=teclas[KeyEvent.VK_S];
		izquierda=teclas[KeyEvent.VK_A];
		derecha=teclas[KeyEvent.VK_D];
		disparar=teclas[KeyEvent.VK_ENTER];
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		teclas[e.getKeyCode()]=true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		teclas[e.getKeyCode()]=false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public static boolean isArriba() {
		return arriba;
	}


	public static void setArriba(boolean arriba) {
		Controles.arriba = arriba;
	}


	public static boolean isAbajo() {
		return abajo;
	}


	public static void setAbajo(boolean abajo) {
		Controles.abajo = abajo;
	}


	public static boolean isIzquierda() {
		return izquierda;
	}


	public static void setIzquierda(boolean izquierda) {
		Controles.izquierda = izquierda;
	}


	public static boolean isDerecha() {
		return derecha;
	}


	public static void setDerecha(boolean derecha) {
		Controles.derecha = derecha;
	}


	public static boolean isDisparar() {
		return disparar;
	}


	public static void setDisparar(boolean disparar) {
		Controles.disparar = disparar;
	}
	
}
