package com.bitc.reactasyncserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// CROS 오류 : Cross Origin Resource Sharing의 줄임말. 동일한 주소 내에서만 리소스를 공유할 수 있다.
// 스프링에서는 CROS 허용을 위해서 @CrossOrigin 어노테이션을 사용하여 처리한다.
// @CrossOrigin : 해당 어노테이션을 사용하면 지정한 도메인에 대해서 접근을 허용한다.
// @CrossOrigin 어노테이션은 메서드, 클래스, configurer 에 설정할 수 있음
// 메서드에 사용 시 지정한 메서드만 접근을 허용한다.
// 클래스에 사용 시 지정한 컨트롤러에 대해서만 접근을 허용한다.
// configurer 에 사용 시 모든 곳에 접근을 허용한다.
// 옵션으로 origins에 접근할 서버의 주소를 입력한다.


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"}) //2번째 방법

@RequestMapping("/async")
@RestController
public class AsyncServerController {



    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    //    localhost:3000으로 접근하는 게 있으면 이리로 보내줘라는 뜻
//    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value = "/data1", method = RequestMethod.POST)
    public String asyncDatal() throws Exception {
        return "서버와 통신 성공";
    }

    //    get방식 데이터 전송
    @RequestMapping(value = "/sendDataGet", method = RequestMethod.GET)
    public Object sendDataGet() throws Exception {
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        result.put("data", "");

        return result;
    }

    // post방식
    @RequestMapping(value = "/sendDataPost", method = RequestMethod.POST)
    public Object sendDataPost(@RequestParam("id") String id, @RequestParam("pw") String pw) throws Exception {

        Map<String, Object> user = new HashMap<>();
        user.put("id", "test1");
        user.put("pw", "abcd1234");

        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("data", user);

        return result;
    }

    @RequestMapping(value = "/sendDataPut", method = RequestMethod.PUT)
//    requestbody로 해야 데이터 받아진다.
    public Object sendDataPut(@RequestParam("idx") int idx) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");

        return result;
    }

    @RequestMapping(value = "/sendDataDelete", method = RequestMethod.DELETE)
    public Object sendDataDelete(@RequestParam("idx") int idx) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");

        return result;
    }
}
