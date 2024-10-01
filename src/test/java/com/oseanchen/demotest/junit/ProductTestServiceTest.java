package com.oseanchen.demotest.junit;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ProductTestServiceTest {

    @Mock
    private ProductTestDao productTestDao;

    @InjectMocks
    private ProductTestService productTestService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadMockProduct() {
        // mockProduct
        ProductTest mockProduct = new ProductTest();
        mockProduct.setId(1L);
        mockProduct.setName("Switch 2");
        mockProduct.setPrice(11999.99);
        mockProduct.setDescription("任天堂熱門的手持遊戲機");

        when(productTestDao.findById(1L)).thenReturn(Optional.of(mockProduct));

        Optional<ProductTest> product = productTestService.getProductById(1L);
        assertTrue(product.isPresent());
        assertEquals(11999.99, product.get().getPrice());
        assertEquals("任天堂熱門的手持遊戲機", product.get().getDescription());
        verify(productTestDao, times(1)).findById(1L);
    }

    @Test
    public void testUpdateMockProduct() {
        Long id = 2L;
        ProductTest mockProduct = new ProductTest();
        mockProduct.setId(id);
        mockProduct.setName("PlayStation 5 pro discount");
        mockProduct.setPrice(21999.99);
        mockProduct.setDescription("索尼的次世代遊戲主機 - 降價促銷");

        when(productTestDao.updateById(eq(id), any(ProductTest.class))).thenReturn(mockProduct);

        ProductTest updatedMockProduct = productTestService.updateProductById(id, mockProduct);

        assertNotNull(updatedMockProduct);
        assertEquals(id, updatedMockProduct.getId());
        assertEquals("PlayStation 5 pro discount", updatedMockProduct.getName());
        assertEquals(21999.99, updatedMockProduct.getPrice());
        verify(productTestDao, times(1)).updateById(eq(id), any(ProductTest.class));
    }

    @Test
    public void testDeleteMockProduct() {
        doNothing().when(productTestDao).deleteById(1L);
        productTestService.deleteProductById(1L);
        verify(productTestDao, times(1)).deleteById(1L);
    }

    @Test
    public void testCreateMockProduct() {
        // 新增一個新的產品
        ProductTest mockProduct = new ProductTest();
        mockProduct.setId(6L);
        mockProduct.setName("三星 Galaxy S22");
        mockProduct.setPrice(20999.99);
        mockProduct.setDescription("三星旗艦智慧型手機");

        when(productTestDao.save(mockProduct)).thenReturn(mockProduct);

        ProductTest savedProduct = productTestService.saveProduct(mockProduct);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("三星 Galaxy S22", savedProduct.getName());
    }
}