package com.sda.carrentalproject.dto;

import com.sda.carrentalproject.domain.PriceList;
import com.sda.carrentalproject.domain.enumeration.Color;
import java.time.YearMonth;
import lombok.Builder;

@Builder
public record CarDto(Long id,
                    String brand,
                    String model,
                    YearMonth productionYear,
                    Color color,
                    boolean available,
                     long pricePerDayInEuroCents
) {

}
