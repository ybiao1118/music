package com.cqyb.music.util;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/22 16:08
 * @Description:
 */
public class OkResult extends JsonResult {
    public OkResult() {
        super(200, (String)null, (Object)null);
    }
    public OkResult(Object data) {
        super(200, (String)null, data);
    }
    public OkResult(String message, Object data) {
        super(200, message, data);
    }
}
