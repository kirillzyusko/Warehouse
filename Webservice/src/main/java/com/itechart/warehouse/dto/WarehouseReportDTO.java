package com.itechart.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itechart.warehouse.deserializer.TrimmingJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.LocalDate;

/**
 * Created by Alexey on 30.04.2017.
 */
@Getter
@Setter
@ToString
public class WarehouseReportDTO {
    @JsonDeserialize(using = TrimmingJsonDeserializer.class)
    private Long idWarehouse;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
