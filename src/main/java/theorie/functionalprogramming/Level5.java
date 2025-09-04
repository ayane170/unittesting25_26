package theorie.functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Level5 {
    public void runnableRunner(Runnable runnable) {
        runnable.run();
    }

    public Integer supplierRunner(Supplier<Integer> supplier) {
        Integer supplierResult = supplier.get();
        System.out.println("Result from this supplier is " + supplierResult);
        return supplierResult;
    }

    public Integer biFunctionRunner(BiFunction<Integer, Integer, Integer> biFunction) {
        Integer biFunctionResult = biFunction.apply(1, 2);
        System.out.println(biFunctionResult);
        return biFunctionResult;
    }

    int randomInt() {
        return (int) (Math.random() * 100);
    }

    void usingExplicitRunnable() {
        runnableRunner(new Runnable() {
            public void run() {
                System.out.println("Hello World");
            }
        });
    }

    void usingLambda() {
        runnableRunner(() -> System.out.println("Hello World"));
    }

    void usingSupplier() {
        supplierRunner(() -> 5);
        supplierRunner(() -> {
            System.out.println("Custom supplier code");
            int a = 5;
            int b = 9;

            return a * b;
        });
        supplierRunner(this::randomInt);
    }

    void usingBiFunction() {
        biFunctionRunner((a, b) -> {
            System.out.println("Custom biFunction code");
            return a + b;
        });
        biFunctionRunner((a, b) -> a + b);
        biFunctionRunner(Integer::sum);
    }


}
