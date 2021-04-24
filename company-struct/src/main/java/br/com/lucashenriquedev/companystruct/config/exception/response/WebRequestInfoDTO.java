package br.com.lucashenriquedev.companystruct.config.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebRequestInfoDTO {

    private String contextPath;
    private Map<String, String[]> parameterMap;
    private Map<String, Object[]> headers;
    private String remoteUser;

    public WebRequestInfoDTO(WebRequest request) {
        contextPath = request.getContextPath();
        parameterMap = request.getParameterMap();
        headers = new HashMap<>();
        request.getHeaderNames()
                .forEachRemaining(header -> headers.put(header, request.getHeaderValues(header)));
        remoteUser = request.getRemoteUser();
    }

    public WebRequestInfoDTO(HttpServletRequest request) {
        contextPath = request.getContextPath();
        parameterMap = request.getParameterMap();
        headers = new HashMap<>();
        request.getHeaderNames()
                .asIterator()
                .forEachRemaining(header -> {
                    List<String> values = new ArrayList<>();
                    request.getHeaders(header)
                            .asIterator()
                            .forEachRemaining(values::add);
                    headers.put(header, values.toArray());
                });
        remoteUser = request.getRemoteUser();
    }

}
