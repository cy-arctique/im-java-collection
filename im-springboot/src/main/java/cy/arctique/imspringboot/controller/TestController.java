package cy.arctique.imspringboot.controller;

import cy.arctique.imspringboot.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cy
 * @date 2022-08-13 10:33
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试Api")
public class TestController {

    /**
     * 查询分页
     *
     * @return {@link R<String>}
     */
    @GetMapping("/getPages")
    @ApiOperation(value = "查询分页")
    public R<String> getPages() {
        return new R<>();
    }
}
