package com.bruceking.main.goods.Service;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ContentService {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    public List<Map<String,Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {

        if(pageNo<=1){
            pageNo = 1;
        }

        SearchRequest searchRequest = new SearchRequest("goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.from((pageNo-1) * pageSize+1);
        searchSourceBuilder.size(pageSize);

        //精确匹配


        //模糊查询
        MatchQueryBuilder termQueryBuilder = QueryBuilders.matchQuery("title", keyword);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));


        //实现搜索高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);//多个高亮
        highlightBuilder.preTags("<span style= 'color:red'>");
        highlightBuilder.postTags("</span>");
        SearchSourceBuilder highlighter = searchSourceBuilder.highlighter(highlightBuilder);



        //搜索
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        for(SearchHit documentField:response.getHits().getHits()) {


            //封装结果高亮
            Map<String, HighlightField> highlightFields = documentField.getHighlightFields();
            HighlightField title = highlightFields.get("title");

            Map<String,Object> sourceAsMap = documentField.getSourceAsMap();

            if(title!= null){
                Text[] fragements = title.fragments();
                String n_title="";
                for( Text fragment:fragements){
                    n_title += fragment;
                }
                String oldtitle = (String) sourceAsMap.get("title");
                oldtitle = oldtitle.replaceAll("[/]"," ");
                sourceAsMap.put("oldtitle",oldtitle);


                sourceAsMap.put("title",n_title);

            }

            list.add(sourceAsMap);

        }



        return list;
    }



}
