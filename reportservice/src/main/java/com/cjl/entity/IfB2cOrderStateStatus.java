package com.cjl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author wmx
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("IF_B2C_ORDER_STATE_STATUS")
public class IfB2cOrderStateStatus extends Model<IfB2cOrderStateStatus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SERIALKEY", type = IdType.AUTO)
    private Long serialkey;

    @TableField("COMPANYCODE")
    private String companycode;

    @TableField("DCCODE")
    private String dccode;

    @TableField("DCNAME")
    private String dcname;

    @TableField("STORERKEY")
    private String storerkey;

    @TableField("STORERNAME")
    private String storername;

    @TableField("RPTDT")
    private String rptdt;

    @TableField("PACKAGE_CNT")
    private Double packageCnt;

    @TableField("SKU_CNT")
    private Double skuCnt;

    @TableField("PCS_CNT")
    private Double pcsCnt;

    @TableField("CANCEL_CNT")
    private Double cancelCnt;

    @TableField("PICKING_QTY")
    private Double pickingQty;

    @TableField("INSPECTION_QTY")
    private Double inspectionQty;

    @TableField("PACKING_QTY")
    private Double packingQty;

    @TableField("FINISH_QTY")
    private Double finishQty;

    @TableField("DEL_YN")
    private String delYn = "N";

    @TableField("IF_FLAG")
    private String ifFlag = "N";

    @TableField("IF_DATE")
    private Date ifDate;

    @TableField("IF_MEMO")
    private String ifMemo;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableField("CREATE_USER")
    private String createUser = "dashboardif";

    @TableField("IS_PROCESSED")
    private Boolean isProcessed;

    @TableField("IS_LAST")
    private Boolean isLast;

    @TableField("TRIED")
    private Integer tried;

    @TableField("REPLY_MESSAGE")
    private String replyMessage;

    @Override
    protected Serializable pkVal() {
        return this.serialkey;
    }

}
