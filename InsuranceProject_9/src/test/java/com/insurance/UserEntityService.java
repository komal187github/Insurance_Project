package com.insurance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entity.NomineeEntity;
import com.insurance.entity.PolicyEntity;
import com.insurance.entity.UserEntity;
import com.insurance.entityrepository.NomineeEntityRepository;
import com.insurance.entityrepository.PolicyEntityRepository;
import com.insurance.entityrepository.UserEntityRepository;
import com.insurance.entityserviceimpl.UserEntityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserEntityService {

	@InjectMocks
	private UserEntityServiceImpl userEntityServiceImpl;

	@Mock
	private UserEntityRepository userEntityRepository;

	@Mock
	private PolicyEntityRepository policyEntityRepository;

	@Mock
	private NomineeEntityRepository nomineeEntityRepository;

	@Test
	public void testSaveUserWithAllDetails() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(11);
		userEntity.setFirstName("Prithviraj");
		userEntity.setLastName("Chavan");
		userEntity.setDateOfBirth("10-08-1996");
		userEntity.setGender("Male");
		userEntity.setEmail("prithvirajchavan@gmail.com");
		userEntity.setAdharCard("123456789012");
		userEntity.setPanCard("ASDFS6781Q");

		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setPolicyId(12);
		policyEntity.setPolicyName("Life Insurance");
		policyEntity.setPolicyStatus("Active");

		PolicyEntity policyEntity2 = new PolicyEntity();
		policyEntity2.setPolicyId(14);
		policyEntity2.setPolicyName("Term Insurance");
		policyEntity2.setPolicyStatus("Inactive");

		NomineeEntity nomineeEntity = new NomineeEntity();
		nomineeEntity.setNomineeid(1);
		nomineeEntity.setNomineeName("ANirudh Arsud");
		nomineeEntity.setNomineeAge(26);
		nomineeEntity.setRelation("Brother");

		userEntity.setPolicylist(Arrays.asList(policyEntity, policyEntity2));
		userEntity.setNomineelist(Arrays.asList(nomineeEntity));
		when(userEntityRepository.save(userEntity)).thenReturn(userEntity);
		UserEntity userEntity2 = userEntityServiceImpl.saveUserEntity(userEntity);
		assertEquals(userEntity, userEntity2);
	}

	@Test
	public void testFindUserWithAllDetails() {
		Long id = 1L;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(11);
		userEntity.setFirstName("Prithviraj");
		userEntity.setLastName("Chavan");
		userEntity.setDateOfBirth("10-08-1996");
		userEntity.setGender("Male");
		userEntity.setEmail("prithvirajchavan@gmail.com");
		userEntity.setAdharCard("123456789012");
		userEntity.setPanCard("ASDFS6781Q");

		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setPolicyId(12);
		policyEntity.setPolicyName("Life Insurance");
		policyEntity.setPolicyStatus("Active");

		PolicyEntity policyEntity2 = new PolicyEntity();
		policyEntity2.setPolicyId(14);
		policyEntity2.setPolicyName("Term Insurance");
		policyEntity2.setPolicyStatus("Inactive");

		NomineeEntity nomineeEntity = new NomineeEntity();
		nomineeEntity.setNomineeid(1);
		nomineeEntity.setNomineeName("ANirudh Arsud");
		nomineeEntity.setNomineeAge(26);
		nomineeEntity.setRelation("Brother");
		userEntity.setPolicylist(Arrays.asList(policyEntity, policyEntity2));
		userEntity.setNomineelist(Arrays.asList(nomineeEntity));
		userEntityRepository.save(userEntity);
		when(userEntityRepository.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));
		UserEntity foundUser = userEntityServiceImpl.readUserEntity(userEntity.getId());
		assertEquals(userEntity, foundUser);
	}

	@Test
	public void testDeleteUserById() {
		Long id = 1L;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(11);
		userEntity.setFirstName("Prithviraj");
		userEntity.setLastName("Chavan");
		userEntity.setDateOfBirth("10-08-1996");
		userEntity.setGender("Male");
		userEntity.setEmail("prithvirajchavan@gmail.com");
		userEntity.setAdharCard("123456789012");
		userEntity.setPanCard("ASDFS6781Q");

		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setPolicyId(12);
		policyEntity.setPolicyName("Life Insurance");
		policyEntity.setPolicyStatus("Active");

		PolicyEntity policyEntity2 = new PolicyEntity();
		policyEntity2.setPolicyId(14);
		policyEntity2.setPolicyName("Term Insurance");
		policyEntity2.setPolicyStatus("Inactive");

		NomineeEntity nomineeEntity = new NomineeEntity();
		nomineeEntity.setNomineeid(1);
		nomineeEntity.setNomineeName("ANirudh Arsud");
		nomineeEntity.setNomineeAge(26);
		nomineeEntity.setRelation("Brother");
		userEntity.setPolicylist(Arrays.asList(policyEntity, policyEntity2));
		userEntity.setNomineelist(Arrays.asList(nomineeEntity));
		userEntityRepository.save(userEntity);
		when(userEntityRepository.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));
		userEntityServiceImpl.deleteUserEntity(userEntity.getId());
		Mockito.verify(userEntityRepository, times(1)).deleteById(userEntity.getId());
	}

	@Test
	public void testUpdateUserWithDetails() {
		UserEntity existingUser = new UserEntity();
		existingUser.setId(1L);
		existingUser.setFirstName("Yuvraj");
		existingUser.setLastName("P.Chavan");
		existingUser.setDateOfBirth("12-09-1987");
		existingUser.setGender("Male");
		existingUser.setEmail("yuvrajchavan@gmail.com");
		existingUser.setAdharCard("98765443212");
		existingUser.setPanCard("ZXCV2344R");

		PolicyEntity policy = new PolicyEntity();
		policy.setPolicyId(12);
		policy.setPolicyName("Bike Insurance");
		policy.setPolicyStatus("Inactive");

		PolicyEntity policy2 = new PolicyEntity();
		policy2.setPolicyId(14);
		policy2.setPolicyName("Post Insurance");
		policy2.setPolicyStatus("active");

		NomineeEntity nominee = new NomineeEntity();
		nominee.setNomineeid(1);
		nominee.setNomineeName("Qwerty user");
		nominee.setNomineeAge(26);
		nominee.setRelation("Father");

		existingUser.setPolicylist(Arrays.asList(policy, policy2));
		existingUser.setNomineelist(Arrays.asList(nominee));

		Long id = 1L;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setFirstName("Prithviraj");
		userEntity.setLastName("Chavan");
		userEntity.setDateOfBirth("10-08-1996");
		userEntity.setGender("Male");
		userEntity.setEmail("prithvirajchavan@gmail.com");
		userEntity.setAdharCard("123456789012");
		userEntity.setPanCard("ASDFS6781Q");

		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setPolicyId(12);
		policyEntity.setPolicyName("Life Insurance");
		policyEntity.setPolicyStatus("Active");

		PolicyEntity policyEntity2 = new PolicyEntity();
		policyEntity2.setPolicyId(14);
		policyEntity2.setPolicyName("Term Insurance");
		policyEntity2.setPolicyStatus("Inactive");

		NomineeEntity nomineeEntity = new NomineeEntity();
		nomineeEntity.setNomineeid(1);
		nomineeEntity.setNomineeName("ANirudh Arsud");
		nomineeEntity.setNomineeAge(26);

		nomineeEntity.setRelation("Brother");
		userEntity.setPolicylist(Arrays.asList(policyEntity, policyEntity2));
		userEntity.setNomineelist(Arrays.asList(nomineeEntity));
		userEntityRepository.save(userEntity);
		when(userEntityRepository.findById(existingUser.getId())).thenReturn(Optional.of(existingUser));
		userEntityServiceImpl.getUserById(userEntity.getId());
		Mockito.verify(userEntityRepository, times(1)).save(userEntity);
	}
}
