package com.finance.api.controller.category;

import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.service.imp.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDTO> findAllCategory(){
        return categoryService.findAll();
    }
}
