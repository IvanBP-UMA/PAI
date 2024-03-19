package jarras;

public class Jarra {
    final private int capacidad;
    private int contenido;

    public Jarra(int capacidad){
        if (capacidad<=0){
            throw new RuntimeException("Capacidad invalida");
        }
        this.capacidad = capacidad;
        contenido = 0;
    }

    public int capacidad(){
        return this.capacidad;
    }
    public int contenido(){
        return  this.contenido;
    }
    public void llena(){
        this.contenido = capacidad;
    }
    public void vacia(){
        this.contenido = 0;
    }
    public void llenaDesde(Jarra j){
        if (this.equals(j)){
            throw new RuntimeException("Son la misma jarra");
        }
        int capacidadDisponible = capacidad-contenido;
        if (j.contenido >= capacidadDisponible){
            this.contenido = this.capacidad;
            j.contenido -= capacidadDisponible;
        }else {
            this.contenido += j.contenido;
            j.contenido = 0;
        }
    }

    public String toString(){
        return "J("+capacidad+","+contenido+")";
    }
}
