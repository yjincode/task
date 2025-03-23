package com.example.tobyspring.user.dao;

import com.example.tobyspring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

            User user = new User();
            user.setId("whiteship10");
            user.setName("백기선");
            user.setPassword("marride");

            dao.add(user);

            System.out.println(user.getId() + " 등록 성공");

            User user2 = dao.get(user.getId());
            System.out.println(user2.getName());
            System.out.println(user2.getPassword());

            System.out.println(user2.getId() + " 조회 성공");

            CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
            System.out.println("Connection counter : " + ccm.getCounter());
        }

    }
