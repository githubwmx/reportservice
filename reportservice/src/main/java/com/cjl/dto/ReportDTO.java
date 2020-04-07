package com.cjl.dto;

import lombok.Data;

@Data
public class ReportDTO {

    /**
     * 主键
     */
    private String serialkey;

    /**
     * 公司代码
     */
    private String companycode;

    /**
     * 仓库代码
     */
    private String dccode;

    /**
     * 仓库名称
     */
    private String dcname;

    /**
     * 客户代码
     */
    private String storerkey;

    /**
     * 客户名称
     */
    private String storername;

    /**
     * 报表日期
     */
    private String rptdt;

    /**
     * 订单数
     */
    private Double packageCnt;

    /**
     * 商品数
     */
    private Double skuCnt;

    /**
     * PCS数
     */
    private Double pcsCnt;

    /**
     * 取消单数
     */
    private Double cancelCnt;

    /**
     * 拣货数
     */
    private Double pickingQty;

    /**
     * 检验数
     */
    private Double inspectionQty;

    /**
     * 打包数
     */
    private Double packingQty;

    /**
     * 完成数
     */
    private Double finishQty;

}
