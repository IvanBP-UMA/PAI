package elecciones;

public class Candidata {
    public static enum Sexo {F,M}
    private String nombre;
    private Sexo sexo;
    private String DNI;
    private String partido;

    public Candidata(String nombre, String DNI, Sexo sexo, String partido){
        this.nombre = nombre;
        this.DNI = DNI;
        this.sexo = sexo;
        this.partido = partido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Candidata(String nombre, String DNI, Sexo sexo){
        this.nombre = nombre;
        this.DNI = DNI;
        this.sexo = sexo;
        this.partido = "";
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartido() {
        return partido;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public boolean esIndependiente(){
        return (partido.isEmpty());
    }

    @Override
    public String toString(){
        String res = nombre.toUpperCase();
        res += (esIndependiente())? "(independiente)":"";
        return  res;
    }
}
