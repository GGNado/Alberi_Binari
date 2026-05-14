package service;

import entity.NT;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcoliNT implements TreeOperations<NT> {

    @Override
    public int sommaNodi(NT nodo) {
        return 0;
    }

    @Override
    public int contaNodi(NT nodo) {
        return 0;
    }

    @Override
    public int contaFoglie(NT nodo) {
        return 0;
    }

    @Override
    public int esisteCammino(NT nodo, int k) {
        return 0;
    }

    @Override
    public int bil(NT nodo) {
        return 0;
    }

    public NT populate(NT nodo, Scanner scanner) {

        System.out.println("Inserisci il valore del nodo: ");
        int val = Integer.parseInt(scanner.nextLine());


        if (nodo == null){
            nodo = new NT(val, new ArrayList<>());
        } else {
            nodo.getFigli().add(new NT(val, new ArrayList<>()));
        }

        System.out.println("Vuoi inserire dei figli per " + nodo.getValore() + "? (s/n)");
        String risposta = scanner.nextLine();
        while (risposta.equals("s")){
            nodo.getFigli().add(populate(null, scanner));
            System.out.println("Vuoi inserire altri figli per " + nodo.getValore() + "? (s/n)");
            risposta = scanner.nextLine();
        }

        return nodo;
    }
}
