package org.example.Service;

import org.example.Entity.*;
import org.example.Repository.*;
//importorg.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IIRER_ServiceImpl  implements IIRER_Sevice {
    private final IIRERRepo iirerRepo;
    private final SignupRepo signupRepo;
    private final VRServiceRepo vrServiceRepo;
    private final CIERepo cieRepo;
    private final DRSRepo drsRepo;
    private final PDFRepo pdfRepo;
    private final PasswordEncoder passwordEncoder;

    //private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public IIRER_ServiceImpl(IIRERRepo iirerRepo, SignupRepo signupRepo, VRServiceRepo vrServiceRepo, CIERepo cieRepo, DRSRepo drsRepo, PDFRepo pdfRepo, PasswordEncoder passwordEncoder) {
        this.iirerRepo = iirerRepo;
        this.signupRepo = signupRepo;
        this.vrServiceRepo = vrServiceRepo;
        this.cieRepo = cieRepo;
        this.drsRepo = drsRepo;


        this.pdfRepo = pdfRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public IIRER_Entity saveUser(IIRER_Entity iirerEntity) {
        return iirerRepo.save(iirerEntity);

    }
    public SignupEntity registerUser(SignupRequest signupRequest) {

        SignupEntity signupEntity=new SignupEntity();
        signupEntity.setName(signupRequest.getName());
        signupEntity.setEmail(signupRequest.getEmail());

        String encryptedPassword = passwordEncoder.encode(signupRequest.getPassword());
        signupEntity.setPassword(encryptedPassword);

        // Encrypt password
        //signupEntity.setPassword(signupRequest.getPassword());

        signupRepo.save(signupEntity);

        return signupEntity;
    }

    @Override
    public List<IIRER_Entity> searchUsersByEmail(String email) {
        return iirerRepo.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public VR_Entity saveVRService(VR_Entity vrEntity) {
       return vrServiceRepo.save(vrEntity);
    }

    @Override
    public CIEEntity savecieentity(CIEEntity cieEntity) {
        return cieRepo.save(cieEntity);
    }

    @Override
    public DRSEntity drsclousre(DRSEntity drsEntity) {
        return drsRepo.save(drsEntity);
    }

    @Override
    public boolean validateUser(String email, String password) {

        Optional<SignupEntity> optionalUser = signupRepo.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return false;
        }

        SignupEntity user = optionalUser.get();

        return user.getEmail().equals(email) && user.getPassword().equals(password);
    }

//    @Override
//    public VR_Entity saveVRServiceNew(VRServiceDTO vrServiceDTO) {
//
//        return vrServiceRepo.save(vrServiceDTO);;
//    }

    @Override
    public LoginRequestDTO findByEmail(String email) {
        Optional<SignupEntity> optionalUser = signupRepo.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return null;
        }

        SignupEntity user = optionalUser.get();

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setCustomerID(user.getId());
        loginRequestDTO.setEmail(user.getEmail());
        loginRequestDTO.setPassword(user.getPassword());

        return loginRequestDTO;
    }

    @Override
    public PdfEntity uploadPdf(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        if (!"application/pdf".equalsIgnoreCase(file.getContentType())) {
            throw new RuntimeException("Only PDF files are allowed");
        }

        PdfEntity pdf = new PdfEntity();
        pdf.setFileName(file.getOriginalFilename());
        pdf.setContentType(file.getContentType());
        pdf.setFileSize(file.getSize());
        pdf.setUploadedAt(LocalDateTime.now());
        pdf.setData(file.getBytes());

        return pdfRepo.save(pdf);
    }

    @Override
    public PdfEntity getPdfById(Long id) {
        return pdfRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PDF not found with id: " + id));
    }
}




