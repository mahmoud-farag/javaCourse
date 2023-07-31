package com.AOPLearning.AOP.DAO;


import org.springframework.stereotype.Repository;

@Repository // to make scanning
public class AccountDAOImpl implements  AccountDAo{

    @Override
    public void addToAccount(int id, boolean isOkay) {
        System.out.println(getClass() + " DO SOME DB STUFF IN --ADDTOACCOUNT-- METHOD");
    }

    @Override
    public void makeNewPerson() {
        System.out.println(getClass() + " DO SOME DB STUFF IN --makeNewPerson-- METHOD");

    }
}
