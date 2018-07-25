package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener
{	

	public boolean[] teclado=new boolean[10];
	private static boolean arriba=false;
	private static boolean abajo=false;
	private static boolean izquierda=false;
	private static boolean derecha=false;
	private static boolean inventario=false;
	private static boolean escape=false;
	private static boolean cogerObjeto=false;
	private static boolean disparar=false;
	
	public void actualizar() 
	{
		teclado[0]=arriba;
		teclado[1]=abajo;
		teclado[2]=izquierda;
		teclado[3]=derecha;
		teclado[4]=inventario;
		teclado[5]=escape;
		teclado[6]=cogerObjeto;
		teclado[7]=disparar;
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{	
		switch(e.getKeyCode()) 
		{
		case KeyEvent.VK_W:
			teclado[0]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_S:
			teclado[1]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_A:
			teclado[2]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_D:
			teclado[3]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_I:
			teclado[4]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_ESCAPE:
			teclado[5]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_E:
			teclado[6]=true;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_SPACE:
			teclado[7]=true;
			Tecla.acciones(this);
			break;
			default:
				System.out.println("tecla introducida no valida");
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			teclado[0]=false;
			break;
		case KeyEvent.VK_S:
			teclado[1]=false;
			break;
		case KeyEvent.VK_A:
			teclado[2]=false;
			break;
		case KeyEvent.VK_D:
			teclado[3]=false;
			break;
		case KeyEvent.VK_I:
			teclado[4]=false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_ESCAPE:
			teclado[5]=false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_E:
			teclado[6]=false;
			Tecla.acciones(this);
			break;
		case KeyEvent.VK_SPACE:
			teclado[7]=false;
			Tecla.acciones(this);
			break;
			default:
				System.out.println("tecla soltada no valida");
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
