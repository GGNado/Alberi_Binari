package entity;

public interface HelperNodi<T extends Nodo<T>> {
    int sommaNodi(T nodo);
    int contaNodi(T nodo);
    int contaFoglie(T nodo);
    int esisteCammino(T nodo, int k);
    int bil(T nodo);
    Nodo<T> populate(T nodo, int valore);

}
