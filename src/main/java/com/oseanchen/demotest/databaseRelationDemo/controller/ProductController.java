package com.oseanchen.demotest.databaseRelationDemo.controller;

import com.oseanchen.demotest.databaseRelationDemo.entity.Product;
import com.oseanchen.demotest.databaseRelationDemo.entity.ProductDTO;
import com.oseanchen.demotest.databaseRelationDemo.entity.ProductDetails;
import com.oseanchen.demotest.databaseRelationDemo.entity.ProductsDetailsDTO;
import com.oseanchen.demotest.databaseRelationDemo.repository.ProductDetailsRepository;
import com.oseanchen.demotest.databaseRelationDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/productDetails")
    public List<ProductDetails> getAllProductDetails() {
        return productDetailsRepository.findAll();
    }


    @GetMapping("/productsDTO")
    public List<ProductDTO> getProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());

            ProductsDetailsDTO productDetailsDTO = new ProductsDetailsDTO();
            productDetailsDTO.setDeveloper(product.getProductDetails().getDeveloper());
            productDetailsDTO.setPublisher(product.getProductDetails().getPublisher());
            productDetailsDTO.setReleaseDate(product.getProductDetails().getReleaseDate());
            productDetailsDTO.setLanguageSupport(product.getProductDetails().getLanguageSupport());

            productDTO.setProductDetail(productDetailsDTO);

            productDTOList.add(productDTO);
        }
        return productDTOList;
    }


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
