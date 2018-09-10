package spawn;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import CosasBasicas.DibujosBasicos;
import CosasBasicas.Sprites;
import personajes.Entidad;

public class SpawnEnemigo {
	private int cantidadGenerados;
	private int vida;
	private Sprites imagenSpawn;
	private ArrayList<Entidad> entidades = new ArrayList<Entidad>();
	private Point posicionSpawn;

	public SpawnEnemigo(int cantidadGenerados, ArrayList<Entidad> entidades, int vida) {
		super();
		this.cantidadGenerados = cantidadGenerados;
		this.entidades = entidades;
		this.posicionSpawn = posicionSpawn();
		this.vida = vida;

	}

	public void Actualizar(Graphics2D g) {
		DibujosBasicos.pintarImagenSpawnEnemigo(g, this.imagenSpawn, this);
	}

	public Point posicionSpawn() {

		return null;

	}
}
