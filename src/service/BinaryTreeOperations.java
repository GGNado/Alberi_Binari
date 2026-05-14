package service;

import entity.Nodo;

public interface BinaryTreeOperations<T extends Nodo<T>> extends TreeOperations<T> {
    T populate(T nodo, int valore);
}
