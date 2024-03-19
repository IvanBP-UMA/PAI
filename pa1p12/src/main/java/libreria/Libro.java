package libreria;

public class Libro {
    static  private  double porcIVA = 10;
    private String autor;
    private String titulo;
    private double precioBase;

    public Libro(String autor, String titulo, double precioBase){
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    protected double getBaseImponible(){
        return  precioBase;
    }

    static public double getIVA(){
        return porcIVA;
    }
    static public void setIVA(double IVA){
        porcIVA = IVA;
    }

    public double getPrecioFinal(){
        return this.precioBase + this.precioBase * getIVA() * 0.01;
    }

    @Override
    public String toString() {
        return "("+this.getAutor()+"; "+this.getTitulo()+"; "+this.getPrecioBase()+"; "+getIVA()+"%; "+ this.getPrecioFinal()+")";
    }

}
