package com.cjl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjl.dto.ReportDTO;
import com.cjl.entity.IfB2cOrderStateStatus;
import com.cjl.mapper.IfB2cOrderStateStatusMapper;
import com.cjl.service.IfB2cOrderStateStatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wmx
 * @since 2020-04-02
 */
@Service
public class IfB2cOrderStateStatusServiceImpl extends ServiceImpl<IfB2cOrderStateStatusMapper, IfB2cOrderStateStatus> implements IfB2cOrderStateStatusService {

    @Autowired
    private IfB2cOrderStateStatusMapper ifB2cOrderStateStatusMapper;

    @Override
    public void saveBatch(List<ReportDTO> reportDTOS) {
        if(!CollectionUtils.isEmpty(reportDTOS)) {
            for(int i=0;i<reportDTOS.size();i++) {
                IfB2cOrderStateStatus report = new IfB2cOrderStateStatus();
                BeanUtils.copyProperties(reportDTOS.get(i), report);
                ifB2cOrderStateStatusMapper.insert(report);
            }
//            reportDTOS.stream().forEach(dto ->{
////                IfB2cOrderStateStatus report = new IfB2cOrderStateStatus();
////                BeanUtils.copyProperties(dto, report);
////                ifB2cOrderStateStatusMapper.insert(report);
//            });
        }
    }
}
