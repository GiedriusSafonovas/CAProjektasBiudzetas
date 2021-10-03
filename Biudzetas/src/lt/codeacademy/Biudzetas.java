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
        if(!irasas.contains(indeksas)) {
            System.out.println("Tokio įrašo nėra");
            return;
        }
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getIndeksas().equals(indeksas)) {
                if (irasas.get(i) instanceof PajamuIrasas) {
                    System.out.println("Pajamų irašo nr: " + irasas.get(i).getIndeksas());
                    System.out.println("Suma: " + irasas.get(i).getSuma());
                    System.out.println("Data: " + irasas.get(i).getData());
                    System.out.println("Ar pinigai gauti į banką: " + ((PajamuIrasas) irasas.get(i)).isPozymisArIBanka());
                    System.out.println("Papildoma info: " + irasas.get(i).getPapildomaInfo());
                    break;
                } else {
                    System.out.println("Išlaidų irašo nr: " + irasas.get(i).getIndeksas());
                    System.out.println("Suma: " + irasas.get(i).getSuma());
                    System.out.println("Data: " + irasas.get(i).getData());
                    System.out.println("Atsiskaitymo būdas: " + ((IslaiduIrasas) irasas.get(i)).getAtsiskaitymoBudas());
                    System.out.println("Papildoma info: " + irasas.get(i).getPapildomaInfo());
                    break;
                }
            }
        }
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

    public boolean printIrasai() {
        if (irasas.size() == 0) {
            System.out.println("Įrašų nėra");
            return false;
        }
        for (Irasas i : irasas) {
            if (i instanceof PajamuIrasas) {
                System.out.println(String.format("Pajamų irašo nr: %s\nSuma: %.2f\nData: %s\nAr pinigai gauti į banką: %b\nPapildoma info: %s\n",
                        i.getIndeksas(), i.getSuma(), i.getData(), ((PajamuIrasas) i).isPozymisArIBanka(), i.getPapildomaInfo()));
            } else {
                System.out.println(String.format("Išlaidų irašo nr: %s\nSuma: %.2f\nData: %s\nAtsiskaitymo būdas: %s\nPapildoma info: %s\n",
                        i.getIndeksas(), i.getSuma(), i.getData(), ((IslaiduIrasas) i).getAtsiskaitymoBudas(), i.getPapildomaInfo()));
            }
        }
        return true;
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
        if(!irasas.contains(indeksas)) {
            System.out.println("Tokio įrašo nėra");
            return;
        }
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getIndeksas().equals(indeksas)) {
                irasas.remove(i);
                System.out.println("Įrašas " + indeksas + " pašalintas");
                break;
            }
        }
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
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getIndeksas().equals(indeksas)) {
                String[] irasuTekstas = irasas.get(i).toString().split("\n");
                for (int j = 1; j < irasuTekstas.length; j++) {
                    System.out.println(irasuTekstas[j]);
                    while (true) {
                        System.out.println(tekstas1);
                        int komanda = Scan.getInt();
                        if (komanda == 1) {
                            System.out.println(tekstas2);
                            switch (j) {
                                case 1:
                                    double suma = Scan.getDbl();
                                    irasas.get(i).setSuma(suma);
                                    break;
                                case 2:
                                    LocalDate data = Scan.getDate();
                                    irasas.get(i).setData(data);
                                    break;
                                case 3:
                                    String papildomaInfo = Scan.getStr();
                                    irasas.get(i).setPapildomaInfo(papildomaInfo);
                                    break;
                                case 4:
                                    if (irasas.get(i) instanceof PajamuIrasas) {
                                        boolean bankas = Scan.getBool();
                                        ((PajamuIrasas) irasas.get(i)).setPozymisArIBanka(bankas);
                                        break;
                                    } else {
                                        String atsiskaitymoBudas = Scan.getStr();
                                        ((IslaiduIrasas) irasas.get(i)).setAtsiskaitymoBudas(atsiskaitymoBudas);
                                        break;
                                    }
                            }
                            break;
                        } else if (komanda == 2) {
                            break;
                        } else {
                            System.out.println("Neteisinga komanda");
                        }
                    }
                }
                break;
            }
        }
    }


    public void atnaujintiIrasa(Irasas irasas) {
        for (Irasas i : this.irasas) {
            if (irasas.equals(i)) {
                i.setSuma(irasas.getSuma());
                i.setData(irasas.getData());
                i.setPapildomaInfo(irasas.getPapildomaInfo());
                if (i instanceof PajamuIrasas) {
                    ((PajamuIrasas) i).setPozymisArIBanka(((PajamuIrasas) irasas).isPozymisArIBanka());
                } else {
                    ((IslaiduIrasas) i).setAtsiskaitymoBudas(((IslaiduIrasas) irasas).getAtsiskaitymoBudas());
                }
            }
        }
    }
}
