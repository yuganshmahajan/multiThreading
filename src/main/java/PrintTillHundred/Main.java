package PrintTillHundred;

public class Main {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){
            new Thread(new PrintNumber(i)).start();
        }
    }
}
