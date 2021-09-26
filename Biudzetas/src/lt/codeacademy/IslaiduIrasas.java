package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IslaiduIrasas extends Irasas {
    private final static String KATEGORIJA = "I";
    private String atsiskaitymoBudas;
    private static int counter;

    IslaiduIrasas(double suma, String atsiskaitymoBudas, String papildomaInfo){
        super((KATEGORIJA+counter), suma, papildomaInfo);
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        counter++;
    }

//    IslaiduIrasas(double suma, String atsiskaitymoBudas){
//        this.suma = suma;
//        this.atsiskaitymoBudas = atsiskaitymoBudas;
//        this.data = LocalDate.now();
//        counter++;
//        this.indeksas = counter;
//    }


    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    @Override
    public String toString(){
        return super.toString() + "atsiskaitymo būdas: " + atsiskaitymoBudas;
    }

}
