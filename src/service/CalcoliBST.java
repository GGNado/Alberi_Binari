package service;

import entity.BST;

public class CalcoliBST implements BinaryTreeOperations<BST> {
    @Override
    public int sommaNodi(BST nodo) {
        return 0;
    }

    @Override
    public int contaNodi(BST nodo) {
        return 0;
    }

    @Override
    public int contaFoglie(BST nodo) {
        return 0;
    }

    @Override
    public int esisteCammino(BST nodo, int k) {
        return 0;
    }

    @Override
    public int bil(BST nodo) {
        if (nodo == null){
            return 0;
        }

        if (altezza(nodo.getSinistro()) - altezza(nodo.getDestra()) > 1 || altezza(nodo.getDestra()) - altezza(nodo.getSinistro()) > 1){
            return -1;
        }

        return 1;
    }

    @Override
    public BST populate(BST nodo, int valore) {
        if (nodo == null){
            BST nodoNuovo = new BST();
            nodoNuovo.setValore(valore);
            return nodoNuovo;
        }

        if (valore > nodo.getValore()){
            nodo.setDestra(populate(nodo.getDestra(), valore));
        } else {
            nodo.setSinistro(populate(nodo.getSinistro(), valore));
        }
        return autoBil(nodo, valore);
    }

    public int altezza(BST nodo) {
        if (nodo == null) return 0;

        return Math.max(altezza(nodo.getSinistro()), altezza(nodo.getDestra())) + 1;
    }

    public BST autoBil(BST nodo, int valore){
        if (nodo == null){
            return null;
        }

        if (bil(nodo) != -1){
            return nodo;
        }

        // Trovato il parent, nodo sbilanciato, ora devo capire se è sbilanciato a destra o a sinistra
        int altezzaDX = altezza(nodo.getDestra());
        int altezzaSX = altezza(nodo.getSinistro());

        if (altezzaSX > altezzaDX){
            // Sbilanciato a sinistra,
            //devo capaire se fare LL o LR
            if (valore < nodo.getSinistro().getValore()){
                // LL
                return rotationRight(nodo);
            } else {
                // LR
                nodo.setSinistro(rotationLeft(nodo.getSinistro()));
                return rotationRight(nodo);
            }

        } else {
            // Sbilanciato a destra, quindi rotazione a sinistra
            if (valore > nodo.getDestra().getValore()){
                // RR
                return rotationLeft(nodo);
            } else {
                nodo.setDestra(rotationRight(nodo.getDestra()));
            }
            return rotationLeft(nodo);
        }
    }

    private BST rotationLeft(BST nodoSbilanciato){
        BST child = nodoSbilanciato.getDestra();
        nodoSbilanciato.setDestra(child.getSinistro());
        child.setSinistro(nodoSbilanciato);
        return nodoSbilanciato;
    }

    private BST rotationRight(BST nodoSbilanciato){
        BST child = nodoSbilanciato.getSinistro();
        nodoSbilanciato.setSinistro(child.getDestra());
        child.setDestra(nodoSbilanciato);
        return child;
    }
}
