package menu.iteradores;

import java.util.Iterator;
import java.util.Stack;
import menu.MenuComponente;
import menu.menus.Menu;
import menu.menus.burrito.MenuBurrito;
import menu.menus.pizza.MenuPizza;
import menu.menus.hamburguesa.MenuHamburguesa;

public class IteradorCompuesto implements Iterator<MenuComponente> {
	
	private Stack<Iterator> stack = new Stack();

	public IteradorCompuesto(Iterator<MenuComponente> iterador) {
		stack.push(iterador);
	}

	@Override
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterador = stack.peek();
			if (!iterador.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	@Override
	public MenuComponente next() {
		if (hasNext()) {
			Iterator<MenuComponente> iterador = stack.peek();
			MenuComponente mc = iterador.next();

			if (mc instanceof Menu) {
				Iterator<MenuComponente> it = mc.obtenerIterador();
				MenuComponente cc = it.next();
				stack.push(it);
				return cc;
			}
			return mc;
		} else {
			return null;
		}
	}
}
