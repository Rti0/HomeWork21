package com.example.school_anagement_software.Service;

import com.example.school_anagement_software.ApiException.ApiException;
import com.example.school_anagement_software.DTO.AddressDTO;
import com.example.school_anagement_software.Model.Address;
import com.example.school_anagement_software.Model.Teacher;
import com.example.school_anagement_software.Repository.AddressRepository;
import com.example.school_anagement_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    //Add teacher address
    public void addTeacherAddress(AddressDTO dto) {
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Can't add address, teacher not found");
        }
        Address address = new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id,Address address){
        Address old=addressRepository.findAddressById(id);
        if (old==null){
            throw new ApiException("Not Found");
        }
        old.setArea(address.getArea());
        old.setStreet(address.getStreet());
        old.setBuildingNumber(address.getBuildingNumber());
        addressRepository.save(old);
    }

    public void deleteAddress(Integer id){
        Address address=addressRepository.findAddressById(id);
            if (address==null){
                throw new ApiException("Not Deleted");
            }
         addressRepository.delete(address);
        }
    }






