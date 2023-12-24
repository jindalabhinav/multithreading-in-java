package MergeSorter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@AllArgsConstructor
@Getter
@Setter
public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> values = new ArrayList<>();
    private ExecutorService executorService;

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if (values.size() <= 1) {
            return values;
        }

        int mid = values.size() / 2;

        MergeSorter sortedLeft = new MergeSorter(values.subList(0, mid), executorService);
        MergeSorter sortedRight = new MergeSorter(values.subList(mid, values.size()), executorService);

        return merge(executorService.submit(sortedLeft), executorService.submit(sortedRight));
    }

    private List<Integer> merge(Future<List<Integer>> leftFuture, Future<List<Integer>> rightFuture) throws ExecutionException, InterruptedException {
        List<Integer> sortedValues = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = leftFuture.get();
        List<Integer> sortedRight = rightFuture.get();

        while (first < sortedLeft.size() && second < sortedRight.size()) {
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                sortedValues.add(sortedLeft.get(first++));
            }
            else {
                sortedValues.add(sortedRight.get(second++));
            }
        }

        while (first < sortedLeft.size()) {
            sortedValues.add(sortedLeft.get(first++));
        }
        while (second < sortedRight.size()) {
            sortedValues.add(sortedRight.get(second++));
        }

        return sortedValues;
    }

}
