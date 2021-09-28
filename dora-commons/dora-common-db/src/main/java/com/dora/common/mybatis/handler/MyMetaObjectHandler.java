package com.dora.common.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhou
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private final static String CREATE_BY_COLUMN = "createBy";
    private final static String CREATE_TIME_COLUMN = "createTime";
    private final static String UPDATE_BY_COLUMN = "updateBy";
    private final static String UPDATE_TIME_COLUMN = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter(CREATE_BY_COLUMN)) {
            this.strictInsertFill(metaObject, CREATE_BY_COLUMN, LocalDateTime::now, LocalDateTime.class);
        }
        this.strictInsertFill(metaObject, CREATE_TIME_COLUMN, LocalDateTime::now, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        if (metaObject.hasSetter(UPDATE_BY_COLUMN)) {
            this.strictInsertFill(metaObject, UPDATE_BY_COLUMN, LocalDateTime::now, LocalDateTime.class);
//        }
        this.strictUpdateFill(metaObject, UPDATE_TIME_COLUMN, LocalDateTime::now, LocalDateTime.class);
    }
}
