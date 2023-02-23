package cn.watermelonhit.dubbo.mini.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 调用信息
 * @Author watermelonhit
 * @Date 2023/2/22 16:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;
}
