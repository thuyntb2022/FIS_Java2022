package fis.test.test_final.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionMessage {
    private String code;
    private String message;
}
