import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private String address;
    private List<Good> goodList = new ArrayList<>();


    public Store(String name,String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getGoodsCount(){
        return goodList.size();
    }

    public Good getGood(int i){
        if(i < 0 || i >= goodList.size())
            return null;
        return goodList.get(i);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void addGood(Good good){
        goodList.add(good);
    }

    public void deleteGood(int i){
        goodList.remove(i);
    }
}
