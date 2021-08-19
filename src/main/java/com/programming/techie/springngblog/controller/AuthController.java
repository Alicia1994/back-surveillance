
package com.programming.techie.springngblog.controller;

        import com.programming.techie.springngblog.dto.LoginRequest;
        import com.programming.techie.springngblog.dto.RegisterRequest;
        import com.programming.techie.springngblog.service.AuthService;
        import com.programming.techie.springngblog.service.AuthenticationResponse;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


   /* SIGNUP USER */
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    /* SIGNUP ADMIN */
    @PostMapping("/signup/admin")
    public ResponseEntity signupAdmin(@RequestBody RegisterRequest registerRequest) {
        authService.createAdmin(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    /* LOGIN USER AND ADMIN */
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
