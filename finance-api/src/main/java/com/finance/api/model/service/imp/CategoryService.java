package com.finance.api.model.service.imp;

import com.finance.api.model.DTO.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDTO> findAllCategory();
}
