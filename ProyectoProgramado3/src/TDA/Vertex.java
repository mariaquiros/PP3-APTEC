package TDA;

/**
 * Los vértices del Dijkstra son sus nodos de información, por lo que estos
 * pueden generar dependencia con otros objetos que se deseen ubicar al grafo.
 *
 * @param <GenericObject>
 */
public class Vertex<GenericObject> {
	private String vertex_ID;
	private GenericObject element;

	// CONSTRUCTOR
	public Vertex(String pId, GenericObject element) {
		this.vertex_ID = pId;
		this.element = element;
	}
	// GETTERS Y SETTERS

	public String getId() {
		return vertex_ID;
	}

	public void setId(String id) {
		this.vertex_ID = id;
	}

	public GenericObject getElement() {
		return element;
	}

	public void setElement(GenericObject element) {
		this.element = element;
	}

	@Override
        /**
         * método para obtener variables en string
         */
	public String toString() {
		String msj = "";
		//msj += "Vertex: ID:*" + vertex_ID + "*"+" ";
		msj+= element;
		//msj += element.toString();
		return msj;
	}
}

