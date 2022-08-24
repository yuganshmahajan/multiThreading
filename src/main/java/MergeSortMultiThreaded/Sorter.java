package MergeSortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arr;
    public Sorter(List<Integer> a){
        this.arr = a;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arr.size() <= 1){
            return arr;
        }

        int mid = arr.size()/2;

        List<Integer> lArr = new ArrayList<>();
        List<Integer> rArr = new ArrayList<>();

        for(int i = 0; i < mid; i++){
            lArr.add(arr.get(i));
        }

        for(int i = mid; i < arr.size(); i++){
            rArr.add(arr.get(i));
        }

        //Executor doesnt take callable, it only takes runnable
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<List<Integer>> lArrFuture =  executor.submit(new Sorter(lArr));
        Future<List<Integer>> rArrFuture = executor.submit(new Sorter(rArr));

        List<Integer> lSortedArray = lArrFuture.get();
        List<Integer> rSortedArray = lArrFuture.get();

        List<Integer> mergedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < lSortedArray.size() && j < rSortedArray.size()){
            if(lSortedArray.get(i) < rSortedArray.get(j)){
                mergedArray.add(lSortedArray.get(i));
                i++;
            } else {
                mergedArray.add(rSortedArray.get(j));
                j++;
            }
        }

        while(i < lSortedArray.size()){
            mergedArray.add(lSortedArray.get(i));
            i++;
        }

        while(i < rSortedArray.size()){
            mergedArray.add(lSortedArray.get(i));
            i++;
        }

        return mergedArray;
    }
}
