package CosasBasicas;

import constantes.Constantes;

public class AccionesBasicas {
	
	public static int escalarPantallaX(int numero)
	{
		return (int) (numero*Constantes.ESCALAX);
	}
	public static int escalarPantallaY(int numero)
	{
		return (int) (numero*Constantes.ESCALAY);
	}
}
