import java.util.Scanner;

public class Main {
    public static void printStoresList(Database database){
        System.out.println("Stores list:\n");

        for(int i = 0;i<database.getStoreCount();i++){
            System.out.println((i+1) + "." + database.getStore(i).getName());
        }
    }

    public static void printGoodsList(Store store){
        System.out.println("Goods list in " + store.getName() + " store:\n");

        for(int i=0;i<store.getGoodsCount();i++){
            Good good = store.getGood(i);
            System.out.print((i+1) + ". Name: " + good.getName());
            System.out.println("   Number: " + good.getNumber());
            System.out.println("   Price: " + good.getPrice());
            System.out.println("   Count: " + good.getCount() + "\n");
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        while(true){
            System.out.println("\n\nMenu:");
            System.out.println("1 - Add new store");
            System.out.println("2 - Add new good");
            System.out.println("3 - Print goods list");
            System.out.println("4 - Print goods by name");
            System.out.println("5 - Print sums of goods");
            System.out.println("6 - Find cheapest good");
            System.out.println("7 - Delete goods by price");
            System.out.println("0 - Exit");
            System.out.print("\n > ");

            int menu = scanner.nextInt();

            if(menu == 0){
                break;
            }
            else if(menu == 1){
                System.out.println("Input store`s name > ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.println("Input store`s address > ");
                String address = scanner.nextLine();

                database.addNewStore(new Store(name,address));
            }
            else if(menu == 2){
                printStoresList(database);

                System.out.print("Input number of store > ");
                int n = scanner.nextInt();

                if(n < 1 || n > database.getStoreCount()){
                    System.out.println("Error!");
                    continue;
                }

                System.out.print("Input good`s name > ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.print("Input good`s number > ");
                int number = scanner.nextInt();

                System.out.println("Input good`s price > ");
                double price = scanner.nextDouble();

                System.out.println("Input good`s count > ");
                int count = scanner.nextInt();

                database.getStore(n-1).addGood(new Good(name,number,price,count));
            }
            else if(menu == 3){
                printStoresList(database);

                System.out.println("Input store > ");
                int n = scanner.nextInt();

                if(n < 1 || n > database.getStoreCount()){
                    System.out.println("Error!");
                    continue;
                }

                printGoodsList(database.getStore(n-1));
            }
            else if(menu == 4){
                System.out.println("Input name of good > ");
                scanner.nextLine();
                String name = scanner.nextLine();

                database.findGoodsByName(name);
            }
            else if(menu == 5){
                System.out.println("Input name of good > ");
                scanner.nextLine();
                String name = scanner.nextLine();

                database.printSumsOfGood(name);
            }
            else if(menu == 6){
                System.out.println("Input name of good > ");
                scanner.nextLine();
                String name = scanner.nextLine();

                database.findCheapestGood(name);
            }
            else if(menu == 7){
                System.out.println("Input price > ");
                double price = scanner.nextDouble();

                database.deleteGoodsByPrice(price);
            }
        }

    }
}
