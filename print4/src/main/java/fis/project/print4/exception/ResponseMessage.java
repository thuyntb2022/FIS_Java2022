package fis.project.print4.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
    private String code;
    private String message;
}
