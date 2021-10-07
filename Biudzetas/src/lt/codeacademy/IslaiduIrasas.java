package lt.codeacademy;


import java.time.LocalDate;

public class IslaiduIrasas extends Irasas {
    private final static String KATEGORIJA = "I";
    private String atsiskaitymoBudas;
    private static int counter;

    IslaiduIrasas(double suma, String atsiskaitymoBudas, String papildomaInfo){
        super((KATEGORIJA+counter), suma, papildomaInfo);
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        counter++;
    }

    IslaiduIrasas(String indeksas, double suma, LocalDate data, String atsiskaitymoBudas, String papildomaInfo){
        super((KATEGORIJA+counter), suma, data, papildomaInfo);
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        counter++;
    }

    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    @Override
    public String toString(){
        return (super.toString() + String.format("atsiskaitymo būdas: %s\n",atsiskaitymoBudas));
    }

}
