package com.example.crudtutorial.dto;

import com.example.crudtutorial.onetomany.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private AddressType addressType;

}
