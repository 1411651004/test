package com.example.demo.controller;

import com.example.demo.pojo.Girl;
import com.example.demo.pojo.Result;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gzf on 2017/8/11.
 */
@RestController
public class GirlController {

    @Autowired
    GirlRepository girlRepository;

    @Autowired
    GirlService girlService;
    /**
     * 查询女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @RequestMapping(value = "/girls1")
    public Result<Girl> girladd(@Valid Girl girl, BindingResult bindingResult){
        //@Valid 是为了验证Girl对象中的拦截，并将验证的结果放在BindindResult中

        /*这里按理说是Girl因为下面需要返回.save(girl)对象，
        * 但是你又想打印错误信息返回的是String信息的，所以在这里可以写Object*/
        if (bindingResult.hasErrors()){
            //输出拦截的内容（bindingResult.getFieldError().getDefaultMessage）
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtils.success(girlRepository.save(girl));
    }
    @GetMapping(value = "/girls2")
    public Girl girlFindOne(@RequestParam("id") Integer id){
        return girlRepository.findOne(id);
    }
    @GetMapping(value = "/girls3/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }
    @GetMapping(value = "/girls4")
    public void girlsAdd(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
