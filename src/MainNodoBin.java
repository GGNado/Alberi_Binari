import entity.NodoBin;

public class MainNodoBin {

    public static void main(String[] args) {
        CalcoliNodi calcoli = new CalcoliNodi();
        NodoBin root = inizializzaAlberoBase();
        printVerticale(root, "");
        System.out.println(calcoli.sommaNodi(root));
        System.out.println(calcoli.contaNodi(root));
        System.out.println(calcoli.contaFoglie(root));
        System.out.println(calcoli.esisteCammino(root, 1));
        System.out.println(calcoli.bil(root));
    }

    private static NodoBin inizializzaAlberoBase() {
        NodoBin n6 = new NodoBin(6);
        NodoBin n73 = new NodoBin(73);
        NodoBin n2 = new NodoBin(2);
        NodoBin n8 = new NodoBin(8);
        NodoBin n5 = new NodoBin(5);
        NodoBin n15 = new NodoBin(15);
        NodoBin n7 = new NodoBin(7);
        NodoBin n2_ = new NodoBin(2);
        NodoBin n5_ = new NodoBin(5);
        NodoBin n6__ = new NodoBin(6);
        NodoBin n6___ = new NodoBin(6);

        n6.setSinistro(n73);
        n6.setDestra(n15);

        n73.setSinistro(n2);
        n73.setDestra(n8);

        n8.setSinistro(n5);
        n8.setDestra(n7);

        n15.setSinistro(n2_);
        n15.setDestra(n5_);

        n5_.setSinistro(n6__);
        n5_.setDestra(n6___);

        return n6;
    }

    public static void printVerticale(NodoBin nodo, String prefisso) {
        if (nodo == null) return;

        printVerticale(nodo.getDestra(), prefisso + "    ");
        System.out.println(prefisso + "|-- " + nodo.getValore());
        printVerticale(nodo.getSinistro(), prefisso + "    ");
    }
}