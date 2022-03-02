package com.generation.iroomiedb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class IRoomiedbApplicationTests {
@Autowired
	private MockMvc mockMvc;
@Test
public void testGet() throws Exception {
	this.mockMvc.perform(get("/api/propiedades/1")	)
	.andDo(print())
	.andExpect(status().isOk()).andExpect(content().string(containsString("hombre") ));

} // testGet

}
