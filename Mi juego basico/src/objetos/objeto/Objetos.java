package objetos.objeto;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import Controles.Tecla;
import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import constantes.Constantes;
import gestores.GestorJuego;
import objetos.TipoObjetos;
import objetos.armas.Armas;

public class Objetos {
	public Point posicion;
	public Rectangle areaObjetoInfluencia;
	private String url;
	private String urlInventario;
	public Sprites sprite;
	public Sprites spriteInventario;
	public int ancho;
	public int alto;
	public boolean cogido = false;
	public boolean usar = false;
	public TipoObjetos tipoObjeto;
	public int sumarle;

	public Objetos(Point posicion, String url, String urlInventario, int ancho, int alto, TipoObjetos tipoObjetos,
			int sumarle) {
		super();
		this.posicion = posicion;
		this.url = url;
		this.urlInventario = urlInventario;
		this.ancho = ancho;
		this.alto = alto;
		this.tipoObjeto = tipoObjetos;
		cargarImagen(ancho, alto, url);
		cargarImagenInventario(ancho, alto, urlInventario);
		this.areaObjetoInfluencia = new Rectangle(posicion.x, posicion.y, ancho, alto);
		this.usar = false;
		this.cogido = false;
		this.sumarle = sumarle;
	}

	public void actualizar() {
		if (this.usar == true) {
			if (this.getTipoObjeto().equals(TipoObjetos.ARMAS)) {
				// Aqui se tendría que cambiar la imagen del jugador para tener el arma actual
				((Armas) Tecla.objetoElegido).poderDisparar = true;
			}
			if (this.getTipoObjeto().equals(TipoObjetos.ESTAMINA)) {
				if (this.tipoObjeto == TipoObjetos.ESTAMINA
						&& GestorJuego.jugador.getResistencia() + this.sumarle <= 100) {
					GestorJuego.jugador.setResistencia(GestorJuego.jugador.getResistencia() + this.sumarle);
					for (int i = 0; i < GestorJuego.jugador.inventarioArray.length; i++) {
						if (GestorJuego.jugador.inventarioArray[i] == this) {
							GestorJuego.jugador.inventarioArray[i] = null;
							break;
						}
					}
				}
			}
			if (this.getTipoObjeto().equals(TipoObjetos.MEDICINAL)) {
				if (this.tipoObjeto == TipoObjetos.MEDICINAL && GestorJuego.jugador.getVida() + this.sumarle <= 100) {
					GestorJuego.jugador.setVida(GestorJuego.jugador.getVida() + this.sumarle);
					for (int i = 0; i < GestorJuego.jugador.inventarioArray.length; i++) {
						if (GestorJuego.jugador.inventarioArray[i] == this) {
							GestorJuego.jugador.inventarioArray[i] = null;
							break;
						}
					}
				}

			}
			if (this.getTipoObjeto().equals(TipoObjetos.ARMADURA)) {

				GestorJuego.jugador.setArmadura(GestorJuego.jugador.getArmadura() + this.sumarle);

			}

		}
		this.usar = false;
	}

	public void cargarImagen(int ancho, int alto, String url) {
		sprite = new Sprites(ancho, alto, url);
	}

	public void cargarImagenInventario(int ancho, int alto, String urlInventario) {
		spriteInventario = new Sprites(ancho, alto, urlInventario);
	}

	public void dibujar(Graphics2D g, Objetos arma) {
		if (arma.isCogido() == false) {
			// System.out.println("No cogido");
			// DibujosBasicos.pintarImagenArmas(g, arma.sprite, (Armas) arma);
			g.drawImage(sprite.imagen, arma.posicion.x, arma.posicion.y, sprite.introducirImagenesArray(sprite.imagen),
					null);
			g.drawRect(arma.posicion.x, arma.posicion.y, arma.ancho, arma.alto);
			arma.areaObjetoInfluencia = new Rectangle(this.posicion.x, this.posicion.y, this.ancho, this.alto);
		} else {
			try {
				actualizar();
				arma.areaObjetoInfluencia = new Rectangle(100000, 100000, 0, 0);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public boolean isCogido() {
		return cogido;
	}

	public void setCogido(boolean cogido) {
		this.cogido = cogido;
	}

	public Rectangle getAreaObjetoInfluencia() {
		return areaObjetoInfluencia;
	}

	public void setAreaObjetoInfluencia(Rectangle areaObjetoInfluencia) {
		this.areaObjetoInfluencia = areaObjetoInfluencia;
	}

	public TipoObjetos getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(TipoObjetos tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

}
