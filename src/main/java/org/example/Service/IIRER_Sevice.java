package org.example.Service;

import org.example.Entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IIRER_Sevice {
    IIRER_Entity saveUser(IIRER_Entity iirerEntity);

    SignupEntity registerUser(SignupRequest signupRequest);

    List<IIRER_Entity> searchUsersByEmail(String  email);

    VR_Entity saveVRService(VR_Entity vrEntity);

    CIEEntity savecieentity(CIEEntity cieEntity);

    DRSEntity drsclousre(DRSEntity drsEntity);

    public boolean validateUser(String email, String password);

   // VR_Entity saveVRServiceNew(VRServiceDTO vrServiceDTO);

    LoginRequestDTO findByEmail(String email);

    PdfEntity uploadPdf(MultipartFile file) throws IOException;

    PdfEntity getPdfById(Long id);

    String generateAndSaveOtp(String email);

    boolean verifyOtp(String email, String otp);

    SignupEntity findSignupUserByEmail(String email);




}
