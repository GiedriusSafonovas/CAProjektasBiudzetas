package lt.codeacademy;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Biudzetas b1 = new Biudzetas();
        String komanda;
        double suma;
        boolean bankas;
        String atsiskaitymoBudas;
        String papildomaInfo;
        while(true){
            System.out.println("[p] - naujas pajamų įrašas");
            System.out.println("[i] - naujas išlaidų įrašas");
            System.out.println("[info] - informacija");
            System.out.println("[x] - pabaiga");
            komanda = new Scanner(System.in).next();
            if(komanda.equals("x")){
                break;
            }

            switch (komanda){
                case "p":
                    System.out.println("Įveskite sumą");
                    suma = new Scanner(System.in).nextDouble();
                    System.out.println("Ar pinigai gasuti į banką(true/false)?");
                    bankas = new Scanner(System.in).nextBoolean();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = new Scanner(System.in).nextLine();
                    b1.pridetiPajamuIrasa(suma, bankas, papildomaInfo);
                    break;
                case "i":
                    System.out.println("Įveskite sumą");
                    suma = new Scanner(System.in).nextDouble();
                    System.out.println("Atsiskaitymo būdas");
                    atsiskaitymoBudas = new Scanner(System.in).next();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = new Scanner(System.in).nextLine();
                    b1.pridetiIslaiduIrasa(suma, atsiskaitymoBudas, papildomaInfo);
                    break;
                case "info":
                    System.out.println("[p] - pajamų įrašai");
                    System.out.println("[i] - išlaidų įrašai");
                    komanda = new Scanner(System.in).next();
                    if (komanda.equals("p")){
                        System.out.println("Nurodykite pajamų įrašo numerį");
                        System.out.println("***");
                        b1.gautiPajamuIrasa(new Scanner(System.in).nextInt());
                        System.out.println("***");
                    }else if(komanda.equals("i")){
                        System.out.println("Nurodykite išlaidų įrašo numerį");
                        System.out.println("***");
                        b1.gautiIslaiduIrasa(new Scanner(System.in).nextInt());
                        System.out.println("***");
                    }else{
                        System.out.println("Neteisinga komanda");
                    }
                    break;
                default:
                    System.out.println("Neteisinga komanda");
            }

        }

    }
}
