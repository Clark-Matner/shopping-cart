package src.main.models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item){
        if (this.items.contains(item)){
            return false;
        }
        this.items.add(new Item(item));
        return true;
    }

    public boolean contains(Item item){
        return this.items.contains(item);

    }

    public void remove(String name){
        this.items.removeIf((item) -> {
            return item.getName().equals(name);
        });

    }

    public double getTax(double subtotal){
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(subtotal * 0.13));
    }

    public double getTotal(double tax, double subtotal){
        return subtotal + tax;

    }

 

    public double getSubtotal(){
        return this.items.stream()
        .mapToDouble((item) -> {
            return item.getPrice();
        })
        .sum();
        
        
    }


    
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
