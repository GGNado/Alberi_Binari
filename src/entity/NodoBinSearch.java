package entity;

public class NodoBinSearch extends Nodo<NodoBinSearch> {

    public NodoBinSearch() {
        super();
    }

    public NodoBinSearch populate(NodoBinSearch nodo, int valore){
        if (nodo == null){
            NodoBinSearch nodoNuovo = new NodoBinSearch();
            nodoNuovo.setValore(valore);
            return nodoNuovo;
        }

        if (valore > nodo.getValore()){
            nodo.setDestra(populate(nodo.getDestra(), valore));
        } else {
            nodo.setSinistro(populate(nodo.getSinistro(), valore));
        }

        return nodo;
    }
}
