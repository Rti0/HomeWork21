package com.example.school_anagement_software.Controller;

import com.example.school_anagement_software.DTO.AddressDTO;
import com.example.school_anagement_software.Model.Address;
import com.example.school_anagement_software.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

private final AddressService addressService;


@PostMapping("/addAddress")
public ResponseEntity addTeacherAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addTeacherAddress(addressDTO);
        return ResponseEntity.status(200).body("Done Added");
    }
@PutMapping("/updateAddress/{id}")
    public ResponseEntity updateAddress(@RequestBody @Valid Address address ,@PathVariable Integer id){
    addressService.updateAddress(id,address);
    return ResponseEntity.status(200).body("Address added");
}
@DeleteMapping ("/deleteAddress/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
    addressService.deleteAddress(id);
    return ResponseEntity.status(200).body("Done Deleted");
}
    }

