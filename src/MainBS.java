import entity.BS;

public class MainBS {

    public static void main(String[] args) {
        CalcoliBS calcoli = new CalcoliBS();
        BS root = inizializzaAlberoBase();
        printVerticale(root, "");
        System.out.println(calcoli.sommaNodi(root));
        System.out.println(calcoli.contaNodi(root));
        System.out.println(calcoli.contaFoglie(root));
        System.out.println(calcoli.esisteCammino(root, 1));
        System.out.println(calcoli.bil(root));
    }

    private static BS inizializzaAlberoBase() {
        BS n6 = new BS(6);
        BS n73 = new BS(73);
        BS n2 = new BS(2);
        BS n8 = new BS(8);
        BS n5 = new BS(5);
        BS n15 = new BS(15);
        BS n7 = new BS(7);
        BS n2_ = new BS(2);
        BS n5_ = new BS(5);
        BS n6__ = new BS(6);
        BS n6___ = new BS(6);

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

    public static void printVerticale(BS nodo, String prefisso) {
        if (nodo == null) return;

        printVerticale(nodo.getDestra(), prefisso + "    ");
        System.out.println(prefisso + "|-- " + nodo.getValore());
        printVerticale(nodo.getSinistro(), prefisso + "    ");
    }
}