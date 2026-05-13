package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Nodo<T extends Nodo<T>> {
    protected int valore;
    protected T sinistro;
    protected T destra;

    public Nodo() {
        this.sinistro = null;
        this.destra = null;
    }

    public Nodo(int valore) {
        this.valore = valore;
        this.sinistro = null;
        this.destra = null;
    }
}
