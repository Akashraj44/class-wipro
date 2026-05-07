package AAKASH_HOTEL;
import java.sql.*;
import java.util.Scanner;

public class CustomerService {

    public static void addCustomer(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.println("Enter customer name:");
            String name = sc.nextLine();

            System.out.println("Enter city:");
            String city = sc.nextLine();

            System.out.println("Enter phone:");
            String phone = sc.nextLine();

            String sql =
                    "insert into customer(name,city,phone) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, phone);

            ps.executeUpdate();

            System.out.println("Customer Added");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void viewCustomer() {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "select * from customer";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ID  Name  City  Phone");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("name") + " "
                                + rs.getString("city") + " "
                                + rs.getString("phone"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}