package hello.exception.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ServletExController {

    @GetMapping("/error-ex")
    public void errorEx() {
        throw new RuntimeException("예외 발생");
    }


    @GetMapping("/error-500")
    public void error500(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("dispatchType={}", request.getDispatcherType());
        response.sendError(500);
    }

    @GetMapping("/error-404")
    public void error400(HttpServletResponse response) throws IOException {
        response.sendError(404, "404 오류");
    }
}
