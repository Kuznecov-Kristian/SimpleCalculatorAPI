package org.example.simplecalculatorapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminResource {

    @GetMapping
    public String admin() {
        return "Admin Panel";
    }
}
