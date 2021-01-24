package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * add info here about controller
 */

@Controller
 // can be at the top of the class if all methods will use this
//@RequestMapping("form") // will create the path at the class level instead of at the method level
public class HelloController {

//    @GetMapping("hello") // specifies get requests should be accepted - without a path it lives at the root path.
//    @ResponseBody // this won't be used when we start using templates - returns plain text response
//    public String hello() {
//        return "Hello, Spring!";
//    }
//    This was commented out because two controllers can't point to the same path - see hello path below.

//    @GetMapping("goodbye") // specifies get requests should be accepted - without a path it lives at the root path.
////    @ResponseBody // this won't be used when we start using templates - returns plain text response
//    public String goodbye() {
//        return "BuhBye, Spring!";
//    }
//
//    // Handles requests of the form / hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET}) // removed value="hello" from original after putting path above class
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        return "Hello, " + name + "!";
//        }
//
//    // Handles requests of the form /hello/LaunchCode
//
//    @GetMapping("{name}") // removed "hello/ from the original after putting path above class
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    //responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // removed value="hello" from original after putting path above class
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting); // local variable should match second value in the add attribute statement
        return "hello";
    }


    //responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!"); // local variable should match second value in the add attribute statement
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Rachele");
        names.add("Jen");
        names.add("Ellen");
        names.add("OG LaunchCoders");
        model.addAttribute("names", names);
        return "hello-list";
    }

    //    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // removed value="hello" from original after putting path above class
    //    @ResponseBody
    //    public String hello(@RequestParam String name) {
    //        return "Hello, " + name + "!";
    //    }

//    @ResponseBody
//    public String hello(@RequestParam String name, @RequestParam String language) {
//        String greeting;
//        switch (language){
//            case "french":
//                greeting = "Bonjour";
//                break;
//            case "italian":
//                greeting = "Ciao";
//                break;
//            case "spanish":
//                greeting =  "Hola";
//                break;
//            case "pigLatin":
//                greeting = "ElloHay";
//                break;
//            case "canadian":
//                greeting = "Eh Hello";
//                break;
//            default:
//                greeting = "Hi there";
//
//        }
//        return greeting + ", " + name + "!";
//    }


//    @GetMapping("form")
//    public String helloForm(){
//        return "form";
//    }

//    @PostMapping
//    @ResponseBody
//    public String reply(@RequestParam String name, @RequestParam String language) {
//        String greeting;
//        switch (language){
//        case "french":
//            greeting = "Bonjour";
//            break;
//        case "italian":
//            greeting = "Ciao";
//            break;
//        case "spanish":
//            greeting =  "Hola";
//            break;
//        case "pigLatin":
//            greeting = "ElloHay";
//            break;
//        case "canadian":
//            greeting = "Eh Hello";
//            break;
//        default:
//            greeting = "Hi there";
//
//        }
//        return greeting + ", " + name + "!";
//    }
}

//now wired to be a request handler