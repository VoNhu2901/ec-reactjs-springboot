package com.example.assignment.service.impl;

import com.example.assignment.data.entities.Category;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;
import com.example.assignment.exceptions.ResourceAlreadyExistsException;
import com.example.assignment.services.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTests {
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ModelMapper mapper;
    @Mock
    private Category category;
    @Mock
    private CategoryCreateDto createDto;
    @Mock
    private CategoryResponseDto expect;

    @BeforeEach
    public void setUp() {
        Category.builder().id(1).name("test").description("description").createDate(new Date()).updateDate(new Date())
                .status("Active").product(null).build();

    }

    @Test
    public void createNewCategory_ShouldReturnDto_WhenDataValid() {

        //new data for object
        CategoryCreateDto dto = new CategoryCreateDto();
        dto.setCateName("test");
        dto.setCateDescription("description");

        // check repository
        when(categoryRepository.findByName("test")).thenReturn(Optional.empty());
        when(categoryRepository.save(category)).thenReturn(category);
        //map object
        when(mapper.map(dto, Category.class)).thenReturn(category);
        //map service
        when(mapper.map(category, CategoryResponseDto.class)).thenReturn(expect);

        CategoryResponseDto actual = categoryService.createNewCategory(dto);

        assertThat(actual.getDescription(), is(expect.getDescription()));
    }

    @Test
    public void createNewCategory_Given_InvalidCategoryName_Then_ThrowsExceptionNotFound(){
        when(categoryRepository.findByName("invalid")).thenReturn(null);
        assertThrows(ResourceAlreadyExistsException.class,() -> {
            categoryService.createNewCategory(createDto);
        });
    }

}