package main;

import robot.Robot;
import productos.mercancia.Mercancia;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.pizza.Pizza;
import productos.menu.burrito.Burrito;
import productos.menu.hamburguesa.Hamburguesa;
import productos.menu.MenuItem;
import menu.MenuComponente;
import menu.menus.Menu;
import menu.menus.pizza.MenuPizza;
import menu.menus.hamburguesa.MenuHamburguesa;
import menu.menus.burrito.MenuBurrito;

/**
 * Clase con valores para la ejecucion del proyecto
 */
public class Valores {
	
	/**
	 * Inicia los tres menus predeterminados
	 */
	public static MenuHamburguesa mh = new MenuHamburguesa("");
	public static MenuPizza mp = new MenuPizza("");
	public static MenuBurrito mb = new MenuBurrito("");
	public static Menu todos = new Menu("Menu");
	
	/**
	 * Metodo que asigna varios alimentos en los menus
	 */
	public static void metodo() {
		mh.agregar(new Hamburguesa("Hamburguesa de tofu","Todo lo " +
			"bueno de las hamburguesas, pero con tofu",true,35));
		mh.agregar(new Hamburguesa("KangreBurgesa","El mayor miste" +
			"ro del exterior de ropa",false,30));
		mh.agregar(new Hamburguesa("Yoshitemato","La mas alta en g" +
			"rasa del restaurante",false,50));
		mh.agregar(new Hamburguesa("Hamburguesa de pollo","Todo lo" +
			" bueno de las hamburguesas, pero con pollo",false,36));
		mh.agregar(new Hamburguesa("Hamburgesa vegetariana delux",
		"La mejor haburgesa sin carne animal",true,50));
		mh.agregar(new AdaptadorMenuItem(new Mercancia("Fanatico d" +
			"e las hamburguesas","Gorra","Verde","Tela",50)));
		mh.agregar(new AdaptadorMenuItem(new Mercancia("Fanatico d" +
			"e las hamburguesas","Gorra","Amarillo","Tela",40)));
		mh.agregar(new AdaptadorMenuItem(new Mercancia("Conocedor " +
			"de las hamburguesas","Taza","Amarillo","Melamina",50)));
	
		mp.agregar(new Pizza("Hawaiyana","Pizza con pi\u00f1a (no les gu" +
			"sta a los italianos)",false,99));
		mp.agregar(new Pizza("PizaPiza","Pizza con pepperoni y nada mas." +
			" Lista al caliente",false,79));
		mp.agregar(new Pizza("Vegana","Queso vegano e ingrdientes vegeta" +
			"les",true,100));
		mp.agregar(new Pizza("Trinagular","Piza de pepperoni pero con fo" +
			"rma triangular",false,60));
		mp.agregar(new AdaptadorMenuItem(new Mercancia("Fanatico de las " +
			"pizzas","Gorra","Azul","Tela",50)));
		mp.agregar(new AdaptadorMenuItem(new Mercancia("Fanatico de las " +
			"pizzas","Gorra","Naranja","Tela",50)));
		mp.agregar(new AdaptadorMenuItem(new Mercancia("Mu\u00f1eco cabe" +
			"zon","Juguete","Morado","Plastico",25)));
		mp.agregar(new AdaptadorMenuItem(new Mercancia("Pizzivir","Jugue" +
			"te","Morado","Plastico",72)));
		
		mb.agregar(new Burrito("Huevito con jamon","Un burrito con ing" +
			"rediente principal huevito con jamon",false,40));
		mb.agregar(new Burrito("Frijoles solos","Un burrito solo con f" +
			"ijoles",true,20));
		mb.agregar(new Burrito("Burritus Maximus","Un burrito que  no " +
			"te puedes acabar tu solo, ven acompa\u00f1ado",false,69));
		mb.agregar(new Burrito("Burrito especial","En realidad no es m" +
			"uy especial",false,35));
		mb.agregar(new AdaptadorMenuItem(new Mercancia("Fanatico de lo" +
			"s burritos","Gorra","Rojo","Tela",50)));
		mb.agregar(new AdaptadorMenuItem(new Mercancia("Fanatico de lo" +
			"s burritos","Gorra","Rosa","Tela",50)));
		mb.agregar(new AdaptadorMenuItem(new Mercancia("Playera de com" +
			"ensal distinguido","Playera","Cafe","Tela",120)));
	
		todos.agregar(mh);
		todos.agregar(mp);
		todos.agregar(mb);
	}
	
	/**
	 * Crea un robot con los tres menus
	 */
	public static Robot robot = new Robot(todos);
	
}
