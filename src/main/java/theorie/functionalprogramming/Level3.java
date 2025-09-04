package theorie.functionalprogramming;

import java.util.function.Function;

public class Level3 {
    // Same as Level1
    public Integer executeTheFunction(Function<String, Integer> function, String text) {
        Integer functionResult = function.apply(text);
        System.out.println(functionResult);
        return functionResult;
    }

    // Local static method to be used as method reference
    public static Integer staticMethod(String text) {
        return text.length();
    }

    // Local, private and non-static method to be used as method reference
    private int calculateStringLength(String text) {
        return text.length();
    }

    void usingLocalMethodReference() {
        executeTheFunction(Level3::staticMethod, "Just some text");
    }

    void usingLocalNonStaticMethodReference() {
        executeTheFunction(
                this::calculateStringLength,
                "Just some text"
        );
    }
}
