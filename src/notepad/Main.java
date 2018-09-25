package notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter commmand: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "create":
                    create();
                    break;
                case "list":
                    printList();
                    break;
                case "delete":
                    deleteById();
                case "exit":
                    return;
                default:
                    System.out.println("It isn't a command");
            }
        }
    }

    private static void deleteById() {
        System.out.println("Enter id of person to be deleted: ");
        int idDelete = scanner.nextInt();

        int index = -1;

        for (Person p : people) {
            index++;
            if(p.getId() == idDelete)
                break;
        }
 //       delete row with index value!
        System.out.print(index);

       }

    private static void printList() {
        int count = 0;
        for (Person p : people) {
            System.out.println(p);
                  }
    }

    private static void create() {
        System.out.println("Enter name: ");
        String name = scanner.next();

        System.out.println("Enter surname: ");
        String surname = scanner.next();

        System.out.println("Enter phone number: ");
        String phone = scanner.next();

        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);

        people.add(p);

        System.out.println(p);
    }
}

