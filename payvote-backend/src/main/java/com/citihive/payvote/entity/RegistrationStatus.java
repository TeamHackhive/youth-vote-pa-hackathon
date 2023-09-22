package com.citihive.payvote.entity;
/**
 * @author Sreekanth Varidhireddy
 * Sep 21, 2023
 */
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class RegistrationStatus {
	
	@OneToOne
    @JoinColumn(name = "voterID")
	@DynamoDBAttribute
	private Voter voter;
	

	
	/**
	 * @return the voter
	 */
	public Voter getVoter() {
		return voter;
	}

	/**
	 * @param voter the voter to set
	 */
	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	/**
	 * @return the registrationStatus
	 */
	public String getRegistrationCurrentStatus() {
		return registrationCurrentStatus;
	}

	/**
	 * @param registrationStatus the registrationStatus to set
	 */
	public void setRegistrationCurrentStatus(String registrationStatus) {
		this.registrationCurrentStatus = registrationStatus;
	}

	/**
	 * @return the registrationSubmissionDate
	 */
	public String getRegistrationSubmissionDate() {
		return registrationSubmissionDate;
	}

	/**
	 * @param registrationSubmissionDate the registrationSubmissionDate to set
	 */
	public void setRegistrationSubmissionDate(String registrationSubmissionDate) {
		this.registrationSubmissionDate = registrationSubmissionDate;
	}

	/**
	 * @return the registeredDate
	 */
	public String getRegisteredDate() {
		return registeredDate;
	}

	/**
	 * @param registeredDate the registeredDate to set
	 */
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	@DynamoDBAttribute
	private String registrationSubmissionDate;
	
	@DynamoDBAttribute
	private String registeredDate;
	
	@DynamoDBAttribute
	private String registrationCurrentStatus;

}