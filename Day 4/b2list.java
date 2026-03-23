import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b2list {
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("Using Array List");
        System.out.println("=========================================");
        List<String> arrayList = new ArrayList<>();  // list using ArrayList
        //add an element
        arrayList.add("kittu");
        arrayList.add("brunda");
        arrayList.add("chandu");
        arrayList.add("deepthi");
        arrayList.add("kittu");

        System.out.println("-----------Patient List----------");
        System.out.println(arrayList);
        arrayList.add(2, "Ramu");//to add at particular index
        System.out.println("Emergency patient Ramu added : " + arrayList);
        arrayList.set(4, "deepika"); // to update the value
        System.out.println("patient name updated : " + arrayList);
        arrayList.remove("chandu");
        System.out.println("patient name removed : " + arrayList);
        System.out.println("patient brunda exists or not : " + arrayList.contains("brunda")); // to check
        System.out.println("no.of patients : " + arrayList.size());
        System.out.println("First Occurrence of kittu : " + arrayList.indexOf("kittu"));
        System.out.println("last Occurrence of kittu : " + arrayList.lastIndexOf("kittu"));

        System.out.println("---------Patient Names-------");
        for (String patient : arrayList) {
            System.out.println(patient);
        }

        arrayList.clear();
        System.out.println(arrayList);

        //using LinkedList
        System.out.println("=========================================");
        System.out.println("Using LinkedList");
        System.out.println("=========================================");
        List<String> linkedList = new LinkedList<>();  // list using ArrayList
        //add an element
        linkedList.add("kittu");
        linkedList.add("brunda");
        linkedList.add("chandu");
        linkedList.add("deepthi");
        linkedList.add("kittu");

        System.out.println("-----------Patient List----------");
        System.out.println(linkedList);
        linkedList.add(2, "Ramu");//to add at particular index
        System.out.println("Emergency patient Ramu added : " + linkedList);
        linkedList.set(4, "deepika"); // to update the value
        System.out.println("patient name updated : " + linkedList);
        linkedList.remove("chandu");
        System.out.println("patient name removed : " + linkedList);
        System.out.println("patient brunda exists or not : " + linkedList.contains("brunda")); // to check
        System.out.println("no.of patients : " + linkedList.size());
        System.out.println("First Occurrence of kittu : " + linkedList.indexOf("kittu"));
        System.out.println("last Occurrence of kittu : " + linkedList.lastIndexOf("kittu"));

        System.out.println("---------Patient Names-------");
        for (String patient : linkedList) {
            System.out.println(patient);
        }

        linkedList.clear();
        System.out.println(linkedList);
    }
}
