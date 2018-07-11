
import Controles.Teclado;
import constantes.Constantes;
import visual.Pantalla;
import visual.SuperficieDibujo;

public class BuclePrincipal implements Runnable 
{
	
	private static boolean corriendo = false;
	private Thread hilo = new Thread(this);
	private Teclado teclado=new Teclado();
	private SuperficieDibujo sd= new SuperficieDibujo(Constantes.ANCHO, Constantes.ALTO, teclado);
	private Pantalla pantalla = new Pantalla(Constantes.ANCHO, Constantes.ALTO, sd);
	
	public void actualizar() 
	{

		while (corriendo) {
			dibujar();
			teclado.actualizar();
		}
		parar();
	}

	@Override
	public void run() 
	{
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
