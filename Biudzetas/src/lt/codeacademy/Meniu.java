package lt.codeacademy;

import java.util.Scanner;

public class Meniu {
    private Scanner strsc = new Scanner(System.in);
    private Scanner intsc = new Scanner(System.in);
    private String komanda;
    private int nr;

    public void komandos1(){
        System.out.println("[1] - naujas pajamų įrašas");
        System.out.println("[2] - naujas išlaidų įrašas");
        System.out.println("[3] - pašalinti įrašą");
        System.out.println("[4] - informacija");
        System.out.println("[5] - redaguoti");
        System.out.println("[x] - pabaiga");
    }

    public void komandos2(){
        System.out.println("[1] - visi įrašai");
        System.out.println("[2] - įrašas pagal nr.");
        System.out.println("[3] - balansas");
        System.out.println("[4] - pajamų įrašai");
        System.out.println("[5] - islaidų įrašai");
    }



}
