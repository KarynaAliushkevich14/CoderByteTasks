import java.util.*;

public class TreeConstructor {

    public static boolean TreeConstructorMethod(String[] strArr) {
        // code goes here
        Map<Integer, Integer> childToParentMap = new HashMap<Integer,Integer>();
        Map<Integer, List<Integer>> parentToChildrenMap = new HashMap<Integer, List<Integer>>();
        List<Integer> allChildren = new ArrayList<>();

        for (String pairNum : strArr) {

            String[] pair = pairNum.replaceAll("[^0-9,]", "").split(",");

            int child = Integer.parseInt(pair[0]);
            int parent = Integer.parseInt(pair[1]);

            // 1 warunek: sprawdzenie czy child ma tylko 1 parenta
            // jeśli child już ma przypisaną wartość parenta, to return false
            if (childToParentMap.containsKey(child)) {
                return false;
            }
            childToParentMap.put(child, parent);

            // 2 warunek: sprawdzenie czy parent ma nie więcej niż 2 childa
            // dodajemy do parentToChildrenMap nowy wiersz z Key: parent, Value new ArrayList for childern{...}
            parentToChildrenMap.putIfAbsent(parent, new ArrayList<Integer>());
            List<Integer> children = parentToChildrenMap.get(parent); // wyciągamy wszystkich dzieci dla danego parenta

            if (children.size() >= 2) {
                return false;
            }
            children.add(child);
        }

        // 3 warunek: sprawdzenie czy jest tylko 1 korzeń == parent sam nie jest czyimś dzieckiem == spośród dzieci nie ma rodzica
        Set<Integer> allParents = parentToChildrenMap.keySet();
        int rootCount = 0;

        for (Integer parent: allParents) {
            if (!childToParentMap.containsKey(parent)) {
                rootCount += 1;
            }
        }

        if (rootCount != 1) {
            return false;
        }
        return true;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(TreeConstructorMethod(s.nextLine()));
    }
}
