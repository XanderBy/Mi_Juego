 


import Controles.Raton;
import Controles.Tecla;
import Controles.Teclado;
import constantes.Constantes;
import objetos.armas.Armas;
import visual.Pantalla;
import visual.SuperficieDibujo;

public class BuclePrincipal implements Runnable 
{
	
	private static boolean corriendo = false;
	private Thread hilo = new Thread(this);
	
	private static Teclado teclado=new Teclado();
	private static Raton raton= new Raton();
	static SuperficieDibujo sd= new SuperficieDibujo(Constantes.ANCHO, Constantes.ALTO, teclado, raton);
	private Pantalla pantalla = new Pantalla(Constantes.ANCHO, Constantes.ALTO, sd);
	
	//para los fps
	//-
	private static int fps=0;
	private static int aps;
	//-
	public void actualizar() 
	{	
		aps++;
		dibujar();
		raton.actualizar();
		
		
		
		
		
	}

	@Override
	public void run() 
	{	
		SuperficieDibujo.getArraySuperficie()[0]=sd;
		Constantes.arrayPantalla.add(pantalla);
		//-
		final int NS_POR_SEGUNDO=1000000000;
		final int APS_OBJETIVO= 120;
		final double NS_POR_ACTUALIZACION= NS_POR_SEGUNDO/ APS_OBJETIVO;
		long referenciaActualizacion= System.nanoTime();
		long referenciaContador= System.nanoTime();
		double tiempoTranscurrido;
		double delta=0;
		//-
		
		while (corriendo) 
		{
			
			//-
			final long inicioBucle= System.nanoTime();
			tiempoTranscurrido= inicioBucle - referenciaActualizacion;
			referenciaActualizacion=inicioBucle;
			delta +=tiempoTranscurrido/NS_POR_ACTUALIZACION;
			
			while(delta >=1) 
			{
				//Menos actualizar que eso es obligatorio
				actualizar();
				delta --;
			}
			
			if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) 
			{
				System.out.println("Fps: " + fps);
				fps=0;
				aps=0;
				referenciaContador=System.nanoTime();
			}
			//-
		}
		parar();

	}

	public void iniciar() 
	{
		hilo.start();
		BuclePrincipal.corriendo = true;

		//actualizar();
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
		fps++;
		sd.dibujar();
	}

	public static void main(String args[]) 
	{
		BuclePrincipal bp = new BuclePrincipal();
		bp.iniciar();
	}

}
