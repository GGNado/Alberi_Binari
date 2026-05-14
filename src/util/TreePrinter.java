package util;

import entity.NT;
import entity.Nodo;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrinter {

    public static void printVerticale(Nodo<?> nodo, String prefisso) {
        if (nodo == null) return;

        printVerticale(nodo.getDestra(), prefisso + "    ");
        System.out.println(prefisso + "|-- " + nodo.getValore());
        printVerticale(nodo.getSinistro(), prefisso + "    ");
    }

    public static void printVerticale(NT nodo, String prefisso) {
        if (nodo == null) return;

        System.out.println(prefisso + "|-- " + nodo.getValore());
        if (nodo.getFigli() != null) {
            for (NT figlio : nodo.getFigli()){
                printVerticale(figlio, prefisso + "    ");
            }
        }
    }

    public static void printBFS(Nodo<?> nodo){
        if (nodo == null)
            return;

        Queue<Nodo<?>> queue = new LinkedList<>();
        queue.add(nodo);

        while (!queue.isEmpty()) {
            Nodo<?> current = queue.poll();
            System.out.println(current.getValore());
            if (current.getSinistro() != null)
                queue.add(current.getSinistro());
            if (current.getDestra() != null)
                queue.add(current.getDestra());
        }
    }
}
