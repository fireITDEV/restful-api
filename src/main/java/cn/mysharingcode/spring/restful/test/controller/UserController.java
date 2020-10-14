package cn.mysharingcode.spring.restful.test.controller;


import org.springframework.web.bind.annotation.*;

import cn.mysharingcode.spring.restful.test.vo.UserVO;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("")
    public List<UserVO> list() {
        // 查询列表
        List<UserVO> result = new ArrayList<>();
        UserVO userVO1 =new UserVO();
        userVO1.setId(1L);
        userVO1.setUserName("struts1");
        UserVO userVO2 =new UserVO();
        userVO2.setId(2L);
        userVO2.setUserName("struts2");
        UserVO userVO3 =new UserVO();
        userVO3.setId(3L);
        userVO3.setUserName("spring mvc");
        result.add(userVO1);
        result.add(userVO2);
        result.add(userVO3);
        // 返回列表
        return result;
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Long id) {
        // 查询并返回用户
        UserVO userVO1 =new UserVO();
        userVO1.setId(1L);
        userVO1.setUserName("struts1");
        return userVO1;
    }

    /**
     * 添加用户
     *
     * @param userVO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("")
    public Integer add(UserVO userVO) {
        // 插入用户记录，返回编号
        Integer returnId = 1;
        // 返回用户编号
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param id 用户编号
     * @param userVO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Long id, UserVO userVO) {
        // 将 id 设置到 updateDTO 中
        userVO.setId(id);
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    /**
     * 删除指定用户编号的用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }
}
