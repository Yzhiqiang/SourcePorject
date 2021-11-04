package com.source.sourceporject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 12:49 2021/11/2
 * @Modified By:
 */
@Data
@NoArgsConstructor
public class Value {
    private int id;
    private String values;
    private String sortedValues;

    public Value(String values, String sortedValues) {
        this.values = values;
        this.sortedValues = sortedValues;
    }
}
