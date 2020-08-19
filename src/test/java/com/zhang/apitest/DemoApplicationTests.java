package com.zhang.apitest;


/**
 * @author  yanping_zhang
 * @create  2020/8/15 22:10
 * @desc  api文档通过执行测试方法导出到docs 目录下
 **/

//启动应用服务容器
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)//SpringBootTest.WebEnvironment.DEFINED_PORT表示使用application.yml定义的端口
public class DemoApplicationTests {

//    @Test
//    public void generateAsciiDocs() throws Exception {
//        //    输出Ascii格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC) //设置生成格式
//                .withOutputLanguage(Language.ZH)  //设置语言中文还是其他语言
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("src/main/resources/docs/asciidoc"));
//        //访问路径:http://localhost:8080/swagger-ui.html
//    }
}