package AAKASH_HOTEL;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("👤Username:");
        String username = sc.nextLine();

        System.out.println("🔒 Password:");
        String password = sc.nextLine();

        if (!LoginService.login(username, password)) {

            System.out.println("❌ Login Failed");
            return;
        }

        while (true) {
        	System.out.println("=====================================================");
            System.out.println("          WELCOME TO AAKASH HOTEL                 ");
            System.out.println("======================================================");

            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Book Room");
            System.out.println("4. Order Food");
            System.out.println("5. Exit");

            System.out.println("Enter choice:");

            int ch = sc.nextInt();

            sc.nextLine();

            switch (ch) {

                case 1:
                    CustomerService.addCustomer(sc);
                    break;

                case 2:
                    CustomerService.viewCustomer();
                    break;

                case 3:
                    RoomService.bookRoom(sc);
                    break;

                case 4:
                    FoodService.orderFood(sc);
                    break;

                case 5:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}