package notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Record> records = new ArrayList<>();
    // person list

    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter commmand: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "createperson":
                case "cp":
                    createPerson();
                    break;
                case "createnote":
                case "cn":
                    createNote();
                    break;
                case "list":
                    printList();
                    break;
                case "remove":
                    removeById();
                    break;
                case "find":
                    find();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("It isn't a command");
            }
        }
    }

    private static void find() {
        System.out.println("Find what?");
        String str = askString();
        for (Record r: records) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            }
        }
    }

    private static void removeById() {
        System.out.println("Enter id of person to be deleted: ");
        int id = scanner.nextInt();

        //       int index = -1;

        for (int i = 0; i < records.size(); i++) {
            Record p = records.get(i);
            if (id == p.getId()) {
                records.remove(i);
                break;
            }
        }
    }

    //       for (Person p : records) {
    //           index++;
    //           if(p.getId() == idDelete)
    //              break;
    //      }
    //       delete row with index value!
    //       System.out.print(index);
    //      }

    private static void printList() {
        int count = 0;
        for (Record p : records) {
            System.out.println(p);
        }
    }

    private static void createPerson() {
        System.out.println("Enter name: ");
        String name = askString();

        System.out.println("Enter surname: ");
        String surname = askString();

        System.out.println("Enter phone number: ");
        String phone = askString();

        System.out.println("Enter email: ");
        String email = askString();

        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);
        p.setEmail(email);

        records.add(p);

        System.out.println(p);
    }

    private static void createNote() {
        System.out.println("Enter note: ");
        String text = askString();
        Note note = new Note();
        note.setText(text);
        records.add(note);
        System.out.println(note);

    }


    private static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")){

            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    String str = String.join("", result);
                    return str.substring(1, str.length()-1);
                }
                word = scanner.next();
            }while(true);
        }else {
            return word;
        }
    }
}
