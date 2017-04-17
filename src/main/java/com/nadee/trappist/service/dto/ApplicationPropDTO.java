package com.nadee.trappist.service.dto;

import javax.validation.constraints.Size;

/**
 * A DTO representing an application's properties
 */
public class ApplicationPropDTO {

    @Size(max = 256)
    private String logoUrl;

    public ApplicationPropDTO(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "ApplicationPropDTO{" + '\'' +
            "logoUrl='" + this.logoUrl + '\'' +
            "}";
    }
}
