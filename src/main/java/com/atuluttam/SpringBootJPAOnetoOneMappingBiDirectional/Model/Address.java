package com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long add_id;
    private String street;
    private String city;
    private String pincode;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    // Prevent circular reference
    @JsonIgnore
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //Name of property in student class
    private Student student;
}
