package com.oseanchen.demotest.databaseRelationDemo.controller;

import com.oseanchen.demotest.databaseRelationDemo.entity.Product;
import com.oseanchen.demotest.databaseRelationDemo.dto.ProductDTO;
import com.oseanchen.demotest.databaseRelationDemo.entity.ProductDetails;
import com.oseanchen.demotest.databaseRelationDemo.dto.ProductsDetailsDTO;
import com.oseanchen.demotest.databaseRelationDemo.repository.ProductDetailsRepository;
import com.oseanchen.demotest.databaseRelationDemo.repository.ProductRepository;
import com.oseanchen.demotest.databaseRelationDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProdctById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/productDetails")
    public List<ProductDetails> getAllProductDetails() {
        return productDetailsRepository.findAll();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }


//    @GetMapping("/productsDTO")
//    public List<ProductDTO> getProducts() {
//        List<Product> productList = productRepository.findAll();
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        for (Product product : productList) {
//            ProductDTO productDTO = new ProductDTO();
//            productDTO.setId(product.getId());
//            productDTO.setName(product.getName());
//            productDTO.setPrice(product.getPrice());
//            productDTO.setDescription(product.getDescription());
//
//            ProductsDetailsDTO productDetailsDTO = new ProductsDetailsDTO();
//            productDetailsDTO.setDeveloper(product.getProductDetails().getDeveloper());
//            productDetailsDTO.setPublisher(product.getProductDetails().getPublisher());
//            productDetailsDTO.setReleaseDate(product.getProductDetails().getReleaseDate());
//            productDetailsDTO.setLanguageSupport(product.getProductDetails().getLanguageSupport());
//
//            productDTO.setProductDetail(productDetailsDTO);
//
//            productDTOList.add(productDTO);
//        }
//        return productDTOList;
//    }


//    @GetMapping("/productDetailsDTO")
//    public List<ProductsDetailsDTO> getProductDetails() {
//        List<ProductDetails> productDetailsList = productDetailsRepository.findAll();
//        List<ProductsDetailsDTO> productDetailsDTOList = new ArrayList<>();
//        for (ProductDetails productDetails : productDetailsList) {
//            ProductsDetailsDTO productDetailsDTO = new ProductsDetailsDTO();
//            productDetailsDTO.setDeveloper(productDetails.getDeveloper());
//            productDetailsDTO.setPublisher(productDetails.getPublisher());
//            productDetailsDTO.setReleaseDate(productDetails.getReleaseDate());
//            productDetailsDTO.setLanguageSupport(productDetails.getLanguageSupport());
//
//            ProductDTOForDetails productDTOForDetails = new ProductDTOForDetails();
//            productDTOForDetails.setProductId(productDetails.getProduct().getId());
//            productDTOForDetails.setProductName(productDetails.getProduct().getName());
//            productDetailsDTO.setProduct(productDTOForDetails);
//
//            productDetailsDTOList.add(productDetailsDTO);
//        }
//        return productDetailsDTOList;
//    }

}
