package com.francisco;

import com.francisco.resources.ClienteResources;
import com.francisco.resources.dtos.CriarClienteDto;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteResourcesTests {

	@Autowired
	private MockMvc mockMvc;

	private final Gson gson = new Gson();

	@Test
	public void testBuscarCliente() throws Exception {
		// TODO: atualmente o cliente 1 sempre sera inserido no banco - H2
		mockMvc.perform(MockMvcRequestBuilders.get("/clientes/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Maria Silva"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("maria@gmail.com"));
	}

	@Test
	public void testCriarCliente() throws Exception {
		// TODO: atualmente o cliente 1 sempre sera inserido no banco - H2

		// Criar um objeto Pessoa para enviar no corpo da requisição
		String pessoa = gson.toJson(new CriarClienteDto(
				"Maria Silva",
				"maria@gmail.com",
				"747.411.444-00"
		));

		mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(pessoa))
                .andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
