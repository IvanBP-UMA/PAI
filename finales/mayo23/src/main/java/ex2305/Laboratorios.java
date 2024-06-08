package ex2305;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Laboratorios {
    private int maxLabs;
    private List<Solicitud> solicitudes;
    private SortedSet<Solicitud> erroresDeAsignacion;
    private SortedMap<Integer, SortedMap<Integer, List<Solicitud>>> asignaciones;

    public Laboratorios(int max){
        if (max < 1){
            throw new LabException("Argumentos erróneos");
        }
        maxLabs = max;
        solicitudes = new ArrayList<>();
        erroresDeAsignacion = new TreeSet<>();
        asignaciones = new TreeMap<>();
    }

    protected SortedSet<Solicitud> getErroresDeAsignacion(){
        return erroresDeAsignacion;
    }

    protected void addSolicitud(Solicitud solicitud){
        int index = findSolicitud(solicitud);
        if (index<0){
            solicitudes.add(solicitud);
        }
    }

    public void addSolicitud(String data){
        Solicitud solicitud = getSolicitudFromString(data);
        addSolicitud(solicitud);
    }

    public SortedSet<Solicitud> getSolicitudesOrdenadas(){
        SortedSet<Solicitud> resSet = new TreeSet<>(Comparator.comparing(Solicitud::getAsignatura));
        resSet.addAll(solicitudes);
        return resSet;
    }

    public void asignarLabs(){
        erroresDeAsignacion.clear();
        asignaciones.clear();

        for (Solicitud s: solicitudes){
            asignarLabASolicitud(s);
        }
    }

    @Override
    public String toString() {
        StringJoiner totalRes = new StringJoiner(",\n", "(", ")");
        totalRes.add("Solitudes: " + solicitudes).add("ErroresDeAsignacion: " + erroresDeAsignacion).add("Asignaciones: " + asignaciones);
        return totalRes.toString();
    }

    public void cargarSolicitudesDeFichero(String fileName) throws IOException {
        try (Scanner scanner = new Scanner(Path.of(fileName))){
            while (scanner.hasNextLine()){
                try {
                    addSolicitud(scanner.nextLine());
                }catch (LabException ignored){

                }
            }
        }
    }

    public void guardarAsignacionesEnFichero(String fileName) throws IOException{
        mostrarAsignaciones(new PrintWriter(fileName));
    }

    public void mostrarAsignaciones(PrintWriter pw){
        for (int i = 1; i<8; i++){
            SortedMap<Integer, List<Solicitud>> dia = asignaciones.get(i);
            if (dia != null){
                for (int j = 1; j<4; j++){
                    List<Solicitud> solicitudes = dia.get(j);
                    if (solicitudes != null){
                        pw.println("DiaSem: " + i + "; Franja: " + j);
                        for (int k = 0; k <solicitudes.size(); k++){
                            pw.println("Lab: " + k + ": " + solicitudes.get(k));
                        }
                        pw.println("\n");
                    }
                }
            }
        }

        pw.println("ErroresDeAsignacion:");
        for (Solicitud s: erroresDeAsignacion){
            pw.println(s);
        }
        pw.close();
    }

    protected void asignarLabASolicitud(Solicitud solicitud){
        solicitud.setLab(-1);
        SortedMap<Integer, List<Solicitud>> dia = asignaciones.get(solicitud.getDiaSem());
        if (dia == null){
            dia = new TreeMap<>();
        }

        List<Solicitud> solicitudesFranja = dia.get(solicitud.getFranja());
        if (solicitudesFranja == null){
            solicitudesFranja = new ArrayList<>();
        }

        if (solicitudesFranja.size() < maxLabs){
            solicitud.setLab(solicitudesFranja.size());
            solicitudesFranja.add(solicitud);
        }else{
            erroresDeAsignacion.add(solicitud);
        }

        dia.put(solicitud.getFranja(), solicitudesFranja);
        asignaciones.put(solicitud.getDiaSem(), dia);
    }

    private Solicitud getSolicitudFromString(String data){
        String[] params = data.split("\\s*[;]\\s*");
        Solicitud res;
        try{
            res = new Solicitud(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        }catch (IndexOutOfBoundsException | NumberFormatException | LabException exception){
            throw new LabException("Argumentos erróneos");
        }
        return res;
    }

    private int findSolicitud(Solicitud solicitud){
        int i = 0;
        boolean found = false;

        while (!found && i<solicitudes.size()){
            if (solicitudes.get(i).equals(solicitud)){
                found = true;
            }
            i++;
        }

        return (i >= solicitudes.size())? -1 : i-1;
    }
}
