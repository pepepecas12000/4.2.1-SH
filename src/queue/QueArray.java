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


    public QueArray<QueArray<String>> dividir(QueArray<String> q) throws FullException {
        QueArray<String> A_D=new QueArray<>(4);
        QueArray<String> E_L=new QueArray<>(4);
        QueArray<String> M_P=new QueArray<>(4);
        QueArray<String> Q_Z=new QueArray<>(4);
    Iterator rep=q.iterator();
while (rep.hasNext()){
    String palabra= (String) rep.next();



        String apellidos="";
        boolean continuar=true;
        for (int i = 0; i < palabra.length(); i++) {
            String letra = palabra.substring(i,i+1);
            if (letra.equals(" ") && continuar) {
                apellidos= palabra.substring(i+1,palabra.length());;
                continuar=false;
            }
        }
        switch (apellidos.substring(0,1).toLowerCase()){
            case "a","b","c","d":
                if (A_D.isFull()){
                    A_D._queue=Arrays.copyOf(A_D._queue,A_D._queue.length+1);
                }
                A_D.queue(apellidos);
                break;
                case "e","f","g","h","i","j","k","l":
                    if (E_L.isFull()){
                        E_L._queue=Arrays.copyOf(E_L._queue,E_L._queue.length+1);
                    }
                    E_L.queue(apellidos);
                    break;
                    case "m","n","ñ","o","p":
                        if (M_P.isFull()){
                            M_P._queue=Arrays.copyOf(M_P._queue,M_P._queue.length+1);
                        }
                        M_P.queue(apellidos);
                        break;
                        case "q","r","s","t","u","v","w","x","y","z":
                            if (Q_Z.isFull()){
                                Q_Z._queue=Arrays.copyOf(Q_Z._queue,Q_Z._queue.length+1);
                            }
                            Q_Z.queue(apellidos);
                            break;
                            default:
                                System.out.println(apellidos+" no valido");
        }
    }
    QueArray<QueArray<String>> grupos= new QueArray<>();
        grupos.queue(A_D);
        grupos.queue(E_L);
        grupos.queue(M_P);
        grupos.queue(Q_Z);
    return grupos;
    }

    public int size() {
        return _couter; // Devuelve el número de elementos en la cola
    }

    public T get(int index) {
        if (index < 0 || index >= _couter) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return _queue[(_front + 1 + index) % _size]; // Calcula la posición real en la cola circular
    }

    public void imp(QueArray<QueArray<String>> Grupos) {
        for (int i = 0; i < Grupos._couter; i++) { // Recorre el array de grupos
            QueArray<String> grupo = Grupos.get(i);
            System.out.println("Grupo " + (i + 1) + ":");

            for (int j = 0; j < grupo.size(); j++) { // Recorre cada grupo para imprimir sus elementos
                System.out.println(grupo.get(j));
            }
            System.out.println(); // Espacio entre grupos
        }
    }

}
