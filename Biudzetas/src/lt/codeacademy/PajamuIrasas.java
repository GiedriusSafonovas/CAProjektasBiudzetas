package lt.codeacademy;

import java.time.LocalDate;

public class PajamuIrasas {
    private double suma;
    private int kategorija;
    private LocalDate data;
    private boolean pozymisArIBanka;
    private String papildomaInfo;
    private static int counter;

    PajamuIrasas(double suma, boolean pozymisArIBanka, String papildomaInfo){
        this.suma = suma;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
        this.data = LocalDate.now();
        counter++;
        this.kategorija = counter;
    }

    PajamuIrasas(double suma, boolean pozymisArIBanka){
        this.suma = suma;
        this.pozymisArIBanka = pozymisArIBanka;
        this.data = LocalDate.now();
        counter++;
        this.kategorija = counter;
    }

    public double getSuma() {
        return suma;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public int getKategorija() {
        return kategorija;
    }
}
