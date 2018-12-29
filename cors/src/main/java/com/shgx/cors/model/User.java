package com.shgx.cors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户类
 *
 * @author guangxush
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User {

    /**
     * 用户id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    private int age;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;
}
