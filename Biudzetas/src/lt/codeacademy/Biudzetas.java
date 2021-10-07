package lt.codeacademy;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biudzetas {
    private ArrayList<Irasas> irasas = new ArrayList<>();

    public void pridetiIrasa(Irasas irasas) {
        this.irasas.add(irasas);
    }


    public void gautiIrasa(String indeksas) {
        Irasas ieskomasIrasas = new Irasas(indeksas);
        if (!irasas.contains(ieskomasIrasas)) {
            System.out.println("Tokio įrašo nėra");
            return;
        } else {
            System.out.println(irasas.get(irasas.indexOf(ieskomasIrasas)));
        }
    }


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
        return (Math.round((pajamuSuma - islaiduSuma)*100.0))/100.0;
    }

    public boolean printIrasai() {
        if (irasas.size() == 0) {
            System.out.println("Įrašų nėra");
            return false;
        }
        System.out.println(irasas);
        return true;
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


    public void remove(String indeksas) {
        Irasas ieskomasIrasas = new Irasas(indeksas);
        if (!irasas.contains(ieskomasIrasas)) {
            System.out.println("Tokio įrašo nėra");
            return;
        } else {
            irasas.remove(irasas.indexOf(ieskomasIrasas));
            System.out.println("Įrašas pašalintas");
        }
    }


    public void redaguoti(String indeksas) {

        String tekstas1 = "[1] - redaguoti, [2] - toliau";
        String tekstas2 = "Įveskite naują reikšmę";
        Irasas ieskomasIrasas = new Irasas(indeksas);
        if (!irasas.contains(ieskomasIrasas)) {
            System.out.println("Tokio įrašo nėra");
            return;
        } else {
//            int irasoIndeksas = irasas.indexOf(ieskomasIrasas);
            Irasas koreguojamasIrasas = irasas.get(irasas.indexOf(ieskomasIrasas));
            String[] irasuTekstas = koreguojamasIrasas.toString().split("\n");
            for (int j = 1; j < irasuTekstas.length; j++) {
                System.out.println(irasuTekstas[j]);
                int komanda = 0;
                while (true) {
                    System.out.println(tekstas1);
                    komanda = Scan.getInt();
                    if (komanda == 1 || komanda == 2) {
                        break;
                    } else {
                        System.out.println("Neteisinga komanda");
                    }
                }
                if (komanda == 1) {
                    System.out.println(tekstas2);
                    switch (j) {
                        case 1:
                            double suma = Scan.getDbl();
                            koreguojamasIrasas.setSuma(suma);
                            break;
                        case 2:
                            LocalDate data = Scan.getDate();
                            koreguojamasIrasas.setData(data);
                            break;
                        case 3:
                            String papildomaInfo = Scan.getStr();
                            koreguojamasIrasas.setPapildomaInfo(papildomaInfo);
                            break;
                        case 4:
                            if (koreguojamasIrasas instanceof PajamuIrasas) {
                                boolean bankas = Scan.getBool();
                                ((PajamuIrasas) koreguojamasIrasas).setPozymisArIBanka(bankas);
                                break;
                            } else {
                                String atsiskaitymoBudas = Scan.getStr();
                                ((IslaiduIrasas) koreguojamasIrasas).setAtsiskaitymoBudas(atsiskaitymoBudas);
                                break;
                            }
                    }
                }
            }
            atnaujintiIrasa(koreguojamasIrasas);
        }
    }


    public void atnaujintiIrasa(Irasas irasas) {
            int indeksas = this.irasas.indexOf(irasas);
            this.irasas.set(indeksas,irasas);
    }

    public ArrayList<Irasas> getIrasas() {
        return irasas;
    }
}
