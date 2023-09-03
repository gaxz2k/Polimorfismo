import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> productList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            System.out.println("Product #" + i + " data");
            System.out.print("Common, used or imported (c/u/i)? ");
            char c = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (c == 'c'){
               productList.add(new Product(name, price));
            } else if (c == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                productList.add(new UsedProduct(name,price,date));
            } else {
                System.out.print("Customs fee: ");
                Double customs = sc.nextDouble();
                productList.add(new ImportedProduct(name,price,customs));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product product : productList){
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}