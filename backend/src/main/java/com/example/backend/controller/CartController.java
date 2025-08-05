package com.example.backend.controller;

import com.example.backend.dto.CartItemRequest;
import com.example.backend.model.CartItem;
import com.example.backend.model.Product;
import com.example.backend.repository.CartRepository;
import com.example.backend.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(
            @Valid @RequestBody CartItemRequest request
    ) {
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(request.getQuantity());
        item.setUserId(request.getUserId());
        CartItem saved = cartRepository.save(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCartContents(
            @RequestParam String userId
    ) {
        List<CartItem> items = cartRepository.findByUserId(userId);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<?> updateQuantity(
            @PathVariable String id,
            @RequestParam int quantity
    ) {
        if (quantity <= 0) {
            return ResponseEntity.badRequest().body("Quantity must be greater than 0.");
        }

        CartItem item = cartRepository.findById(id).orElse(null);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart item not found.");
        }
        item.setQuantity(quantity);
        return ResponseEntity.ok(cartRepository.save(item));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> removeItem(
            @PathVariable String id
    ) {
        if (!cartRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        cartRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
