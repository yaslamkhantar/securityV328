package elmoukhantar.yass.securitytraining328v.entities;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employe {

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/voiture")
    public String testWeb(){
        return "voiture";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user")
    public String test2(){
        return "Megane";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/admin")
    public String test3(){
        return "peugeot";
    }
}
