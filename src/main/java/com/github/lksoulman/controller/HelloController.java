package com.github.lksoulman.controller;

import com.alibaba.fastjson.JSON;
import com.github.lksoulman.service.HelloService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author lksoulman
 * @date 2019/01/09
 */
@RestController
public class HelloController {

  @Autowired
  private HelloService helloService;

  @RequestMapping("/hello")
  @ResponseBody
  public Map<String, Object> hello(String name, HttpServletRequest request) {
    System.out.println("Hello:" + name);

    System.out.println("request.getRequestURL() = " + request.getRequestURL());
    System.out.println("request.getQueryString() = " + request.getQueryString());
    System.out.println("request.getSession().getId() = " + request.getSession().getId());

    String result = helloService.sayHello(name);
    Map<String,Object> map = new HashMap<>(2);
    map.put("code",200);
    map.put("msg",result);
    System.out.println("map json:" + JSON.toJSONString(map,true));
    return map;
  }
}
