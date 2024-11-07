package queue;

import exceptions.EmptyException;
import exceptions.FullException;

import java.util.Arrays;
import java.util.Iterator;

public class QueArray<T> implements IQueue<T>, Iterable<T> {
    private T[] _queue;
    private int _front,_back,_couter,_size;
    private final static int SIZE=10;


    public QueArray(){
        this(SIZE);
    }

    public QueArray(int size) {
        _queue = (T[]) new Object[size<=0?SIZE:size];
        _couter=_back=_front=0;
        _front=-1;
        _size= _queue.length;
    }



    @Override
    public T dequeue() throws EmptyException {

        try {
            isEmpty();
            _couter--;
            return _queue[++_front % _size];

        }catch (EmptyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean queue(T elemento) throws FullException {
        try {
            isFull();
            _queue[_back++ % _size] = elemento;
            _couter++;
            return true;

        }catch (FullException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeAll() throws EmptyException {
        _couter=_back=0;
        _front=-1;
        return true;
    }



    @Override
    public boolean isEmpty() throws EmptyException {
    if(_couter==0){
        throw new EmptyException("La cola esta vacia");
    }
    return false;
    }

    @Override
    public boolean isFull() throws FullException {
    if(_couter==_size){
    throw new FullException("La cola esta llena");
    }
    return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=_front;
            int counter=_couter;
            @Override
            public boolean hasNext() {
                return counter-- != 0;
            }

            @Override
            public T next() {
                return _queue[++index % _size];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for(T value: this){
            cadena.append(value).append(" ");
        }
        return "Queue [ "+cadena+" ]";
    }
    private void aumentar() {
       this._queue = Arrays.copyOf(_queue, this._size+1);
        _size = _queue.length;
    }

    public QueArray<QueArray<String>> dividir(QueArray<String> q) throws FullException {
        QueArray<String> A_D = new QueArray<>(4);
        QueArray<String> E_L = new QueArray<>(4);
        QueArray<String> M_P = new QueArray<>(4);
        QueArray<String> Q_Z = new QueArray<>(4);

        Iterator rep = q.iterator();
        while (rep.hasNext()) {
            String palabra = (String) rep.next();
            String apellidos = "";
            boolean continuar = true;

            for (int i = 0; i < palabra.length(); i++) {
                String letra = palabra.substring(i, i + 1);
                if (letra.equals(" ") && continuar) {
                    apellidos = palabra.substring(i + 1, palabra.length());
                    continuar = false;
                }
            }

            switch (apellidos.substring(0, 1).toLowerCase()) {
                case "a", "b", "c", "d":
                    try {
                        A_D.isFull();
                        A_D.queue(palabra);
                    } catch (FullException e) {
                        A_D.aumentar();
                        A_D.queue(palabra);
                    }
                    break;

                case "e", "f", "g", "h", "i", "j", "k", "l":
                    try {
                        E_L.isFull();
                        E_L.queue(palabra);
                    } catch (FullException e) {
                        E_L.aumentar();
                        E_L.queue(palabra);
                    }
                    break;

                case "m", "n", "ñ", "o", "p":
                    try {
                        M_P.isFull();
                        M_P.queue(palabra);
                    } catch (FullException e) {
                        M_P.aumentar();
                        M_P.queue(palabra);
                    }
                    break;

                case "q", "r", "s", "t", "u", "v", "w", "x", "y", "z":
                    try {
                        Q_Z.isFull();
                        Q_Z.queue(palabra);
                    } catch (FullException e) {
                        Q_Z.aumentar();
                        Q_Z.queue(palabra);
                    }
                    break;

                default:
                    System.out.println(palabra + " no válido");
            }
        }

        QueArray<QueArray<String>> grupos = new QueArray<>();
        grupos.queue(A_D);
        grupos.queue(E_L);
        grupos.queue(M_P);
        grupos.queue(Q_Z);
        return grupos;
    }

    public T buscar(int index) {
        return _queue[(_front + 1 + index) % _size];
    }

    public void imp(QueArray<QueArray<String>> Grupos) {
        for (int i = 0; i < Grupos._couter; i++) {
            QueArray<String> grupo = Grupos.buscar(i);
            System.out.println("Grupo " + (i + 1) + ":");

            for (int j = 0; j < grupo._couter; j++) {
                System.out.println(grupo.buscar(j));
            }
            System.out.println();
        }
    }

}
