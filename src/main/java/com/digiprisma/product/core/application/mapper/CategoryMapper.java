package com.digiprisma.product.core.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.digiprisma.product.api.dto.CategoryDto;
import com.digiprisma.product.core.domain.Category;
import com.digiprisma.product.persistence.model.CategoryDpo;

/**
 * 
 * @author SKAN
 *
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

   CategoryDto toTransferObject(Category source);

   List<CategoryDto> toTransferObject(List<Category> source);
   
   Category toDomaineObject(CategoryDpo source);

   List<Category> toDomaineObject(List<CategoryDpo> source);
   
   Category toDomaineObjectFromDto(CategoryDto source);

	List<Category> toDomaineObjectFromDto(List<CategoryDto> source);
   
   CategoryDpo toDpoObject(Category source);

	List<CategoryDpo> toDpoObject(List<Category> source);
   
   
}
