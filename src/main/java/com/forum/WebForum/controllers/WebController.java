package com.forum.WebForum.controllers;

import com.forum.WebForum.Iservice.IPremiumKitBonusCalculation;
import com.forum.WebForum.Iservice.ICustomerAcquisitionBonusCalculationService;
import com.forum.WebForum.dataProvider.CompenstionPlansData;
import com.forum.WebForum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
//@RequestMapping("/nextSphere")
public class WebController {

    @Autowired
    IPremiumKitBonusCalculation IPremiumKitBonusCalculation;

    @Autowired
    ICustomerAcquisitionBonusCalculationService iCustomerAcquisitionBonusCalculationService;


    @PostMapping("/percentage")
    public PremiumKitBonusReturn setPercentage(@RequestBody PremiumKitPercentage percentage) throws Exception {
        PremiumKitBonusReturn bonusReturn= IPremiumKitBonusCalculation.setPercentage(percentage);

        return bonusReturn;

    }


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
    @PostMapping("/levels")
    public  List<CustomerAcquisitionBonusDetails> bonusDetailsList(@RequestBody CustomerAcquisitionLevels levels) throws IOException
    {
        List<CustomerAcquisitionBonusDetails> bonusDetailsList = iCustomerAcquisitionBonusCalculationService.setLevels(levels);
        System.out.println("\n\n**************************\n\n");
        System.out.println("Customer Acquisition Bonus Details\n\n");
        for (CustomerAcquisitionBonusDetails i : bonusDetailsList) {
            System.out.println(i);
        }
        return bonusDetailsList;
    }

}
