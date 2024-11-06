import exceptions.FullException;
import stacks.Stacks;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FullException {
        float start,end;
       /* Stacks<Integer> name = new Stacks<>(4);
        name.push(0);
        name.push(1);
        name.push(2);
        name.push(3);
        for (Integer names:name){
            System.out.println(names);

        }
        System.out.println("\n");
        start=System.nanoTime();
        name.invertir(name);
        end=System.nanoTime();
        for (Integer names:name){
            System.out.println(names);

        }
        System.out.println("Tiempo de ejecucion "+(end-start));*/
        String palabra="Jesus Jimenez Mendoza";
        String apellidos="";
        boolean continuar=true;
        for (int i = 0; i < palabra.length(); i++) {
            String letra = palabra.substring(i,i+1);
          if (letra.equals(" ") && continuar) {
               apellidos= palabra.substring(i+1,palabra.length());;
              System.out.println(apellidos);
              continuar=false;
              System.out.println(apellidos.substring(0,1));
          }
        }
        switch (apellidos.substring(0,1).toLowerCase()){
            case "a","b","c","d":

        }




    }
}