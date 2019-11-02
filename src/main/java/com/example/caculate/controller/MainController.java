package com.example.caculate.controller;

import com.example.caculate.process.ProcessNum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value={"/","/*"},method= RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value={"/"},method=RequestMethod.POST)
    public String caculate(@RequestParam(name="number") String listNum, Model model){
        String[] arrNum=listNum.split(",");
        int[] arr = new int[10];
        for(int i=0;i<arrNum.length;i++){
            arr[i]=Integer.parseInt(arrNum[i]);
        }
        ProcessNum proces=new ProcessNum();
        proces.sort(arr,0,9);
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        int sum1=0,sum2=0;
        for(int i=0;i<arr.length/2;i++){
            s1.append(arr[i]).append(",");
            sum1+=arr[i];
            s2.append(arr[i+5]).append(",");
            sum2+=arr[i+5];
        }
        model.addAttribute("listNum",listNum);
        model.addAttribute("groupA",s1);
        model.addAttribute("groupB",s2);
        model.addAttribute("value",sum2-sum1);
        return "index";
    }
}
