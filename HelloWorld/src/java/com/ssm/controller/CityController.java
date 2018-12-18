package com.ssm.controller;

import com.ssm.service.CityService;
import com.ssm.service.CityServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CityController {
    private CityServiceImpl cityService;
     public ModelAndView hello(ModelAndView mv, @RequestParam String id){
         String name = cityService.getCityName(id);
         mv.addObject("cityname", name);
         mv.setViewName("cityname");
         return mv;
    }
}
