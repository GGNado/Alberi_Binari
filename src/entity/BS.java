package entity;

import java.util.Scanner;

public class BS extends Nodo<BS> {

    public BS(int valore) {
        super(valore);
    }

    public void populate(BS nodo, Scanner scanner){
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
            nodo.setSinistro(new BS(0));
            populate(nodo.getSinistro(), scanner);
        }

        System.out.println("Vuoi inserire alla Destra di " + nodo.getValore() + "? (s/n)");
        risposta = scanner.nextLine();
        if (risposta.equals("s")){
            nodo.setDestra(new BS(0));
            populate(nodo.getDestra(), scanner);
        }

        System.out.println("Finito di inserire sia sinistra che destra di " + nodo.getValore());

    }
}


