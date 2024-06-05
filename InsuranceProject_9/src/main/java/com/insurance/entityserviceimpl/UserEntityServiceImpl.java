package com.insurance.entityserviceimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.PolicyEntity;
import com.insurance.entity.UserEntity;
import com.insurance.entityrepository.NomineeEntityRepository;
import com.insurance.entityrepository.PolicyEntityRepository;
import com.insurance.entityrepository.UserEntityRepository;
import com.insurance.entityservice.UserEntityService;
import com.insurance.exception.IdNotFoundException;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Policy;

@Service
public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	@Autowired
	private NomineeEntityRepository nomineeEntityRepository;
	@Autowired
	private PolicyEntityRepository policyEntityRepository;

	
	//save user
	@Override
	public UserEntity saveUserEntity(UserEntity userEntity) {
		return userEntityRepository.save(userEntity);
	}

//get user
	@Override
	public UserEntity readUserEntity(Long id) {
		return userEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Given Id is Does not exist : " + id));
	}


// update api	
	@Override
	public UserEntity getUserById(long id) {
		return userEntityRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteUserEntity(Long id) {
		UserEntity userentity = userEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Given Id is Does not exist : " + id));
		userEntityRepository.deleteById(id);

	}

	@Override
	public void generateCsvFile(HttpServletResponse response) throws IOException {
		List<PolicyEntity> policyentity = policyEntityRepository.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Policy_info");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("policy_id");
		row.createCell(1).setCellValue("policy_name");
		row.createCell(2).setCellValue("policy_status");

		int dataRowIndex = 1;
		for (PolicyEntity p : policyentity) {
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

