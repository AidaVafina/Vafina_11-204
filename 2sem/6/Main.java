import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, String> persons = new HashMap<>();
        persons.put("Vafina", "+7 (421) 367-56-66");
        persons.put("Petrov", "+7 (917) 894-34-21");
        persons.put("Khakimova", "+7 (421) 657-12-90");
        printValues(persons);
        //System.out.println(check(persons));
        mostOften(persons);
        printValues(createNewMap(persons));
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("a", 1);
        newMap.put("b", 2);
        newMap.put("c", 3);
        newMap.put("d",4);
        sum(newMap);
        deleteElem(newMap,2);
    }

    public static void printValues(Map<String, String> map) {
        map.entrySet()
                .stream()
                .map(x -> x.getValue())
                .forEach(System.out::println);
    }

    public static Map<String, String> createNewMap(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<>();
        map.entrySet()
                .stream()
                .map(x -> newMap.put(x.getValue(), x.getKey()))
                .collect(Collectors.toList());
        return newMap;
    }

    public static void sum(Map<String, Integer> map) {
        System.out.println(map.values().stream().mapToInt(Integer::intValue).sum());
    }

    public static void deleteElem(Map<String, Integer> map, int number) {
        map.entrySet()
                .stream()
                .filter(x -> x.getValue() > number)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void mostOften(Map<String, String> map1){
        Map<String, Integer> stringsCount = new HashMap<>();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            Integer c = stringsCount.get(entry);
            if (c == null){
                c = new Integer(0);
                c++;
                stringsCount.put(String.valueOf(entry),c);
            }
        }
        Map.Entry<String,Integer> mostRepeated = null;
        for(Map.Entry<String, Integer> e: stringsCount.entrySet()) {
            if(mostRepeated == null || mostRepeated.getValue() < e.getValue()) {
                mostRepeated = e;
            }
        }
        if(mostRepeated != null) {
            System.out.println(mostRepeated.getKey());
        }
    }
}