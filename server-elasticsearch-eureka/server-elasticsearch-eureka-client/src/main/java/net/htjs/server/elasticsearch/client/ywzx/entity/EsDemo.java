package net.htjs.server.elasticsearch.client.ywzx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Auther: baixijiao
 * @Date：2021-02-04 10:04
 * @Description： EsDemo实体bean
 * @Modified By:
 */
@Document(indexName = "es_demo_index",type="es_demo")
@Data
@AllArgsConstructor
@ApiModel(value = "EsDemo", description = "EsDemo申请实体bean")
public class EsDemo implements Serializable {

    private static final long serialVersionUID = 7069434541237060995L;

    // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
    protected EsDemo() {
    }

    @Id // 主键
    @ApiModelProperty(value = "esDemo的id")
    private String esDemoId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;



}
