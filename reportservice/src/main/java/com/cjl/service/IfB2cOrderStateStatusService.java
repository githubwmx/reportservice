package com.cjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjl.dto.ReportDTO;
import com.cjl.entity.IfB2cOrderStateStatus;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wmx
 * @since 2020-04-02
 */
public interface IfB2cOrderStateStatusService extends IService<IfB2cOrderStateStatus> {

    void saveBatch(List<ReportDTO> reportRequest);

}
