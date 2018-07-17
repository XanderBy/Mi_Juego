package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import constantes.Constantes;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;

public class Jugador extends Entidad implements MetodosEntidades
{
	public static Rectangle areaJugador1;
	public static Rectangle areaJugador2;
	public static Rectangle areaJugador3;
	public static Rectangle areaJugador4;
	public static Rectangle areaJugador5;
	public static Rectangle areaJugador6;
	public static Rectangle areaJugador7;
	public static Rectangle areaJugador8;
	
	public static boolean booleanJugador1=false;
	public static boolean booleanJugador2=false;
	public static boolean booleanJugador3=false;
	public static boolean booleanJugador4=false;
	public static boolean booleanJugador5=false;
	public static boolean booleanJugador6=false;
	public static boolean booleanJugador7=false;
	public static boolean booleanJugador8=false;
	
	public Jugador(int ancho, int alto, Point posicion, int vida, int resistencia,
			int velocidadMovimientoXIzquierda,int velocidadMovimientoYArriba,int  velocidadMovimientoXDerecha,int velocidadMovimientoYAbajo, String urlQuieto) {
		super(ancho, alto, posicion, vida, resistencia, velocidadMovimientoXIzquierda,velocidadMovimientoYArriba,velocidadMovimientoXDerecha,velocidadMovimientoYAbajo, urlQuieto);
		// TODO Auto-generated constructor stub
		
	}
	
	public void moverArriba(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y=GestorJuego.mapa.posicion.y +velocidadMovimiento;
		AccionesBasicas.correccionYPositivo(velocidadMovimiento);
		colision();
		//posicion.y=posicion.y - velocidadMovimiento;
	}
	public void moverAbajo(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.y=GestorJuego.mapa.posicion.y -velocidadMovimiento;
		AccionesBasicas.correccionYNegativo(velocidadMovimiento);
		colision();
		//posicion.y=posicion.y + velocidadMovimiento;
	}
	public void moverIzquierda(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x=GestorJuego.mapa.posicion.x +velocidadMovimiento;
		AccionesBasicas.correccionXPositivo(velocidadMovimiento);
		//posicion.x=posicion.x - velocidadMovimiento;
		colision();
	}
	public void moverDerecha(Point posicion, int velocidadMovimiento) {
		GestorJuego.mapa.posicion.x=GestorJuego.mapa.posicion.x -velocidadMovimiento;
		AccionesBasicas.correccionXNegativo(velocidadMovimiento);
		//posicion.x=posicion.x + velocidadMovimiento;
		colision();
	}
	public void colisionMover()
	{	
		//Kado izquierdo
		if(booleanJugador1==true && booleanJugador8==true && booleanJugador7==true || booleanJugador1==true && booleanJugador8==true || booleanJugador8==true && booleanJugador7==true || booleanJugador1==true || booleanJugador7==true || booleanJugador8==true) 
		{
			System.out.println("Parado");
			this.setVelocidadMovimientoXIzquierda(0);
		}else
		{
			this.setVelocidadMovimientoXIzquierda(Constantes.velocidadGeneral);
		}
		
		if(booleanJugador1==true && booleanJugador2==true && booleanJugador3==true||booleanJugador1==true && booleanJugador2==true||booleanJugador2==true && booleanJugador3==true|| booleanJugador2==true||booleanJugador3==true|| booleanJugador1==true) 
		{
			this.setVelocidadMovimientoYArriba(0);
		}else 
		{
			this.setVelocidadMovimientoYArriba(Constantes.velocidadGeneral);
		}
		if(booleanJugador3==true && booleanJugador4==true && booleanJugador5==true ||booleanJugador3==true && booleanJugador4==true || booleanJugador4==true && booleanJugador5==true||booleanJugador3==true||booleanJugador5==true|| booleanJugador4==true) 
		{
			this.setVelocidadMovimientoXDerecha(0);
		}else 
		{
			this.setVelocidadMovimientoXDerecha(Constantes.velocidadGeneral);
		}
		if(booleanJugador5==true && booleanJugador6==true && booleanJugador7==true || booleanJugador5==true && booleanJugador6==true || booleanJugador6==true && booleanJugador7==true||booleanJugador7==true||booleanJugador6==true||booleanJugador5==true) 
		{
			this.setVelocidadMovimientoYAbajo(0);
		}else 
		{
			this.setVelocidadMovimientoYAbajo(Constantes.velocidadGeneral);
		}
	}
	public static void colision() 
	{	
		GestorJuego.cargarArray();
		//areaJugador8= new Rectangle(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y+GestorJuego.jugador.getAlto()/2 , 2, 2);
		//GestorJuego.rectangulo= new Rectangle(GestorJuego.rectangulo1x,GestorJuego.rectangulo1y,50,50);
		for (Rectangle a: GestorJuego.colisiones) 
		{
			if(areaJugador1.intersects(a)) 
			{
				System.out.println("Holaaaa1");
				booleanJugador1=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador1.intersects(a)) 
			{
				System.out.println("Holaaaa1");
				booleanJugador1=false;
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador2.intersects(a)) 
			{
				booleanJugador2=true;
				System.out.println("Holaaaa2");
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador2.intersects(a)) 
			{
				booleanJugador2=false;
				System.out.println("Holaaaa2");
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador3.intersects(a)) 
			{
				System.out.println("Holaaaa3");
				booleanJugador3=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador3.intersects(a)) 
			{
				System.out.println("Holaaaa3");
				booleanJugador3=false;
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador4.intersects(a)) 
			{
				System.out.println("Holaaaa4");
				booleanJugador4=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador4.intersects(a)) 
			{
				System.out.println("Holaaaa4");
				booleanJugador4=false;
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador5.intersects(a)) 
			{
				System.out.println("Holaaaa5");
				booleanJugador5=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador5.intersects(a)) 
			{
				System.out.println("Holaaaa5");
				booleanJugador5=false;
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador6.intersects(a)) 
			{
				System.out.println("Holaaaa6");
				booleanJugador6=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador6.intersects(a)) 
			{
				System.out.println("Holaaaa6");
				booleanJugador6=false;
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador7.intersects(a)) 
			{
				System.out.println("Holaaaa7");
				booleanJugador7=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador7.intersects(a)) 
			{
				System.out.println("Holaaaa7");
				booleanJugador7=false;
				GestorJuego.jugador.colisionMover();
			}
			if(areaJugador8.intersects(a)) 
			{
				System.out.println("Holaaaa8");
				booleanJugador8=true;
				GestorJuego.jugador.colisionMover();
			}
			if(!areaJugador8.intersects(a)) 
			{
				System.out.println("Holaaaa8");
				booleanJugador8=false;
				GestorJuego.jugador.colisionMover();
			}
		}
		GestorJuego.eliminarArrar();
	}
	@Override
	public void dibujar(Graphics2D g) 
	{	
		
		//DibujosBasicos.pintarRectangulo(g, this.getAncho(), this.getAlto(), this.getPosicion().x, this.getPosicion().y);		
		DibujosBasicos.pintarImagenJugador(g, this.getSprite(), this);
		areaJugador1= new Rectangle(this.getPosicion().x + 10, this.getPosicion().y + 10, 2, 2);
		g.drawRect(this.getPosicion().x + 10, this.getPosicion().y + 10, 2, 2);
		
		areaJugador2= new Rectangle(this.getPosicion().x+ this.getAncho()/2, this.getPosicion().y, 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()/2, this.getPosicion().y, 2, 2);
		
		areaJugador3= new Rectangle(this.getPosicion().x+ this.getAncho()- 10, this.getPosicion().y + 10, 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho() - 10, this.getPosicion().y + 10, 2, 2);
		
		areaJugador4= new Rectangle(this.getPosicion().x+ this.getAncho(), this.getPosicion().y+this.getAlto()/2 , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho(), this.getPosicion().y+ this.getAlto()/2, 2, 2);
		
		areaJugador5= new Rectangle(this.getPosicion().x+ this.getAncho()+10, this.getPosicion().y+this.getAlto()-10 , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()-10, this.getPosicion().y+ this.getAlto()+10, 2, 2);
		
		areaJugador6= new Rectangle(this.getPosicion().x+ this.getAncho()/2, this.getPosicion().y+this.getAlto() , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()/2, this.getPosicion().y+ this.getAlto(), 2, 2);
		
		areaJugador7= new Rectangle(this.getPosicion().x + 10, this.getPosicion().y+this.getAlto() -10, 2, 2);
		g.drawRect(this.getPosicion().x +10, this.getPosicion().y+ this.getAlto() -10, 2, 2);
		
		areaJugador8= new Rectangle(this.getPosicion().x, this.getPosicion().y+this.getAlto()/2 , 2, 2);
		g.drawRect(this.getPosicion().x, this.getPosicion().y+ this.getAlto()/2, 2, 2);
		
	}

	@Override
	public void dano(int dano) 
	{
		this.setVida(this.getVida() - dano);
	}
}
