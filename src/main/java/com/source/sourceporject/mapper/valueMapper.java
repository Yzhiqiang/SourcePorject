package com.source.sourceporject.mapper;

import com.source.sourceporject.entity.Value;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 12:48 2021/11/2
 * @Modified By:
 */
@Mapper
public interface valueMapper {
    public int save(Value Value);
}
