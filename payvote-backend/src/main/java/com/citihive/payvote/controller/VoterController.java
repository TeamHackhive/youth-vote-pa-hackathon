package com.citihive.payvote.controller;

import com.citihive.payvote.entity.Voter;
import com.citihive.payvote.entity.RegistrationStatus;
import com.citihive.payvote.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoterController {

    @Autowired
    private VoterRepository voterRepository;

    @PostMapping("/voter")
    public Voter saveVoter(@RequestBody Voter voter) {
        return voterRepository.save(voter);
    }

    @GetMapping("/voter/{id}")
    public Voter getVoter(@PathVariable("id") String voterID) {
        return voterRepository.getVoterByID(voterID);
    }

    @DeleteMapping("/voter/{id}")
    public String deleteVoter(@PathVariable("id") String voterID) {
        return voterRepository.delete(voterID);
    }

    @PutMapping("/voter/{id}")
    public String updateVoter(@PathVariable("id") String voterID, @RequestBody Voter voter) {
        return voterRepository.update(voterID, voter);
    }

    @PutMapping("/voter/{id}/registrationStatus")
    public String updateVoterRegistrationStatus(@PathVariable("id") String voterID, @RequestBody RegistrationStatus registrationStatus) {
        Voter voter = voterRepository.getVoterByID(voterID);
        if (voter != null) {
            voter.getRegistrationStatus().setRegistrationCurrentStatus(registrationStatus.getRegistrationCurrentStatus());
            voter.getRegistrationStatus().setRegistrationSubmissionDate(registrationStatus.getRegistrationSubmissionDate());
            voter.getRegistrationStatus().setRegisteredDate(registrationStatus.getRegisteredDate());
            return "Voter registration status updated successfully";
        } else {
            return "Voter not found";
        }
    }

    @GetMapping("/voter/{id}/registrationStatus")
    public RegistrationStatus getVoterRegistrationStatus(@PathVariable("id") String voterID) {
        Voter voter = voterRepository.getVoterByID(voterID);
        if (voter != null) {
            return voter.getRegistrationStatus();
        } else {
            return null;
        }
    }
}
