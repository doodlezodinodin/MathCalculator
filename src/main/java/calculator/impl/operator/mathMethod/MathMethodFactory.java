package calculator.impl.operator.mathMethod;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MathMethodFactory {

    private final Map<String, MathMethod> method = new HashMap<String, MathMethod>() {{
       put("sqr", new SquareMethod());
    }};

    public MathMethod getMethod(String representation) {
        return method.get(representation);
    }

    public Set<String> getRepresentations() {
        return method.keySet();
    }
}
