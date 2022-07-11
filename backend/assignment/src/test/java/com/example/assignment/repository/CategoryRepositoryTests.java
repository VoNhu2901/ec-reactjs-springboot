package com.example.assignment.repository;

import com.example.assignment.data.entities.Category;
import com.example.assignment.data.repositories.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;

    @BeforeEach
    public void setUp() {
       category = new Category(1,"Bat","hjkdf");
    }
    @AfterEach
    public void tearDown() {
        categoryRepository.deleteAll();
        category = null;
    }

    @Test
    public void givenProduct_ToAddShould_ReturnAddedProduct(){
        categoryRepository.save(category);
        Category fetchedCategory = categoryRepository.findById(category.getId()).get();
        assertEquals(1, fetchedCategory.getId());
    }

//    @Test
//    void saveAll_WhenRequestValid_ReturnListProduct() {
//        List<Category> categories = Arrays.asList(
//                new Category("mat na", "cac san pham"),
//                new Category("kem danh rang", "cac san pham"),
//                new Category("sua tam", "cac san pham")
//        );
//        Iterable<Category> allCategory = categoryRepository.saveAll(categories);
//
//        AtomicInteger validIdFound = new AtomicInteger();
//        allCategory.forEach(customer -> {
//            if(customer.getId()>0){
//                validIdFound.getAndIncrement();
//            }
//        });
//
//        assertThat(validIdFound.intValue()).isEqualTo(3);
//    }
//
//    @Test
//    void findAll_WhenRequestValid_ReturnListProduct() {
//        List<Category> allCategory = categoryRepository.findAll();
//        assertThat(allCategory.size()).isGreaterThanOrEqualTo(0);
//    }
}
