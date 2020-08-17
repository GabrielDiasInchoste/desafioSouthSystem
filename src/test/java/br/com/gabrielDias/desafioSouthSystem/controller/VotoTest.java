package br.com.gabrielDias.desafioSouthSystem.controller;

import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.gabrielDias.desafioSouthSystem.dto.VotoDTO;
import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.VotoEntity;
import br.com.gabrielDias.desafioSouthSystem.repository.AssociadoRepository;
import br.com.gabrielDias.desafioSouthSystem.repository.PautaRepository;
import br.com.gabrielDias.desafioSouthSystem.repository.VotoRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class VotoTest {

	@Autowired
	private PautaController pautaController;

	@MockBean
	private VotoRepository votoRepository;
	
	@MockBean
	private PautaRepository pautaRepository;
	
	@MockBean
	private AssociadoRepository associadoRepository;

	@Before
	public void setup() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	
	@Test
	public void votoTest() throws Exception {

		when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new PautaEntity(1,"nome",ZonedDateTime.now().plusMonths(1))));
		when(votoRepository.findByPautaIdAndAssociadoId(Mockito.any(),Mockito.any())).thenReturn(Optional.empty());

		ResponseEntity<VotoEntity> responseEntity = pautaController.votarPauta(1, new VotoDTO(123456798,false));

		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void votoTestTestException() throws Exception {
		when(votoRepository.findByPautaIdAndAssociadoId(Mockito.any(),Mockito.any())).thenReturn(Optional.of(new VotoEntity()));
		when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new PautaEntity(1,"nome",ZonedDateTime.now().plusMonths(1))));

		Assertions.assertThrows(Exception.class, () -> pautaController.votarPauta(1, new VotoDTO(123456798,false)));

	}
	
	@Test
	public void votoTestTestException2() throws Exception {
		when(votoRepository.findByPautaIdAndAssociadoId(Mockito.any(),Mockito.any())).thenReturn(Optional.empty());
		when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new PautaEntity(1,"nome",ZonedDateTime.now().minusMonths(1))));

		Assertions.assertThrows(Exception.class, () -> pautaController.votarPauta(1, new VotoDTO(123456798,false)));

	}
}
