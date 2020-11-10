package menu.iteradores;

import java.util.Iterator;
import menu.MenuComponente;

public class IteradorNulo implements Iterator<MenuComponente> {
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public MenuComponente next() {
		return null;
	}
}
