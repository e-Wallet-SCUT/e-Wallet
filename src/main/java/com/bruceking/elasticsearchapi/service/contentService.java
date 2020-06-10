package com.bruceking.elasticsearchapi.service;

import com.alibaba.fastjson.JSON;
import com.bruceking.elasticsearchapi.bean.Content;
import com.bruceking.elasticsearchapi.util.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class contentService {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient restHighLevelClient;

    public Boolean parseContent(String keyword) throws IOException {
        List<Content> list = new HtmlParseUtil().parseJD(keyword);


        //判断数据库是否创建
        GetIndexRequest getrequest = new GetIndexRequest("goods");
        boolean exists = restHighLevelClient.indices().exists(getrequest, RequestOptions.DEFAULT);
        System.out.println(exists);
        if (!exists){
            CreateIndexRequest createRequest = new CreateIndexRequest("goods");
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createRequest, RequestOptions.DEFAULT);
            System.out.println(createIndexResponse);
        }

        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");

        for(int i =0; i <list.size(); i++){
            bulkRequest.add(
                    new IndexRequest("goods").source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }
}