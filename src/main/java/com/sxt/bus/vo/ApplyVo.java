package com.sxt.bus.vo;


import com.sxt.bus.domain.Apply;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApplyVo extends Apply {


    private static final long serialVersionUID = 1L;

    private Integer page = 1;
    private Integer limit = 10;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date applyTime;
}
