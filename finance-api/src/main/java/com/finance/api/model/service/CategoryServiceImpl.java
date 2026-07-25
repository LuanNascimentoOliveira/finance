package com.finance.api.model.service;

import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.mapper.CategoryMapper;
import com.finance.api.model.service.imp.CategoryService;
import com.finance.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }
}
