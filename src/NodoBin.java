import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class NodoBin {
    private int valore;
    private NodoBin sinistro;
    private NodoBin destra;

    public NodoBin(int valore) {
        this.valore = valore;
        this.sinistro = null;
        this.destra = null;
    }

    public void populate(NodoBin nodo, Scanner scanner){
        if (nodo == null){
            System.out.println("caso base");
            return;
        }

        System.out.println("Inserisci il valore del nodo: ");
        int valore = Integer.parseInt(scanner.nextLine());
        nodo.setValore(valore);

        System.out.println("Vuoi inserire alla Sinistra di " + nodo.getValore() + "? (s/n)");
        String risposta = scanner.nextLine();
        if (risposta.equals("s")){
            nodo.setSinistro(new NodoBin(0));
            populate(nodo.getSinistro(), scanner);
        }

        System.out.println("Vuoi inserire alla Destra di " + nodo.getValore() + "? (s/n)");
        risposta = scanner.nextLine();
        if (risposta.equals("s")){
            nodo.setDestra(new NodoBin(0));
            populate(nodo.getDestra(), scanner);
        }

        System.out.println("Finito di inserire sia sinistra che destra di " + nodo.getValore());

    }

    public void printVerticale(NodoBin nodo, String prefisso){
        if (nodo == null){
            return;
        }

        if (nodo.getDestra() == null){
            System.out.println("\t---" + nodo.getValore());
        } else {
            printVerticale(nodo.getDestra(), prefisso + "\t");
            System.out.println(prefisso + "|");
            System.out.println(prefisso + nodo.getValore());
            System.out.println(prefisso + "|");
        }

        if (nodo.getSinistro() != null){
            printVerticale(nodo.getSinistro(), prefisso + "\t");
        }


    }
}


