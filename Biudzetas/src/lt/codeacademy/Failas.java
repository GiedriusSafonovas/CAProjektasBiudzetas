package lt.codeacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Failas {
    private static boolean writeMode = true;


    public static boolean issaugotiDuomenis(ArrayList<Irasas> irasai) {
        File f = new File("Biudzetas.csv");
        try {
            FileWriter fw = new FileWriter(f, writeMode);
            fw.write("Indeksas,Suma,Data,Požymis ar į banką,Atsiskaitymo būdas,Papildoma Informacija" + System.lineSeparator());
            for (int i = 0; i < irasai.size(); i++) {
                fw.write(String.format("%s,%s,%s,%s,%s,%s",
                        irasai.get(i).getIndeksas(),
                        irasai.get(i).getSuma(),
                        irasai.get(i).getData(),
                        (irasai.get(i) instanceof PajamuIrasas) ?
                                ((PajamuIrasas) irasai.get(i)).isPozymisArIBanka() :
                                "",
                        (irasai.get(i) instanceof IslaiduIrasas) ?
                                ((IslaiduIrasas) irasai.get(i)).getAtsiskaitymoBudas() :
                                "",
                        irasai.get(i).getPapildomaInfo()) + System.lineSeparator());
            }
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println("IOException");
            return false;
        }
    }

    public static boolean gautiDuomenis(Biudzetas biudzetas) {
        File f = new File("Biudzetas.csv");
        try {
            Scanner sc = new Scanner(f);
            sc.nextLine();
            sc.useDelimiter(",");
            while (sc.hasNext()){
                String kodas = sc.next();
                Double suma = sc.nextDouble();
                LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                boolean arIBanka = sc.nextBoolean();
                String atsiskaitymoBudas = sc.next();
                String papildomaInformacija = sc.next();
                if(kodas.charAt(0) == 'P'){
                    biudzetas.pridetiIrasa(new PajamuIrasas(kodas, suma, data, arIBanka, papildomaInformacija));
                }else{
                    biudzetas.pridetiIrasa(new IslaiduIrasas(kodas, suma, data, atsiskaitymoBudas, papildomaInformacija));
                }
            }
            writeMode = false;
            return true;
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            return false;
        }
    }
}
