package org.sid.securityservice.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestApi {

    @GetMapping(path = "/dataTest")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public Map<String,Object> dataTest(Authentication authentication){
        return Map.of(
                "message","data Test",
                "username",authentication.getName(),
                "authorities",authentication.getAuthorities()
        );
    }
    @PostMapping(path = "/savedData")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Map<String,String> saveData(String data){
        return Map.of("savedData",data);
    }
}
