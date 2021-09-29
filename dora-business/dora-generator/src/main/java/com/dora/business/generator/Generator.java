package com.dora.business.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.dora.common.mybatis.entity.SuperEntity;
import com.dora.common.mybatis.mapper.SuperMapper;
import com.dora.common.mybatis.service.SuperService;
import com.dora.common.mybatis.service.impl.SuperServiceImpl;

import java.util.Collections;

/**
 * @author zhou
 * @date 2021/9/27
 */
public class Generator {

    private final static String[] TABLE_LIST = {"sys_user"};
    private final static String[] TABLE_PREFIX = {"sys_"};
    private final static String DIRECTION = "D:/MyData/OneDrive - ksDrh/Code/MyWorkspace/dora/dora-business/dora-system/src/main/java/";
    private final static String MAPPER_DIRECTION = "D:/MyData/OneDrive - ksDrh/Code/MyWorkspace/dora/dora-business/dora-system/src/main/resources/mapper/";

    public static void main(String[] args) {
        generateCode();
    }

    private static void generateCode() {
        FastAutoGenerator.create(
                new DataSourceConfig.Builder("jdbc:postgresql://localhost:15432/dora", "dora", "dora")
                        .schema("dora"))
                .globalConfig(builder -> {
                    builder.author("zhou")
                            .enableSwagger()
                            .fileOverride()
                            .disableOpenDir()
                            .outputDir(DIRECTION);
                })
                .packageConfig(builder -> {
                    builder.parent("com.dora.business")
                            .moduleName("system")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, MAPPER_DIRECTION));
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER);
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_LIST)
                            .addTablePrefix(TABLE_PREFIX)

                            .entityBuilder()
                            .superClass(SuperEntity.class)
                            .addSuperEntityColumns("create_time", "update_time")
                            .logicDeleteColumnName("deleted")
                            .enableLombok()
                            .enableChainModel()
                            .build()

                            .serviceBuilder()
                            .superServiceClass(SuperService.class)
                            .superServiceImplClass(SuperServiceImpl.class)
                            .formatServiceFileName("%sService")
                            .build()

                            .mapperBuilder()
                            .superClass(SuperMapper.class)
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .enableMapperAnnotation()
                            .build();

                }).templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
