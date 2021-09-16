package lt.codeacademy;

public class Biudzetas {
    private PajamuIrasas[] pajamos = new PajamuIrasas[100];
    private IslaiduIrasas[] islaidos = new IslaiduIrasas[100];


    public void pridetiPajamuIrasa(double suma, boolean pozymisArIBanka, String papildomaInfo){
        for (int i = 0; i < pajamos.length; i++) {
            if(pajamos[i] == null){
                pajamos[i] = new PajamuIrasas(suma,pozymisArIBanka,papildomaInfo);
                break;
            }
        }
    }

    public void pridetiPajamuIrasa(double suma, boolean pozymisArIBanka) {
        for (int i = 0; i < pajamos.length; i++) {
            if (pajamos[i] == null) {
                pajamos[i] = new PajamuIrasas(suma, pozymisArIBanka);
                break;
            }
        }
    }

    public void pridetiIslaiduIrasa(double suma, String atsiskaitymoBudas, String papildomaInfo){
        for (int i = 0; i < islaidos.length; i++) {
            if (islaidos[i] == null) {
                islaidos[i] = new IslaiduIrasas(suma, atsiskaitymoBudas, papildomaInfo);
                break;
            }
        }
    }

    public void pridetiIslaiduIrasa(double suma, String atsiskaitymoBudas){
        for (int i = 0; i < islaidos.length; i++) {
            if (islaidos[i] == null) {
                islaidos[i] = new IslaiduIrasas(suma, atsiskaitymoBudas);
                break;
            }
        }
    }

    public void gautiPajamuIrasa(int indeksas){
        System.out.println("Pajamų irašo nr: " + pajamos[indeksas - 1].getKategorija());
        System.out.println("Suma: " + pajamos[indeksas - 1].getSuma());
        System.out.println("Data: " + pajamos[indeksas - 1].getData());
        System.out.println("Ar pinigai gauti į banką: " + pajamos[indeksas - 1].isPozymisArIBanka());
        System.out.println("Papildoma info: " + pajamos[indeksas - 1].getPapildomaInfo());
    }

    public void gautiIslaiduIrasa(int indeksas){
        System.out.println("Išlaidų irašo nr: " + islaidos[indeksas - 1].getKategorija());
        System.out.println("Suma: " + islaidos[indeksas - 1].getSuma());
        System.out.println("Data: " + islaidos[indeksas - 1].getDataSuLaiku());
        System.out.println("Atsiskaitymo būdas: " + islaidos[indeksas - 1].getAtsiskaitymoBudas());
        System.out.println("Papildoma info: " + islaidos[indeksas - 1].getPapildomaInfo());
    }

}
