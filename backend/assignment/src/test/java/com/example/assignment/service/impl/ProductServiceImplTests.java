package com.example.assignment.service.impl;

import com.example.assignment.data.entities.Product;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.data.repositories.ProductImageRepository;
import com.example.assignment.data.repositories.ProductRepository;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTests {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ModelMapper modelMapper;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ProductImageRepository productImageRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    Product product;

    ProductResponseDto expected;

    ProductCreateDto request;

    @BeforeEach
    public void setUp() {
        product = mock(Product.class);

        expected = mock(ProductResponseDto.class);

        request = mock(ProductCreateDto.class);
    }

    @DisplayName("Test getAllProduct")
//    @Test
//    public void getAllProduct_When_RequestValid_Expect_ReturnListProduct(){
//        List<Product> productList = new ArrayList<>();
//        when(productRepository.findAll()).thenReturn(productList);
//        List<ProductResponseDto> expectedList = new ArrayList<>();
//        for(int i = 0; i<5;i++){
//            expectedList.add(expected);
//        }
//        when(modelMapper.map(product, ProductResponseDto.class)).thenReturn(expected);
////        verify(expected).setRate(0.0);
//        List<ProductResponseDto> actual = productServiceImpl.getAllProduct();
//        assertThat(actual, is(equalTo(expectedList)));
//    }

    @Test
    public void getAllProduct_When_RequestInValid_Then_ThrowsExceptionNotFound() {
        when(productRepository.findAll()).thenReturn(null);
        ResourceNotFoundException e = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> productServiceImpl.getAllProduct());
        assertThat(e.getMessage(), is("Product.list.not.found"));
    }


    @DisplayName("Test getProductById")
    @Test
    public void getProductById_Given_ValidProductId_When_GetProductById_Expect_ThrowsExceptionNotFound() {
        when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product));
        when(modelMapper.map(product, ProductResponseDto.class)).thenReturn(expected);
        ProductResponseDto actual = productServiceImpl.getProductById(1);
        assertThat(actual, is(equalTo(expected)));
    }


    @Test
    public void getProductById_Given_InvalidProductId_When_GetProductById_Then_ThrowsExceptionNotFound() {
        when(productRepository.findById(1)).thenReturn(Optional.ofNullable(null));
        assertThrows(ResourceNotFoundException.class, () -> {
            productServiceImpl.getProductById(1);
        });
    }

    @DisplayName("Test createNewProduct")
    @Test
    public void createNewProduct_When_RequestValid_Expect_ReturnProductAfterCreate(){
        //new data for object
        ProductCreateDto dto = new ProductCreateDto();
        dto.setName("PRO");
        dto.setPrice(12);
        dto.setDescription("jfhd");
        dto.setAmount(2);
        dto.setCategoryId(1);
        String[] array = new String[] {"element1","element2","element3"};
        dto.setImages(array);
        when(categoryRepository.findById(1)).thenReturn(Optional.empty());
        when(productRepository.save(product)).thenReturn(product);

        when(modelMapper.map(dto, Product.class)).thenReturn(product);
        when(modelMapper.map(product, ProductResponseDto.class)).thenReturn(expected);

        ProductResponseDto actual = productServiceImpl.createNewProduct(dto);
        assertThat(actual.getName(), is(expected.getName()));
    }

    @Test
    public void createNewProduct_Given_InvalidCategoryId_Then_ThrowsExceptionNotFound(){
        when(categoryRepository.findById(1)).thenReturn(null);
        assertThrows(ResourceNotFoundException.class,() -> {
            productServiceImpl.createNewProduct(request);
        });
    }

//    @DisplayName("Test updateProduct")
//    @Test
//    public void updateProduct_When_RequestValid_Expect_ReturnProductAfterUpdate() {
//        //new data for object
//        ProductCreateDto dto = new ProductCreateDto();
//                dto.setName("PRO");
//        dto.setPrice(12);
//        dto.setDescription("jfhd");
//        dto.setAmount(2);
//        dto.setCategoryId(1);
//        String[] array = new String[] {"element1","element2","element3"};
//        dto.setImages(array);
//
//    }

}
