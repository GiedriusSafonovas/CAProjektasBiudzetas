package lt.codeacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {
    private ArrayList<Irasas> irasas = new ArrayList<>();


    public void pridetiPajamuIrasa(double suma, boolean pozymisArIBanka, String papildomaInfo) {
        irasas.add(new PajamuIrasas(suma, pozymisArIBanka, papildomaInfo));
//        pridetiIrasa(new PajamuIrasas(suma, pozymisArIBanka, papildomaInfo));
    }

    public void pridetiIslaiduIrasa(double suma, String atsiskaitymoBudas, String papildomaInfo) {
        irasas.add(new IslaiduIrasas(suma, atsiskaitymoBudas, papildomaInfo));
    }

    public void pridetiIrasa(Irasas irasas) {
        this.irasas.add(irasas);
    }


    public void gautiIrasa(String indeksas) {
        boolean found = false;
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getIndeksas().equals(indeksas)) {
                if (irasas.get(i) instanceof PajamuIrasas) {
                    System.out.println("Pajamų irašo nr: " + irasas.get(i).getIndeksas());
                    System.out.println("Suma: " + irasas.get(i).getSuma());
                    System.out.println("Data: " + irasas.get(i).getData());
                    System.out.println("Ar pinigai gauti į banką: " + ((PajamuIrasas) irasas.get(i)).isPozymisArIBanka());
                    System.out.println("Papildoma info: " + irasas.get(i).getPapildomaInfo());
                    found = true;
                    break;
                } else {
                    System.out.println("Išlaidų irašo nr: " + irasas.get(i).getIndeksas());
                    System.out.println("Suma: " + irasas.get(i).getSuma());
                    System.out.println("Data: " + irasas.get(i).getData());
                    System.out.println("Atsiskaitymo būdas: " + ((IslaiduIrasas) irasas.get(i)).getAtsiskaitymoBudas());
                    System.out.println("Papildoma info: " + irasas.get(i).getPapildomaInfo());
                    found = true;
                    break;
                }
            }
        }
        if(!found) System.out.println("Tokio įrašo nėra");
    }

//    public void gautiIslaiduIrasa(String indeksas) {
//        for (int i = 0; i < irasas.size(); i++) {
//            if (irasas.get(i).getIndeksas().equals(indeksas)) {
//                System.out.println("Išlaidų irašo nr: " + irasas.get(i).getIndeksas());
//                System.out.println("Suma: " + irasas.get(i).getSuma());
//                System.out.println("Data: " + irasas.get(i).getData());
//                System.out.println("Atsiskaitymo būdas: " + ((IslaiduIrasas) irasas.get(i)).getAtsiskaitymoBudas());
//                System.out.println("Papildoma info: " + irasas.get(i).getPapildomaInfo());
//            }
//        }

//    }

    public double balansas() {
        double pajamuSuma = 0;
        double islaiduSuma = 0;
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i) instanceof PajamuIrasas) {
                pajamuSuma += irasas.get(i).getSuma();
            } else {
                islaiduSuma += irasas.get(i).getSuma();
            }
        }
        return pajamuSuma - islaiduSuma;
    }

    public void printIrasai() {
        for (Irasas i : irasas) {
            if (i instanceof PajamuIrasas) {
                System.out.println(String.format("Pajamų irašo nr: %s\nSuma: %.2f\nData: %s\nAr pinigai gauti į banką: %b\nPapildoma info: %s\n",
                        i.getIndeksas(), i.getSuma(), i.getData(), ((PajamuIrasas) i).isPozymisArIBanka(), i.getPapildomaInfo()));
            } else {
                System.out.println(String.format("Išlaidų irašo nr: %s\nSuma: %.2f\nData: %s\nAtsiskaitymo būdas: %s\nPapildoma info: %s\n",
                        i.getIndeksas(), i.getSuma(), i.getData(), ((IslaiduIrasas) i).getAtsiskaitymoBudas(), i.getPapildomaInfo()));
            }
        }
    }

//    public void printIslaidos() {
//        for (Irasas i : irasas) {
//            if(i instanceof PajamuIrasas) {
//                System.out.println(String.format("Pajamų irašo nr: %d\nSuma: %.2f\nData: %s\nAtsiskaitymo būdas: %s\nPapildoma info: %s\n",
//                        i.getIndeksas(), i.getSuma(), i.getData(), ((IslaiduIrasas) i).getAtsiskaitymoBudas(), i.getPapildomaInfo()));
//            }
//        }
//    }

    public void remove(String indeksas) {
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getIndeksas().equals(indeksas)) {
                irasas.remove(i);
                break;
            }
        }
        System.out.println("Tokio įrašo nėra");
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasus() {
        ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
        for (Irasas i : irasas) {
            if (i instanceof PajamuIrasas) {
                pajamos.add((PajamuIrasas) i);
            }
        }
        return pajamos;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
        ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();
        for (Irasas i : irasas) {
            if (i instanceof IslaiduIrasas) {
                islaidos.add((IslaiduIrasas) i);
            }
        }
        return islaidos;
    }

    public void redaguoti(String indeksas) {

        String tekstas1 = "[1] - redaguoti, [2] - toliau";
        String tekstas2 = "Įveskite naują reikšmę";
        for (Irasas i : irasas) {
            if (i.getIndeksas().equals(indeksas)) {
                String[] irasuTekstas = i.toString().split("\n");
                for (int j = 1; j < irasuTekstas.length; j++) {
                    System.out.println(irasuTekstas[j]);
                    System.out.println(tekstas1);
                    if (Scan.intgr.nextInt() == 1) {
                        System.out.println(tekstas2);
                        switch (j) {
                            case 1:
                                double suma = Scan.dbl.nextDouble();
                                i.setSuma(suma);
                                break;
                            case 2:
                                LocalDate data = LocalDate.parse(Scan.str.nextLine(), (DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                                i.setData(data);
                                break;
                            case 3:
                                String papildomaInfo = Scan.str.nextLine();
                                i.setPapildomaInfo(papildomaInfo);
                                break;
                            case 4:
                                if (i instanceof PajamuIrasas) {
                                    boolean bankas = Scan.bool.nextBoolean();
                                    ((PajamuIrasas) i).setPozymisArIBanka(bankas);
                                    break;
                                } else {
                                    String atsiskaitymoBudas = Scan.str.nextLine();
                                    ((IslaiduIrasas) i).setAtsiskaitymoBudas(atsiskaitymoBudas);
                                    break;
                                }
                        }
                    }
                }
                break;
            }
        }
    }

    public void atnaujintiIrasa(Irasas irasas){
        for(Irasas i: this.irasas){
            if(irasas.equals(i)){
                i.setSuma(irasas.getSuma());
                i.setData(irasas.getData());
                i.setPapildomaInfo(irasas.getPapildomaInfo());
                if(i instanceof PajamuIrasas){
                    ((PajamuIrasas) i).setPozymisArIBanka(((PajamuIrasas) irasas).isPozymisArIBanka());
                }else{
                    ((IslaiduIrasas) i).setAtsiskaitymoBudas(((IslaiduIrasas) irasas).getAtsiskaitymoBudas());
                }
            }
        }
    }
}
