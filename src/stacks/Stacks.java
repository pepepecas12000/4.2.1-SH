package stacks;

import exceptions.EmptyException;
import exceptions.FullException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stacks<T> implements IStacks<T>, Iterable<T> {

    private  T[] _stack;
    private int _top,_size;
    private static final int SIZE= 10;

    public Stacks() {
        this(SIZE);
    }

    public Stacks(int size) {
    _stack= (T[]) new Object[size<=0?SIZE:size];
    _size=  _stack.length;
    _top=   -1;
    }

    @Override
    public boolean isEmpty() throws EmptyException {
        if (_top == -1){
            throw new EmptyException("La pila esta vacia");
        }

        return false;
    }

    @Override
    public boolean isFull() throws FullException {
        if(_top==_size-1){
            throw new FullException("La pila esta llena");}
        return false;
    }



    @Override
    public boolean push(T element) throws FullException {
    try {
        isFull();
        _stack[++_top] = element;
        return true;
    }catch (FullException e){
        System.out.println(e.getMessage());

    }return false;
    }



    @Override
    public T pop() throws EmptyException {
        try {
            isEmpty();
            return _stack[_top--];

        }catch (EmptyException e){
            System.out.println(e.getMessage());

        }return null;
    }



    @Override
    public T peek() throws EmptyException {
        try {
            isEmpty();
            return _stack[_top];

        }catch (EmptyException e){
            System.out.println(e.getMessage());

        }return null;
    }



    @Override
    public int search(T element) throws EmptyException {
        int count = 0;
        try {
            isEmpty();
            for(T value:this){
                if(value.equals(element)){
                    return count;
                }
                count++;
            };
        }catch (EmptyException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public void invertir(Stacks p){
        int fin=0,inicio=_top,contador=0;


            while (inicio>fin){
                T kik=_stack[inicio];
                _stack[inicio]=_stack[fin];
                _stack[fin]=kik;
                contador++;
                inicio-=contador;
                fin+=contador;

            }



    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cima=get_top();
            @Override
            public boolean hasNext() {
                return cima>=0;
            }

            @Override
            public T next() {
                return _stack[cima--];
            }
        };
    }



    public int get_size() {
        return _size;
    }

    public int get_top() {
        return _top;
    }
}
