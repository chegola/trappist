package com.nadee.trappist.web.rest;

import com.nadee.trappist.config.ApplicationProperties;
import com.nadee.trappist.service.dto.ApplicationPropDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resource to return the application information.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationResource {

    private final Logger log = LoggerFactory.getLogger(ApplicationResource.class);

    private ApplicationProperties applicationProperties;

    public ApplicationResource(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @GetMapping("/login-screen")
    public ResponseEntity<ApplicationPropDTO> getImgLoginUrl(){
        final String logoUrl = this.applicationProperties.getLoginScreen().getLogoUrl();
        final ApplicationPropDTO applicationPropDTO = new ApplicationPropDTO(logoUrl);
        return new ResponseEntity<>(applicationPropDTO, HttpStatus.OK);

    }

}
