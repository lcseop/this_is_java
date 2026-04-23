package com.mjc813.cafe_kiosk.models.sale;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;

    public SaleDto insert(SaleDto newDto) {
        SaleEntity newEntity = new SaleEntity();
        newEntity.copyMembers(newDto, true);
        newEntity.setId(null);
        SaleEntity save = this.repository.save(newEntity);

        SaleDto result = new SaleDto();
        result.copyMembers(save, true);
        return result;
    }
}
