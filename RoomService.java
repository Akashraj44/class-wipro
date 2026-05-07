package AAKASH_HOTEL;
import java.sql.*;
import java.util.Scanner;

public class RoomService {

    public static void bookRoom(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.println("\n------ ROOM MENU ------");

            System.out.println("1. Standard Room    1000");
            System.out.println("2. Deluxe Room      2000");
            System.out.println("3. AC Room          3000");
            System.out.println("4. VIP Room         5000");
            System.out.println("5. Suite Room       7000");

            System.out.println("------------------------");

            System.out.println("Enter Customer ID:");
            int cid = sc.nextInt();

            System.out.println("Enter Room ID:");
            int roomId = sc.nextInt();

            String roomType = "";
            int price = 0;

            switch(roomId) {

                case 1:
                    roomType = "Standard Room";
                    price = 1000;
                    break;

                case 2:
                    roomType = "Deluxe Room";
                    price = 2000;
                    break;

                case 3:
                    roomType = "AC Room";
                    price = 3000;
                    break;

                case 4:
                    roomType = "VIP Room";
                    price = 5000;
                    break;

                case 5:
                    roomType = "Suite Room";
                    price = 7000;
                    break;

                default:
                    System.out.println("Invalid Room ID");
                    return;
            }

            String sql =
            "insert into rooms(customer_id,room_type,price) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cid);
            ps.setString(2, roomType);
            ps.setInt(3, price);

            ps.executeUpdate();

            System.out.println("\nRoom Booked Successfully");

            System.out.println("\n------ ROOM BILL ------");

            System.out.println("Customer ID : " + cid);
            System.out.println("Room Type   : " + roomType);
            System.out.println("Room Price  : " + price);

            System.out.println("------------------------");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}