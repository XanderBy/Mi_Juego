package personajes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import Controles.Tecla;
import Controles.Teclado;
import CosasBasicas.AccionesBasicas;
import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import constantes.Constantes;
import gestores.GestorJuego;
import interfaces.MetodosEntidades;
import objetos.Objetos;
import visual.SuperficieDibujo;

public class Jugador extends Entidad implements MetodosEntidades
{

	private int resistencia;
	private int armadura;
	public static Rectangle areaJugador1;
	public static Rectangle areaJugador2;
	public static Rectangle areaJugador3;
	public static Rectangle areaJugador4;
	public static Rectangle areaJugador5;
	public static Rectangle areaJugador6;
	public static Rectangle areaJugador7;
	public static Rectangle areaJugador8;
	public static Rectangle areaJugadorInfluencia;
	
	public static ArrayList <Objetos> inventarioArray=new ArrayList <Objetos>();
	public static boolean booleanJugador1=false;
	public static boolean booleanJugador2=false;
	public static boolean booleanJugador3=false;
	public static boolean booleanJugador4=false;
	public static boolean booleanJugador5=false;
	public static boolean booleanJugador6=false;
	public static boolean booleanJugador7=false;
	public static boolean booleanJugador8=false;
	
	public Jugador(int ancho, int alto, Point posicion, int vida, int resistencia,int armadura,
			int velocidadMovimientoXIzquierda,int velocidadMovimientoYArriba,int  velocidadMovimientoXDerecha,int velocidadMovimientoYAbajo, String urlQuieto) {
		super(ancho, alto, posicion, vida, velocidadMovimientoXIzquierda,velocidadMovimientoYArriba,velocidadMovimientoXDerecha,velocidadMovimientoYAbajo, urlQuieto);
		// TODO Auto-generated constructor stub
		this.resistencia = resistencia;
		this.armadura=armadura;
		Sprites derecha1=new Sprites(55, 75, "C:\\Users\\alexi\\Desktop\\1derecha.gif");
		Sprites derecha2=new Sprites(55, 75, "C:\\Users\\alexi\\Desktop\\2derecha.gif");
		this.imagenesDerecha.add(derecha1);
		this.imagenesDerecha.add(derecha2);
		
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
		//lado izquierdo
		if(booleanJugador1==true && booleanJugador8==true && booleanJugador7==true || booleanJugador1==true && booleanJugador8==true || booleanJugador8==true && booleanJugador7==true || booleanJugador1==true || booleanJugador7==true || booleanJugador8==true) 
		{
			this.setVelocidadMovimientoXIzquierda(0);
			
		}else
		{
			this.setVelocidadMovimientoXIzquierda(Constantes.velocidadGeneral);
		}
		//arriba
		if(booleanJugador1==true && booleanJugador2==true && booleanJugador3==true||booleanJugador1==true && booleanJugador2==true||booleanJugador2==true && booleanJugador3==true|| booleanJugador2==true||booleanJugador3==true|| booleanJugador1==true) 
		{
			this.setVelocidadMovimientoYArriba(0);
		}else 
		{
			this.setVelocidadMovimientoYArriba(Constantes.velocidadGeneral);
		}
		//derecha
		if(booleanJugador3==true && booleanJugador4==true && booleanJugador5==true ||booleanJugador3==true && booleanJugador4==true || booleanJugador4==true && booleanJugador5==true||booleanJugador3==true||booleanJugador5==true|| booleanJugador4==true) 
		{
			this.setVelocidadMovimientoXDerecha(0);
		}else 
		{
			this.setVelocidadMovimientoXDerecha(Constantes.velocidadGeneral);
		}
		//Abajo
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
		GestorJuego.cargarArrayColisiones();
		//areaJugador8= new Rectangle(GestorJuego.jugador.getPosicion().x, GestorJuego.jugador.getPosicion().y+GestorJuego.jugador.getAlto()/2 , 2, 2);
		//GestorJuego.rectangulo= new Rectangle(GestorJuego.rectangulo1x,GestorJuego.rectangulo1y,50,50);
		//GestorJuego.jugador.colisionMover();
		for (Rectangle a: GestorJuego.colisiones) 
		{	
			
			//System.out.println(GestorJuego.colisiones.size());
			if(areaJugador1.intersects(a)) 
			{	
				//GestorJuego.jugador.colisionMover();
				booleanJugador1=true;
			}
			if(!areaJugador1.intersects(a)) 
			{
				//GestorJuego.jugador.colisionMover();
				booleanJugador1=false;
			}
			if(areaJugador2.intersects(a)) 
			{
				booleanJugador2=true;
			}
			if(!areaJugador2.intersects(a)) 
			{
				booleanJugador2=false;
			}
			if(areaJugador3.intersects(a)) 
			{
				booleanJugador3=true;
			}
			if(!areaJugador3.intersects(a)) 
			{
				booleanJugador3=false;
			}
			if(areaJugador4.intersects(a)) 
			{
				booleanJugador4=true;
			}
			if(!areaJugador4.intersects(a)) 
			{
				booleanJugador4=false;
			}
			if(areaJugador5.intersects(a)) 
			{
				booleanJugador5=true;
			}
			if(!areaJugador5.intersects(a)) 
			{
				booleanJugador5=false;
			}
			if(areaJugador6.intersects(a)) 
			{
				booleanJugador6=true;
			}
			if(!areaJugador6.intersects(a)) 
			{
				booleanJugador6=false;
			}
			if(areaJugador7.intersects(a)) 
			{
				booleanJugador7=true;
			}
			if(!areaJugador7.intersects(a)) 
			{
				booleanJugador7=false;
			}
			if(areaJugador8.intersects(a)) 
			{	
				//GestorJuego.jugador.colisionMover();
				booleanJugador8=true;
			}
			if(!areaJugador8.intersects(a)) 
			{	
				//GestorJuego.jugador.colisionMover();
				booleanJugador8=false;
			}
			if(booleanJugador1==true || booleanJugador2==true || booleanJugador3==true || booleanJugador4==true || booleanJugador5==true || booleanJugador6==true || booleanJugador7==true || booleanJugador8==true) {
			
				GestorJuego.jugador.colisionMover();
				break;
			}
			
		}
		GestorJuego.jugador.colisionMover();
		GestorJuego.eliminarArrayColisiones();
	}
	@Override
	public void dibujar(Graphics2D g) 
	{	
		
		//DibujosBasicos.pintarRectangulo(g, this.getAncho(), this.getAlto(), this.getPosicion().x, this.getPosicion().y);		
		//DibujosBasicos.pintarImagenJugador(g, this.getSprite(), this);
		DibujosBasicos.pintarImagenJugador(g, GestorJuego.jugador.imagenesDerecha.get(Tecla.contDerecha), GestorJuego.jugador);
		
		areaJugadorInfluencia=new Rectangle(this.getPosicion().x, this.getPosicion().y, this.getAncho(), this.getAlto());
		g.drawRect(this.getPosicion().x-(this.getPosicion().x/4), this.getPosicion().y-(this.getPosicion().x/4), this.getAncho() + (this.getPosicion().x/2), this.getAlto()+ (this.getPosicion().x/2));
		
		areaJugador1= new Rectangle(this.getPosicion().x + 10, this.getPosicion().y + 10, 2, 2);
		g.drawRect(this.getPosicion().x + 10, this.getPosicion().y + 10, 2, 2);
		
		areaJugador2= new Rectangle(this.getPosicion().x+ this.getAncho()/2, this.getPosicion().y, 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()/2, this.getPosicion().y, 2, 2);
		
		areaJugador3= new Rectangle(this.getPosicion().x+ this.getAncho()- 10, this.getPosicion().y + 10, 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho() - 10, this.getPosicion().y + 10, 2, 2);
		
		areaJugador4= new Rectangle(this.getPosicion().x+ this.getAncho(), this.getPosicion().y+this.getAlto()/2 , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho(), this.getPosicion().y+ this.getAlto()/2, 2, 2);
		
		areaJugador5= new Rectangle(this.getPosicion().x+ this.getAncho()-10, this.getPosicion().y+this.getAlto()-10 , 2, 2);
		g.drawRect(this.getPosicion().x + this.getAncho()-10, this.getPosicion().y+ this.getAlto()-10, 2, 2);
		
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
	public void cogerObjetos(Objetos objeto) 
	{
		inventarioArray.add(objeto);
	}
	public void soltarObjetos(Objetos objeto) 
	{
		inventarioArray.remove(objeto);
	}
	
	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	
}
