package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@Controller
public class RequestParamArrayTestController {
    /**
     * (GET,POST), API 방식으로 String[] 받을 수 있는지 테스트
     */
    @PostMapping("/arrayparam/v1")
//    @GetMapping("/arrayparam/v1")
    @ResponseBody
    public String arrayparamRequestTest(@RequestBody HelloData helloData){
        log.info("HelloData ={}", helloData); //HelloData =HelloData(username=userA, age=1, arr=[1, 2, 3, 4], arrList=[1, 2, 3])
        log.info("helloData.getUsername()={}", helloData.getUsername()); //helloData.getUsername()=userA
        log.info("helloData.getAge()={}", helloData.getAge()); //helloData.getAge()=1
        log.info("helloData.getArr()={}", helloData.getArr()); //helloData.getArr()=1
        log.info("helloData.getArr()={}", helloData.getArr().toString()); //helloData.getArr()=[Ljava.lang.String;@7a859e0f

        // 정상적으로 s=1, s=2, s=3, s=4찍힘
        String[] arr = helloData.getArr();
        for (String s : arr) {
            log.info("s={}", s);
        }

        log.info("Arrays.toString(helloData.getArr())={}", Arrays.toString(helloData.getArr())); //Arrays.toString(helloData.getArr())=[1, 2, 3, 4]
        log.info("helloData.getArrList()={}", helloData.getArrList()); //helloData.getArrList()=[1, 2, 3]
        return "ok";
    }


}
