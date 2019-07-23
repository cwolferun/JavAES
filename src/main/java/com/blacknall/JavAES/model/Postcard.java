package com.blacknall.JavAES.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "postcard")
public class Postcard {

    @Id
    UUID id;

    @JsonProperty(value = "to")
    @NotEmpty(message = "To must have a value")
    String uto;

    @NotEmpty(message = "From must have a value")
    @JsonProperty(value = "from")
    String ufrom;
    String message;
}
