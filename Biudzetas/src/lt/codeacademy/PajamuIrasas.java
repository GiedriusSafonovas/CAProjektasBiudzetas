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

//    PajamuIrasas(double suma, boolean pozymisArIBanka){
//        this.suma = suma;
//        this.pozymisArIBanka = pozymisArIBanka;
//        this.data = LocalDate.now();
//        counter++;
//        this.indeksas = counter;
//    }


    public void setPozymisArIBanka(boolean pozymisArIBanka) {
        this.pozymisArIBanka = pozymisArIBanka;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    @Override
    public String toString(){
        return (super.toString() + "Ar pinigai gauti į banką: " + pozymisArIBanka);
    }

}
