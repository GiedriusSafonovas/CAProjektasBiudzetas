package lt.codeacademy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Biudzetas b1 = new Biudzetas();
        double suma;
        boolean bankas;
        String atsiskaitymoBudas;
        String papildomaInfo;
        String komanda;
        int nr;
        while (true) {
            Meniu.komandos1();
            komanda = Scan.getStr();
            if (komanda.equals("x")) {
                break;
            }

            switch (komanda) {
                case "1":
                    System.out.println("Įveskite sumą");
                    suma = Scan.getDbl();
                    System.out.println("Ar pinigai gasuti į banką(true/false)?");
                    bankas = Scan.getBool();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = Scan.getStr();
                    b1.pridetiPajamuIrasa(suma, bankas, papildomaInfo);
                    break;
                case "2":
                    System.out.println("Įveskite sumą");
                    suma = Scan.getDbl();
                    System.out.println("Atsiskaitymo būdas");
                    atsiskaitymoBudas = Scan.getStr();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = Scan.getStr();
                    b1.pridetiIslaiduIrasa(suma, atsiskaitymoBudas, papildomaInfo);
                    break;
                case "3":
                    System.out.println("Įveskite įrašo kodą");
                    komanda = Scan.getStr();
                    b1.remove(komanda);
                    break;
                case "4":
                    Meniu.komandos2();
                    komanda = Scan.getStr();
                    switch (komanda) {
                        case "1":
                            b1.printIrasai();
                            break;
                        case "2":
                            System.out.println("Įveskite įrašo kodą");
                            komanda = Scan.getStr();
                            b1.gautiIrasa(komanda);
                            break;
                        case "3":
                            System.out.println("Balansas: " + b1.balansas());
                            break;
                        case "4":
                            System.out.println("Pajamų įrašai:\n" + b1.gautiPajamuIrasus());
                            break;
                        case "5":
                            System.out.println("Išlaidų įrašai:\n" + b1.gautiIslaiduIrasus());
                            break;
                        default:
                            System.out.println("Neteisinga komanda");
                    }
                    break;
                case "5":
                    if(!b1.printIrasai()){
                        b1.printIrasai();
                        break;
                    }
                    b1.printIrasai();
                    System.out.println("Įveskite įrašo kodą");
                    komanda = Scan.getStr();
                    b1.redaguoti(komanda);
                    break;
                default:
                    System.out.println("Neteisinga komanda");
            }

        }

    }
}
