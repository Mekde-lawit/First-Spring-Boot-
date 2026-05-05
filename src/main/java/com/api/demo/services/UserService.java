// package com.api.demo.services;

// import org.springframework.stereotype.Service;

// import com.api.demo.models.User;
// import com.api.demo.repositories.AddressRepository;
// import com.api.demo.repositories.ProfileRepository;
// import com.api.demo.repositories.UserRepository;

// import jakarta.persistence.EntityManager;
// import jakarta.transaction.Transactional;
// import lombok.AllArgsConstructor;

// @AllArgsConstructor
// @Service
// public class UserService {
//     private final UserRepository userRepository;
//     private final ProfileRepository profileRepository;
//     private final AddressRepository addressRepository;
//     private final EntityManager entityManager;

//     @Transactional
//     public void showEntityStates() {
//         var user = User.builder()
//                 .name("John Doe")
//                 .email("john.doe@example.com")
//                 .password("password123")
//                 .build();

//         if (entityManager.contains(user))
//             System.out.println("User is in the persistence context (managed).");
//         else
//             System.out.println("User is not in the persistence context. Transient or detached.");

//         userRepository.save(user);

//         if (entityManager.contains(user))
//             System.out.println("User is in the persistence context (managed).");
//         else
//             System.out.println("User is not in the persistence context. Transient or detached.");
//     }

//     @Transactional
//     public void showRelatedEntities() {
//         var profile = profileRepository.findById(1L).orElseThrow();
//         System.out.println("Profile: " + profile.getBio());
//     }

//     public void fetchAddress() {
//         var address = addressRepository.findById(1L).orElseThrow();
//         System.out.println("Address: " + address.getStreet() + ", " + address.getCity());
//     }
// }

package com.api.demo.services;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.demo.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found!"));
        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList());
    }
}
