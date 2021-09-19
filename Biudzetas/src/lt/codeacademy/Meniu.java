package lt.codeacademy;

import java.util.Scanner;

public class Meniu {
    private Scanner strsc = new Scanner(System.in);
    private Scanner intsc = new Scanner(System.in);
    private String komanda;
    private int nr;

    public void komandos1(){
        System.out.println("[p] - naujas pajamų įrašas");
        System.out.println("[i] - naujas išlaidų įrašas");
        System.out.println("[b] - balansas");
        System.out.println("[r] - pašalinti įrašą");
        System.out.println("[info] - informacija");
        System.out.println("[x] - pabaiga");
    }

    public void komandos2(){
        System.out.println("[p] - pajamų įrašai");
        System.out.println("[i] - išlaidų įrašai");
    }



}
