package com.example.assignment.controller;


import com.example.assignment.controllers.CategoryController;
import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;
import com.example.assignment.services.CategoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoryService categoryService;

    private CategoryCreateDto category;
    private List<CategoryCreateDto> categoryCreateDtoList;
    //    @InjectMocks
//    private CategoryController categoryController;

    @BeforeEach
    public void setup() {
        category = new CategoryCreateDto("name", "desc");
        categoryCreateDtoList = Arrays.asList(category);
    }

    @AfterEach
    void tearDown() {
        category = null;
    }

//    @Test
//    public void postCategory_WhenRequestValid_ExpectReturnAddedCategory() throws Exception {
//        CategoryCreateDto dto = new CategoryCreateDto("name", "desc");
////        when(categoryService.createNewCategory(any())).thenReturn(dto);
//        mockMvc.perform(post("/api/v1/category")
//                        .contentType(MediaType.APPLICATION_JSON)) // Thực hiện post REQUEST
//                .content(dto))
//                .andExpect(status().isCreated());
//        verify(categoryService, times(1)).createNewCategory(any());
//    }

    @Test
    public void findAll_WhenRequestValid_ExpectReturnListCategory() throws Exception {
        // Tạo ra một List<Category> 10 phần tử
        List<CategoryResponseDto> allCategories = IntStream.range(0, 10)
                .mapToObj(i -> new CategoryResponseDto(i, "title-" + i, "desc-" + i))
                .collect(Collectors.toList());

        // giả lập categoryService trả về List mong muốn
        given(categoryService.getAllCategory()).willReturn(allCategories);

        mockMvc.perform(get("/api/v1/category").contentType(MediaType.APPLICATION_JSON)) // Thực hiện GET REQUEST
                .andExpect(status().isOk()) // Mong muốn Server trả về status 200
                .andExpect(jsonPath("$", hasSize(10))); // Hi vọng server trả về List độ dài 10
//                .andExpect(jsonPath("$[0].id", is(0))) // Hi vọng phần tử trả về đầu tiên có id = 0
//                .andExpect(jsonPath("$[0].title", is("title-0"))) // Hi vọng phần tử trả về đầu tiên có title = "title-0"
//                .andExpect(jsonPath("$[0].detail", is("detail-0")));
    }

}
