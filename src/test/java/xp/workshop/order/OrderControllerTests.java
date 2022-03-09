package xp.workshop.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderControllerTests {

    private MockMvc mockMvc;
    private SpyStubOrderRepository spyStubOrderRepository;

    @BeforeEach
    void setUp() {
        spyStubOrderRepository = new SpyStubOrderRepository();
        mockMvc = MockMvcBuilders
                .standaloneSetup(new OrderController(spyStubOrderRepository))
                .build();
    }

    @Test
    void getOrders_isOk() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void getOrders_returnsOrderList() throws Exception {
        spyStubOrderRepository.setFindAll_returnValue(Collections.singletonList(new Order("1", 5)));


        mockMvc.perform(get("/orders"))
                .andExpect(jsonPath("$.[0].id", equalTo("1")))
                .andExpect(jsonPath("$.[0].totalPrice", equalTo(5)));
    }

    @Test
    void getOrder_isOk() throws Exception {
        mockMvc.perform(get("/orders/123"))
                .andExpect(status().isOk());
    }

    @Test
    void getOrder_returnsOrder() throws Exception {
        spyStubOrderRepository.setFindOrder_returnValue(new Order("123", 55));


        mockMvc.perform(get("/orders/123"))
                .andExpect(jsonPath("$.id", equalTo("123")))
                .andExpect(jsonPath("$.totalPrice", equalTo(55)));
    }

    @Test
    void getOrder_invokesAppropriateOrderId() throws Exception {
        mockMvc.perform(get("/orders/999"));


        assertThat(spyStubOrderRepository.getFindOrder_parameter(), equalTo("999"));
        assertThat(spyStubOrderRepository.getFindOrder_calledTimes(), equalTo(1));
    }
}



