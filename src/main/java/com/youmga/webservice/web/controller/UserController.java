package com.youmga.webservice.web.controller;

import com.youmga.webservice.core.exception.ResourceNotFoundException;
import com.youmga.webservice.domain.user.User;
import com.youmga.webservice.domain.user.UserRepository;
import com.youmga.webservice.payload.UserIdentityAvailability;
import com.youmga.webservice.payload.UserProfile;
import com.youmga.webservice.payload.UserSummary;
import com.youmga.webservice.security.CurrentUser;
import com.youmga.webservice.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return UserSummary.builder()
                .id(currentUser.getId())
                .username(currentUser.getUsername())
                .name(currentUser.getName())
                .build();
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return UserIdentityAvailability.builder().available(isAvailable).build();
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return UserIdentityAvailability.builder().available(isAvailable).build();
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> ResourceNotFoundException.builder().resourceName("User").fieldName("username").fieldValue(username).build());
        UserProfile userProfile = UserProfile.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .joinedAt(user.getCreatedAt())
                .build();
        return userProfile;
    }
}
