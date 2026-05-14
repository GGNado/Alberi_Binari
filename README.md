<div align="center">
  <h1>🌲 Alberi Algoritmici 🌲</h1>
  <p><i>Un'esplorazione teorica e pratica sulle strutture dati ad albero</i></p>
  
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/OOP-SOLID_Principles-4CAF50?style=for-the-badge" alt="OOP">
  <img src="https://img.shields.io/badge/Data_Structures-Trees-007EC6?style=for-the-badge" alt="Data Structures">
</div>

<br>

> Un progetto focalizzato sulla pulizia del codice (*Clean Code*) e sull'implementazione formale e teorica degli algoritmi di visita degli alberi Binari (BST, AVL) e N-ari.

---

## 📑 Indice
1. [🏛️ Architettura N-Tier](#-architettura-n-tier)
2. [🧭 Teoria degli Attraversamenti](#-teoria-degli-attraversamenti)
   - [Ricerca in Profondità (DFS)](#-depth-first-search-dfs)
   - [Ricerca in Ampiezza (BFS)](#-breadth-first-search-bfs)
3. [🗺️ Mappa Strutturale (UML)](#-mappa-strutturale-uml)

---

## 🏛️ Architettura N-Tier

L'intero progetto è stato re-ingegnerizzato seguendo il **Separation of Concerns**. Ogni strato ha una responsabilità univoca e invalicabile.

| Layer | Package | Scopo Principale | Pattern Utilizzati |
|:---:|:---|:---|:---|
| 📦 | `entity` | Rappresentazione in memoria del dato (`Nodo`, `BS`, `NT`). **Nessuna logica di I/O o business**. | *POJO, Generics* |
| ⚙️ | `service` | Motore di calcolo. Implementa le interfacce e applica gli algoritmi sui nodi. | *Strategy, ISP* |
| 🛠️ | `util` | Funzioni di supporto trasversali (es. stampa visuale via `TreePrinter`). | *Utility Class* |
| 🚀 | `app` | Entry points (i `Main`). Collega i service alle entità. | *Dependency Injection (manuale)* |

---

## 🧭 Teoria degli Attraversamenti

Le funzioni matematiche e di calcolo in questo progetto non sono semplici iterazioni: sfruttano paradigmi algoritmici formali per navigare la RAM.

### 🔴 Depth-First Search (DFS)
La **DFS** esplora l'albero calandosi nel ramo più profondo possibile prima di effettuare *backtracking*. Si affida allo **Stack** di Java tramite ricorsione.

#### 1. Pre-Order *(Radice → Sinistra → Destra)*
Il nodo viene elaborato **prima** di scendere nei suoi rami. Usato quando un'operazione ha senso solo se il padre soddisfa un requisito, o per accumulare conteggi dall'alto verso il basso.

<details open>
<summary><b>👀 Visualizza Esempio Pratico: <code>contaNodi()</code></b></summary>

```java
@Override
public int contaNodi(BS nodo) {
    if (nodo == null) return 0;
    
    // 1. VISITA (conto me stesso)
    int self = 1; 
    
    // 2 & 3. ESPLORA (scendo a sx e dx)
    return self + contaNodi(nodo.getSinistro()) + contaNodi(nodo.getDestra());
}
```
</details>

#### 2. Post-Order *(Sinistra → Destra → Radice)*
L'approccio *Bottom-Up*. Un nodo viene valutato **solo dopo** che l'intero sotto-albero è stato esplorato. Essenziale per altezze e bilanciamenti (AVL): è letteralmente impossibile sapere se sei sbilanciato se prima non misuri i tuoi figli.

<details open>
<summary><b>👀 Visualizza Esempio Pratico: <code>altezza()</code></b></summary>

```java
public int altezza(BST nodo) {
    if (nodo == null) return 0;
    
    // 1 & 2. ESPLORA (vado in profondità fino alle foglie)
    int altezzaSX = altezza(nodo.getSinistro());
    int altezzaDX = altezza(nodo.getDestra());
    
    // 3. VISITA (ora che ho i dati, stabilisco la mia altezza)
    return Math.max(altezzaSX, altezzaDX) + 1;
}
```
</details>

#### 3. Reverse In-Order *(Destra → Radice → Sinistra)*
Un brillante stratagemma geometrico. Visitando prima la parte destra e indentando progressivamente, possiamo stampare a terminale l'albero "sdraiato" di 90 gradi mantenendo coerente la struttura visiva. Lo usi all'interno del metodo `TreePrinter.printVerticale()`.

---

### 🔵 Breadth-First Search (BFS)
A differenza della DFS, la **BFS** si espande "a macchia d'olio" livello per livello, orizzontalmente. Non può usare la ricorsione: si affida a una **Coda (Queue - FIFO)**.

<details open>
<summary><b>👀 Visualizza Esempio Pratico: <code>printBFS()</code></b></summary>

```java
public static void printBFS(Nodo<?> nodo) {
    if (nodo == null) return;
    
    Queue<Nodo<?>> queue = new LinkedList<>();
    queue.add(nodo); // Inserisco la Radice iniziale

    while (!queue.isEmpty()) {
        // FIFO: Estrae il nodo più vecchio, garantendo la lettura per livelli
        Nodo<?> current = queue.poll(); 
        System.out.println(current.getValore());
        
        // Accoda i figli per i cicli futuri (il livello successivo)
        if (current.getSinistro() != null) queue.add(current.getSinistro());
        if (current.getDestra() != null) queue.add(current.getDestra());
    }
}
```
</details>

---

## 🗺️ Mappa Strutturale (UML)

L'architettura vista dall'alto, con le interfacce Strategy al centro e un design disaccoppiato.

```mermaid
classDiagram
    direction TB
    
    %% Stili personalizzati
    classDef interface fill:#e1f5fe,stroke:#0288d1,stroke-width:2px,color:#01579b
    classDef entity fill:#fff3e0,stroke:#f57c00,stroke-width:2px,color:#e65100
    classDef service fill:#e8f5e9,stroke:#388e3c,stroke-width:2px,color:#1b5e20
    classDef util fill:#f3e5f5,stroke:#7b1fa2,stroke-width:2px,color:#4a148c

    class TreeOperations~T~ {
        <<interface>>
        +sommaNodi(T)
        +contaNodi(T)
        +esisteCammino(T, k)
        +bil(T)
    }
    
    class BinaryTreeOperations~T~ {
        <<interface>>
        +populate(T, int) T
    }

    TreeOperations <|-- BinaryTreeOperations : extends
    
    class Nodo~T~ {
        <<abstract>>
        #int valore
        #T sinistro
        #T destra
    }
    
    class NT {
        -int valore
        -List~NT~ figli
    }

    class CalcoliBS
    class CalcoliBST
    class CalcoliNT
    
    BinaryTreeOperations <|.. CalcoliBS
    BinaryTreeOperations <|.. CalcoliBST
    TreeOperations <|.. CalcoliNT

    CalcoliBS --> Nodo : esegue DFS su
    CalcoliNT --> NT : elabora
    
    class TreePrinter {
        <<Utility>>
        +printVerticale(Nodo)$
        +printBFS(Nodo)$
    }
    
    TreePrinter ..> Nodo : usa Queue/Stack

    %% Applica gli stili
    class TreeOperations~T~, BinaryTreeOperations~T~ interface
    class Nodo~T~, NT entity
    class CalcoliBS, CalcoliBST, CalcoliNT service
    class TreePrinter util
```

<br>
<div align="center">
  <p><i>Code architecture matters as much as the algorithms it runs.</i></p>
</div>
