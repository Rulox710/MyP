package utilidad.ed;

/**
 * <p>
 * Clase para árboles AVL.
 * </p>
 *
 * <p>
 * Un árbol AVL cumple que para cada uno de sus nodos, la diferencia entre la
 * áltura de sus subárboles izquierdo y derecho está entre -1 y 1.
 * </p>
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {

    /**
     * Clase interna protegida para nodos de árboles AVL. La única diferencia con
     * los nodos de árbol binario, es que tienen una variable de clase para la
     * altura del nodo.
     */
    protected class NodoAVL<T> extends Nodo<T> {

        /** La altura del nodo. */
        public int altura;

        /**
         * Constructor único que recibe un elemento.
         * 
         * @param elemento el elemento del nodo.
         */
        public NodoAVL(T elemento) {
            super(elemento);
        }

        /**
         * Regresa la altura del nodo.
         * 
         * @return la altura del nodo.
         */
        @Override
        public int altura() {
            return super.altura();
        }

        /**
         * Regresa una representación en cadena del nodo AVL.
         * 
         * @return una representación en cadena del nodo AVL.
         */
        @Override
        public String toString() {
            String s = "( " + this.elemento.toString() + " )";
            return s;
        }

        /**
         * Compara el nodo con otro objeto. La comparación es <em>recursiva</em>.
         * 
         * @param o el objeto con el cual se comparará el nodo.
         * @return <code>true</code> si el objeto es instancia de la clase
         *         {@link NodoAVL}, su elemento es igual al elemento de éste nodo, los
         *         descendientes de ambos son recursivamente iguales, y las alturas son
         *         iguales; <code>false</code> en otro caso.
         */
        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    }

    /**
     * Constructor sin parámetros. Para no perder el constructor sin parámetros de
     * {@link ArbolBinarioBusqueda}.
     */
    public ArbolAVL() {
        super();
    }

    /**
     * Construye un árbol rojinegro a partir de una colección. El árbol rojinegro
     * tiene los mismos elementos que la colección recibida.
     * 
     * @param coleccion la colección a partir de la cual creamos el árbol rojinegro.
     */
    public ArbolAVL(Coleccionable<T> coleccion) {
        for (T elemento : coleccion) {
            agrega(elemento);
        }
    }

    /**
     * Construye un nuevo nodo, usando una instancia de {@link NodoAVL}.
     * 
     * @param elemento el elemento dentro del nodo.
     * @return un nuevo nodo con el elemento recibido dentro del mismo.
     */
    @Override
    protected NodoAVL<T> nuevoNodo(T elemento) {
        return new NodoAVL<T>(elemento);
    }

    /**
     * Agrega un nuevo elemento al árbol. El método invoca al método
     * {@link ArbolBinarioBusqueda#agrega(Comparable)}, y después balancea el árbol girándolo
     * como sea necesario.
     * 
     * @param elemento el elemento a agregar.
     */
    @Override
    public void agrega(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento no puede ser null");
        }
        NodoAVL<T> nuevoNodo = nuevoNodo(elemento);
        if (esVacio()) {
            raiz = nuevoNodo;
        } else {
            agregaNodo(raiz, nuevoNodo);
            rebalanceo(nuevoNodo);
        }
        tamanio++;
    }

    /**
     * Método privado que rebalance el árbol.
     */
    private void rebalanceo(NodoAVL<T> nodo) {
        if (nodo != null) {
            NodoAVL<T> izquierdo = (NodoAVL<T>) nodo.izquierdo;
            NodoAVL<T> derecho = (NodoAVL<T>) nodo.derecho;
            int balance = alturaNodo(izquierdo) - alturaNodo(derecho);
            // Este se va a ejecutar cuando hay desbalance en el hijo izquierdo
            if (balance == 2) {
                int balanceIzquierdo = alturaNodo(izquierdo.izquierdo) - alturaNodo(izquierdo.derecho);
                if (balanceIzquierdo == -1){
                    super.giraIzquierda(izquierdo);
                }
                super.giraDerecha(nodo);
            } 
            // Cuando hay desbalance en el hijo derecho
            else if (balance == -2) {
                int balanceDerecho = alturaNodo(derecho.izquierdo) - alturaNodo(derecho.derecho);
                if (balanceDerecho == 1) {
                    super.giraDerecha(derecho);
                }
                super.giraIzquierda(nodo);
            }
            rebalanceo((NodoAVL<T>) nodo.padre);
        }
    }

    private int alturaNodo(Nodo<T> nodo) {
        if (nodo == null)
            return -1;
        return nodo.altura();
    }

    /**
     * Elimina un elemento del árbol. El método elimina el nodo que contiene el
     * elemento, y gira el árbol como sea necesario para rebalancearlo.
     * 
     * @param elemento el elemento a eliminar del árbol.
     */
    @Override
    public void elimina(T elemento) {
        NodoAVL<T> nodo = (NodoAVL<T>) buscaNodo(raiz, elemento);
        if (nodo != null) {
            if (nodo == raiz && tamanio == 1) {
                limpia();
            } else {
                eliminaNodo(nodo);
                tamanio--;
                rebalanceo((NodoAVL<T>) nodo.padre);
            }
        }

    }

    /**
     * Lanza la excepción {@link UnsupportedOperationException}: los árboles AVL no
     * pueden ser girados a la derecha por los usuarios de la clase, porque se
     * desbalancean.
     * 
     * @param nodo el nodo sobre el que se quiere girar.
     * @throws UnsupportedOperationException siempre.
     */
    @Override
    public void giraDerecha(Nodo<T> nodo) {
        throw new UnsupportedOperationException(
                "Los árboles AVL no  pueden " + "girar a la izquierda por el " + "usuario.");
    }

    /**
     * Lanza la excepción {@link UnsupportedOperationException}: los árboles AVL no
     * pueden ser girados a la izquierda por los usuarios de la clase, porque se
     * desbalancean.
     * 
     * @param nodo el nodo sobre el que se quiere girar.
     * @throws UnsupportedOperationException siempre.
     */
    @Override
    public void giraIzquierda(Nodo<T> nodo) {
        throw new UnsupportedOperationException(
                "Los árboles AVL no  pueden " + "girar a la derecha por el " + "usuario.");
    }

}
