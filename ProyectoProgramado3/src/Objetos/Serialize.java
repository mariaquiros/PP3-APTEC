package Objetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	
	public Serialize() {
	};
	/**
	 * Metodo que crea un archivo en el directorio
	 * @param nombre
	 */
	public static void Create (String nombre) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(nombre));
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo que guarda un objeto en el directorio
	 * @param elemnt
	 * @param nombre
	 */
	public static void Save (Object elemnt, String nombre) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(nombre));
			oos.writeObject(elemnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo que abre el archivo serializado
	 * @param nombre
	 * @return element
	 */
	public static Object Load (String nombre) {
		try {
			ois = new ObjectInputStream(new FileInputStream(nombre));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
