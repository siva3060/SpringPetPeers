package com.hcl.pp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.pp.dtos.*;
import com.hcl.pp.repository.*;
import com.hcl.pp.Models.*;
public class UserServiceImpl {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	PetRepository petRepository;
	
	public String addUsers(UserReqDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepo.save(user);
		return "User added Succcessfully";
	}
		public String buyPets(UserPetDTO userpet) {
			Pet petModel = new Pet();
			
			if(userRepo.findById(userpet.getUserID()).isPresent())
			{		
					
				petModel = petRepository.findById(userpet.getPetID()).get();
					if(petModel.getPetOwnerID() ==0 ) {
						petModel.setPetOwnerID(userpet.getUserID());
						petRepository.save(petModel);
						return "Pet bought successfully by user "+userpet.getUserID();
							
					}else {	
						return ("Unable to buy pet for user : "+ userpet.getUserID());	
					}
			
			}
			else {
				
				return "Please add user before purchase any pets";
			}
			
			
		}	

}
