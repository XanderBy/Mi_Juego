
import Controles.Raton;
import Controles.Teclado;
import constantes.Constantes;
import visual.Pantalla;
import visual.SuperficieDibujo;

public class BuclePrincipal implements Runnable 
{
	
	private static boolean corriendo = false;
	private Thread hilo = new Thread(this);
	private static Teclado teclado=new Teclado();
	private static Raton raton= new Raton();
	public static SuperficieDibujo sd= new SuperficieDibujo(Constantes.ANCHO, Constantes.ALTO, teclado, raton);
	private Pantalla pantalla = new Pantalla(Constantes.ANCHO, Constantes.ALTO, sd);
	public void actualizar() 
	{

		while (corriendo) {
			dibujar();
			teclado.actualizar();
			raton.actualizar();
		}
		parar();
	}

	@Override
	public void run() 
	{	
		System.out.println("Error");
		SuperficieDibujo.getArraySuperficie()[0]=sd;
		System.out.println(sd.getMousePosition());
		// TODO Auto-generated method stub

	}

	public void iniciar() 
	{

		hilo.start();
		BuclePrincipal.corriendo = true;

		actualizar();
	}

	public void parar() 
	{

		try 
		{
			corriendo = false;
			hilo.join();
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dibujar() 
	{
		sd.dibujar();
	}

	public static void main(String args[]) 
	{
		BuclePrincipal bp = new BuclePrincipal();
		bp.iniciar();
	}

}
