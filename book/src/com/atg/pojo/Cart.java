package com.atg.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Integer totalCount;
    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new HashMap<>();

    public void addItem(CartItem cartItem){
        //items.add(cartItem);//不合适，页面会直接多出一个商品项，数量为1
        CartItem item = items.get(cartItem.getId());
        if (item==null){
            items.put(cartItem.getId(), cartItem);
        }else {
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal( item.getCount() )));
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if (cartItem!=null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            //cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal( cartItem.getCount() )) ); // 更新总金额
        }
    }

    public Cart() {
    }

    public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }

    //public void setTotalCount(Integer totalCount) {
    //    this.totalCount = totalCount;
    //}

    //public BigDecimal getTotalPrice() {
    //    return totalPrice;
    //}
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }
    //public void setTotalPrice(BigDecimal totalPrice) {
    //    this.totalPrice = totalPrice;
    //}


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
