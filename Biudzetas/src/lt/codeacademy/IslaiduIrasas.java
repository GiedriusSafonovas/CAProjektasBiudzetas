package lt.codeacademy;

import java.time.LocalDateTime;

public class IslaiduIrasas {
    private final String KATEGORIJA = "Išlaidos";
    private double suma;
    private int indeksas;
    private LocalDateTime dataSuLaiku;
    private String atsiskaitymoBudas;
    private String papildomaInfo;
    private static int counter;

    IslaiduIrasas(double suma, String atsiskaitymoBudas, String papildomaInfo){
        this.suma = suma;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        this.papildomaInfo = papildomaInfo;
        this.dataSuLaiku = LocalDateTime.now();
        counter++;
        this.indeksas = counter;
    }

    IslaiduIrasas(double suma, String atsiskaitymoBudas){
        this.suma = suma;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        this.dataSuLaiku = LocalDateTime.now();
        counter++;
        this.indeksas = counter;
    }

    public double getSuma() {
        return suma;
    }

    public LocalDateTime getDataSuLaiku() {
        return dataSuLaiku;
    }

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public int getIndeksas() {
        return indeksas;
    }


}
