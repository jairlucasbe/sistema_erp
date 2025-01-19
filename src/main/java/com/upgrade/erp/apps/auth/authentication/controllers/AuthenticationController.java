package com.upgrade.erp.apps.auth.authentication.controllers;
// package com.upgrade.erp.modules.auth.controllers;

// import com.upgrade.erp.modules.auth.controllers.dto.AuthCreateUserRequest;
// import com.upgrade.erp.modules.auth.controllers.dto.AuthLoginRequest;
// import com.upgrade.erp.modules.auth.controllers.dto.AuthResponse;
// import com.upgrade.erp.modules.auth.services.UserDetailServiceImpl;
// import jakarta.validation.Valid;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/auth")
// public class AuthenticationController {

//     @Autowired
//     private UserDetailServiceImpl userDetailService;

//     @PostMapping("/sign-up")
//     public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest userRequest){
//         return new ResponseEntity<>(this.userDetailService.createUser(userRequest), HttpStatus.CREATED);
//     }

//     @PostMapping("/log-in")
//     public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){
//         return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
//     }
// }