package hello.login.web.filter;

import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();


        try {
            log.info("인증 체크 필터 시작 {}", requestURI);

        if (isLoginCheckPath(requestURI)) { // whitelist면 false

            log.info("인증 체크 로직 실행 {}", requestURI);
            HttpSession session = httpRequest.getSession(false);

            // 로그인된 사용자가 로그인 페이지로 가는 것 막기 위해(로그인 안된 사용자만 로그인 페이지로 이동)
            if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {

                log.info("미인증 사용자 요청 {}", requestURI);

                // 로그인으로 redirect
                httpResponse.sendRedirect("/login?redirectURL=" + requestURI);

                return;
            }
        }

            chain.doFilter(request, response); // 핵심 로직(1.필터 2.서블릿)
            
        } catch (Exception e) {
            throw e; // 예외 로깅 가능하지만, 톰캣까지 예외 보내주어야
        } finally {
            log.info("인증 체크 필터 종료 {}", requestURI);
        }

    }

    /**
     * 화이트 리스트인 경우 인증 체크X
     */
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }

}
