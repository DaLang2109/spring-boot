package com.zhang.utill;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanping_zhang
 * @create 2020/8/5 4:03
 * @desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
    // 状态码 200-成功 400
    private int code;
    private String msg;
    private Map<String, Object> data = new HashMap<String, Object>();
    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("处理成功!");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(500);
        msg.setMsg("处理失败!");
        return msg;
    }

    public Msg add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }


}
