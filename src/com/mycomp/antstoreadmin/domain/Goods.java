package com.mycomp.antstoreadmin.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private String image;
    private String gdesc;
    private Integer is_hot;
    private Integer cid;

    @Override
    public String toString() {
        return "Goods [id=" + id + ", name=" + name + ", price=" + price
                + ", image=" + image + ", desc=" + gdesc + ", is_hot=" + is_hot
                + ", cid=" + cid + "]";
    }
}
