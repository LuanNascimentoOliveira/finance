package com.finance.api.service;

import com.finance.api.builder.CategoryMother;
import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.entity.Category;
import com.finance.api.model.mapper.CategoryMapper;
import com.finance.api.model.service.CategoryServiceImpl;
import com.finance.api.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    private Category category;
    private CategoryResponseDTO categoryResponseDTO;

    @BeforeEach
    public void setUp(){
        category = CategoryMother.build();
        categoryResponseDTO = CategoryMother.buildResponseDto();
    }

    @Test
    @DisplayName("Should find all categories")
    public void find_shouldFindAllCategories(){

        List<Category> categories = List.of(category);

        when(categoryRepository.findAll()).thenReturn(categories);
        when(categoryMapper.toResponseDto(category)).thenReturn(categoryResponseDTO);

        List<CategoryResponseDTO> result = categoryServiceImpl.findAllCategory();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(categoryResponseDTO, result.get(0));
    }



}
