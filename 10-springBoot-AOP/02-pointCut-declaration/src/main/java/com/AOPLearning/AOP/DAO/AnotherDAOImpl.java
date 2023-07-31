package com.AOPLearning.AOP.DAO;


import org.springframework.stereotype.Repository;

@Repository
public class AnotherDAOImpl implements  AnotherDAO{
    @Override
    public void addNewUser() {
        System.out.println(getClass() + " DO SOME DB STUFF IN --addNewUser-- METHOD");
    }

    @Override
    public boolean checkExistence() {
        System.out.println(getClass() + " DO SOME DB STUFF IN --checkExistence-- METHOD");

        return false;
    }
}
