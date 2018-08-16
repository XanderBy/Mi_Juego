package objetos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bala {
	public Point posicion;
	public Rectangle rectangulo;
	public final String direccion;
	public static int contador=0;
	public int contadorVida=0;
	public static ArrayList<Bala>ArrayBalas=new ArrayList<Bala>();
	
	
	public Bala(Point posicion, String direccion) {
		super();
		this.posicion = posicion;
		this.direccion = direccion;
		rectangulo=new Rectangle(posicion.x, posicion.y, 2, 2);
		ArrayBalas.add(this);
	}
	
	public void recorridoBala(Bala bala, Graphics2D g) {
		switch(direccion)
		{
		case "norte":
			bala.posicion.y--;
			rectangulo=new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;
		case "sur":
			bala.posicion.y++;
			rectangulo=new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;

		case "este":
			bala.posicion.x++;
			rectangulo=new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;

		case "oeste":
			bala.posicion.x--;
			rectangulo=new Rectangle(bala.posicion.x, bala.posicion.y, 2, 2);
			g.fillRect(bala.posicion.x, bala.posicion.y, 2, 2);
			bala.contadorVida++;
			break;
			default:
				System.out.println("Error direccion bala!!");
				break;
		}
		
	}
	 
}
