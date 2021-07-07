package com.sxt.bus.vo;

import com.sxt.bus.domain.InOutInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InOutInfoVo extends InOutInfo {

    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

}
