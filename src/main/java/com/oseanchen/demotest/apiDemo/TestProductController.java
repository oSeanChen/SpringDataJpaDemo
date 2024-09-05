package com.oseanchen.demotest.apiDemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test/products")
public class TestProductController {
    // 新增產品
    @PostMapping
    public String createProduct() {
        return "成功新增產品";
    }

    // 查詢單一產品
    @GetMapping("/{id}")
    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProduct() {
        return "成功查詢產品";
    }

    // 更新產品
    @PutMapping("/{id}")
    public String updateProduct() {
        return "成功更新產品";
    }

    // 刪除產品
    @DeleteMapping("/{id}")
    public String deleteProduct() {
        return "成功刪除產品";
    }
}
