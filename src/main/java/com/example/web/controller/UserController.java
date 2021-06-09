package com.example.web.controller;

import com.example.domain.*;
import com.example.domain2.UserListTO;
import com.example.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.example.domain.UserTO;

import java.util.List;

/**
 * Swagger2测试接口
 *
 * @author qiyu
 * @date 2020-09-20 17:13
 */
@RestController
@Slf4j
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 新增用户
     * @param user
     * @return
     */
/*    @ApiOperation(value = "新增用户")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody TkUserPojo user) {
        log.info("user:{}", user);
        return Result.success(user);
    }*/

    /**
     * 根据用户名和年龄获取用户
     *
     * @param name
     * @param age
     * @return
     */
//    @GetMapping("/getUserByNameAndAge1")
//    public Result getUserByNameAndAge1(@ApiParam(value = "姓名",type = "String",required = true) @RequestParam String name, @ApiParam(value = "年龄",type = "Integer",required = true) @RequestParam int age) {
//        log.info("name:{}, age:{}", name, age);
//        return Result.success(new TkUserPojo());
//    }

    /**
     * 根据用户名和年龄获取用户
     *
     * @param name
     * @param age
     * @return
*/

    @ApiResponses({
            @ApiResponse(code = -1, message = "网络错误"),
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 910, message = "token为空"),
            @ApiResponse(code = 911, message = "token无效")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "Integer", paramType = "query", required = true)
    })
    @GetMapping("/getUserByNameAndAge")
    public Result getUserByNameAndAge(@RequestParam String name, @RequestParam Integer age) {
        log.info("name:{}, age:{}", name, age);
        return Result.success(new TkUserPojo());
    }

    @GetMapping("/getUser")
    public ApiResultTO<UserTO> getUser(){
        //参数校验失败
        String username = "";
        if(StringUtils.isEmpty(username)){
            //可以把常见的错误信息抽取到枚举类并传入
            return ApiResultTO.buildFailed(ExceptionCodeEnum.NO_PERMISSION);
        }


        //查询并返回
        return ApiResultTO.buildSuccess(new UserTO());
    }



    @GetMapping("/listUser")
    public PageResult<UserTO> listUser(){
        //查询并返回(userService返回的时Page对象。含有列表+分页信息
        return PageResult.success(userService.listUser());
    }

    @GetMapping("/getUser")
    public ApiResultTO<UserListTO> getUser(Integer page,Integer pageSize){
        //查询用户列表
        List<UserTO> userList = userService.listUser1();

        //封装
        UserListTO userListTO = new UserListTO();
        userListTO.setUserList(userList);
        userListTO.setHasMore(userList.size() >= pageSize);
        return  ApiResultTO.buildSuccess(userListTO);

    }
}
