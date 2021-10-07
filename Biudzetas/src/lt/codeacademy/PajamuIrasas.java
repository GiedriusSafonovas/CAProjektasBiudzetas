package lt.codeacademy;


import java.time.LocalDate;

public class PajamuIrasas extends Irasas{
    private final static String KATEGORIJA = "P";
    private boolean pozymisArIBanka;
    private static int counter;

    PajamuIrasas(double suma, boolean pozymisArIBanka, String papildomaInfo){
        super(KATEGORIJA + counter,suma,papildomaInfo);
        this.pozymisArIBanka = pozymisArIBanka;
        counter++;
    }

    PajamuIrasas(String indeksas, double suma, LocalDate data, boolean pozymisArIBanka, String papildomaInfo){
        super((KATEGORIJA+counter), suma, data, papildomaInfo);
        this.pozymisArIBanka = pozymisArIBanka;
        counter++;
    }


    public void setPozymisArIBanka(boolean pozymisArIBanka) {
        this.pozymisArIBanka = pozymisArIBanka;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    @Override
    public String toString(){
        return (super.toString() + String.format("Ar pinigai gauti į banką: %b\n",pozymisArIBanka));
    }

}
