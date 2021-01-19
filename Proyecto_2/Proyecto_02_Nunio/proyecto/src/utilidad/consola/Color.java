package utilidad.consola;

/**
 * Enum con colores que pueden ser usados en la consola con ANSI
 * 
 * @see <a href="https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println/45444716#45444716">stack overflow</a>
 */

public enum Color {
    /**
     * Repone el color original de la consola
     */
    RESET("\033[0m"),

    NEGRO("\033[0;30m"),
    ROJO("\033[0;31m"),
    VERDE("\033[0;32m"),
    AMARILLO("\033[0;33m"),
    AZUL("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CIAN("\033[0;36m"),
    BLANCO("\033[0;37m"),

    NEGRO_NEGRITAS("\033[1;30m"),
    ROJO_NEGRITAS("\033[1;31m"),
    VERDE_NEGRITAS("\033[1;32m"),
    AMARILLO_NEGRITAS("\033[1;33m"),
    AZUL_NEGRITAS("\033[1;34m"),
    MAGENTA_NEGRITAS("\033[1;35m"),
    CIAN_NEGRITAS("\033[1;36m"),
    BLANCO_NEGRITAS("\033[1;37m"),

    NEGRO_SUBRAYADO("\033[4;30m"),
    ROJO_SUBRAYADO("\033[4;31m"),
    VERDE_SUBRAYADO("\033[4;32m"),
    AMARILLO_SUBRAYADO("\033[4;33m"),
    AZUL_SUBRAYADO("\033[4;34m"),
    MAGENTA_SUBRAYADO("\033[4;35m"),
    CIAN_SUBRAYADO("\033[4;36m"),
    BLANCO_SUBRAYADO("\033[4;37m"),

    NEGRO_FONDO("\033[40m"),
    ROJO_FONDO("\033[41m"),
    VERDE_FONDO("\033[42m"),
    AMARILLO_FONDO("\033[43m"),
    AZUL_FONDO("\033[44m"),
    MAGENTA_FONDO("\033[45m"),
    CIAN_FONDO("\033[46m"),
    BLANCO_FONDO("\033[47m"),

    NEGRO_BRILLANTE("\033[0;90m"),
    ROJO_BRILLANTE("\033[0;91m"),
    VERDE_BRILLANTE("\033[0;92m"),
    AMARILLO_BRILLANTE("\033[0;93m"),
    AZUL_BRILLANTE("\033[0;94m"),
    MAGENTA_BRILLANTE("\033[0;95m"),
    CIAN_BRILLANTE("\033[0;96m"),
    BLANCO_BRILLANTE("\033[0;97m"),

    NEGRO_NEGRITAS_BRILLANTE("\033[1;90m"),
    ROJO_NEGRITAS_BRILLANTE("\033[1;91m"),
    VERDE_NEGRITAS_BRILLANTE("\033[1;92m"),
    AMARILLO_NEGRITAS_BRILLANTE("\033[1;93m"),
    AZUL_NEGRITAS_BRILLANTE("\033[1;94m"),
    MAGENTA_NEGRITAS_BRILLANTE("\033[1;95m"),
    CIAN_NEGRITAS_BRILLANTE("\033[1;96m"),
    BLANCO_NEGRITAS_BRILLANTE("\033[1;97m"),

    NEGRO_FONDO_BRILLANTE("\033[0;100m"),
    ROJO_FONDO_BRILLANTE("\033[0;101m"),
    VERDE_FONDO_BRILLANTE("\033[0;102m"),
    AMARILLO_FONDO_BRILLANTE("\033[0;103m"),
    AZUL_FONDO_BRILLANTE("\033[0;104m"),
    MAGENTA_FONDO_BRILLANTE("\033[0;105m"),
    CIAN_FONDO_BRILLANTE("\033[0;106m"),
    BLANCO_FONDO_BRILLANTE("\033[0;107m");

    private final String code;

    private Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
