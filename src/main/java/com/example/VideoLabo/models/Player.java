package com.example.VideoLabo.models;

import com.example.VideoLabo.util.validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private Long id;

    @NotNull(message = "userName can't be null") //existen la notaciones @Size @Min @Max para definir cantidad de caracteres
    private String userName;
    @NotNull(message = "password can't be null")
    @ValidPassword
    private String password;

    @NotNull (message = "email can't be null")
    @Email(message = "email can't be null")
    private String email;
    private String avatar;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")//en el config se agrego objectMapper.registerModule(new JavaTimeModule());
    //para que no se rompa la app, pero el formato devuelto es poco amigable. a raiz de eso, esta notacion para darle un formato más amigable
    private LocalDateTime lastLoginDate;


}