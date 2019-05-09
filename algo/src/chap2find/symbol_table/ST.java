package chap2find.symbol_table;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ST<Key, Value> {

    public ST() {

    }

    void put(Key key, Value val) {

    }

    void get(Key key) {

    }

    boolean contains(Key key) {
        return true;
    }

    boolean isEmpty() {
        return true;
    }

    int size() {
        return 0;
    }

    /**
     * 符号表中所有键的集，注意是集，不容许重复元素
     *
     * @return 键集
     */
    Iterable<Key> keys() {
        return null;
    }


    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put(null, "null-val");
        m.put(null, null);
        m.put("", null);
    }
}
