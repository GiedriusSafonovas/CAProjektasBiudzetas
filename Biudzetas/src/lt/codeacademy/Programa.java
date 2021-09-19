package lt.codeacademy;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Biudzetas b1 = new Biudzetas();
        Meniu meniu = new Meniu();
        double suma;
        boolean bankas;
        String atsiskaitymoBudas;
        String papildomaInfo;
        Scanner strsc = new Scanner(System.in);
        Scanner intsc = new Scanner(System.in);
        Scanner dblsc = new Scanner(System.in);
        String komanda;
        int nr;
        while (true) {
            meniu.komandos1();
            komanda = strsc.nextLine();
            if (komanda.equals("x")) {
                break;
            }

            switch (komanda) {
                case "p":
                    System.out.println("Įveskite sumą");
                    suma = dblsc.nextDouble();
                    System.out.println("Ar pinigai gasuti į banką(true/false)?");
                    bankas = new Scanner(System.in).nextBoolean();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = strsc.nextLine();
                    b1.pridetiPajamuIrasa(suma, bankas, papildomaInfo);
                    break;
                case "i":
                    System.out.println("Įveskite sumą");
                    suma = dblsc.nextDouble();
                    System.out.println("Atsiskaitymo būdas");
                    atsiskaitymoBudas = strsc.nextLine();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = strsc.nextLine();
                    b1.pridetiIslaiduIrasa(suma, atsiskaitymoBudas, papildomaInfo);
                    break;
                case "info":
                    meniu.komandos2();
                    komanda = strsc.nextLine();
                    if (komanda.equals("p")) {
                        System.out.println("Nurodykite pajamų įrašo numerį arba [0] visiems įrašams gauti");
                        nr = intsc.nextInt();
                        if (nr == 0) {
                            System.out.println("***");
                            b1.printPajamos();
                            System.out.println("***");
                        } else {
                            System.out.println("***");
                            b1.gautiPajamuIrasa(nr);
                            System.out.println("***");
                        }
                    } else if (komanda.equals("i")) {
                        System.out.println("Nurodykite išlaidų įrašo numerį arba [0] visiems įrašams gauti");
                        nr = intsc.nextInt();
                        if (nr == 0) {
                            System.out.println("***");
                            b1.printIslaidos();
                            System.out.println("***");
                        } else {
                            System.out.println("***");
                            b1.gautiIslaiduIrasa(nr);
                            System.out.println("***");
                        }
                    } else {
                        System.out.println("~Neteisinga komanda");
                    }
                    break;
                case "b":
                    System.out.println("Balansas: " + b1.balansas());
                    break;
                case "r":
                    meniu.komandos2();
                    komanda = strsc.nextLine();
                    System.out.println("Įveskite numerį");
                    nr = intsc.nextInt();
                    b1.remove(nr, komanda);
                default:
                    System.out.println("*Neteisinga komanda");
            }

        }

    }
}
