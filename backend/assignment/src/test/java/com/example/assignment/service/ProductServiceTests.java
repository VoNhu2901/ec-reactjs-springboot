package com.example.assignment.service;

import com.example.assignment.data.entities.Product;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.data.repositories.ProductImageRepository;
import com.example.assignment.data.repositories.ProductRepository;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private ProductServiceImpl productService;

    private CategoryRepository categoryRepository;
    private ProductImageRepository productImageRepository;

    Optional<Product>  productOptional;

    @BeforeEach
    void setUp() {
        Product product=new Product();
        product.setProId(1);
        productOptional=Optional.of(product);
        productRepository = mock(ProductRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        productImageRepository = mock(ProductImageRepository.class);
        modelMapper = mock(ModelMapper.class);
        productService = new ProductServiceImpl(productRepository, modelMapper, categoryRepository, productImageRepository);
    }

    @Test
    public void findProductById_WhenRequestValid_ExpectReturnProduct(){
        ProductResponseDto productDto=mock(ProductResponseDto.class);
        when(productRepository.findById(anyInt())).thenReturn(productOptional);
        when(modelMapper.map(productOptional.get(),ProductResponseDto.class)).thenReturn(productDto);
        assertEquals(productDto,productService.getProductById(anyInt()));
    }

    @Test
    public void updateProduct_WhenRequestValid_ExpectReturnProductAfterUpdate(){
        ProductCreateDto productCreateDto=mock(ProductCreateDto.class);
        modelMapper.map(productCreateDto,productOptional.get());
//        productOptional.get().setUpdateDate(new Date());
        Product product=mock(Product.class);
        when(productRepository.save(productOptional.get())).thenReturn(product);
        when(productRepository.findById(anyInt())).thenReturn(productOptional);
//        assertEquals(modelMapper.map(product,ProductResponseDto.class),productService.updateProduct(anyInt(),productCreateDto));
    }

}
