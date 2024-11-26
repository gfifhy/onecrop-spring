package com.onecrop.onecrop.mapper;

import com.onecrop.onecrop.dto.AddressDto;
import com.onecrop.onecrop.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public Address addressRequestDtotoAddressEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setAddressLine2(addressDto.getAddressLine2());
        address.setBarangay(addressDto.getBarangay());
        address.setCity(addressDto.getCity());
        address.setRegion(addressDto.getRegion());
        address.setPostalCode(addressDto.getPostalCode());


        return address;
    }
}
