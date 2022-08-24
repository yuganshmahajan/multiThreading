package PrintNumbersVIaExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        Executor executor = Executors.newCachedThreadPool();
        Executor executor = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 100; i++) {

            if(i == 50){
                System.out.println("STOP");
            }

            executor.execute(new PrintNumber(i));
        }
    }
}
