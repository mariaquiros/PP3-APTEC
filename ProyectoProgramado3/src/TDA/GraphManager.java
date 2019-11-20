package TDA;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * clase para controlar el grafo
 */

//atributos
public class GraphManager {
	private List<Vertex<Object>> vertices;
	private List<Edge> edges;
	private LinkedList<Vertex<Object>> trazo;

	/**
	 * Al generar el contructor se inicializan y se crean objetos de las 3 listas
	 * necesarias.
	 */
	public GraphManager() {
		this.vertices = new ArrayList<Vertex<Object>>();
		this.edges = new ArrayList<Edge>();
		this.trazo = new LinkedList<Vertex<Object>>();
	}

	/**
	 * método para obtener el trazo del grafo
	 * 
	 * @return trazo con camino
	 */
	public LinkedList<Vertex<Object>> getTrazo() {
		return trazo;
	}

	/**
	 * método para ingresar nuevo trazo
	 * 
	 * @param trazo trazo por ingresar
	 */
	public void setTrazo(LinkedList<Vertex<Object>> trazo) {
		this.trazo = trazo;
	}

	/**
	 * método para obtener vertices
	 * 
	 * @return vertices del grafo
	 */
	public List<Vertex<Object>> getVertices() {
		return vertices;
	}

	/**
	 * método para configurar vertices
	 * 
	 * @param vertices vertices nuevas para el grafo
	 */
	public void setVertices(List<Vertex<Object>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * método para obtener aristas
	 * 
	 * @return aristas
	 */
	public List<Edge> getEdges() {
		return edges;
	}

	/**
	 * MÉtodo para ingresar aristas al grafo
	 * 
	 * @param edges nuevas aristas
	 */
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	/**
	 * Permite generar relaciones entre los vertices (que deben ser existentes) y
	 * las aristas
	 * 
	 * @param edge_id           ID que se le dará a las aristas
	 * @param vertices_A_list_ID ID del vértice del cuál se parte
	 * @param vertices_B_list_ID ID del vértice de llegada
	 * @param roadDistance   La distancia que hay entre el Vértice de partida
	 *                            y el vertice de llegada
	 */
	public void newEdge(String edge_id, int vertices_A_list_ID, int vertices_B_list_ID,
			double roadDistance) {

		Edge arista = new Edge(edge_id, vertices.get(vertices_A_list_ID),
				vertices.get(vertices_B_list_ID), roadDistance);
		edges.add(arista);
	}

	/**
	 * Permite generar nuevos vértices para ser utilizados dentro del grafo
	 * 
	 * @param vertex_ID  ID del vértice que se desea crear
	 * @param element Objeto externo que se desea insertar dentro del vértice
	 */
	public void newVertes(String vertex_ID, Object element) {
		Vertex<Object> vertice = new Vertex<Object>(vertex_ID, element);
		vertices.add(vertice);
	}

	/**
	 * método para obtener el id según el string de un vértice
	 * 
	 * @param id_vertice id del vértice buscado
	 * @return vértice con el valor buscado
	 */
	public Vertex<Object> consultbyVertexID(String id_vertice) {
		Vertex<Object> newVertex = null;
		for (Vertex<Object> nestedVertes : vertices) {
			if (nestedVertes.getId().equals(id_vertice)) {
				newVertex = nestedVertes;
				return newVertex;
			}
		}
		return null;
	}
	/** metodo para remover un vertice
	 * 
	*  @param vertex vértice que se quiere borrar
	*/
	public void removeVertex(Vertex<Object> vertex) {
		vertices.remove(vertex);
	}
	/** metodo para remover una arista
	 * 
	*  @param edge arista que se quiere borrar
	*/
	public void removeEdge(Edge edge) {
		edges.remove(edge);
	}
}

