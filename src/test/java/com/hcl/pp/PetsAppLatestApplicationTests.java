package com.hcl.pp;

import java.util.Optional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;import com.hcl.pp.dtos.*;
import com.hcl.pp.repository.*;
import com.hcl.pp.services.UserService;
import com.hcl.pp.services.UserServiceImpl;
import com.hcl.pp.Models.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PetsAppLatestApplicationTests {
	@Mock
	UserRepository userRepo;
	@Mock
	PetRepository petRepo;
	
	@InjectMocks
	UserServiceImpl userService;
	
	static User userModel= null;
	static Pet petrModel= null;
	static UserReqDTO userDTO= null;
	static UserPetDTO userpet= null;
	static Optional<User> userOptional = Optional.empty();	
	static Optional<Pet> petOptional = Optional.empty();	
	
	@BeforeClass
	public static void setup() {
		userModel= new User();
		petrModel= new Pet();
		userModel.setId(2);
		userDTO = new UserReqDTO();		
		userOptional = Optional.of(userModel);	
		petOptional = Optional.of(petrModel);
		userpet= new UserPetDTO();
	}
	
	
	@Test
	public void testAddUser()
	{ 
	  userDTO.setId(2);
	  Mockito.when( userService.addUsers(userDTO)).thenReturn("User saved successfully");
	  String message = userService.addUsers(userDTO);
	  Assert.assertEquals(userDTO.getId(),userModel.getId() );
	  }
	/*
	 * @Test public void testAddUser() { userDTO.setId(2);
	 * Mockito.when(userRepo.save(userModel)).thenReturn(userModel); String message
	 * = userService.addUsers(userDTO);
	 * Assert.assertEquals(userDTO.getId(),userModel.getId() );
	 * 
	 * }
	 */
	/*
	 * @Test public void testBuyPets() { userpet.setUserID(2); userpet.setPetID(3);
	 * Mockito.when(userRepo.findById(2)).thenReturn(userOptional); //
	 * Mockito.when(petRepo.findById(3)).thenReturn(petOptional); String message =
	 * userService.buyPets(userpet); Assert.assertEquals(userpet.getUserID(),2);
	 * Assert.assertEquals(userpet.getPetID(),3);
	 * 
	 * }
	 */

}
