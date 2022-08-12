package com.example.dataserver.controller;

import com.example.dataserver.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping({"/all", "/"})
    public ModelAndView getAllData(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", webService.getAllData());
        return mav;
    }

    @GetMapping("/statistics")
    public ModelAndView getStatistics(){
        ModelAndView mav = new ModelAndView("statistics");
        mav.addObject("devices", webService.getAllDevices());
//        mav.addObject("list", webService.getAllData());
        mav.addObject("data_count", webService.getDataCountList());
        mav.addObject("device_ids", webService.getDeviceIdList());
        mav.addObject("dates", webService.getTimeIntervalList());
        return mav;
    }

    @GetMapping("/deleteDevice")
    public String deleteEmployee(@RequestParam Long deviceId) {
        webService.deleteDeviceById(deviceId);
        return "redirect:/statistics";
    }

    @GetMapping("/deleteData")
    public String deleteData(@RequestParam Long id) {
        webService.deleteDataById(id);
        return "redirect:/all";
    }

    @GetMapping("/random-fill")
    public ModelAndView randomFill(){
        webService.randomSetup();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", webService.getAllData());
        return mav;
    }

}
