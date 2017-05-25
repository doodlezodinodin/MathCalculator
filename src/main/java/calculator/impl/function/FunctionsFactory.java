package calculator.impl.function;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionsFactory {

    private final Map<String, Function> functions = new HashMap<String, Function>() {{
        put("min", new MinNumberFunction());
        put("max", new MaxNumberFunction());
        put("sum", new SumNumberFunction());
    }};

    public Function getFunction(String representation) {
        return functions.get(representation);
    }

    public Set<String> getFunctions() {
        return functions.keySet();
    }
}
