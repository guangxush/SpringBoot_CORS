package com.shgx.web.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户类
 *
 * @author guangxush
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户id
     */

    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String sex;
}
