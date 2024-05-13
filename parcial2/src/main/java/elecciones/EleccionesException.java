package elecciones;

public class EleccionesException extends RuntimeException{
    public EleccionesException(){
        super();
    }

    public EleccionesException(String err){
        super(err);
    }
}
