package com.hcl.pp.services;

import com.hcl.pp.dtos.*;

public interface UserService {

	public String addUsers(UserReqDTO user);
	public String buyPets(UserPetDTO userpet);

}
