package com.example.assignment.service;

import com.example.assignment.data.entities.Product;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.data.repositories.ProductImageRepository;
import com.example.assignment.data.repositories.ProductRepository;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTests {
    @Mock
    private ProductRepository productRepository;
    @Mock private ModelMapper modelMapper;

    @Mock private CategoryRepository categoryRepository;
    @Mock private ProductImageRepository productImageRepository;

    @InjectMocks private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findProductById_WhenRequestValid_ExpectReturnProduct(){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProId(1);

        Product product = new Product();
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(modelMapper.map(product,ProductResponseDto.class)).thenReturn(productResponseDto);

        ProductResponseDto result = productService.getProductById(1);

        assertThat(result,is(productResponseDto));
        assertEquals(productResponseDto,result);
    }

//    @Test
//    public void updateProduct_WhenRequestValid_ExpectReturnProductAfterUpdate(){
//        ProductCreateDto productCreateDto= new ProductCreateDto();
//
//        ProductResponseDto productResponseDto = new ProductResponseDto();
//        Product product = new Product();
//        when(modelMapper.map(product,ProductResponseDto.class)).thenReturn(productResponseDto);
//
//        product.setUpdateDate(new Date());
//        when(productRepository.save(product)).thenReturn(product);
//        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
//
//
//        assertEquals(modelMapper.map(product,ProductResponseDto.class),productService.updateProduct(anyInt(),productCreateDto));
//    }



}
