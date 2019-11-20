package TDA;


import java.util.*;

/**
 * Interface que contiene los m�todos de ejecuci�n para cualquier grafo
 * 
 *
 * @param <GenericObject>
 *            Este gen�rico permite utilizar cualquier objeto, de modo que este
 *            objeto sea parte del nodo del grafo
 */
public interface GraphBehavior<GenericObject> {
	public void runGraph(GenericObject Grafo);

	public LinkedList<GenericObject> obtainListedRoad(GenericObject pDestino);
}

