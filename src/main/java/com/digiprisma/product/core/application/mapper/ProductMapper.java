package com.digiprisma.product.core.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.digiprisma.product.api.dto.ProductDto;
import com.digiprisma.product.core.domain.Product;
import com.digiprisma.product.persistence.model.ProductDpo;

/**
 * 
 * @author SKAN
 *
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

   ProductDto toTransferObject(Product source);

   List<ProductDto> toTransferObject(List<Product> source);
   
   Product toDomaineObject(ProductDpo source);

   List<Product> toDomaineObject(List<ProductDpo> source);
   
   Product toDomaineObjectFromDto(ProductDto source);

	List<Product> toDomaineObjectFromDto(List<ProductDto> source);
   
   ProductDpo toDpoObject(Product source);

	List<ProductDpo> toDpoObject(List<Product> source);
   
   
}
