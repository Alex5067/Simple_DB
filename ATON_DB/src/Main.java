import java.util.Scanner;
import record.Record;
import cache.Cache;

public class Main {
    public static void main(String[] args) {
        Cache cache = new Cache();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter command (add, remove, update, Get_by_account, Get_by_name, Get_by_value, Show_all, Exit): ");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    System.out.println("Enter account: ");
                    long account = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter value: ");
                    double value = scanner.nextDouble();
                    scanner.nextLine();
                    Record record = new Record(account, name, value);
                    cache.add(record);
                    break;
                case "remove":
                    System.out.println("Enter account: ");
                    long accountToRemove = scanner.nextLong();
                    scanner.nextLine();
                    cache.remove(accountToRemove);
                    break;
                case "update":
                    System.out.println("Enter account: ");
                    long accountToUpdate = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter value: ");
                    double newValue = scanner.nextDouble();
                    scanner.nextLine();
                    cache.update(accountToUpdate, newName, newValue);
                    break;
                case "Get_by_account":
                    System.out.println("Enter account: ");
                    long accountToGet = scanner.nextLong();
                    scanner.nextLine();
                    cache.get_by_Account(accountToGet);
                    break;
                case "Get_by_name":
                    System.out.println("Enter name: ");
                    String nameToGet = scanner.nextLine();
                    cache.get_by_Name(nameToGet);
                    break;
                case "Get_by_value":
                    System.out.println("Enter value: ");
                    double valueToGet = scanner.nextDouble();
                    scanner.nextLine();
                    cache.get_by_Value(valueToGet);
                    break;
                case "Show_all":
                    cache.show_AllRecords();
                    break;
                case "Exit":
                    System.out.println("Exit...");
                    System.exit(1);
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
