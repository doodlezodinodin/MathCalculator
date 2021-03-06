package calculator.impl.parser;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConstantFactory {

    private final Map<String, Double> constant = new HashMap<String, Double>() {{
        put("Pi", 3.14);
        put("e", 2.71);
        put("randInt", Math.ceil((Math.random() * 200)) - 100);
        put("randDouble", (Math.random() * 200) - 100);
    }};

    public double getConstant(String representation) {
        return constant.get(representation);
    }

    public Set<String> getRepresentation() {
        return constant.keySet();
    }
}
