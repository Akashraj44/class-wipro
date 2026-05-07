package AAKASH_HOTEL;
import java.sql.*;
import java.util.Scanner;

public class FoodService {

    public static void orderFood(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            
            System.out.println("Enter Customer ID:");
            int cid = sc.nextInt();

            while(true) {

                System.out.println("\n------ FOOD MENU ------");

                System.out.println("1. Pizza        250");
                System.out.println("2. Burger       120");
                System.out.println("3. Pasta        180");
                System.out.println("4. Sandwich     100");
                System.out.println("5. Coffee        80");
                System.out.println("6. Tea           40");
                System.out.println("7. Biryani      220");
                System.out.println("8. Chowmein     150");
                System.out.println("9. Ice Cream     90");
                System.out.println("10. Cold Drink   60");

                System.out.println("-----------------------");

                System.out.println("Enter Food ID:");
                int foodId = sc.nextInt();

                String foodName = "";
                int price = 0;

                switch(foodId) {

                    case 1:
                        foodName = "Pizza";
                        price = 250;
                        break;

                    case 2:
                        foodName = "Burger";
                        price = 120;
                        break;

                    case 3:
                        foodName = "Pasta";
                        price = 180;
                        break;

                    case 4:
                        foodName = "Sandwich";
                        price = 100;
                        break;

                    case 5:
                        foodName = "Coffee";
                        price = 80;
                        break;

                    case 6:
                        foodName = "Tea";
                        price = 40;
                        break;

                    case 7:
                        foodName = "Biryani";
                        price = 220;
                        break;

                    case 8:
                        foodName = "Chowmein";
                        price = 150;
                        break;

                    case 9:
                        foodName = "Ice Cream";
                        price = 90;
                        break;

                    case 10:
                        foodName = "Cold Drink";
                        price = 60;
                        break;

                    default:
                        System.out.println("Invalid Food ID");
                        continue;
                }

                String sql =
                "insert into food(customer_id,food_name,price) values(?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, cid);
                ps.setString(2, foodName);
                ps.setInt(3, price);

                ps.executeUpdate();

                System.out.println(foodName + " Ordered Successfully");

               
                while(true) {

                    System.out.println("Want More Food ? yes/no");

                    sc.nextLine();
                    String choice = sc.nextLine();

                    if(choice.equalsIgnoreCase("yes")) {

                        break;
                    }

                    else if(choice.equalsIgnoreCase("no")) {

                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery(
                        "select * from food where customer_id=" + cid);

                        int total = 0;

                        System.out.println("\n------ FINAL BILL ------");

                        System.out.println("Customer ID : " + cid);

                        while(rs.next()) {

                            System.out.println( rs.getString("food_name") + " = "+ rs.getInt("price"));

                            total = total + rs.getInt("price");
                        }

                        System.out.println("------------------------");

                        System.out.println("Total Bill : " + total);
                        System.out.println("Thanks for ordering food Enjoy your meal");

                        System.out.println("------------------------");

                        return;
                    }

                    else {

                        System.out.println("Invalid Input");
                    }
                }
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}