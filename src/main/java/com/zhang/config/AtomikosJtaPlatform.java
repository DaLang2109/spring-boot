package com.zhang.config;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
/**
 * 处理事务的类  hibernate不提供 需要自己写
 */
public class AtomikosJtaPlatform extends AbstractJtaPlatform {

    private static final long serialVersionUID = 1L;
    //事务管理器 atomikos的userTransactionManager
    public static TransactionManager transactionManager;
    //atomikos的事务管理的相关配置  比如超时时间 等
    public static UserTransaction transaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return transaction;
    }

}
