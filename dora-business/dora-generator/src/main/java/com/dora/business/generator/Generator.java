package com.dora.business.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author zhou
 * @date 2021/9/27
 */
public class Generator {

    private final static String[] TABLE_LIST = {"sys_user"};
    private final static String[] TABLE_PREFIX = {"sys_"};
    private final static String DIRECTION = "D://";

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:postgresql://locahost:15432/dora" , "dora" , "dora")
                .globalConfig(builder -> {
                    builder.author("zhou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(DIRECTION); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, DIRECTION)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_LIST) // 设置需要生成的表名
                            .addTablePrefix(TABLE_PREFIX); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
