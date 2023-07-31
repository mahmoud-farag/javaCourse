package com.AOPLearning.AOP.ascpect_AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect // @Aspect her is required only if the class may contain advices.
public class pointCuts {

        // PointCut declaration used to write once a pointcut and used in many places many
        @Pointcut("execution(* com.AOPLearning.AOP.DAO.*.add*(..))")
        public void beforeAddMethods(){}

        @Pointcut("execution(* com.AOPLearning.AOP.DAO.AccountDAo.makeNewPerson(..))")
        private void makeNewPersonAnalaytics () {}
        @Pointcut("execution(* com.AOPLearning.AOP.DAO.AnotherDAO.checkExistence(..))")
        private void checkExistenceAnalaytics () {}

        @Pointcut("makeNewPersonAnalaytics() && makeNewPersonAnalaytics()")
        public void DoAnalyticsStuff(){}


}
