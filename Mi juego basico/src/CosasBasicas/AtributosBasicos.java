package CosasBasicas;


public abstract class AtributosBasicos {
	private int ancho;
	private int alto;
	
	
	public void cargarImagen(int ancho, int alto, String url) {
		Sprites sprite=new Sprites(ancho, alto, url);
		
	}
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	
}
