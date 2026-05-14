package service;

public interface TreeOperations<T> {
    int sommaNodi(T nodo);
    int contaNodi(T nodo);
    int contaFoglie(T nodo);
    int esisteCammino(T nodo, int k);
    int bil(T nodo);
}
