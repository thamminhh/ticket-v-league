package com.example.demo_tss.entity;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {


    private String userName;

    private String orderDate;

    private double total;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

    public CartInfo() {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<CartLineInfo> getCartLines() {
        return cartLines;
    }

//    public void addProduct(ProductInfo productInfo, int quantity) {
//        CartLineInfo line = this.findLineByCode(productInfo.getCode());
//
//        if (line == null) {
//            line = new CartLineInfo();
//            line.setQuantity(0);
//            line.setProductInfo(productInfo);
//            this.cartLines.add(line);
//        }
//        int newQuantity = line.getQuantity() + quantity;
//        if (newQuantity <= 0) {
//            this.cartLines.remove(line);
//        } else {
//            line.setQuantity(newQuantity);
//        }
//    }

//    public void validate() {
//
//    }

//    public void updateProduct(String code, int quantity) {
//        CartLineInfo line = this.findLineByCode(code);
//
//        if (line != null) {
//            if (quantity <= 0) {
//                this.cartLines.remove(line);
//            } else {
//                line.setQuantity(quantity);
//            }
//        }
//    }
//
//    public void removeProduct(ProductInfo productInfo) {
//        CartLineInfo line = this.findLineByCode(productInfo.getCode());
//        if (line != null) {
//            this.cartLines.remove(line);
//        }
//    }
//
//    public boolean isEmpty() {
//        return this.cartLines.isEmpty();
//    }
//
//    public boolean isValidCustomer() {
//        return this.customerInfo != null && this.customerInfo.isValid();
//    }
//
//    public int getQuantityTotal() {
//        int quantity = 0;
//        for (CartLineInfo line : this.cartLines) {
//            quantity += line.getQuantity();
//        }
//        return quantity;
//    }
//
//    public double getAmountTotal() {
//        double total = 0;
//        for (CartLineInfo line : this.cartLines) {
//            total += line.getAmount();
//        }
//        return total;
//    }
//
//    public void updateQuantity(CartInfo cartForm) {
//        if (cartForm != null) {
//            List<CartLineInfo> lines = cartForm.getCartLines();
//            for (CartLineInfo line : lines) {
//                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
//            }
//        }
//
//    }

}