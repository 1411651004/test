package com.example.demo.pojo;

/**Http请求返回的最外层对象（返回的格式）
 * Created by gzf on 2017/8/13.
 */
public class Result<T> {
    /** 错误码0成功，1失败*/
    private Integer code;

    /**提示信息*/
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**返回的具体内容*/

    private T data;
}
