import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Store> storeList = new ArrayList<>();

    public void addNewStore(Store store){

        storeList.add(store);
    }

    public Store getStore(int i){
        if(i < 0 || i >= storeList.size())
            return null;
        return storeList.get(i);
    }

    public int getStoreCount(){return storeList.size();}

    public void findGoodsByName(String name){
        System.out.println("Search result:\n");

        for(int i=0;i<storeList.size();i++){
            for(int j=0;j<storeList.get(i).getGoodsCount();j++){
                Good good = storeList.get(i).getGood(j);
                if(good.getName().equals(name)) {
                    System.out.println((i + 1) + ". Store: " + storeList.get(i).getName());
                    System.out.println("   Name: " + good.getName());
                    System.out.println("   Number: " + good.getNumber());
                    System.out.println("   Price: " + good.getPrice());
                    System.out.println("   Count: " + good.getCount() + "\n");
                }
            }
        }
    }
    public void printSumsOfGood(String name){
        System.out.println("Search result:\n");

        for(int i=0;i<storeList.size();i++){
            for(int j=0;j<storeList.get(i).getGoodsCount();j++){
                Good good = storeList.get(i).getGood(j);

                if(good.getName().equals(name)) {
                    System.out.println((i + 1) + ". Store: " + storeList.get(i).getName());
                    System.out.println("   Name: " + good.getName());
                    System.out.println("   Sum: " + good.getPrice() * good.getNumber() + "\n");
                }
            }
        }
    }

    public void findCheapestGood(String name){
        System.out.println("Search result:\n");

        double min = Double.MAX_VALUE;
        Store store = null;

        for(int i=0;i<storeList.size();i++){
            for(int j=0;j<storeList.get(i).getGoodsCount();j++){
                Good good = storeList.get(i).getGood(j);

                if(good.getName().equals(name) && good.getPrice() < min){
                    min = good.getPrice();
                    store = storeList.get(i);
                }
            }
        }

        if(store!=null){
            System.out.println("Store: " + store.getName());
            System.out.println("Address: " + store.getAddress());
        }
        else {
            System.out.println("Cant find!");
        }
    }

    public void deleteGoodsByPrice(double price){
        for(int i=0;i<storeList.size();i++){
            for(int j=0;j<storeList.get(i).getGoodsCount();j++){
                Good good = storeList.get(i).getGood(j);
                if(good.getPrice() == price){
                    storeList.get(i).deleteGood(j);
                    j--;
                }
            }
        }
    }

}