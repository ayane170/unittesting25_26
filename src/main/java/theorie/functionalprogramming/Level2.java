package theorie.functionalprogramming;

import java.util.function.Function;

public class Level2 {
    // Same as Level1
    public Integer executeTheFunction(Function<String, Integer> function, String text) {
        Integer functionResult = function.apply(text);
        System.out.println(functionResult);
        return functionResult;
    }

    // Implementation of the Function interface happens "inline"
    void usingInlineImplementation() {
        executeTheFunction(
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String text) {
                        return text.length();
                    }
                },
                "Just some text"
        );
    }

    // Using a lambda expression, only the "return" part of the body
    void usingLambda() {
        executeTheFunction(
                text -> text.length(),
                "Just some text"
        );
    }

    // Same form but used when more logic is needed
    void usingLambdaFunction() {
        executeTheFunction(
                text -> {
                    System.out.println("Custom code here");
                    return text.length();
                },
                "Just some text"
        );
    }

    // Using a method reference --> points to a PUBLIC, STATIC function on a class that has the same signature as the function we want to use
    void usingMethodReference() {
        executeTheFunction(
                String::length,
                "Just some text"
        );
    }
}
