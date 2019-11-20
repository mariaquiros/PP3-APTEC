package TDA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase posee el comportamiento que tendrá el Dijkstra en el momento de
 * ser ejecutado
 * */
public class Dijkstra implements GraphBehavior<Vertex<Object>> {
	private List<Vertex<Object>> vertices; // Listado de vertices
	private List<Edge> aristas; // Listado de aristas
	private Set<Vertex<Object>> verticeControlado; // Corresponde a vertices ya contados en un trayecto
	private Set<Vertex<Object>> verticeNoControlado; // Corresponde a los vertices no contados en el trayecto
	private Map<Vertex<Object>, Vertex<Object>> predecesores; // Vértices vecinos del trayecto
	private Map<Vertex<Object>, Double> distancias; // Guarda la distancia de un vertice hacia todos los demas

	/**
	 * CONSTRUCTOR ComportamientoDijkstra Este constructor unicamente requiere de un
	 * grafo para poder utilizarse Genera el comportamiento para dicho grafo
	 * 
	 * @param Grafo que se usara para el comportamiento 
	 */
	public Dijkstra(Graph Grafo) {
		this.vertices = new ArrayList<Vertex<Object>>(Grafo.getVertices());
		this.aristas = new ArrayList<Edge>(Grafo.getEdges());
	}

	// GETTERS AND SETTERS
	public List<Vertex<Object>> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex<Object>> vertices) {
		this.vertices = vertices;
	}

	public List<Edge> getAristas() {
		return aristas;
	}

	public void setAristas(List<Edge> aristas) {
		this.aristas = aristas;
	}

	public Set<Vertex<Object>> getVerticeControlado() {
		return verticeControlado;
	}

	public void setVerticeControlado(Set<Vertex<Object>> verticeControlado) {
		this.verticeControlado = verticeControlado;
	}

	public Set<Vertex<Object>> getVerticeNoControlado() {
		return verticeNoControlado;
	}

	public void setVerticeNoControlado(Set<Vertex<Object>> verticeNoControlado) {
		this.verticeNoControlado = verticeNoControlado;
	}

	public Map<Vertex<Object>, Vertex<Object>> getPredecesores() {
		return predecesores;
	}

	public void setPredecesores(Map<Vertex<Object>, Vertex<Object>> predecesores) {
		this.predecesores = predecesores;
	}

	public Map<Vertex<Object>, Double> getDistancias() {
		return distancias;
	}

	public void setDistancias(Map<Vertex<Object>, Double> distancias) {
		this.distancias = distancias;
	}

	/**
	 * Permite averiguar si un vertice se encuentra ya contado dentro del trazo
	 * 
	 * @param vertice
	 *            nodo que se desea comparar
	 * @return True si se encuentra dentro de los nodos controlados
	 */
	private boolean esControlado(Vertex<Object> vertice) {
		return verticeControlado.contains(vertice);
	}

	/**
	 * Obtiene la distancia de los destinos dentro del trayecto
	 * 
	 * @param pDestino
	 *            Nodo hacia el cual se desea ir
	 * @return La distancia entre vertices de la arista
	 */
	private double obtenerDistanciaMasCorta(Vertex<Object> pDestino) {
		Double dist = distancias.get(pDestino);
		if (dist == null)
			return Double.MAX_VALUE;
		return dist;
	}

	/**
	 * Permite obtener la distancia más corta de un vertice a otro
	 * 
	 * @param vertices
	 *            este set permite generar un listado de los diferentes nodos
	 *            mapeados para configurar la salida más corta
	 * @return Los vertices por los cuales es más corto el camino
	 */
	private Vertex<Object> obtenerMinimo(Set<Vertex<Object>> vertices) {
		Vertex<Object> minimo = null;
		for (Vertex<Object> vertice : vertices) {
			if (minimo == null)
				minimo = vertice;
			else {
				if (obtenerDistanciaMasCorta(vertice) < obtenerDistanciaMasCorta(minimo))
					minimo = vertice;
			}
		}
		return minimo;
	}

	/**
	 * Permite obtener los vecinos de un trazo desde un punto a otro del grafo
	 * 
	 * @param pVertice
	 *            Que funcionará como centroide para obtener sus vecinos
	 * @return Listado de vértices que conforman un camino en común
	 */
	private List<Vertex<Object>> obtenerVecinos(Vertex<Object> pVertice) {
		List<Vertex<Object>> vecinos = new ArrayList<Vertex<Object>>();
		for (Edge arista : aristas) {
			if (arista.getPuntoPartida().equals(pVertice) && !esControlado(arista.getPuntoLlegada()))
				vecinos.add(arista.getPuntoLlegada());
		}
		return vecinos;
	}

	/**
	 * Obtiene la distancia entre 2 vertices de ubicaciones distintas
	 * 
	 * @param partida
	 *            Vértice del cuál se parte
	 * @param llegada
	 *            Vértice de destino
	 * @return La distancia para ser guardada dentro de las distancias como una
	 *         longitud
	 */
	private double obtenerDistancia(Vertex<Object> partida, Vertex<Object> llegada) {
		for (Edge arista : aristas) {
			if (arista.getPuntoPartida().equals(partida) && arista.getPuntoLlegada().equals(llegada))
				return arista.getLongitud();
		}
		throw new RuntimeException("Estos vertices no tienen uni�n uno con el otro");
	}

	/**
	 * Permite generar la distancia más corta entre 2 vertices. Esta distancia está
	 * dada por medio del conjunto de infotmaición de los métodos anteriores
	 * 
	 * @param pVertice
	 *            Vértice del cual se desea obtener una distancia mínima
	 */
	private void obtenerDistanciaMinima(Vertex<Object> pVertice) {
		List<Vertex<Object>> verticesVecinos = obtenerVecinos(pVertice);
		for (Vertex<Object> verticeDestino : verticesVecinos) {
			if (obtenerDistanciaMasCorta(verticeDestino) > obtenerDistanciaMasCorta(pVertice) + obtenerDistancia(pVertice, verticeDestino)) {
				distancias.put(verticeDestino,
						obtenerDistanciaMasCorta(pVertice) + obtenerDistancia(pVertice, verticeDestino));
				predecesores.put(verticeDestino, pVertice);
				verticeNoControlado.add(verticeDestino);
			}
		}
	}

	/**
	 * Este método permite generar un mapeo general a partir de un nodo centroide.
	 * Este centroide será el nodo de partida y todos los demás nodos serán los de
	 * llegada. De manera automática se podran obtener las diferentes distancias
	 * hacia cada uno de los nodos.
	 * 
	 * Este métodos se debe ejecutar antes que obtenerListadoCamino().
	 */
	public void runGraph(Vertex<Object> pVertice) {
		verticeControlado = new HashSet<Vertex<Object>>();
		verticeNoControlado = new HashSet<Vertex<Object>>();
		distancias = new HashMap<Vertex<Object>, Double>();
		predecesores = new HashMap<Vertex<Object>, Vertex<Object>>();
		distancias.put(pVertice, 0.0);
		verticeNoControlado.add(pVertice);
		while (verticeNoControlado.size() > 0) {
			Vertex<Object> vertice = obtenerMinimo(verticeNoControlado);
			verticeControlado.add(vertice);
			verticeNoControlado.remove(vertice);
			obtenerDistanciaMinima(vertice);
		}
	}

	/**
	 * Permite generar un listado de nodos mediante los cuales se llegará al destino
	 * mediante una distancia más corta.
	 * 
	 * Este método debe ejecutarse desupués de ejecutarGrafo();
	 * 
	 * @param pDestino
	 *            Corresponde al vértice destino al cuál se desea llegar a partir de
	 *            uno conocido
	 */
	public LinkedList<Vertex<Object>> obtainListedRoad(Vertex<Object> pDestino) {
		LinkedList<Vertex<Object>> caminoDijkstra = new LinkedList<Vertex<Object>>();
		Vertex<Object> trazo = pDestino;
		if (predecesores.get(trazo) == null)
			return null;
		caminoDijkstra.add(trazo);
		while (predecesores.get(trazo) != null) {
			trazo = predecesores.get(trazo);
			caminoDijkstra.add(trazo);
		}                
                Collections.reverse(caminoDijkstra);
		return caminoDijkstra;
	}
}

