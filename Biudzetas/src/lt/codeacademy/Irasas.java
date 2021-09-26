package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Irasas {
    private String indeksas;
    private double suma;
    private LocalDate data;
    private String papildomaInfo;

    Irasas(String indeksas, double suma, String papildomaInfo) {
        this.indeksas = indeksas;
        this.suma = suma;
        this.papildomaInfo = papildomaInfo;
        this.data = LocalDate.now();
    }

    public double getSuma() {
        return suma;
    }

    public LocalDate getData() {
        return data;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public String getIndeksas() {
        return indeksas;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return String.format("Išlaidų irašo nr: %s\nSuma: %.2f\nData: %s\nPapildoma info: %s\n",
                indeksas, suma, data, papildomaInfo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Irasas) {
            return ((Irasas) obj).indeksas.equals(this.indeksas);
        } else {
            return false;
        }

    }
}
