import exceptions.FullException;
import queue.QueArray;
import stacks.Stacks;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FullException {

        QueArray<QueArray<String>> Grupos=new QueArray<>(4);
        QueArray<String> Nombres=new QueArray<>(20);
        Nombres.queue("Juan Pérez García");
        Nombres.queue("María Gómez Sánchez");
        Nombres.queue("Carlos Díaz Fernández");
        Nombres.queue("Luisa Herrera López");
        Nombres.queue("Ana Ramírez Torres");
        Nombres.queue("Pedro Fernández Cruz");
        Nombres.queue("José Ortega Morales");
        Nombres.queue("Laura Escobar Martínez");
        Nombres.queue("Martín López Castillo");
        Nombres.queue("Rosa Martínez Vargas");
        Nombres.queue("Diego Álvarez Gutiérrez");
        Nombres.queue("Fernanda Gutiérrez Navarro");
        Nombres.queue("Tomás Quintana Ríos");
        Nombres.queue("Sofía Benítez Rodríguez");
        Nombres.queue("David Castro Peña");
        Nombres.queue("Elena Morales Herrera");
        Nombres.queue("Manuel Jiménez Paredes");
        Nombres.queue("Paula Suárez Villalobos");
        Nombres.queue("Alberto Vargas Nieto");
        Nombres.queue("Beatriz Zamora Ávila");


        Grupos=Grupos.dividir(Nombres);
    Grupos.imp(Grupos);


/*
float start,end;
Stacks<Integer> numeros = new Stacks<>(4);
        numeros.push(0);
        numeros.push(1);
        numeros.push(2);
        numeros.push(3);
        for (Integer num:numeros){
            System.out.println(num);

        }
        System.out.println("\n");
        start=System.nanoTime();
        numeros.invert(numeros);
        end=System.nanoTime();
        for (Integer num:numeros){
            System.out.println(num);

        }
        System.out.println("Tiempo de ejecucion "+(end-start));
*/



}}