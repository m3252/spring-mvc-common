package hello.exception.exhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ErrorResult {
    private String code;
    private String message;
}
