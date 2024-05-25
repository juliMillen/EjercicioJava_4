package Iterators;

import java.util.Comparator;

import lab3_excepciones3.Juguete;

public class NombreIterator implements Comparator<Juguete> {

	@Override
	public int compare(Juguete o1, Juguete o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
