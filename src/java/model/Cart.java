/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

//khi nao lam bat cu dieu gi thi phai nhin tu dau den cuoi
/**
 *
 * @author Admin
 */
public class Cart {
    private List<Item> items;
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    
    public Cart(List<Item> items) {
        this.items = items;
    }
    
    private Item getItemById(int id) {
        for (Item i : items) {
            if(i.getProduct().getId() == id)
                return i;
        }
        return null; 
    }
    
    public Item getItemByIdTest() {
        for (Item i : items) {
            if(i.getProduct().getId() == 1)
                return i;
        }
        return null; 
    }
    
    public int getQuantityById(int id){
        return getItemById(id).getQuantity(); 
    }
    
    //them vao cart
    
    public void addItem (Item t) {
        // da co cart roi
        if(getItemById(t.getProduct().getId()) != null) {
            Item i = getItemById(t.getProduct().getId());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            // chua co item
            items.add(t);
        } 
    }
    
    public void removeItem(int id) {
        if(getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    
    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += i.getQuantity()*i.getPrice();
        }
        
        return t;
    }
}
