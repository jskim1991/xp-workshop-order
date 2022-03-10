package xp.workshop.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xp.workshop.order.domain.Order;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderControllerTests {

    private MockMvc mockMvc;
    private StubOrderRepository stubOrderRepository;

    @BeforeEach
    void setUp() {
        stubOrderRepository = new StubOrderRepository();
        mockMvc = MockMvcBuilders
                .standaloneSetup(new OrderController(stubOrderRepository))
                .build();
    }

    @Test
    void getOrders_isOk() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void getOrders_returnsOrderList() throws Exception {
        stubOrderRepository.setFindAll_returnValue(Collections.singletonList(new Order("1", 5)));


        mockMvc.perform(get("/orders"))
                .andExpect(jsonPath("$.[0].id", equalTo("1")))
                .andExpect(jsonPath("$.[0].totalPrice", equalTo(5)));
    }
}



