package com.finalback;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bean.Product;
import com.bean.User;
import com.controller.CartItemController;
import com.controller.OrderController;
import com.controller.ProductController;
import com.dao.CartItemDao;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.service.CartItemService;
import com.service.OrderService;
import com.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(MockitoJUnitRunner.class)
//@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@WebMvcTest(CartItemController.class)
@AutoConfigureMockMvc
public class newtest {
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer();

    // a mocked http server
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CartItemService cartItemService;

    @Mock
    private CartItemDao cartItemDao;
    @Mock
    private UserDao userDao;

    @MockBean
    private CartItemController cartItemController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @WithMockUser
    @Test
    public void testGetCartItem() throws Exception {
        User u1 = new User(1, "testname", "testpass", null,null,null);
        when(userDao.findByUsername("testname")).thenReturn(u1);





    }




}
