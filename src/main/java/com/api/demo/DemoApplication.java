package com.api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

	}

}

// import com.api.demo.models.User;
// import com.api.demo.repositories.UserRepository;
// import com.api.demo.services.UserService;

// var repository = context.getBean(UserRepository.class);

// var user = User.builder()zz
// .name("John Doe")
// .email("john.doe@example.com")
// .password("password123")
// .build();

// repository.save(user);
// var user = repository.findById(1L).orElseThrow();
// System.err.println(user.getEmail());

// repository.findAll().forEach(u -> System.out.println(u.getEmail()));

// var userService = context.getBean(UserService.class);
// userService.showRelatedEntities();

// var user = User.builder()
// .name("John Doe")
// .email("john.doe@example.com")
// .password("password123")
// .build();

// var address1 = Address.builder()
// .street("123 Main St")
// .city("Anytown")
// .state("CA")
// .zip("12345")
// .build();

// user.getAddresses().add(address1);
// address1.setUser(user);
// user.addAddress(address1);

// var tag1 = new Tag();
// tag1.setName("Developer");

// user.getTags().add(tag1);
// tag1.getUsers().add(user);
// user.addTag("Developer");

// var profile = Profile.builder()
// .bio("Software developer with 10 years of experience.")
// .phoneNumber("555-1234")
// .dateOfBirth("1990-01-01")
// .loyaltyPoints("1000")
// .build();

// user.setProfile(profile);
// profile.setUser(user);

// System.out.println(user);
