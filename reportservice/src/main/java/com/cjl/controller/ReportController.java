package com.cjl.controller;


import com.alibaba.fastjson.JSONObject;
import com.cjl.dto.ReportRequest;
import com.cjl.service.IfB2cOrderStateStatusService;
import com.cjl.util.BusinessException;
import com.cjl.util.EncodeUtil;
import com.cjl.util.Result;
import com.cjl.util.ResultConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wmx
 * @since 2020-04-02
 */
@Slf4j
@Controller
@RequestMapping("/orderStateStatus")
@Api(value = "/orderStateStatus", tags = {"ReportController API"}, description = "报表导入API")
public class ReportController {

    @Resource
    private IfB2cOrderStateStatusService reportService;

    /**
     * 导入数据
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(notes = "导入",
            httpMethod = "POST",
            response = Result.class,
            value = "导入",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result save(@RequestParam("appKey") String appKey, @RequestParam("sign") String sign, @RequestBody String param) throws Exception {
        log.info(String.format("用户%s导入数据%S", appKey, param));
        ReportRequest reportRequest = JSONObject.parseObject(param, ReportRequest.class);
        checkData(reportRequest);
        // 校验sign
        String appSecret = getAppSecret(appKey);
        String md5base64 = EncodeUtil.md5EncryptBase64(param + appSecret);
        log.info("sign: " + md5base64);
        if(md5base64.equals(sign)) {
            reportService.saveBatch(reportRequest.getReportDTOs());
        } else {
            return ResultConstant.createErrorMessage("签名不合法!");
        }
        return ResultConstant.Success;
    }

    private String getAppSecret(String appKey) {
        return "123456"; // todo
    }

    /**
     * 检测导入数据是否合法
     * @param reportRequest
     */
    private void checkData(ReportRequest reportRequest) throws BusinessException {
        if(reportRequest == null) {
            throw new BusinessException("数据不能为空");
        } else if(CollectionUtils.isEmpty(reportRequest.getReportDTOs())) {
            throw new BusinessException("没有业务数据");
        }
    }

}
