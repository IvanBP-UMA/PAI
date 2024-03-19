package jarras;

public class Mesa {
    public static enum Posicion {Izquierda, Derecha};
    public Jarra j1;
    public Jarra j2;
    public Mesa(Jarra j1, Jarra j2){
        if (j1.equals(j2)){
            throw new RuntimeException("Son la misma");
        }
        this.j1 = j1;
        this.j2 = j2;
    }

    public Mesa(int capacidad1, int capacidad2){
        j1 = new Jarra(capacidad1);
        j2 = new Jarra(capacidad2);
    }

    public int capacidad(Posicion posicion){
        return (posicion == Posicion.Izquierda)? j1.capacidad() : j2.capacidad();
    }
    public int contenido(Posicion posicion){
        return (posicion == Posicion.Izquierda)? j1.contenido() : j2.contenido();
    }
    public void llena(Posicion posicion){
        if (posicion == Posicion.Izquierda){
            j1.llena();
        }else{
            j2.llena();
        }
    }

    public void vacia(Posicion posicion){
        if (posicion == Posicion.Izquierda){
            j1.vacia();
        }else{
            j2.vacia();
        }
    }

    public void llenaDesde(Posicion posicion){
        if (posicion == Posicion.Izquierda){
            j2.llenaDesde(j1);
        }else{
            j1.llenaDesde(j2);
        }
    }

    public String toString(){
        return "M("+j1.toString()+","+j2.toString()+")";
    }
}
