package com.example.backend.controller;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {

        List<Product> allProducts = productRepository.findAll();
        Stream<Product> stream = allProducts.stream();

        // Filtriranje po imenu
        if (name != null && !name.isEmpty()) {
            stream = stream.filter(p -> p.getName() != null &&
                    p.getName().toLowerCase().contains(name.toLowerCase()));
        }

        // Filtriranje po minimalnoj ceni
        if (minPrice != null) {
            stream = stream.filter(p -> p.getPrice() >= minPrice);
        }

        // Filtriranje po maksimalnoj ceni
        if (maxPrice != null) {
            stream = stream.filter(p -> p.getPrice() <= maxPrice);
        }

        // Sortiranje
        Comparator<Product> comparator = "price".equalsIgnoreCase(sortBy)
                ? Comparator.comparing(Product::getPrice)
                : Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER);

        List<Product> filteredSorted = stream
                .sorted(comparator)
                .collect(Collectors.toList());

        // Paginacija ručno
        int start = Math.min(page * size, filteredSorted.size());
        int end = Math.min(start + size, filteredSorted.size());
        List<Product> paginated = filteredSorted.subList(start, end);

        return ResponseEntity.ok(paginated); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }
}
