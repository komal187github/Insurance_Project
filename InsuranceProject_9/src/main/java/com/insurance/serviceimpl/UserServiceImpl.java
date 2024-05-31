package com.insurance.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.IdNotFoundException;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Nominee;
import com.insurance.model.Policy;
import com.insurance.model.Premium;
import com.insurance.model.User;
import com.insurance.repository.NomineeRepository;
import com.insurance.repository.PolicyRepository;
import com.insurance.repository.PremiumRepository;
import com.insurance.repository.UserRepository;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;
import com.insurance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private NomineeRepository nomineeRepository;

	@Autowired
	private PremiumRepository premiumRepository;

	public User saveUserDetails(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		User existiongUser =userRepository.findById(id).orElseThrow(()->new IdNotFoundException("Given User with "+id+"not exist..!!"));
			existiongUser.setFirstName(user.getFirstName());
			existiongUser.setLastName(user.getLastName());
			existiongUser.setMobileNumber(user.getMobileNumber());
			existiongUser.setEmail(user.getEmail());
			existiongUser.setPolicylist(user.getPolicylist());
			existiongUser.setNomineelist(user.getNomineelist());
			existiongUser.setPremiumlist(user.getPremiumlist());
			userRepository.save(existiongUser);
		return existiongUser;
	}

	@Override
	public User readUser(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Given Id is Does not exist : " + id));
	}

	@Override
	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Given Id is Does not exist : " + id));
		userRepository.deleteById(id);
	}

// Excel file Operation of Policy	
	@Override
	public void generateExcel(HttpServletResponse response) throws IOException {
		List<Policy> policies = policyRepository.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Policy_info");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("policy_id");
		row.createCell(1).setCellValue("policy_name");
		row.createCell(2).setCellValue("policy_status");

		int dataRowIndex = 1;
		for (Policy p : policies) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(p.getPolicyId());
			dataRow.createCell(1).setCellValue(p.getPolicyName());
			dataRow.createCell(2).setCellValue(p.getPolicyStatus());
			dataRowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		// workbook.close();
		ops.close();
	}

}
