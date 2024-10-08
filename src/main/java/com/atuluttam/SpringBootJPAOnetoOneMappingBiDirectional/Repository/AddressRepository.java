package com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Repository;


import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
