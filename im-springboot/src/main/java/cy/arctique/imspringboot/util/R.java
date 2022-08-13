package cy.arctique.imspringboot.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cy
 * @date 2022-05-11 15:23
 */
@Setter
@Getter
@ToString
public class R<T> implements Serializable {
    private static final long serialVersionUID = -3768066512621562450L;

    private Integer code;

    private String msg;

    private T data;

    public static <T> R<T> success() {
        return result(Constant.SUCCESS, null, null);
    }

    public static <T> R<T> success(String msg) {
        return result(Constant.SUCCESS, msg, null);
    }

    public static <T> R<T> success(T data) {
        return result(Constant.SUCCESS, null, data);
    }

    public static <T> R<T> success(String msg, T data) {
        return result(Constant.SUCCESS, msg, data);
    }

    public static <T> R<T> failure() {
        return result(Constant.FAILED, null, null);
    }

    public static <T> R<T> failure(String msg) {
        return result(Constant.FAILED, msg, null);
    }

    public static <T> R<T> failure(Integer code, String msg) {
        return result(code, msg, null);
    }

    public static <T> R<T> failure(String msg, T data) {
        return result(Constant.FAILED, msg, data);
    }

    private static <T> R<T> result(Integer code, String msg, T data) {
        R<T> result = new R<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
