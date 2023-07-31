package com.AOPLearning.AOP.DAO;


import org.springframework.stereotype.Repository;

@Repository // to make scanning
public class AccountDAOImpl implements  AccountDAo{

    @Override
    public void addToAccount() {
        System.out.println(getClass() + " DO SOME DB STUFF IN ADDTOACCOUNT METHOD");
    }
}
