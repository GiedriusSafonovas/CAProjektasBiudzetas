package lt.codeacademy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {
    private static Scanner sc = new Scanner(System.in);

    public static String getStr(){
        return sc.nextLine();
    }

    public static Double getDbl(){
        while (true){
            try {
                double r = sc.nextDouble();
                sc.nextLine();
                return r;
            }catch (InputMismatchException e){
                System.out.println("Įvestas neteisingas argumentas, bandykite dar kartą, įveskite skaičių");
                sc.next();
            }
        }
    }

    public static int getInt(){
        while (true){
            try {
                int r = sc.nextInt();
                sc.nextLine();
                return r;
            }catch (InputMismatchException e){
                System.out.println("Įvestas neteisingas argumentas, bandykite dar kartą, įveskite sveiką skaičių");
                sc.next();
            }
        }
    }

    public static boolean getBool(){
        while (true){
            try {
                boolean r = sc.nextBoolean();
                sc.nextLine();
                return r;
            }catch (InputMismatchException e){
                System.out.println("Įvestas neteisingas argumentas, bandykite dar kartą, įveskite \"true\" arba \"false\"");
                sc.next();
            }
        }
    }

    public static LocalDate getDate(){
        while (true){
            try {
                LocalDate r = LocalDate.parse(Scan.getStr(), (DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                return r;
            }catch (DateTimeParseException e){
                System.out.println("Įvestas neteisinga data, bandykite dar kartą, datos formatas yyyy-MM-dd");
            }
        }
    }

}
