package com.intocomunity.api.service.dto;

public class LoginDTO {
    private UserDTO userDTO;
    private JwtDTO jwtDTO;

    public LoginDTO(UserDTO userDTO, JwtDTO jwtDTO) {
        this.userDTO = userDTO;
        this.jwtDTO = jwtDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public JwtDTO getJwtDTO() {
        return jwtDTO;
    }

    public void setJwtDTO(JwtDTO jwtDTO) {
        this.jwtDTO = jwtDTO;
    }
}
