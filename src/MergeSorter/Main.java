package MergeSorter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> values = List.of(10, 9, 8, 7, 11, 2, 13 ,89);

        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(values, executorService);
        Future<List<Integer>> sortedList = executorService.submit(mergeSorter);
        System.out.println(sortedList.get());
    }
}
