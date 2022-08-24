package MergeSortMultiThreaded;

import com.sun.tools.javac.util.List;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5,2,4,3,1);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<Integer>> sortedArrayFuture = executorService.submit(new Sorter(numbers));

    }
}
