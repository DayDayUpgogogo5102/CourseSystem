package edu.hebust.CourseSystem.util.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Boolean status;
    private String info;
    private Object data;

    public R(Boolean status) {
        this.setStatus(status);
    }

    public R(String info) {
        this.setStatus(false);
        this.setInfo(info);

    }
}