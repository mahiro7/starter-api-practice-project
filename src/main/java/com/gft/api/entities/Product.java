package com.gft.api.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Product {
    private String name;
    private String provider;
    private String dtUsed;
    private String dtExpiration;
    private String responsible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDtExpiration() {
        return dtExpiration;
    }

    public void setDtExpiration(String dtExpiration) {
        this.dtExpiration = dtExpiration;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDtUsed() {
        return dtUsed;
    }

    public void setDtUsed(String dtUsed) {
        this.dtUsed = dtUsed;
    }

    public String getResponsavel() {
        return responsible;
    }

    public void setResponsavel(String responsible) {
        this.responsible = responsible;
    }
}
