package com.mo.manager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaomo
 * @since 2021-03-18
 */
@Controller
@RequestMapping("/infoUser")
public class InfoUserController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
