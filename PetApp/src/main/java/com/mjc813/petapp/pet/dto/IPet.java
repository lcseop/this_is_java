//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mjc813.petapp.pet.dto;

import java.time.LocalDate;
import lombok.Generated;

public interface IPet {
    Integer getId();

    String getName();

    String getSpecies();

    String getBreed();

    String getGender();

    LocalDate getBirth();

    String getImgFile();

    void setId(final Integer id);

    void setName(final String name);

    void setSpecies(final String species);

    void setBreed(final String breed);

    void setGender(final String gender);

    void setBirth(final LocalDate birth);

    void setImgFile(final String imgFile);

    default void copyMemberValue(IPet pet) {
        if (pet.getId() != null) {
            setId(pet.getId());
        }
        if (pet.getName() != null) {
            setName(pet.getName());
        }
        if (pet.getSpecies() != null) {
            setSpecies(pet.getSpecies());
        }
        if (pet.getBreed() != null) {
            setBreed(pet.getBreed());
        }
        if (pet.getGender() != null) {
            setGender(pet.getGender());
        }
        if (pet.getBirth() != null) {
            setBirth(pet.getBirth());
        }
        if (pet.getImgFile() != null) {
            setImgFile(pet.getImgFile());
        }
    }

}
