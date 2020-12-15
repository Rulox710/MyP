package utilidad.ed;

/**
 * Esta clase es usada para la conversión de tiempo. Las conversiones
 * aquí pueden no corresponder a la realidad, puesto que sólo se ocupan
 * para simular medir el tiempo en periodos cortos
 */
public class Tiempo {

    /**
     * Lo que corresponde a un minuto
     */
    private static final long MINUTO = 15_000_000L;

    private Tiempo(){}

    /**
     * Regresa las horas en nanosegundos
     * @param horas entero que señala las horas
     * @return long con los nanosegundos que representan las horas
     */
    public static long convertirHoras(int horas){
        return MINUTO * 60 * horas;
    }

    /**
     * Regresa los minutos en nanosegundos
     * @param minutos entero que señala los minutos
     * @return un long que representa los minutos
     */
    public  static long convertirMinutos(int minutos){
        return MINUTO * minutos;
    }


}
