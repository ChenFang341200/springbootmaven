package com.chen.controller;

import com.chen.service.TickeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/13 16:10
 */
@RestController
public class TiketController {

    @Autowired
    TickeService tickeService;

    @GetMapping("/tiket")
    public String getTikes(){
        return tickeService.getTiket();
    }

}
