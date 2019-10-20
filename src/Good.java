public class Good {
    private String name;
    private int number;
    private double price;
    private int count;

    public Good(String name,int number,double price,int count){
        this.name = name;
        this.number = number;
        this.price = price;
        this.count = count;
    }

    public String getName(){return name;}
    public int getNumber(){return number;}
    public double getPrice(){return price;}
    public int getCount(){return count;}

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        if(number > 0)
            this.number = number;
    }
    public void setPrice(int price){
        if(price > 0)
            this.price = price;
    }
}
