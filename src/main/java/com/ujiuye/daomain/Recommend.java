package com.ujiuye.daomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Recommend {
    private Integer id;
    private String way;
    private int isrecommend;
}
