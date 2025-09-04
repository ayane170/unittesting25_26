package theorie.functionalprogramming;

import java.util.function.Function;

public class Level1 {

    // Function is an interface, so we need to implement it
    // First generic parameter is the input type (String), second is the output type (Integer)
    private static class ExplicitFunctionImpl implements Function<String, Integer> {
        @Override
        public Integer apply(String text) {
            return text.length();
        }
    }

    // Function can be passed as a parameter to another method
    public Integer executeTheFunction(Function<String, Integer> function, String text) {
        Integer functionResult = function.apply(text);
        System.out.println(functionResult);
        return functionResult;
    }

    void usingExplicitFunction() {
        executeTheFunction(
                new ExplicitFunctionImpl(),
                "Just some text"
        );
    }

}
