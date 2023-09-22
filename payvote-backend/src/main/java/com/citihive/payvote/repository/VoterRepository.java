package com.citihive.payvote.repository;
/**
 * @author Sreekanth Varidhireddy
 * Sep 21, 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.citihive.payvote.entity.Voter;

@Repository
public class VoterRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Voter save(Voter voter) {
		dynamoDBMapper.save(voter);
		return voter;
	}
	
	public Voter getVoterByID(String voterID) {
		return dynamoDBMapper.load(Voter.class, voterID);
	}
	
	public String delete(String voterID) {
		Voter voter=dynamoDBMapper.load(Voter.class,voterID);
		dynamoDBMapper.delete(voter);
		return "voter has been deleted";
	}
	
	public String update(String voterID, Voter voter) {
		dynamoDBMapper.save(voter,new DynamoDBSaveExpression()
				.withExpectedEntry(voterID,
						new ExpectedAttributeValue(
								new AttributeValue().withS(voterID)
						)));
		return voterID;
	}

}
