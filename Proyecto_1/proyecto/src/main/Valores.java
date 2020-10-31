package main;

import robot.Robot;
import productos.mercancia.Mercancia;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.pizza.Pizza;
import productos.menu.burrito.Burrito;
import productos.menu.hamburguesa.Hamburguesa;
import productos.menu.MenuItem;
import menu.pizza.MenuPizza;
import menu.hamburguesa.MenuHamburguesa;
import menu.burrito.MenuBurrito;

public class Valores {
	
	public static MenuHamburguesa mh = new MenuHamburguesa();
	public static MenuPizza mp = new MenuPizza();
	public static MenuBurrito mb = new MenuBurrito();
	
	public static void metodo() {
		mh.agregarHamburguesa(new Hamburguesa("Hamburguesa de tofu","Todo lo " +
			"bueno de las hamburguesas, pero con tofu",true,35));
		mh.agregarHamburguesa(new Hamburguesa("KangreBurgesa","El mayor miste" +
			"ro del exterior de ropa",false,30));
		mh.agregarHamburguesa(new Hamburguesa("Yoshitemato","La mas alta en g" +
			"rasa del restaurante",false,50));
		mh.agregarHamburguesa(new Hamburguesa("Hamburguesa de pollo","Todo lo" +
			" bueno de las hamburguesas, pero con pollo",false,36));
		mh.agregarHamburguesa(new Hamburguesa("Hamburgesa vegetariana delux",
		"La mejor haburgesa sin carne animal",true,50));
	
		mp.agregarPizza(new Pizza("Hawaiyana","Pizza con pi\u00f1a (no les gu" +
			"sta a los italianos)",false,99));
		mp.agregarPizza(new Pizza("PizaPiza","Pizza con pepperoni y nada mas." +
			" Lista al caliente",false,79));
		mp.agregarPizza(new Pizza("Vegana","Queso vegano e ingrdientes vegeta" +
			"les",true,100));
		mp.agregarPizza(new Pizza("Trinagular","Piza de pepperoni pero con fo" +
			"rma triangular",false,60));
	
		mb.agregarBurrito(new Burrito("Huevito con jamon","Un burrito con ing" +
			"rediente principal huevito con jamon",false,40));
		mb.agregarBurrito(new Burrito("Frijoles solos","Un burrito solo con f" +
			"ijoles",true,20));
		mb.agregarBurrito(new Burrito("Burritus Maximus","Un burrito que  no " +
			"te puedes acabar tu solo, ven acompa\u00f1ado",false,69));
		mb.agregarBurrito(new Burrito("Burrito especial","En realidad no es m" +
			"uy especial",false,35));
	}
	
	public static Robot robot = new Robot(mh,mp,mb);
	
}
