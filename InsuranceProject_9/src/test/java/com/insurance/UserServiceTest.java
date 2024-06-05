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
import com.insurance.model.Nominee;
import com.insurance.model.Policy;
import com.insurance.model.Premium;
import com.insurance.model.User;
import com.insurance.repository.NomineeRepository;
import com.insurance.repository.PolicyRepository;
import com.insurance.repository.PremiumRepository;
import com.insurance.repository.UserRepository;
import com.insurance.serviceimpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private PolicyRepository policyRepository;

	@Mock
	private PremiumRepository premiumRepository;

	@Mock
	private NomineeRepository nomineeRepository;

	@Test
	public void testSaveUserWithAllDetails() {
		User user = new User();
		user.setId(11);
		user.setFirstName("Prithviraj");
		user.setLastName("Chavan");
		user.setDateOfBirth("10-08-1996");
		user.setGender("Male");
		user.setEmail("prithvirajchavan@gmail.com");
		user.setAdharCard("123456789012");
		user.setPanCard("ASDFS6781Q");

		Policy policy = new Policy();
		policy.setPolicyId(12);
		policy.setPolicyName("Life Insurance");
		policy.setPolicyStatus("Active");

		Policy policy2 = new Policy();
		policy2.setPolicyId(14);
		policy2.setPolicyName("Term Insurance");
		policy2.setPolicyStatus("Inactive");

		Nominee nominee = new Nominee();
		nominee.setNomineeid(1);
		nominee.setNomineeName("ANirudh Arsud");
		nominee.setNomineeAge(26);
		nominee.setRelation("Brother");

		Premium premium = new Premium();
		premium.setPrimiumId(12);
		premium.setPremiumAmount(12000);
		premium.setDueDate("12-03-2023");
		premium.setPaymentFrequency("12 Months");
		premium.setPaymentMethod("UPI");
		premium.setPaymentStatus("Paid");
		premium.setCoveragePeriod("36 Months");

		user.setPolicylist(Arrays.asList(policy, policy2));
		user.setNomineelist(Arrays.asList(nominee));
		user.setPremiumlist(Arrays.asList(premium));
		when(userRepository.save(user)).thenReturn(user);
		User user2 = userService.saveUserDetails(user);
		assertEquals(user, user2);
	}

	@Test
	public void testFindUserWithAllDetails() {
		Long id =1L;
		User user = new User();
		user.setId(1L);
		user.setFirstName("Prithviraj");
		user.setLastName("Chavan");
		user.setDateOfBirth("10-08-1996");
		user.setGender("Male");
		user.setEmail("prithvirajchavan@gmail.com");
		user.setAdharCard("123456789012");
		user.setPanCard("ASDFS6781Q");

		Policy policy = new Policy();
		policy.setPolicyId(12);
		policy.setPolicyName("Life Insurance");
		policy.setPolicyStatus("Active");

		Policy policy2 = new Policy();
		policy2.setPolicyId(14);
		policy2.setPolicyName("Term Insurance");
		policy2.setPolicyStatus("Inactive");

		Nominee nominee = new Nominee();
		nominee.setNomineeid(1);
		nominee.setNomineeName("ANirudh Arsud");
		nominee.setNomineeAge(26);
		nominee.setRelation("Brother");

		Premium premium = new Premium();
		premium.setPrimiumId(12);
		premium.setPremiumAmount(12000);
		premium.setDueDate("12-03-2023");
		premium.setPaymentFrequency("12 Months");
		premium.setPaymentMethod("UPI");
		premium.setPaymentStatus("Paid");
		premium.setCoveragePeriod("36 Months");

		user.setPolicylist(Arrays.asList(policy, policy2));
		user.setNomineelist(Arrays.asList(nominee));
		user.setPremiumlist(Arrays.asList(premium));
		userRepository.save(user);
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		User foundUser = userService.readUser(user.getId());
        assertEquals(user,foundUser);   
	}
	
	@Test
	public void testDeleteUserById() {
		Long id =1L;
		User user = new User();
		user.setId(1L);
		user.setFirstName("Prithviraj");
		user.setLastName("Chavan");
		user.setDateOfBirth("10-08-1996");
		user.setGender("Male");
		user.setEmail("prithvirajchavan@gmail.com");
		user.setAdharCard("123456789012");
		user.setPanCard("ASDFS6781Q");

		Policy policy = new Policy();
		policy.setPolicyId(12);
		policy.setPolicyName("Life Insurance");
		policy.setPolicyStatus("Active");

		Policy policy2 = new Policy();
		policy2.setPolicyId(14);
		policy2.setPolicyName("Term Insurance");
		policy2.setPolicyStatus("Inactive");

		Nominee nominee = new Nominee();
		nominee.setNomineeid(1);
		nominee.setNomineeName("ANirudh Arsud");
		nominee.setNomineeAge(26);
		nominee.setRelation("Brother");

		Premium premium = new Premium();
		premium.setPrimiumId(12);
		premium.setPremiumAmount(12000);
		premium.setDueDate("12-03-2023");
		premium.setPaymentFrequency("12 Months");
		premium.setPaymentMethod("UPI");
		premium.setPaymentStatus("Paid");
		premium.setCoveragePeriod("36 Months");

		user.setPolicylist(Arrays.asList(policy, policy2));
		user.setNomineelist(Arrays.asList(nominee));
		user.setPremiumlist(Arrays.asList(premium));
		userRepository.save(user);
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		userService.deleteUser(user.getId());
		Mockito.verify(userRepository,times(1)).deleteById(user.getId());
	}
	
	
	@Test
	public void testUpdateUserWithDetails() {
		User existingUser = new User();
		existingUser.setId(1L);
		existingUser.setFirstName("Yuvraj");
		existingUser.setLastName("P.Chavan");
		existingUser.setDateOfBirth("12-09-1987");
		existingUser.setGender("Male");
		existingUser.setEmail("yuvrajchavan@gmail.com");
		existingUser.setAdharCard("98765443212");
		existingUser.setPanCard("ZXCV2344R");

		Policy policy = new Policy();
		policy.setPolicyId(12);
		policy.setPolicyName("Bike Insurance");
		policy.setPolicyStatus("Inactive");

		Policy policy2 = new Policy();
		policy2.setPolicyId(14);
		policy2.setPolicyName("Post Insurance");
		policy2.setPolicyStatus("active");

		Nominee nominee = new Nominee();
		nominee.setNomineeid(1);
		nominee.setNomineeName("Qwerty user");
		nominee.setNomineeAge(26);
		nominee.setRelation("Father");

		Premium premium = new Premium();
		premium.setPrimiumId(12);
		premium.setPremiumAmount(12000);
		premium.setDueDate("12-05-2023");
		premium.setPaymentFrequency("24 Months");
		premium.setPaymentMethod("Net Banking");
		premium.setPaymentStatus("unpaid");
		premium.setCoveragePeriod("40 Months");

		existingUser.setPolicylist(Arrays.asList(policy, policy2));
		existingUser.setNomineelist(Arrays.asList(nominee));
		existingUser.setPremiumlist(Arrays.asList(premium));
		
		Long id =1L;
		User user = new User();
		user.setId(1L);
		user.setFirstName("Prithviraj");
		user.setLastName("Chavan");
		user.setDateOfBirth("10-08-1996");
		user.setGender("Male");
		user.setEmail("prithvirajchavan@gmail.com");
		user.setAdharCard("123456789012");
		user.setPanCard("ASDFS6781Q");

		Policy policy1 = new Policy();
		policy1.setPolicyId(12);
		policy1.setPolicyName("Life Insurance");
		policy1.setPolicyStatus("Active");

		Policy policy4 = new Policy();
		policy4.setPolicyId(14);
		policy4.setPolicyName("Term Insurance");
		policy4.setPolicyStatus("Inactive");

		Nominee nominee1 = new Nominee();
		nominee1.setNomineeid(1);
		nominee1.setNomineeName("ANirudh Arsud");
		nominee1.setNomineeAge(26);
		nominee1.setRelation("Brother");

		Premium premium1 = new Premium();
		premium1.setPrimiumId(12);
		premium1.setPremiumAmount(12000);
		premium1.setDueDate("12-03-2023");
		premium1.setPaymentFrequency("12 Months");
		premium1.setPaymentMethod("UPI");
		premium1.setPaymentStatus("Paid");
		premium1.setCoveragePeriod("36 Months");

		user.setPolicylist(Arrays.asList(policy1, policy4));
		user.setNomineelist(Arrays.asList(nominee1));
		user.setPremiumlist(Arrays.asList(premium1));
		userRepository.save(user);
		when(userRepository.findById(existingUser.getId())).thenReturn(Optional.of(existingUser));
		userService.updateUser(user.getId(), user);
		Mockito.verify(userRepository,times(1)).save(user);
	}
}
