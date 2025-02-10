package org.example.samplecode.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.samplecode.util.genderValidator.Gender;
import org.example.samplecode.util.genderValidator.GenderSubset;
import org.example.samplecode.util.phoneValidator.PhoneNumber;
import org.example.samplecode.util.statusValidator.EnumPattern;
import org.example.samplecode.util.statusValidator.UserStatus;
import org.example.samplecode.util.typeValidator.EnumValue;
import org.example.samplecode.util.typeValidator.UserType;

import java.io.Serializable;

import static org.example.samplecode.util.genderValidator.Gender.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO  implements Serializable {
    @NotBlank(message = "first name not blank")
    private String firstName;
    private String lastName;
    private String email;

    @PhoneNumber
    private String phone;

    @GenderSubset(anyOf = {MALE, FEMALE, OTHER})
    private Gender gender;

    @EnumValue(name = "type" , enumClass = UserType.class)
    private String type;

    @EnumPattern(name = "satus" , regexp = "^ACTIVE|INACTIVE|NONE")
    private UserStatus status;

    public UserRequestDTO(String java, String spring, String mail, String number, UserStatus userStatus) {
    }
}
