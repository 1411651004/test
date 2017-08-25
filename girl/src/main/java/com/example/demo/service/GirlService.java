package com.example.demo.service;

import com.example.demo.pojo.Girl;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gzf on 2017/8/11.
 */
@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;

    @Transactional
    //@Transactional注解是事物注解，为了下面两个或多个改动数据库操作，
    // 只有全部完成，才对数据库经行改动，只要一个异常即都不改动
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);

        Integer age = girl.getAge();
        if (age < 10){
            //返回“你还在上小学”
            throw new Exception("你还在上小学吧");
        }else if (age > 10 && age < 20){
            //返回“你可能上初中吧”
            throw new Exception("你可能在上初中吧");
        }
    }
}
