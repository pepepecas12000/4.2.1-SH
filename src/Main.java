import exceptions.FullException;
import queue.QueArray;
import stacks.Stacks;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FullException {
        float start,end;
        Stacks<Integer> name = new Stacks<>(4);
        name.push(0);
        name.push(1);
        name.push(2);
        name.push(3);
        for (Integer names:name){
            System.out.println(names);

        }
        System.out.println("\n");
        start=System.nanoTime();
        name.invert(name);
        end=System.nanoTime();
        for (Integer names:name){
            System.out.println(names);
            System.out.println("lol");
        }
        System.out.println("Tiempo de ejecucion "+(end-start));
/*
        QueArray<QueArray<String>> Grupos=new QueArray<>(4);
        QueArray<String> Nombres=new QueArray<>(20);
        Nombres.queue("Jesus Jimenez");
        Nombres.queue("Jesus Aguillar");

Grupos=Grupos.dividir(Nombres);
    Grupos.imp(Grupos);*/

}}