package cn.watermelonhit.dubbo.mini.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 主机信息
 * @Author watermelonhit
 * @Date 2023/2/22 14:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URL implements Serializable {

    private static final long serialVersionUID = 608453727622269627L;
    private String hostname;
    private Integer port;

}
