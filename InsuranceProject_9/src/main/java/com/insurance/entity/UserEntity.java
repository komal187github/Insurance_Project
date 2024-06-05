package com.insurance.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String mobileNumber;
	private String gender;
	private String email;
	private String adharCard;
	private String panCard;

	@OneToMany(cascade = CascadeType.ALL)
	private List<PolicyEntity> policylist;

	@OneToMany(cascade = CascadeType.ALL)
	private List<NomineeEntity> nomineelist;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public List<PolicyEntity> getPolicylist() {
		return policylist;
	}

	public void setPolicylist(List<PolicyEntity> policylist) {
		this.policylist = policylist;
	}

	public List<NomineeEntity> getNomineelist() {
		return nomineelist;
	}

	public void setNomineelist(List<NomineeEntity> nomineelist) {
		this.nomineelist = nomineelist;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", email=" + email + ", adharCard="
				+ adharCard + ", panCard=" + panCard + ", policylist=" + policylist + ", nomineelist=" + nomineelist
				+ "]";
	}

}
