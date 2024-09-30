package com.oseanchen.demotest.databaseRelationDemo.service;

import com.oseanchen.demotest.databaseRelationDemo.entity.Product;
import com.oseanchen.demotest.databaseRelationDemo.entity.ProductDetails;
import com.oseanchen.demotest.databaseRelationDemo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ProductServiceTest {

    //    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    public void getProdctById() {
//        Product product = productRepository.findById(1L);
//        assertNotNull(product);
//        assertEquals("最後生還者", product.getName());
//    }
//
//    @Transactional
//    @Test
//    public void deleteProductById() {
//        productRepository.deleteById(1);
//        Product product = productRepository.findById(1L);
//        assertNull(product);
//    }
//
//    @Transactional
//    @Test
//    public void saveProduct() {
//        Product product = new Product();
//        product.setId(11L);
//        product.setName("黑神話:悟空");
//        product.setPrice(40.00);
//        product.setDescription("讚!!");
//
//        ProductDetails productDetails = new ProductDetails();
//        productDetails.setId(11L);
//        productDetails.setDeveloper("遊戲科學");
//        productDetails.setPublisher("遊戲科學");
//        productDetails.setReleaseDate("2024-08-11");
//        productDetails.setLanguageSupport("English, Chinese");
//        product.setProductDetails(productDetails);
//        Product productSaved = productService.saveProduct(product);
//        Product productSavedForTest = productRepository.findById(productSaved.getId());
//        assertNotNull(productSavedForTest);
//        assertEquals("黑神話:悟空", productSavedForTest.getName());
//    }
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getProductById() {
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("最後生還者");

        when(productRepository.findById(1L)).thenReturn(mockProduct);

        Product product = productService.getProdctById(1L);
        assertNotNull(product);
        assertEquals("最後生還者", product.getName());

        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    public void deleteProductById() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProductById(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    public void saveProduct() {
        Product product = new Product();
        product.setId(11L);
        product.setName("黑神話:悟空");
        product.setPrice(40.00);
        product.setDescription("讚!!");

        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(11L);
        productDetails.setDeveloper("遊戲科學");
        productDetails.setPublisher("遊戲科學");
        productDetails.setReleaseDate("2024-08-11");
        productDetails.setLanguageSupport("English, Chinese");
        product.setProductDetails(productDetails);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product savedProduct = productService.saveProduct(product);

        assertNotNull(savedProduct);
        assertEquals("黑神話:悟空", savedProduct.getName());
        verify(productRepository, times(1)).save(any(Product.class));
    }
}