package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(
            HttpServletRequest request, //
            HttpServletResponse response,
            HttpMethod httpMethod, // get post delete ..
            Locale locale, // 언어정보
            @RequestHeader MultiValueMap<String, String> headerMap, // 헤더를 한번에 다 받는 경우
            @RequestHeader("host") String host, // 헤더를 하나만 받고 싶을때 (host는 필수 헤더)
            @CookieValue(value="myCookid", required = false) String cookie // value = 쿠키이름
            ) {

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("host={}", host);
        log.info("cookie={}", cookie);
        return "ok";
    }
}
