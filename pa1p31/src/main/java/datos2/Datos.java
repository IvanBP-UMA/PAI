package datos2;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    private List<Double> datos;
    private List<String> errores;
    private double min;
    private double max;

    public Datos(String[] d, double min, double max){
        datos = new ArrayList<Double>();
        errores = new ArrayList<String>();
        this.min = min;
        this.max = max;

        for (int i = 0; i<d.length; i++) {
            try {
                datos.add(Double.parseDouble(d[i]));
            } catch (NumberFormatException err) {
                errores.add(d[i]);
            }
        }
    }

    public double calcMedia() throws DatosException {
        double current;
        double media = 0;
        int addedValues = 0;
        for(int i = 0; i< datos.size(); i++){
            current = datos.get(i);
            if (current <= max && current >= min) {
                media += current;
                addedValues++;
            }
        }
        if (addedValues == 0){
            throw new DatosException("No hay datos en el rango especificado");
        }
        return media/addedValues;
    }

    public double calcDesvTipica() throws DatosException {
        double desvTipica = 0;
        double media = calcMedia();
        double addedValues = 0;
        double current;

        for (int i = 0; i<datos.size(); i++){
            current = datos.get(i);
            if (current <= max && current >= min){
                desvTipica += Math.pow(current - media, 2);
                addedValues++;
            }
        }
        return Math.sqrt(desvTipica/addedValues);
    }

    public void setRango(String rango) throws DatosException {
        try{
            String valores[] = new String[2];
            int pos = rango.indexOf(';');
            valores[0] = rango.substring(0, pos);
            valores[1] = rango.substring(pos+1);

            min = Double.parseDouble(valores[0]);
            max = Double.parseDouble(valores[1]);
        }catch(Exception e){
            throw new DatosException("Error en los datos al establecer el rango");
        }
    }

    public ArrayList<Double> getDatos(){
        return (ArrayList<Double>) datos;
    }

    public ArrayList<String> getErrores(){
        return (ArrayList<String>) errores;
    }

    @Override
    public String toString() {
        String res = "";
        res += "Min:" + min + ", Max: "+ max+ ",\n";
        res += getDatos() + ",\n";
        res += getErrores() + ",\n";
        try {
            double media = calcMedia();
            double desvTipica = calcDesvTipica();
            res += "Media: " + media + ", DesvTipica: " + desvTipica;
        }catch (DatosException err){
            res += "Media: ERROR, DesvTipica: ERROR";
        }
        return res;
    }
}
