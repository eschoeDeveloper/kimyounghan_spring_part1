package com.hello.servlet.springmvc.basic;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {

    /**
     *  회원 목록 조회 : GET /users
     *  회원 등록 : POST /users
     *  회원 조회 : GET /users/{userId}
     *  회원 수정 : PATCH /users/{userId}
     *  회원 삭제 : DELETE /users/{userId}
    * */
    @GetMapping("/mapping/users")
    public String user() {
        return "get users";
    }

    @PostMapping("/mapping/users")
    public String addUser() {
        return  "post user";
    }

    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable("userId") String userId) {
        return "get userId=" + userId;
    }

    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable("userId") String userId) {
        return "update userId=" + userId;
    }

    @DeleteMapping("/mapping/users/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        return "delete userId=" + userId;
    }

}
