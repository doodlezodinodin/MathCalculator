package calculator.impl.operator.bracket;


import calculator.impl.operator.BinaryOperator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BracketFactory {
    private final Map<String, String> brackets = new HashMap<String, String>() {{
        put("(", "");
        put(")", "");
    }};

    public String getBracket(String representation) {
        return brackets.get(representation);
    }

    public Set<String> getRepresentations() {
        return brackets.keySet();
    }
}
