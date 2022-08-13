package cy.arctique.imspringboot.handler;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.NotSafeException;
import cy.arctique.imspringboot.util.Constant;
import cy.arctique.imspringboot.util.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * sa-token全局异常处理
 *
 * @author cy
 * @date 2022-05-11 16:42
 **/
@RestControllerAdvice
@Component
public class SaTokenExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public R handlerNotLoginException(NotLoginException e) {
        String message;
        switch (e.getType()) {
            case NotLoginException.NOT_TOKEN:
                message = "未提供Token";
                break;
            case NotLoginException.INVALID_TOKEN:
                message = "未提供有效的Token";
                break;
            case NotLoginException.TOKEN_TIMEOUT:
                message = "登录信息已过期，请重新登录";
                break;
            case NotLoginException.BE_REPLACED:
                message = "您的账户已在另一台设备上登录，如非本人操作，请立即修改密码";
                break;
            case NotLoginException.KICK_OUT:
                message = "已被系统强制下线";
                break;
            default:
                message = "当前会话未登录";
                break;
        }

        return R.failure(Constant.SA_TOKEN_FAILED, message);
    }

    /**
     * 403
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotRoleException.class)
    @ResponseBody
    public R handlerNotRoleException(NotRoleException e) {
        return R.failure("无此角色：" + e.getRole());
    }

    /**
     * 403
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotPermissionException.class)
    @ResponseBody
    public R handlerNotPermissionException(NotPermissionException e) {
        return R.failure("无此权限：" + e.getCode());
    }

    /**
     * 401
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DisableLoginException.class)
    @ResponseBody
    public R handlerDisableLoginException(DisableLoginException e) {
        return R.failure("账户被封禁：" + e.getDisableTime() + "秒后解封");
    }

    /**
     * 401
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotSafeException.class)
    @ResponseBody
    public R handlerNotSafeException(NotSafeException e) {
        return R.failure("二级认证异常：" + e.getMessage());
    }
}
