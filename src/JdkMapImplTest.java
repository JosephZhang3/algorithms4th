import java.util.*;

public class JdkMapImplTest {


    public static void main(String[] args) {
        System.out.printf("%10d", 1000000);
        System.out.println();
        System.out.printf("%10d", 13);

        System.out.println("开始：");

        Person person1 = new Person("马先生", 220181);
        Person person2 = new Person("李先生", 220193);
        Person person3 = new Person("王小姐", 220186);

        Map<Number, Person> map = new HashMap<>();
        map.put(person1.getId_card(), person1);
        map.put(person2.getId_card(), person2);
        map.put(person3.getId_card(), person3);

        // HashMap
        System.out.println("HashMap，无序：");
        for (Number number : map.keySet()) {
            Person person = map.get(number);
            System.out.println(person.getName() + " " + person.getId_card());
        }

        // TreeMap
        System.out.println("TreeMap，按身份证号升序（默认）：");
        TreeMap<Number, Person> treeMap = new TreeMap<>(map);
        for (Number number : treeMap.keySet()) {
            Person person = treeMap.get(number);
            System.out.println(person.getName() + " " + person.getId_card());
        }

        System.out.println("TreeMap，按身份证号降序（手动指定）：");
        TreeMap<Number, Person> treeMap2 =
                new TreeMap<>(Collections.reverseOrder());
        treeMap2.putAll(map);
        for (Number number : treeMap2.keySet()) {
            Person person = treeMap2.get(number);
            System.out.println(person.getName() + " " + person.getId_card());
        }

        System.out.println("结束！");
    }
}

class Person {
    private String name;
    private Integer id_card;

    Person(String name, Integer id_card) {
        this.name = name;
        this.id_card = id_card;
    }

    String getName() {
        return name;
    }

    Integer getId_card() {
        return id_card;
    }

}