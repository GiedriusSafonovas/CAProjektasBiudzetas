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
                case "1":
                    System.out.println("Įveskite sumą");
                    suma = dblsc.nextDouble();
                    System.out.println("Ar pinigai gasuti į banką(true/false)?");
                    bankas = new Scanner(System.in).nextBoolean();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = strsc.nextLine();
                    b1.pridetiPajamuIrasa(suma, bankas, papildomaInfo);
                    break;
                case "2":
                    System.out.println("Įveskite sumą");
                    suma = dblsc.nextDouble();
                    System.out.println("Atsiskaitymo būdas");
                    atsiskaitymoBudas = strsc.nextLine();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = strsc.nextLine();
                    b1.pridetiIslaiduIrasa(suma, atsiskaitymoBudas, papildomaInfo);
                    break;
                case "3":
                    System.out.println("Įveskite įrašo kodą");
                    komanda = strsc.nextLine();
                    b1.remove(komanda);
                    break;
                case "4":
                    meniu.komandos2();
                    komanda = strsc.nextLine();
                    switch (komanda){
                        case "1":
                            b1.printIrasai();
                            break;
                        case "2":
                            System.out.println("Įveskite įrašo kodą");
                            komanda = strsc.nextLine();
                            b1.gautiIrasa(komanda);
                            break;
                        case  "3":
                            System.out.println("Balansas: " + b1.balansas());
                            break;
                        case  "4":
                            System.out.println("Pajamų įrašai:\n" + b1.gautiPajamuIrasus());
                            break;
                        case  "5":
                            System.out.println("Išlaidų įrašai:\n" + b1.gautiIslaiduIrasus());
                            break;
                        default:
                            System.out.println("Neteisinga komanda");
                    }
                    break;
                case "5":
                    b1.printIrasai();
                    System.out.println("Įveskite įrašo kodą");
                    komanda = strsc.nextLine();
                    b1.redaguoti(komanda);
                    break;
                default:
                    System.out.println("Neteisinga komanda");
            }

        }

    }
}
