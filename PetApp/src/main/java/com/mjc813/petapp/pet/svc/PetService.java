package com.mjc813.petapp.pet.svc;

import com.mjc813.petapp.pet.dto.PetDto;
import com.mjc813.petapp.pet.dto.PetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetDto insert(PetDto petDto) {
        PetEntity petEntity = new PetEntity();
        petEntity.copyMemberValue(petDto);

        this.petRepository.save(petEntity);

        petDto.setId(petEntity.getId());
        return petDto;
    }

    public PetDto update(PetDto petDto) {
        PetEntity petEntity = this.petRepository.findById(petDto.getId()).orElseThrow();
        petEntity.copyMemberValue(petDto);

        this.petRepository.save(petEntity);

        PetDto result = new PetDto();
        result.copyMemberValue(petEntity);
        return result;
    }

    public PetDto deleteById (int id) {
        PetEntity petEntity = this.petRepository.findById(id).orElseThrow();
        this.petRepository.deleteById(id);
        PetDto result = new PetDto();
        result.copyMemberValue(petEntity);
        return result;
    }

    public PetDto findById (int id) {
        PetEntity petEntity = this.petRepository.findById(id).orElseThrow();
        PetDto result = new PetDto();
        result.copyMemberValue(petEntity);
        return result;
    }
}
