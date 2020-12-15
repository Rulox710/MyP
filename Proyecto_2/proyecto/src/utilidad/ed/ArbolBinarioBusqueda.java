package utilidad.ed;

import java.util.Iterator;
import java.lang.Comparable;

/**
 * <p>
 * Clase para modelar árboles binarios de búsqueda genéricos.
 * </p>
 *
 * <p>
 * Un árbol instancia de esta clase siempre cumple que:
 * </p>
 * <ul>
 * <li>Cualquier elemento en el árbol es mayor o igual que todos sus
 * descendientes por la izquierda.</li>
 * <li>Cualquier elemento en el árbol es menor o igual que todos sus
 * descendientes por la derecha.</li>
 * </ul>
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {

    /* Clase privada para iteradores de árboles binarios ordenados. */
    private class Iterador implements Iterator<T> {

        /* Pila para recorrer los nodos en DFS in-order. */
        private Pila<Nodo<T>> pila;

        /* Construye un iterador con el nodo recibido. */
        public Iterador() {
            pila = new Pila<Nodo<T>>();
            if(raiz != null){
                pila.push(raiz);
                while (pila.peek().hayIzquierdo()) {
                    pila.push(pila.peek().izquierdo);
                }
            }
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            return pila.peek() != null;
        }

        /* Regresa el siguiente elemento en orden DFS in-order. */
        @Override
        public T next() {
            Nodo<T> nodo = pila.pop();
            if (nodo.hayDerecho()) {
                pila.push(nodo.derecho);
                while (pila.peek().hayIzquierdo()) {
                    pila.push(pila.peek().izquierdo);
                }
            }
            return nodo.elemento;
        }
    }

    /**
     * Constructor que no recibe parámeteros. {@link ArbolBinario}.
     */
    public ArbolBinarioBusqueda() {

    }

    /**
     * Construye un árbol binario ordenado a partir de una colección. El árbol
     * binario ordenado tiene los mismos elementos que la colección recibida.
     * 
     * @param coleccion la colección a partir de la cual creamos el árbol binario
     *                  ordenado.
     */

    public ArbolBinarioBusqueda(Coleccionable<T> coleccion) {
        super(coleccion);
    }

    protected void agregaNodo(Nodo<T> n, Nodo<T> nuevo) {
        if (nuevo.elemento.compareTo(n.elemento) >= 0) {
            if (n.hayDerecho()) {
                agregaNodo(n.derecho, nuevo);
            } else {
                n.derecho = nuevo;
                nuevo.padre = n;
            }
        } else {
            if (n.hayIzquierdo()) {
                agregaNodo(n.izquierdo, nuevo);
            } else {
                n.izquierdo = nuevo;
                nuevo.padre = n;
            }
        }
    }

    /**
     * Agrega un nuevo elemento al árbol. El árbol conserva su orden in-order.
     * 
     * @param elemento el elemento a agregar.
     */
    @Override
    public void agrega(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento no puede ser null");
        }
        Nodo<T> nuevo = new Nodo<T>(elemento);
        if (esVacio()) {
            raiz = nuevo;
        } else {
            agregaNodo(raiz, nuevo);
        }
        tamanio++;
    }

    /**
     * Elimina un nodo del árbol
     * 
     * @param n un Nodo a eliminar
     * @return el Nodo eliminado
     */
    protected Nodo<T> eliminaNodo(Nodo<T> n) {
        if (n == null) {
            throw new IllegalArgumentException("El elemento a eliminar no puede ser null");
        }
        if (n.hayIzquierdo()) {
            Nodo<T> maximoIzquierdo = maximoEnSubarbolIzquierdo(n);
            n.elemento = maximoIzquierdo.elemento;

            // Es para cambiar la referencia del hijo
            if (maximoIzquierdo.esHijoDerecho()) {
                maximoIzquierdo.padre.derecho = maximoIzquierdo.izquierdo;
            } else {
                maximoIzquierdo.padre.izquierdo = maximoIzquierdo.izquierdo;
            }

            // Para cambiar la refencia del padre
            if (maximoIzquierdo.hayIzquierdo()) {
                maximoIzquierdo.izquierdo.padre = maximoIzquierdo.padre;
            }
        } else {
            Nodo<T> derecho = n.derecho;
            if (n.hayPadre()) {
                if (n.esHijoDerecho()) {
                    n.padre.derecho = derecho;
                } else {
                    n.padre.izquierdo = derecho;
                }

                // Porque existe la posibilidad de que no exista ese nodo
                if (n.hayDerecho()) {
                    derecho.padre = n.padre;
                }
            } else {
                // Este caso es cuando no hay padre, es decir, que es la raiz
                raiz = derecho;
                if (n.hayDerecho()) {
                    derecho.padre = null;
                }
            }
        }
        return n;
    }

    /**
     * Elimina un elemento. Si el elemento no está en el árbol, no hace nada; si
     * está varias veces, elimina el primero que encuentre (in-order). El árbol
     * conserva su orden in-order.
     * 
     * @param elemento el elemento a eliminar.
     */
    @Override
    public void elimina(T elemento) {
        Nodo<T> n = buscaNodo(raiz, elemento);
        if (n == null)
            return;
        if (n == raiz && tamanio == 1) {
            limpia();
        } else {
            eliminaNodo(n);
            tamanio--;
        }
    }

    private Nodo<T> maximoEnSubarbolIzquierdo(Nodo<T> n) {
        if (!n.hayIzquierdo())
            return null;
        Nodo<T> maximo = n.izquierdo;
        while (maximo.hayDerecho()) {
            maximo = maximo.derecho;
        }
        return maximo;
    }

    /**
     * Nos dice si un elemento está contenido en el arbol.
     * 
     * @param elemento el elemento que queremos verificar si está contenido en la
     *                 arbol.
     * @return <code>true</code> si el elemento está contenido en el arbol,
     *         <code>false</code> en otro caso.
     */
    @Override
    public boolean contiene(T elemento) {
        return buscaNodo(raiz, elemento) != null;
    }

    protected Nodo<T> buscaNodo(Nodo<T> n, T elemento) {

        if (elemento.compareTo(n.elemento) > 0) {
            if (n.hayDerecho()) {
                return buscaNodo(n.derecho, elemento);
            } else {
                return null;
            }
        } else if(elemento.compareTo(n.elemento) < 0) {
            if (n.hayIzquierdo()) {
                return buscaNodo(n.izquierdo, elemento);
            } else {
                return null;
            }
        } else {
            return n;
        }
    }

    /**
     * Gira el árbol a la derecha sobre el nodo recibido. Si el nodo no tiene hijo
     * izquierdo, el método no hace nada.
     * 
     * @param nodo el nodo sobre el que vamos a girar.
     */
    protected void giraDerecha(Nodo<T> nodo) {
        if (!nodo.hayIzquierdo()) return;
        Nodo<T> izquierdo = nodo.izquierdo;
        if(nodo == raiz){
            raiz = izquierdo;
        }
        nodo.izquierdo = izquierdo.derecho;
        izquierdo.derecho = nodo;

        if (nodo.hayPadre()) {
            if (nodo.esHijoDerecho()) {
                nodo.padre.derecho = izquierdo;
            } else {
                nodo.padre.izquierdo = izquierdo;
            }
        }
        izquierdo.padre = nodo.padre;
        nodo.padre = izquierdo;
    }

    /**
     * Gira el árbol a la izquierda sobre el nodo recibido. Si el nodo no tiene hijo
     * derecho, el método no hace nada.
     * 
     * @param nodo el nodo sobre el que vamos a girar.
     */
    protected void giraIzquierda(Nodo<T> nodo) {
        if (!nodo.hayDerecho()) return;
        Nodo<T> derecho = nodo.derecho;
        if(nodo == raiz){
            raiz = derecho;
        }
        nodo.derecho = derecho.izquierdo;
        derecho.izquierdo = nodo;
        if (nodo.hayPadre()) {
            if (nodo.esHijoDerecho()) {
                nodo.padre.derecho = derecho;
            } else {
                nodo.padre.izquierdo = derecho;
            }
        }
        derecho.padre = nodo.padre;
        nodo.padre = derecho;
    }

    /**
     * Regresa un iterador para iterar el árbol. El árbol se itera en orden.
     * 
     * @return un iterador para iterar el árbol.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterador();
    }

}
