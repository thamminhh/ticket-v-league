package com.example.demo_tss.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")

public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;
    private int role_id;


    // Exception
    // Controller Advices => Xử lý response exception
    // Định nghĩa exception -> throw cho controller advice.
    // xu li response

    // Security
    // JWT
    // create by, create date, last update by, last update date
    // Spring data JPA Auditing

    // Google authen hoặc firebase
    // return về access token
    // FE set token vào request header để gọi xuống api
    // Authentication Filter
    // Trong filter -> decode token ra để lấy thông tin
    // xác thực lại thông tin (token còn hạn dùng hay không, user được access vào api hay ko,...)
    // Nếu xác thực thành công -> gọi thực hiện api
    // Nếu ko thành công thì response lỗi về

}
