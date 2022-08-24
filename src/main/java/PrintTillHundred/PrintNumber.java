package PrintTillHundred;

public class PrintNumber implements Runnable{
    int noToPrint;
    public PrintNumber(int n){
        this.noToPrint = n;
    }

    @Override
    public void run() {
        System.out.println(noToPrint);
    }
}
