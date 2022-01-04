package br.com.driver;

public class Driver {

    public static void main(String[] args){

        /*Thread t = new Thread(()-> System.out.println("Hi!"));
        t.start();
        System.out.println("Hi!");*/

        Thread t= new Thread(new RunThread());
        t.start();
    }

}
