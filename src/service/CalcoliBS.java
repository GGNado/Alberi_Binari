package service;

import entity.BS;
import java.util.Scanner;

public class CalcoliBS implements BinaryTreeOperations<BS> {

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
        return 1 + contaNodi(nodo.getSinistro()) + contaNodi(nodo.getDestra());
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
    public BS populate(BS nodo, int valore) {
        return null;
    }

    public void populateInteractive(BS nodo, Scanner scanner){
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
            populateInteractive(nodo.getSinistro(), scanner);
        }

        System.out.println("Vuoi inserire alla Destra di " + nodo.getValore() + "? (s/n)");
        risposta = scanner.nextLine();
        if (risposta.equals("s")){
            nodo.setDestra(new BS(0));
            populateInteractive(nodo.getDestra(), scanner);
        }

        System.out.println("Finito di inserire sia sinistra che destra di " + nodo.getValore());
    }
}
