package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NomineeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nomineeid;
	private String nomineeName;
	private int nomineeAge;
	private String relation;

	public long getNomineeid() {
		return nomineeid;
	}

	public void setNomineeid(long nomineeid) {
		this.nomineeid = nomineeid;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public int getNomineeAge() {
		return nomineeAge;
	}

	public void setNomineeAge(int nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	@Override
	public String toString() {
		return "Nominee [nomineeid=" + nomineeid + ", nomineeName=" + nomineeName + ", nomineeAge=" + nomineeAge
				+ ", relation=" + relation + "]";
	}

}
