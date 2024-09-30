package com.oseanchen.demotest.junit;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 使用實際的資料庫
public class ProductTestServiceTest {

    @Autowired
    private ProductTestService productTestService;

    @Test
    @Transactional
    public void testReadExistingProduct() {
        // 假設資料庫已經有 "Switch 2" 這筆資料
        Optional<ProductTest> retrievedProduct = productTestService.getProductById(1L); // 假設 ID 是 1
        assertTrue(retrievedProduct.isPresent());
        assertEquals(11999.99, retrievedProduct.get().getPrice());
        assertEquals("任天堂熱門的手持遊戲機", retrievedProduct.get().getDescription());
    }

    @Test
    @Transactional
    public void testUpdateExistingProduct() {
        // 假設資料庫已經有 "PlayStation 5 pro" 這筆資料
        Optional<ProductTest> productOptional = productTestService.getProductById(2L); // 假設 ID 是 2
        assertTrue(productOptional.isPresent());

        ProductTest productTest = productOptional.get();
        productTest.setPrice(23999.99);
        productTest.setDescription("索尼的次世代遊戲主機 - 降價促銷");

        ProductTest updatedProductTest = productTestService.saveProduct(productTest);

        assertEquals(23999.99, updatedProductTest.getPrice());
        assertEquals("索尼的次世代遊戲主機 - 降價促銷", updatedProductTest.getDescription());
    }

    @Test
    @Transactional
    public void testDeleteExistingProduct() {
        // 假設資料庫已經有 "Dell XPS 13" 這筆資料
        Optional<ProductTest> productOptional = productTestService.getProductById(3L); // 假設 ID 是 3
        assertTrue(productOptional.isPresent());

        ProductTest productTest = productOptional.get();
        Long productId = productTest.getId();

        productTestService.deleteProduct(productId);

        Optional<ProductTest> deletedProduct = productTestService.getProductById(productId);
        assertFalse(deletedProduct.isPresent());
    }

    @Test
    @Transactional
    public void testCreateNewProduct() {
        // 新增一個新的產品
        ProductTest productTest = new ProductTest();
        productTest.setName("三星 Galaxy S22");
        productTest.setPrice(20999.99);
        productTest.setDescription("三星旗艦智慧型手機");

        ProductTest savedProductTest = productTestService.saveProduct(productTest);

        assertNotNull(savedProductTest);
        assertNotNull(savedProductTest.getId());
        assertEquals("三星 Galaxy S22", savedProductTest.getName());
    }
}