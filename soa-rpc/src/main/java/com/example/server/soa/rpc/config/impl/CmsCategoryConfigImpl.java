package com.example.server.soa.rpc.config.impl;

import com.example.server.soa.rpc.base.BaseRpc;
import com.example.server.soa.rpc.config.CmsCategoryConfig;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
public class CmsCategoryConfigImpl extends BaseRpc implements CmsCategoryConfig {

    @Override
    public String getCmsCategoryInfo() {
        return null;
    }

    @PostConstruct // 等同于xml中的init-method="init"配置
    public void init() {
        executeUpdateCmsConfig();
    }

    public void executeUpdateCmsConfig() {
        // 具体的任务逻辑
        log.info(">>>>>> CmsCategoryConfigImpl.executeUpdateCmsConfig");
    }
}
