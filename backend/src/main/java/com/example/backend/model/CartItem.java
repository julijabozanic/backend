package com.example.backend.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class CartItem {

    @Id
    private String id;

    @NotNull(message = "Product must not be null.")
    private Product product;

    @Min(value = 1, message = "Quantity must be at least 1.")
    private int quantity;

    @NotNull(message = "User ID must not be null.")
    private String userId;

    public CartItem() {}

    public CartItem(String id, Product product, int quantity, String userId) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.userId = userId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}