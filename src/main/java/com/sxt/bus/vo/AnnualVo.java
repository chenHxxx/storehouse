package com.sxt.bus.vo;

import com.sxt.bus.domain.Annual;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AnnualVo extends Annual {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;
}
