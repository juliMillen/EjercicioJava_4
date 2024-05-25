package Iterators;

import java.util.Comparator;

import lab3_excepciones3.Juguete;

public class TipoComparator implements Comparator<Juguete> {

	@Override
	public int compare(Juguete o1, Juguete o2) {
		// TODO Auto-generated method stub
		return o1.getTipo().compareToIgnoreCase(o2.getTipo());
	}

}
