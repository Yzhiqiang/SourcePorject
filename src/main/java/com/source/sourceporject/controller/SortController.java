package com.source.sourceporject.controller;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.source.sourceporject.entity.Value;
import com.source.sourceporject.mapper.valueMapper;
import com.source.sourceporject.sort.Csort;
import com.source.sourceporject.sort.Jsort;
import com.source.sourceporject.sort.Tsort;
import com.source.sourceporject.sort.Xsort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 8:48 2021/11/2
 * @Modified By:
 */
@Controller
public class SortController {

    @Autowired
    valueMapper  valuemapper;

    @RequestMapping("/")
    public String view(){
        return "index";
    }

    @RequestMapping("/toTsort")
    public String toTsort() {
        return "Tsort";
    }

    @RequestMapping("/toJsort")
    public String toJsort() {
        return "Jsort";
    }
    @RequestMapping("/tsort")
    public String Tsort(String values, Model model) {
        String []ss = values.split(" ");
        int []arr = new int[ss.length];
        for(int i = 0; i < ss.length; i++)
        {
            arr[i] = Integer.parseInt(ss[i]);
        }
        System.out.println(arr);
        Tsort t = new Tsort(arr);
        t.bucketSort();
        arr = t.getArray();
        String res = new String();
        for(int i = 0; i < arr.length; i++){
            res += arr[i] + " ";
        }
        Value value = new Value(values, res);
        valuemapper.save(value);
        model.addAttribute("res", res);
        model.addAttribute("msg","排序后的结果为：");
        return "Tsort";
    }

    @RequestMapping("/jsort")
    public String Jsort(String values, Model model) {
        String []ss = values.split(" ");
        int []arr = new int[ss.length];
        for(int i = 0; i < ss.length; i++)
        {
            arr[i] = Integer.parseInt(ss[i]);
        }
        Jsort j = new Jsort(arr);
        j.radixSort();
        arr = j.getArray();
        String res = new String();
        for(int i = 0; i < arr.length; i++){
            res += arr[i] + " ";
        }
        Value value = new Value(values, res);
        valuemapper.save(value);
        model.addAttribute("res", res);
        model.addAttribute("msg","排序后的结果为：");
        return "Jsort";
    }

}
