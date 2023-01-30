package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

// 모든 컨트롤러가 request, response를 필요로 하지 않음을 고려
public interface ControllerV3 {

    // request 대신 paramMap으로 데이터 전달받음(서블릿에 독립적)
    // 리턴 타입 : ModelView(viewName, model 포함)
    ModelView process(Map<String, String> paramMap);
}
