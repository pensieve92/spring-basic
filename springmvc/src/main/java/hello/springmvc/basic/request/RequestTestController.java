package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class RequestTestController {

    /**
     * DTO 사용
     * String[]으로 받기
     *
     * basic
     * 요청 url: http://localhost:8080/request-param-arr-v1?arr=1,2,3,4
     *
     * &arr=7 중복 파라미터
     * 요청 url: http://localhost:8080/request-param-arr-v1?arr=1,2,3,4&arr=7
     */
    @ResponseBody
    @GetMapping("/request-param-arr-v1")
    public String requestParamV1(HttpServletRequest request, HttpServletResponse response, HelloData helloData) {
        // arr = 1,2,3,4
        log.info("arr = {}", request.getParameter("arr"));
        // helloData = HelloData(username=null, age=0, arr=[1, 2, 3, 4])
        // &arr=7: helloData = HelloData(username=null, age=0, arr=[1,2,3,4, 7])
        log.info("helloData = {}", helloData);
        // String.valueOf(helloData) = HelloData(username=null, age=0, arr=[1, 2, 3, 4])
        // &arr=7: String.valueOf(helloData) = HelloData(username=null, age=0, arr=[1,2,3,4, 7])
        log.info("String.valueOf(helloData) = {}", String.valueOf(helloData));
        // helloData.getArr() = 1
        // &arr=7: helloData.getArr() = 1,2,3,4
        log.info("helloData.getArr() = {}", helloData.getArr());

        // helloData.getArr()[0] = 1
        // &arr=7: helloData.getArr()[0] = 1,2,3,4
        log.info("helloData.getArr()[0] = {}", helloData.getArr()[0]);

        // helloData.getArr()[1] = 2
        // &arr=7: helloData.getArr()[1] = 7
        log.info("helloData.getArr()[1] = {}", helloData.getArr()[1]);

        // Arrays.toString(helloData.getArr()) = [1, 2, 3, 4]
        // &arr=7: Arrays.toString(helloData.getArr()) = [1,2,3,4, 7]
        log.info("Arrays.toString(helloData.getArr()) = {}", Arrays.toString(helloData.getArr()));
        // helloData.getArr().toString() = [Ljava.lang.String;@77845c51
        log.info("helloData.getArr().toString() = {}", helloData.getArr().toString());

        return "ok";
    }

    /**
     * @RequestParam MultiValueMap<String, String> multiMap
     * List<String>으로 받기
     *
     * basic
     * 요청 url: http://localhost:8080/request-param-arr-v2?arr=1,2,3,4
     *
     * &arr=7 중복 파라미터
     * 요청 url: http://localhost:8080/request-param-arr-v1?arr=1,2,3,4&arr=7
     */
    @ResponseBody
    @GetMapping("/request-param-arr-v2")
    public String requestParamV2(HttpServletRequest request, @RequestParam MultiValueMap<String, String> multiMap) {
        // arr = 1,2,3,4
        log.info("arr = {}", request.getParameter("arr"));
        // arr = [1,2,3,4]
        // &arr=7: arr = [1,2,3,4, 7]
        List<String> arr = multiMap.get("arr");
        log.info("arr = {}", arr);

        // arr.get(0) = 1,2,3,4
        // &arr=7: arr.get(0) = 1,2,3,4
        log.info("arr.get(0) = {}", arr.get(0));

        // arr.get(1) = error
        // &arr=7: arr.get(1) = 7
        log.info("arr.get(1) = {}", arr.get(1));

        return "ok";
    }

}
