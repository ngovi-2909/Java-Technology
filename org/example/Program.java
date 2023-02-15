package org.example;

import java.util.List;
import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    public static Product addProduct()
    {
        System.out.println("Enter id: ");
        String id = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter price: ");
        double price = sc.nextFloat();
        Product newProduct = new Product(id, name, price);
        return newProduct;
    }
    public static void menu(){
        System.out.println("1. Read all products");
        System.out.println("2. Read detail of a product by id");
        System.out.println("3. Add a new product");
        System.out.println("4. Update a new product");
        System.out.println("5. Delete a product by id");
        System.out.println("6. Exit");
    }
    public static void main(String[] args)
    {
        if(args.length < 3)
        {
            System.out.println("Please enter database name and related information");
        }else
        {
            ProductDAO productDao = new ProductDAO();
            productDao.setConnection(args[0], args[1], args[2]);
            String choice = "";
            while(!choice.equals("6"))
            {
                menu();
                System.out.println("-----------------------------------");
                choice = sc.nextLine();
                switch(choice)
                {
                    case "1":
                        List productList = productDao.readAll();
                        for(Object i: productList)
                        {
                            System.out.println(i.toString());
                        }
                        break;
                    case "2":
                        System.out.println("Enter id of product: ");
                        String idProduct = sc.nextLine();
                        Product a = (Product) productDao.read(idProduct);
                        System.out.println(a.toString());
                        break;
                    case "3":
                        productDao.add(addProduct());
                        break;
                    case "4":
                        System.out.println(productDao.update(addProduct()));
                        break;
                    case "5":
                        System.out.println("Enter id of product: ");
                        String id = sc.nextLine();
                        System.out.println(productDao.delete(id));
                        break;
                }
            }
            productDao.closeConnection();
        }

    }
}
