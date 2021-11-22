package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원 목록 조회: GET     /users
     * 회원 등록:      POST    /users
     * 회원 조회:      GET     /user/{userId}
     * 회원 수정:      PATCH   /users/{userId}
     * 회원 삭제:      DELETE  /users/{userId}
     */

    @GetMapping // ("/mapping/users")
    public String user() {
        return "get users";
    }

    @PostMapping // ("/mapping/users")
    public String addUser() {
        return "post user";
    }

//    @GetMapping("/mapping/users/{userId}")
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId = " + userId;
    }

//    @PatchMapping("/mapping/users/{userId}")
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "patch userId = " + userId;
    }

//    @DeleteMapping("/mapping/users/{userId}")
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userID = " + userId;
    }
}
