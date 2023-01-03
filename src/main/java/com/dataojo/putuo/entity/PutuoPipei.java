package com.dataojo.putuo.entity;

import java.io.Serializable;

/**
 * (PutuoPipei)实体类
 *
 * @author makejava
 * @since 2022-12-29 16:33:13
 */
public class PutuoPipei implements Serializable {
    private static final long serialVersionUID = -62628485465180250L;

    private String address;

    private Integer matchcount;

    private Integer id;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMatchcount() {
        return matchcount;
    }

    public void setMatchcount(Integer matchcount) {
        this.matchcount = matchcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "PutuoPipei {" +
                "address : " + address + ", " +
                "matchcount : " + matchcount + ", " +
                "id : " + id + ", " +
                '}';
    }
}