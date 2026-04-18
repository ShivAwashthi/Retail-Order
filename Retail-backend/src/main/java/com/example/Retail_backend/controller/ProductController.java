package com.example.Retail_backend.controller;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/{categoryId}")
    public Product create(@RequestBody Product p,
                          @PathVariable Long categoryId){
        return service.create(p, categoryId);
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/category/{id}")
    public List<Product> byCategory(@PathVariable Long id){
        return service.byCategory(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}