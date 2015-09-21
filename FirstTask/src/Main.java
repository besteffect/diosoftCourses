/**
 * Created by vsv on 9/21/2015.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("args quantity : " + args.length); // количество параметров

        for (String arg : args) {
            System.out.print("arg : " + arg);// все параметры
        }
    }
}
