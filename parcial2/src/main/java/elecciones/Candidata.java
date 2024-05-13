package elecciones;

import java.util.Objects;

/**
 * La clase Candidata mantiene información sobre personas que se puedan presentar
 * como candidatas a unas elecciones, incluyendo su nombre (de tipo String),
 * su documento de identidad (de tipo String) y su afiliación si pertenece a algún grupo
 * o partido político (de tipo String).
 *
 * @author POO
 */
public class Candidata {
    /**
     * Nombre del candidato o candidata.
     */
    private String nombre;

    /**
     * Documento de identidad de la persona candidata.
     */
    private String dni;

    /**
     * Nombre del partido o grupo político. De ser null, indicará que no se encuentra afiliado a ningún partido.
     */
    private String partido;

    private int edad;

    /**
     * Constructor para crear objetos de la clase Candidata. En caso de que la persona candidata
     * no esté afiliada a ningún partido, el tercer argumento será null.
     * @param n	Nombre de la persona candidata
     * @param d	Documento de identidad de la persona candidata
     * @param p	Partido o grupo político de la persona candidata
     * @throws EleccionesException
     */
    public Candidata(String n, String d, int ed, String p) {
        nombre = n;
        dni = d;
        partido = p;
        if (ed<18){
            throw new EleccionesException("La edad del candidato es menor de 18");
        }
        edad = ed;
    }

    /**
     * Método para obtener el nombre de la persona.
     * @return	Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el documento de identidad.
     * @return	Documento de identidad
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método para obtener el partido o grupo político.
     * @return	Partido de la persona candidata
     */
    public String getPartido() {
        return partido;
    }

    public int getEdad() {
        return edad;
    }

    /**
     * Método para cambiar el partido de la persona candidata.
     * En caso de el argumento sea null, se considerará que no tiene afiliación a ningún partido.
     * @param part	Partido o grupo político
     */
    public void setPartido(String part) {
        partido = part;
    }

    /**
     * Método para determinar si la persona candidata es independiente o no.
     * Para ello, se comprobará si la variable que almacena el grupo o partido es null o no.
     * @return	true si la persona candidata es independiente
     */
    public boolean esIndependiente() {
        return partido == null;
    }

    @Override
    public boolean equals(Object obj){
        return (obj instanceof Candidata c) && nombre.equalsIgnoreCase(c.nombre) && dni.equalsIgnoreCase(c.dni);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre.toUpperCase(), dni.toUpperCase());
    }

    /**
     * Representación textual de una persona candidata, seguido del partido entre paréntesis. En caso de no
     * pertenecer a ningún partido, en vez del nombre del partido se incluirá la palabra "independiente":
     * 		NOMBRE DE LA PERSONA (partido)
     * 		NOMBRE DE LA PERSONA (independiente)
     */
    @Override
    public String toString() {
        return nombre.toUpperCase() + " (" + (esIndependiente() ? "independiente" : partido) + ")";
    }

}
