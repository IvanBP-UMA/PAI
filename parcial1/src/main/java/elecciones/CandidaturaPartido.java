package elecciones;

public class CandidaturaPartido extends Candidatura{
    public CandidaturaPartido(String partido, String circunscripición) {
        super(partido, circunscripición);
    }

    @Override
    public void agregarMiembro(Candidata cand) {
        if (!cand.getPartido().equalsIgnoreCase(getPartido())){
            cand.setPartido("");
        }
        super.agregarMiembro(cand);
    }

    @Override
    public void agregarCabezaLista(Candidata cand) {
        if (!cand.getPartido().equalsIgnoreCase(getPartido())){
            cand.setPartido("");
        }
        super.agregarCabezaLista(cand);
    }
}
