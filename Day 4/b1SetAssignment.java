import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class b1SetAssignment {
    public static void main(String[] args) {
        Set<String> set =new HashSet<>(); // order changes due to hash function
        set.add("Java");
        set.add("SQL");
        set.add("Spring Boot");
        set.add("Java");
        set.add("React");
        set.add("SQL");
        set.add("Docker");
        set.add("AWS");

        System.out.println("----------HashSet--------");
        System.out.println(set);
        System.out.println("Set contains React or Not " + set.contains("React"));
        System.out.println("Removing Docker.. " + set.remove("Docker"));
        System.out.println(set);
        System.out.println("Size : " +set.size());
        System.out.println("Is set is Empty "  + set.isEmpty());


        //using LinkedHashSet
        Set<String> set1 =new LinkedHashSet<>(); // order remains same

        set1.addAll(set);
        set1.retainAll(set);

        System.out.println("----------Linked HashSet--------");
        System.out.println(set1);
        System.out.println("Set contains React or Not " + set1.contains("React"));
        System.out.println("Removing Docker.. " + set1.remove("AWS"));
        System.out.println(set1);
        System.out.println("Size : " +set1.size());
        System.out.println("Is set is Empty "  + set1.isEmpty());

        //using TreeSet
        Set<String> set2 =new TreeSet<>(); // get Order set
        set2.add("Java");
        set2.add("SQL");
        set2.add("Spring Boot");
        set2.add("Java");
        set2.add("React");
        set2.add("SQL");
        set2.add("Docker");
        set2.add("AWS");
        set1.retainAll(set1);

        System.out.println("----------Tree Set--------");
        System.out.println(set2);
        System.out.println("Set contains React or Not " + set2.contains("React"));
        System.out.println("Removing Docker.. " + set2.remove("Docker"));
        System.out.println(set2);
        System.out.println("Size : " +set2.size());
        System.out.println("Is set is Empty "  + set2.isEmpty());


    }
}
