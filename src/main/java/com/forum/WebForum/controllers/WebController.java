package com.forum.WebForum.controllers;

import com.forum.WebForum.dataProvider.CompenstionPlansData;
import com.forum.WebForum.model.CompensationPlans;
import com.forum.WebForum.model.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
//@RequestMapping("/nextSphere")
public class WebController {


    @RequestMapping("/home")
    public Greetings firstController()
    {

        System.out.println("controller is hit");
        return new Greetings(1,"subha");
    }

    @RequestMapping("/isValidUser")
    public Boolean validateUser(@RequestParam String user)
    {
        System.out.println("controller "+ user);
        if(user.equals("subha6"))
            return true;
        else
            return false;
    }

    @RequestMapping("/isValidPassword")
    public Boolean validatePassword(@RequestParam String password)
    {
        System.out.println("controller "+ password);
        if(password.equals("subha6"))
            return true;
        else
            return false;
    }


    @GetMapping("/mainPlans")
    public List<CompensationPlans> getCompensationPlans(@RequestParam Map<String,String> param)
    {
        List<CompensationPlans> compensationPlansList = CompenstionPlansData.getCompensationPlans();
        List<CompensationPlans> result = new ArrayList<>();

        int key = Integer.parseInt(param.get("mainPlanKey"));
        for (CompensationPlans i : compensationPlansList)
        {
            if(i.getPlanKey() == key)
            {
                result.add(i);
            }
        }

        return result;
    }
}
