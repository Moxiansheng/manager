package com.mo.manager.controller;


import com.mo.manager.service.InfoGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaomo
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/infoGoods")
public class InfoGoodsController {

    @Autowired
    InfoGoodsService infoGoodsService;

    @GetMapping("/stock")
    public String showStock(){

        return "stockManage";
    }

    @PostMapping("/stock")
    public String updateStock(){

        return null;
    }

}
