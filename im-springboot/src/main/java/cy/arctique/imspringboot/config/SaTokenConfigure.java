package cy.arctique.imspringboot.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @date 2022-05-11 16:43
 **/
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 注册sa-token的注解拦截器，打开注解式鉴权功能
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址
        // 注解拦截方式
         registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");

        // 路由拦截方式
        List<String> excludePaths = new ArrayList<>();

        // 需要开放的接口
        // swagger2
        excludePaths.add("**/swagger-ui.html");
        excludePaths.add("/swagger-resources/**");
        excludePaths.add("/webjars/**");
        excludePaths.add("/v2/**");
        excludePaths.add("/swagger-ui.html/**");
        excludePaths.add("/doc.html/**");
        excludePaths.add("/error");
        excludePaths.add("/favicon.ico");
        excludePaths.add("sso/auth");
        excludePaths.add("/csrf");
        excludePaths.add("/");

        excludePaths.add("/test/**");

        registry.addInterceptor(new SaRouteInterceptor())
                .addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
}
