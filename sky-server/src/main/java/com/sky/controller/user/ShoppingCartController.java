package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "C端-购物车接口")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public Result<Void> add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("添加购物车:{}", shoppingCartDTO);
        shoppingCartService.add(shoppingCartDTO);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<ShoppingCart>> list(){
        log.info("查询购物车");
        return Result.success(shoppingCartService.list());
    }

    @DeleteMapping("/clean")
    public Result<Void> clean(){
        log.info("清空购物车");
        shoppingCartService.clean();
        return Result.success();
    }

    @PostMapping("/sub")
    public Result<Void> sub(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("删除购物车:{}", shoppingCartDTO);
        shoppingCartService.sub(shoppingCartDTO);


        return Result.success();
    }
}
