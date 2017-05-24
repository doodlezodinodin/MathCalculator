package calculator.impl.parser.constantParser;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConstantFactory {

    private final Map<String, Double> constant = new HashMap<String, Double>() {{
        put("Pi", 3.14);
        put("e", 2.71);
    }};

    public double getConstant(String representation) {
        return constant.get(representation);
    }

    public Set<String> getRepresentation() {
        return constant.keySet();
    }
}
