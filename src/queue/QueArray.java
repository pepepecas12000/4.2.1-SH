package queue;

import exceptions.EmptyException;
import exceptions.FullException;

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
}
