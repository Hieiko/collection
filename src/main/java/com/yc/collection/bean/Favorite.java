package com.yc.collection.bean;

import lombok.Data;

@Data
public class Favorite implements java.io.Serializable{
    private Integer fid;

    private String flabel;

    private String furl;

    private String fdesc;

    private String ftags;
}
