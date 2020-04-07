package com.cjl.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReportRequest {

    private List<ReportDTO> reportDTOs;

}
