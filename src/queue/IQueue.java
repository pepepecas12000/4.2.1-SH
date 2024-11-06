package queue;

import exceptions.EmptyException;
import exceptions.FullException;

public interface IQueue <T>{
    T dequeue()throws EmptyException; //sacar un elemento de la cola
    boolean queue(T elemento) throws FullException; // Insertar un dato
    boolean removeAll() throws EmptyException; // Vaciar todo
    boolean isEmpty() throws EmptyException;
    boolean isFull() throws FullException;

}
