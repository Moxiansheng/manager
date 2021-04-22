package com.mo.manager.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.mo.manager.commons.CommonStrings.POJO_GMT_CREATE;
import static com.mo.manager.commons.CommonStrings.POJO_GMT_MODIFIED;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, POJO_GMT_CREATE, LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, POJO_GMT_MODIFIED, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, POJO_GMT_MODIFIED, LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐)
    }
}
