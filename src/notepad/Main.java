package notepad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public final static String DATE_FORMAT = "dd.MM.yyyy";
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    //final it is constant, static - mozhno obrashatsja vezde. Const are upper letters

    public final static String TIME_FORMAT = "HH:MM";
    public final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);


    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Record> records = new LinkedHashMap<>();
    // person list

    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter commmand: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "createPerson":
                case "cp":
                    createPerson();
                    break;
                case "createNote":
                case "cn":
                    createNote();
                    break;
                case "createReminder":
                case "cr":
                    createReminder();
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
                case "show":
                    showById();
                    break;
                case "createalarm":
                case "ca":   
                    createAlarm();
                    break;   
                case "exit":
                    return;
                default:
                    System.out.println("It isn't a command");
            }
        }
    }

    private static void createAlarm() {
        var alarm = new Alarm();
        addRecord(alarm);
    }

    private static void showById() {
        System.out.println("Enter id to find");
        int id = scanner.nextInt();
        Record record = records.get(id);
        System.out.println(records.get(id));
    }

    private static void createReminder() {
//        System.out.println("Enter reminder text");
//        String text = askString();


        var reminder = new Reminder();
        addRecord(reminder);
//        reminder.askQuestions();
//        System.out.println(reminder);
//        records.add(reminder);
    }

    private static void find() {
        System.out.println("Find what?");
        String str = askString();
        for (Record r : records.values()) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            }
        }
    }

    private static void removeById() {
        System.out.println("Enter id of person to be deleted: ");
        int id = scanner.nextInt();

        //       int index = -1;

        records.remove(id);

//        for (int i = 0; i < records.size(); i++) {
//            Record p = records.get(i);
//            if (id == p.getId()) {
//                records.remove(i);
//                break;
//            }
//        }
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
        for (Record p : records.values()) {
            System.out.println(p);
        }
    }

    private static void createPerson() {
        Person p = new Person();
        addRecord(p);
    }

    private static void addRecord(Record p) {
        p.askQuestions();
        records.put(p.getId(), p);
        System.out.println(p);
    }


    private static void createNote() {
        Note note = new Note();
        addRecord(note);

//        note.askQuestions();
//        records.add(note);
//        System.out.println(note);
    }


    public static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")) {

            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    String str = String.join("", result);
                    return str.substring(1, str.length() - 1);
                }
                word = scanner.next();
            } while (true);
        } else {
            return word;
        }
    }

    private static String askPhone() {
        while (true) {
            String phone = askString();
            // checking if there any characters expect digits, spaces, pluses and dashes
            if (phone.chars().anyMatch(c -> !Character.isDigit(c) && c != ' ' && c != '+' && c != '-')) {
                System.out.println("Only digits, spaces, plus and dash are allowed!");
                continue;
            }
            // checking how many digits in the entered number (excluding spaces and other non-digits)
            if (phone.chars().filter(Character::isDigit).count() < 5) {
                System.out.println("At least 5 digits in phone number");
                continue;
            }
            // validation passed
            return phone;
        }
    }

    public static LocalDate askDate() {
        String d = askString();
        LocalDate date = LocalDate.parse(d, DATE_FORMATTER);
        return date;
    }

    public static LocalTime askTime() {
        String t = askString();
        LocalTime time = LocalTime.parse(t, TIME_FORMATTER);
        return time;
    }


}
