package lt.codeacademy;

import java.util.ArrayList;

public class Biudzetas {
    private ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
    private ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();


    public void pridetiPajamuIrasa(double suma, boolean pozymisArIBanka, String papildomaInfo){
                pajamos.add(new PajamuIrasas(suma,pozymisArIBanka,papildomaInfo));
    }

    public void pridetiIslaiduIrasa(double suma, String atsiskaitymoBudas, String papildomaInfo){
                islaidos.add(new IslaiduIrasas(suma, atsiskaitymoBudas, papildomaInfo));
    }



    public void gautiPajamuIrasa(int indeksas){
        for (int i = 0; i < pajamos.size(); i++) {
            if(pajamos.get(i).getIndeksas() == indeksas){
                System.out.println("Pajamų irašo nr: " + pajamos.get(i).getIndeksas());
                System.out.println("Suma: " + pajamos.get(i).getSuma());
                System.out.println("Data: " + pajamos.get(i).getData());
                System.out.println("Ar pinigai gauti į banką: " + pajamos.get(i).isPozymisArIBanka());
                System.out.println("Papildoma info: " + pajamos.get(i).getPapildomaInfo());
            }
        }

    }

    public void gautiIslaiduIrasa(int indeksas){
        for (int i = 0; i < islaidos.size(); i++) {
            if(islaidos.get(i).getIndeksas() == indeksas){
                System.out.println("Išlaidų irašo nr: " + islaidos.get(i).getIndeksas());
                System.out.println("Suma: " + islaidos.get(i).getSuma());
                System.out.println("Data: " + islaidos.get(i).getDataSuLaiku());
                System.out.println("Atsiskaitymo būdas: " + islaidos.get(i).getAtsiskaitymoBudas());
                System.out.println("Papildoma info: " + islaidos.get(i).getPapildomaInfo());
            }
        }

    }

    public double balansas(){
        double pajamuSuma = 0;
        double islaiduSuma = 0;
        for (int i = 0; i < pajamos.size(); i++) {
            pajamuSuma += pajamos.get(i).getSuma();
        }
        for (int i = 0; i < islaidos.size(); i++) {
            islaiduSuma += islaidos.get(i).getSuma();
        }
        return pajamuSuma - islaiduSuma;
    }

    public void printPajamos() {
        for(PajamuIrasas i : pajamos){
            System.out.println(String.format("Pajamų irašo nr: %d\nSuma: %.2f\nData: %s\nAr pinigai gauti į banką: %b\nPapildoma info: %s\n",
                    i.getIndeksas(),i.getSuma(),i.getData(),i.isPozymisArIBanka(),i.getPapildomaInfo()));
        }
    }

    public void printIslaidos() {
        for(IslaiduIrasas i : islaidos){
            System.out.println(String.format("Pajamų irašo nr: %d\nSuma: %.2f\nData: %s\nAtsiskaitymo būdas: %s\nPapildoma info: %s\n",
                    i.getIndeksas(),i.getSuma(),i.getDataSuLaiku(),i.getAtsiskaitymoBudas(),i.getPapildomaInfo()));
        }
    }

    public void remove(int indeksas, String kategorija){
        if(kategorija.equals("p")){
            for (int i = 0; i < pajamos.size(); i++) {
                if(pajamos.get(i).getIndeksas() == indeksas){
                    pajamos.remove(i);
                    break;
                }
            }
        }else if(kategorija.equals("i")){
            for (int i = 0; i < islaidos.size(); i++) {
                if(islaidos.get(i).getIndeksas() == indeksas){
                    islaidos.remove(i);
                    break;
                }
            }
        }else{
            System.out.println("Neteisinga kategorija");
        }

    }
}
