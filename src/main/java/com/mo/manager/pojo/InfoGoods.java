package com.mo.manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaomo
 * @since 2021-03-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InfoGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 货物id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 货物名
     */
    private String goodsName;

    /**
     * 货物量
     */
    private Integer goodsCount;

    /**
     * 货物单位
     */
    private String goodsUnit;

    /**
     * 货物进价
     */
    private Integer goodsPerchase;

    /**
     * 货物售价
     */
    private Integer goodsSell;

    /**
     * 货物产地
     */
    private String goodsOrigin;

    /**
     * 货物供应商
     */
    private String goodsSupplier;

    /**
     * 货物描述
     */
    private String goodsDetail;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;


}
