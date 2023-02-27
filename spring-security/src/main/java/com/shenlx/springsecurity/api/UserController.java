package com.shenlx.springsecurity.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-5
 * @description:
 * @author: shenlx
 * @create: 2023-02-27 22:58
 **/
@RestController
@RequestMapping("/user")
public class UserController {

        @RequestMapping("/add")
        @PreAuthorize("hasAnyRole('user:add')")
        public String add() {
            return "user:add";
        }

        @RequestMapping("/update")
        @PreAuthorize("hasAnyRole('user:update')")
        public String update() {
            return "user:update";
        }

        @RequestMapping("/view")
        @PreAuthorize("hasAnyRole('user:view')")
        public String view() {
            return "user:view";
        }

        @RequestMapping("/delete")
        @PreAuthorize("hasAnyRole('user:delete')")
        public String delete() {
            return "user:delete";
        }

}
