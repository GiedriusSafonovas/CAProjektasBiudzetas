package lt.codeacademy;


public class Programa {

    public static void start() {
        Biudzetas b1 = new Biudzetas();
        double suma;
        boolean bankas;
        String atsiskaitymoBudas;
        String papildomaInfo;
        String komanda;
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
                    System.out.println("Ar pinigai gauti į banką(true/false)?");
                    bankas = Scan.getBool();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = Scan.getStr();
                    b1.pridetiIrasa(new PajamuIrasas(suma, bankas, papildomaInfo));
                    break;
                case "2":
                    System.out.println("Įveskite sumą");
                    suma = Scan.getDbl();
                    System.out.println("Atsiskaitymo būdas");
                    atsiskaitymoBudas = Scan.getStr();
                    System.out.println("Iveskite papildomą info");
                    papildomaInfo = Scan.getStr();
                    b1.pridetiIrasa(new IslaiduIrasas(suma, atsiskaitymoBudas, papildomaInfo));
                    break;
                case "3":
                    System.out.println("Įveskite įrašo kodą");
                    b1.remove(Scan.getStr());
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
                            b1.gautiIrasa(Scan.getStr());
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
                        break;
                    }
                    System.out.println("Įveskite įrašo kodą");
                    b1.redaguoti(Scan.getStr());
                    break;
                case "6":
                    if(Failas.issaugotiDuomenis(b1.getIrasas())){
                        System.out.println("Duomenys išsaugoti");
                    }
                    break;
                case "7":
                    if(Failas.gautiDuomenis(b1)){
                        System.out.println("Duomenys užkrauti");
                    }
                    break;
                default:
                    System.out.println("Neteisinga komanda");
            }

        }

    }
}
