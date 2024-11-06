package stacks;

import exceptions.EmptyException;
import exceptions.FullException;

import java.util.EmptyStackException;

public interface IStacks <T>{
     boolean isEmpty() throws EmptyException;
     boolean isFull() throws FullException;


     boolean push(T element) throws FullException;

     T pop() throws EmptyException;
     T peek() throws EmptyException;
     int search(T element) throws EmptyException;



}
