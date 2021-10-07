package lt.codeacademy;

import java.util.Scanner;

public class Meniu {

    public static void komandos1(){
        System.out.println("[1] - naujas pajamų įrašas");
        System.out.println("[2] - naujas išlaidų įrašas");
        System.out.println("[3] - pašalinti įrašą");
        System.out.println("[4] - informacija");
        System.out.println("[5] - redaguoti");
        System.out.println("[6] - išsaugoti duomenis");
        System.out.println("[7] - nuskaityti duomenis");
        System.out.println("[x] - pabaiga");
    }

    public static void komandos2(){
        System.out.println("[1] - visi įrašai");
        System.out.println("[2] - įrašas pagal nr.");
        System.out.println("[3] - balansas");
        System.out.println("[4] - pajamų įrašai");
        System.out.println("[5] - islaidų įrašai");
    }

    public static void InputMismatch(){
        System.out.println("Įvestas neteisingas argumentas, bandykite dar kartą");
    }



}
