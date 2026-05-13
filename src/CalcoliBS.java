import entity.HelperNodi;
import entity.Nodo;
import entity.BS;

public class CalcoliBS implements HelperNodi<BS> {

    @Override
    public int sommaNodi(BS nodo) {
        if (nodo == null) {
            return 0;
        }

        int sommaAttuale = nodo.getValore();
        int sommaSX = sommaNodi(nodo.getSinistro());
        int sommaDX = sommaNodi(nodo.getDestra());

        return sommaSX + sommaDX + sommaAttuale;
    }

    @Override
    public int contaNodi(BS nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 +  contaNodi(nodo.getSinistro()) +  contaNodi(nodo.getDestra());
    }

    @Override
    public int contaFoglie(BS nodo) {
        if (nodo == null){
            return 0;
        }

        if (nodo.getSinistro() == null && nodo.getDestra() == null) {
            return 1;
        }

        return contaFoglie(nodo.getSinistro()) + contaFoglie(nodo.getDestra());
    }

    @Override
    public int esisteCammino(BS nodo, int k) {
        if (k == 0) {
            return 0;
        }

        if (nodo == null) {
            return -1;
        }

        if (k < 0){
            return -1;
        }

        System.out.println("Sto analizzando il nodo " + nodo.getValore() + " ed entro con k = " + k);
        k -= nodo.getValore();

        int sx = esisteCammino(nodo.getSinistro(), k);
        int dx = esisteCammino(nodo.getDestra(), k);

        return Math.max(sx, dx);
    }

    @Override
    public int bil(BS nodo) {
        if (nodo == null) return 0;

        if (nodo.getSinistro() == null && nodo.getDestra() == null)
            return nodo.getValore();

        int sx = bil(nodo.getSinistro());
        int dx = bil(nodo.getDestra());

        if (sx == -1 || dx == -1) return -1;
        if (sx != dx) return -1;

        return sx + dx;
    }

    @Override
    public Nodo<BS> populate(BS nodo, int valore) {
        return null;
    }
}
