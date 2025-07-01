package br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public class ClientAccountFormDTO {

    private UUID id;

    @NotBlank
    @Size(max = 50, message = "Username deve ter menos de 50 caracteres")
    private String userName;

    @NotBlank
    @Size(max = 100, message = "Identificador de cliente deve ter menos de 100 caracteres")
    private String identifier;

    public ClientAccountFormDTO() {
    }

    public ClientAccountFormDTO(UUID id, String userName, String identifier) {
        this.id = id;
        this.userName = userName;
        this.identifier = identifier;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getIdentifier() { return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }
}