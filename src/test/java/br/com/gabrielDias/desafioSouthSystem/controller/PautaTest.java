package br.com.gabrielDias.desafioSouthSystem.controller;

import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.Collections;
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

import br.com.gabrielDias.desafioSouthSystem.dto.PautaDTO;
import br.com.gabrielDias.desafioSouthSystem.dto.PautaResultado;
import br.com.gabrielDias.desafioSouthSystem.entity.AssociadoEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.VotoEntity;
import br.com.gabrielDias.desafioSouthSystem.repository.PautaRepository;
import br.com.gabrielDias.desafioSouthSystem.repository.VotoRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PautaTest {

		@Autowired
		private PautaController pautaController;

		@MockBean
		private PautaRepository pautaRepository;
		
		@MockBean
		private VotoRepository votoRepository;

		@Before
		public void setup() {
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		}

		@Test
		public void getPautaTest() throws Exception {

			when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new PautaEntity()));

			ResponseEntity<PautaEntity> responseEntity = pautaController.getPauta(1);

			Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		}
		
		@Test
		public void getPautaTestException() throws Exception {

			when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
			Assertions.assertThrows(Exception.class, () -> pautaController.getPauta(1));

		}
		
		@Test
		public void postPautaTest() throws Exception {

			when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new PautaEntity()));

			ResponseEntity<PautaEntity> responseEntity = pautaController.postPauta(new PautaDTO("nome",ZonedDateTime.now()));

			Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		}
		
		@Test
		public void getPautaResultadoTest() throws Exception {

			when(votoRepository.findByPautaId(Mockito.any())).thenReturn(Collections.singletonList(new VotoEntity(1,new PautaEntity(),new AssociadoEntity(),true)));

			when(pautaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new PautaEntity()));

			ResponseEntity<PautaResultado> responseEntity = pautaController.getPautaResultado(1);

			Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		}
		
}
