package com.patientMicroService.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.patientMicroService.patientDetails.model.PatientDetails;
import com.patientMicroService.patientDetails.repository.PatientRepository;
import com.patientMicroService.patientDetails.service.PatientService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PatientApplicationTests {

	@Autowired
	PatientService patientService;

	@MockBean
	PatientRepository patientRepository;

	@Test
	public void testReadAll() {
		when(patientRepository.findAll()).thenReturn(Stream
				.of(new PatientDetails(201,"manikanta","male"), new PatientDetails(202,"chaitu","male")).collect(Collectors.toList()));
		assertEquals(2, patientService.findAll().size());      //assertEquals(Object expected, Object actual)
	}

	@Test
	public void savePatientTest() {
		PatientDetails patientDetails=new PatientDetails(201,"manikanta","male");
		when(patientRepository.save(patientDetails)).thenReturn(patientDetails);
		assertEquals(patientDetails, patientService.save(patientDetails));
	}

	@Test
	public void getPatientByIdTest() {
		int patientId=206;
		PatientDetails patientDetails=new PatientDetails(201,"chaitu","male");
		System.out.println("Hello"+ patientId);
		when(patientRepository.findById(patientId)).thenReturn(java.util.Optional.of(patientDetails));
		System.out.println(patientService.findById(patientId)+"and"+patientDetails);
		assertEquals(patientDetails, patientService.findById(patientId));
	}
}
