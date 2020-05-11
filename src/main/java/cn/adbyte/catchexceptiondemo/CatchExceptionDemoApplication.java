package cn.adbyte.catchexceptiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@SpringBootApplication
public class CatchExceptionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchExceptionDemoApplication.class, args);
    }

    // 这个问题无法解决：TemplateInputException
    @RequestMapping("/")
    public String testError() {

        return "null-page";
    }

    @ResponseBody
    @RequestMapping("/rest")
    public String longContent() {
        StringBuilder str = new StringBuilder("a");
        for (int i = 0; i < 1000000; i++) {
            str.append(i);
        }
        return str.toString();
    }

}
