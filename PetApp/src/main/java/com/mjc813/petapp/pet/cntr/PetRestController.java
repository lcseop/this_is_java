package com.mjc813.petapp.pet.cntr;

import com.mjc813.petapp.pet.PetRequestDto;
import com.mjc813.petapp.pet.PetResponseDto;
import com.mjc813.petapp.pet.dto.PetDto;
import com.mjc813.petapp.pet.dto.PetEntity;
import com.mjc813.petapp.pet.svc.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/pet")
public class PetRestController {
    @Autowired
    public PetService petService;

    @PostMapping
    public ResponseEntity<PetResponseDto> insertPet(@RequestBody PetDto petDto) {
        try {
            PetDto result = this.petService.insert(petDto);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @PatchMapping
    public ResponseEntity<PetResponseDto> updatePet(@RequestBody PetDto petDto) {
        try {
            PetDto result = this.petService.update(petDto);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not Found Error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @DeleteMapping
    public ResponseEntity<PetResponseDto> deletePet(@RequestParam Integer id) {
        try {
            PetDto result = this.petService.deleteById(id);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not Found Error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @GetMapping("/{id}") // => /api/pet/id번호
    public ResponseEntity<PetResponseDto> findById(@PathVariable Object id) {
        try {
            Integer nId = Integer.parseInt(id.toString());
            PetDto result = this.petService.findById(nId);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not Found Error", null));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PetResponseDto(-994, "Number Error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<PetResponseDto> findByNameContains
            (@RequestParam String searchName,
             @RequestParam String searchSpecies,
             @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            PetRequestDto prd = new PetRequestDto();
            prd.setSearchName(searchName);
            prd.setSearchSpecies(searchSpecies);
            Page<PetEntity> result = this.petService.findByNameContainsAndSpeciesContains(prd, pageable);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not Found Error", null));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PetResponseDto(-994, "Number Error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }
}
