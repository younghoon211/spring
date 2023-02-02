package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원 관리 API
     * 회원 목록 조회: GET /users
     *
     * 회원 등록: POST /users
     * 회원 조회: GET /users/{userId}
     * 회원 수정: PATCH /users/{userId}
     * 회원 삭제: DELETE /users/{userId}
     */

    // 회원 목록 조회
    @GetMapping
    public String user() {
        return "get users";
    }

    // 등록
    @PostMapping
    public String addUser() {
        return "post user";
    }

    // 조회
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId = " + userId;
    }

    // 수정
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId = " + userId;
    }

    // 삭제
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId = " + userId;
    }

}
