package principal.maquinaestado.estados.menujuego;

import java.awt.*;

import principal.graficos.SuperficieDibujo;
import principal.maquinaestado.EstadoJuego;

public class GestorMenu implements EstadoJuego {
	//Este gestor es el del inventario
	
	//Creas una variable que sea la superficie de dibujo
	private final SuperficieDibujo sd;
	
	
	//Creas una estrutura de menu aparte y la llamas con una variable
	private final EstructuraMenu estructuraMenu;
	
	//Son los apartados que existen en el inventario
	private final SeccionMenu[] secciones;
	
	//Aqui indicas en que seccion estas actualmente si por ejemplo en equipo o inventario
	private SeccionMenu seccionActual;
	
	
	//Constructor de la "mochila" en cual indicas su estructura secciones
	public GestorMenu(final SuperficieDibujo sd) {
		this.sd = sd;

		estructuraMenu = new EstructuraMenu();

		secciones = new SeccionMenu[2];
		
		//Aqui lo que esta haciendo es dibujar el boton del inventario
		final Rectangle etiquetaInventario = new Rectangle(
				estructuraMenu.BANNER_LATERAL.x + estructuraMenu.MARGEN_HORIZONTAL_ETIQUETAS,
				estructuraMenu.BANNER_LATERAL.y + estructuraMenu.MARGEN_VERTICAL_ETIQUETAS,
				estructuraMenu.ANCHO_ETIQUETAS, estructuraMenu.ALTO_ETIQUETAS);
		
		//Aqui lo que esta haciendo es crear el menu inventario
		secciones[0] = new MenuInventario("Inventario", etiquetaInventario, estructuraMenu);
		
		//Aqui lo que esta haciendo es dibujar el boton del equipo
		final Rectangle etiquetaEquipo = new Rectangle(
				estructuraMenu.BANNER_LATERAL.x + estructuraMenu.MARGEN_HORIZONTAL_ETIQUETAS,
				etiquetaInventario.y + etiquetaInventario.height + estructuraMenu.MARGEN_VERTICAL_ETIQUETAS,
				estructuraMenu.ANCHO_ETIQUETAS, estructuraMenu.ALTO_ETIQUETAS);
		
		//Aqui lo que esta haciendo es crear el menu equipo
		secciones[1] = new MenuEquipo("Equipo", etiquetaEquipo, estructuraMenu);
		
		//Aqui indicas cuando abres el menu de la "mochila" que se abrira por el menu de inventario
		seccionActual = secciones[0];
	}
	//Este metodo lo que hace principalmente es cuando pulsas segun que boton del menu vayas a una seccion u otra
	public void actualizar() {
		for (int i = 0; i < secciones.length; i++) {
			//Si has presionado el boton izquierdo y ademas el rectangulo creado con el raton esta encima del boton actuará
			
			if (sd.obtenerRaton().obtenerClick() && sd.obtenerRaton().obtenerRectanguloPosicion()
					.intersects(secciones[i].obtenerEtiquetaMenuEscalada())) {
               
				//Si las secciones estan declaradas principalmente
				if (secciones[i] instanceof  MenuEquipo) {
					//te crea el menu en las diferentes secciones
                    MenuEquipo seccion = (MenuEquipo) secciones[i];
                    
                   
                }
				
				seccionActual = secciones[i];
			}
		}

		seccionActual.actualizar();
	}
	
	
	//Dibuja el menu
	public void dibujar(final Graphics g) {
		estructuraMenu.dibujar(g);

		for (int i = 0; i < secciones.length; i++) {

			if (seccionActual == secciones[i]) {
				if (sd.obtenerRaton().obtenerRectanguloPosicion()
						.intersects(secciones[i].obtenerEtiquetaMenuEscalada())) {
					secciones[i].dibujarEtiquetaActivaResaltada(g);
				} else {
					secciones[i].dibujarEtiquetaActiva(g);
				}
			} else {
				if (sd.obtenerRaton().obtenerRectanguloPosicion()
						.intersects(secciones[i].obtenerEtiquetaMenuEscalada())) {
					secciones[i].dibujarEtiquetaInactivaResaltada(g);
				} else {
					secciones[i].dibujarEtiquetaInactiva(g);
				}
			}
		}

		seccionActual.dibujar(g, sd, estructuraMenu);
	}
}