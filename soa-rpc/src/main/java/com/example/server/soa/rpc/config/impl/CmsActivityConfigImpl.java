package com.example.server.soa.rpc.config.impl;

import com.example.server.soa.rpc.base.BaseRpc;
import com.example.server.soa.rpc.config.CmsActivityConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CmsActivityConfigImpl extends BaseRpc implements CmsActivityConfig {

    @Override
    public String getCmsActivityInfo() {
        return null;
    }

    public void init() {
        executeUpdateCmsConfig();
    }

    public void executeUpdateCmsConfig() {
        // 具体的任务逻辑
        log.info(">>>>>> CmsActivityConfigImpl.executeUpdateCmsConfig");
    }
}
