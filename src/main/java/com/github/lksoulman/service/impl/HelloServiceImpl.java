package com.github.lksoulman.service.impl;

import com.github.lksoulman.service.HelloService;
import org.springframework.stereotype.Service;

/*
 * @author lksoulman
 * @date 2019/01/09
 */
@Service
public class HelloServiceImpl implements HelloService {

  @Override
  public String sayHello(String name) {
    return name + "： Hello World!";
  }
}
