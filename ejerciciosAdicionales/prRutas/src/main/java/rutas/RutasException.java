package rutas;

public class RutasException extends RuntimeException{
    public RutasException(){
        super();
    }

    public RutasException(String err){
        super(err);
    }
}
