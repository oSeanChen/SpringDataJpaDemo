package com.oseanchen.demotest.apiDemo;


import org.springframework.web.bind.annotation.*;


@RestController
public class RequestController {
    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                        @RequestParam(defaultValue = "Sean") String name,
                        @RequestParam(value = "nickname", required = false) String nickname
    ) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        System.out.println("name:" + nickname);
        return "your request id is " + id + " and name is " + name + ", or you can called me " + nickname;
    }

    @PostMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("student id: " + student.getId() );
        System.out.println("student name: " + student.getName() );
        return "hello test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info,
                        @RequestHeader (name = "gogo", required = false) String gogo){
        System.out.println("header info: " + info);
        System.out.println("header gogo: " + gogo);
        return "hello test3";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name
    ){
        System.out.println("path id: " + id);
        System.out.println("path name: " + name);
        return "hello test4";
    }
}
