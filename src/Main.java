import models.Product;
import services.BusinessProductImpl;

import java.util.Scanner;

public class Main {

    static BusinessProductImpl businessProduct = new BusinessProductImpl();

    static void printMenu() {
        System.out.println("1. Show the list of products");
        System.out.println("2. Search for a product by its id");
        System.out.println("3. Add a new product to the list");
        System.out.println("4. Delete a product by id");
        System.out.println("5. Exit this program.");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("###############################################################");
        System.out.println("##### Java POO Product Management Application with Genericity ######");
        System.out.println("###############################################################");

        while (true) {
            printMenu();
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("List of products :");
                    businessProduct.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter the product ID : ");
                    long idRecherche = scanner.nextLong();
                    scanner.nextLine();
                    Product<String> produitTrouve = businessProduct.findById(idRecherche);
                    if (produitTrouve != null) {
                        System.out.println("Product found : " + produitTrouve);
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 3:
                    System.out.println("Adding a new product");
                    Product product = enterProductDetails();
                    businessProduct.add(product);
                    System.out.println("Product added successfully");
                    break;
                case 4:
                    System.out.print("Enter the ID of the product to delete : ");
                    long idSuppression = scanner.nextLong();
                    businessProduct.delete(idSuppression);
                    System.out.println("Product deleted (if existing)");
                    break;
                case 5:
                    System.out.println("Bye !");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static Product enterProductDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID : ");
        String id = String.valueOf(scanner.nextLong());
        scanner.nextLine();

        System.out.print("Name : ");
        String name = scanner.nextLine();

        System.out.print("Brand : ");
        String brand = scanner.nextLine();

        System.out.print("Price: ");
        String price = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        System.out.print("Quantity : ");
        String quantity = scanner.nextLine();

        Product product = new Product(id, name, brand, price, description, quantity);
        return product;
    }
}