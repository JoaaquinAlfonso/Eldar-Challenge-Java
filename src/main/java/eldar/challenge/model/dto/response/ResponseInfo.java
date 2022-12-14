package eldar.challenge.model.dto.response;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ResponseInfo {

    private String timestap = LocalDate.now().toString();

    @NonNull
    private String message;

    @NonNull
    private String path;

    @NonNull
    private Integer code_status;

}