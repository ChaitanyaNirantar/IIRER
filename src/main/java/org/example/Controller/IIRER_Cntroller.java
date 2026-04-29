package org.example.Controller;


//import jakarta.validation.Valid;
import org.example.Entity.*;
import org.example.Service.IIRER_Sevice;
import org.apache.catalina.User;
import org.example.Service.JWTService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class IIRER_Cntroller {
    private final IIRER_Sevice iirerService;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    public IIRER_Cntroller(IIRER_Sevice iirerService, JWTService jwtService, PasswordEncoder passwordEncoder) {
        this.iirerService = iirerService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public IIRER_Entity createUser(@RequestBody IIRER_Entity iirerEntity) {
        return iirerService.saveUser(iirerEntity);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {

        SignupEntity response = iirerService.registerUser(signupRequest);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<IIRER_Entity>> searchUsers(@RequestParam String email) {

        List<IIRER_Entity> users = iirerService.searchUsersByEmail(email);

        return ResponseEntity.ok(users);
    }
    @PostMapping("/newvrservice")
    public VR_Entity vrservices(@RequestBody VR_Entity vrEntity) {
        return iirerService.saveVRService(vrEntity);
    }
    @PostMapping("/ciemployment")
    public CIEEntity ciemployment(@RequestBody CIEEntity cieEntity) {
        return iirerService.savecieentity(cieEntity);
    }
    @PostMapping("/drsclosure")
    public DRSEntity drsclosure(@RequestBody DRSEntity drsEntity) {
        return iirerService.drsclousre(drsEntity);
    }

    @GetMapping("/extract-email")
    public ResponseEntity<?> extractEmailFromToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7); // removes "Bearer "
        String email = jwtService.extractEmail(token);
        return ResponseEntity.ok(email);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        LoginRequestDTO user = iirerService.findByEmail(request.getEmail());

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            // password correct
            String token = jwtService.generateToken(user.getEmail(), user.getCustomerID());

            return ResponseEntity.ok(new AuthResponse(token, user.getEmail()));
        }
        else{
  
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        
    }
    @PostMapping("/v1/login")
    public ResponseEntity<?> loginn(@RequestBody LoginRequestDTO request) {
        LoginRequestDTO user = iirerService.findByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String otp = String.valueOf((int)(Math.random() * 900000) + 100000);

        iirerService.generateAndSaveOtp(user.getEmail());

       // emailService.sendOtpEmail(user.getEmail(), otp);

        return ResponseEntity.ok("OTP sent to your email");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OTPRequest request) {

        boolean isValid = iirerService.verifyOtp(request.getEmail(), request.getOtp());

        if (!isValid) {
            return ResponseEntity.status(401).body("Invalid or expired OTP");
        }

        SignupEntity user = iirerService.findSignupUserByEmail(request.getEmail());

        String token = jwtService.generateToken(user.getEmail(), user.getId());

        return ResponseEntity.ok(new AuthResponse(token, user.getEmail()));
    }


//    @PostMapping("/v2/newvrservice")
//    public VR_Entity vrservices(
//            @RequestHeader("Authorization") String authHeader,
//            @RequestBody VRServiceDTO vrServiceDTO) {
//
//        // remove "Bearer "
//
//            String token = authHeader.substring(7);
//
//            Long customerId = jwtService.extractCustomerId(token);
//
//            vrEntity.setCustomer_id(customerId);
//
//            return iirerService.saveVRService(vrEntity);
//
//        return iirerService.saveVRServiceNew(vrServiceDTO);
//    }

    @PostMapping("/upload-pdf")
    public ResponseEntity<?> uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            PdfEntity savedPdf = iirerService.uploadPdf(file);
            return ResponseEntity.ok(savedPdf);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/pdf/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        PdfEntity pdf = iirerService.getPdfById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + pdf.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.getData());
    }
}
