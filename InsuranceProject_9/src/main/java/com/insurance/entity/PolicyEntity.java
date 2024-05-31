package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PolicyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long policyId;
	private String policyName;
	private String policyStatus;

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyStatus=" + policyStatus + "]";
	}

}
