package com.finalback;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.bean.Product;
import com.controller.ProductController;
import com.dao.ProductDao;
import com.http.Response;
import com.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;
import org.assertj.core.api.Assertions.*;
import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@WebMvcTest(value = ProductController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//@ContextConfiguration(classes = { ProductController.class })
@RunWith(MockitoJUnitRunner.class)
//@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOfGetAll() throws Exception {
        Product p1 = new Product(1, "name1", "5", "des1","pic1","show");
        Product p2 = new Product(2, "name2", "15", "des2","pic2","show");
        Product p3 = new Product(3, "name3", "25", "des3","pic3","show");
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
//        MockitoAnnotations.initMocks(this);
        when(productDao.findAll()).thenReturn(products);
        Assertions.assertEquals(productController.getproduct().size(),3);

        when(productController.getproduct()).thenReturn(products);
        Assertions.assertEquals(productController.getproduct().get(0).getProductname(),"name1");

        when(productDao.findProductById(1)).thenReturn(p1);
        Assertions.assertEquals(productDao.findProductById(1),p1);

    }

    @Test
    public void testofgetbyname() throws Exception{
        Product p1 = new Product(1, "name1", "5", "des1","pic1","show");
        Product testp = new Product(1, "name2", "3", "des4","pic1","show");
        Product testp2 = new Product(2, "name2", "3", "des4","pic1","show");
        when(productDao.findProductById(1)).thenReturn(p1);
//        when(productDao.findProductById(2)).thenReturn(testp2);
        Response r = productService.changeProduct(testp);
        Assertions.assertEquals(r.isSuccess(), true);

        Response r2 = productService.changeProduct(testp2);
        Assertions.assertEquals(r2.isSuccess(), false);



    }



}

//    // JUnit test for saveEmployee method
//    @DisplayName("JUnit test for saveEmployee method")
//    @Test
//    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() throws Exception {
//        Product p1 = new Product(1, "name1", "5", "des1","pic1","show");
//        Product p2 = new Product(2, "name2", "15", "des2","pic2","show");
//        Product p3 = new Product(3, "name3", "25", "des3","pic3","show");
//        List<Product> products = new ArrayList<>();
//        products.add(p1);
//        products.add(p2);
//        products.add(p3);
//        Mockito.when(productService.test()).thenReturn(products);
//        List<Product> ls = productController.test();
//        assertEquals(3, ls.size());
//
//
//    }




//
//@WebMvcTest
//@ContextConfiguration(classes = ProductController.class)
//@AutoConfigureMockMvc()
//@RunWith(SpringRunner.class)
//public class ProductControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private ProductController productController;
//
//    @InjectMocks
//    private ProductService productService;
//
//    @MockBean
//    private ProductDao productDao;
//
//    private Product p1, p2, p3;
//
//
//    @Test
//    @WithMockUser("spring")
//    public void testShowall() throws Exception{
//        p1 = new Product(1, "name1", "5", "des1","pic1","show");
//        p2 = new Product(2, "name2", "15", "des2","pic2","show");
//        p3 = new Product(3, "name3", "25", "des3","pic3","show");
//        List<Product> products = new ArrayList<>();
//        products.add(p1);
//        products.add(p2);
//        products.add(p3);
//        Mockito.when(productService.test()).thenReturn(products);
//        List<Product> ls = productController.test();
//        assertEquals(3, ls.size());
//
//
//    }


//    @Test
//    public void testAdd() throws Exception {
//        when(productDao.save(p3)).thenReturn(p3);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.productname", is("name3")));
//
//    }






