package bai_2;


import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;

public class RunMain {
    public static void main (String[] args) {
        List<Person> people=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("nhap n: ");
        n= scanner.nextInt();
        for (int i=0; i<n; i++){
            Person person = new Person();
            person.nhap();
            people.add(person);
        }
        Collections.sort(people);
        for (Person person: people){
            System.out.println(person.toString());
        }
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getName().compareTo(o1.getAddress())==0){
                    return o2.getAddress().compareTo(o1.getAddress());
                } else return o1.getName().compareTo(o2.getName());
            }
        });

        for (Person person: people){
            System.out.println(person.toString());
        }
    }

}
