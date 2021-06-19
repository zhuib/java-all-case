package elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * Date: 2021/4/9 1:04
 */
public class ESClient {

    public static void main(String[] args) throws IOException {

        // 创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        /*// 创建索引
        CreateIndexRequest user = new CreateIndexRequest("book");
        CreateIndexResponse createIndexResponse = client.indices().create(user, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(acknowledged);*/

   /*     // 查询索引
        GetIndexRequest request = new GetIndexRequest("book");
        GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());*/

        /*// 删除索引
        DeleteIndexRequest request = new DeleteIndexRequest("book");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());*/

/*        // 向索引插入数据
        IndexRequest request = new IndexRequest();
        request.index("book").id("1001");

        User user = new User();
        user.setName("zhangsan");
        user.setAge(20);
        user.setSex("男");

        // 往ES插入数据。必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        request.source(userJson, XContentType.JSON);
        // 发送
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());*/

  /*      // 修改文档数据
        UpdateRequest request = new UpdateRequest();
        request.index("book").id("1001");
        request.doc(XContentType.JSON,"sex","女");

        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);
        System.out.println(update.getResult());*/

    /*    // 查询文档信息
        GetRequest request = new GetRequest();
        request.index("book").id("1001");

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());*/

      /*  // 删除文档数据
        DeleteRequest request = new DeleteRequest();
        request.index("book").id("1001");
        DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.getResult());*/

/*        // 批量插入数据
        BulkRequest request = new BulkRequest();
//        new IndexRequest().index("book").id("1001").source(XContentType.JSON,"zhangsan");
        request.add(new IndexRequest().index("book").id("1001").source(XContentType.JSON,"name","zhangsan","age",30,"sex","男"));
        request.add(new IndexRequest().index("book").id("1002").source(XContentType.JSON,"name","lisi","age",40,"sex","男"));
        request.add(new IndexRequest().index("book").id("1003").source(XContentType.JSON,"name","wangwu1","age",50,"sex","男"));
        request.add(new IndexRequest().index("book").id("1004").source(XContentType.JSON,"name","wangwu2","age",50,"sex","女"));
        request.add(new IndexRequest().index("book").id("1005").source(XContentType.JSON,"name","wangwu3","age",60,"sex","男"));
        request.add(new IndexRequest().index("book").id("1006").source(XContentType.JSON,"name","wangwu4","age",50,"sex","男"));

        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.getTook());
        System.out.println(bulk.getItems());*/

//        // 批量删除
//        BulkRequest request = new BulkRequest();
////        new IndexRequest().index("book").id("1001").source(XContentType.JSON,"zhangsan");
//        request.add(new DeleteRequest().index("book").id("1001"));
//        request.add(new DeleteRequest().index("book").id("1002"));
//        request.add(new DeleteRequest().index("book").id("1003"));
//
//        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
//        System.out.println(bulk.getTook());
//        System.out.println(bulk.getItems());

/*        // 查询索引中全部数据  matchAllQuery
        SearchRequest request = new SearchRequest();
        request.indices("book");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/


/*        // 条件查询 termQuery
        SearchRequest request = new SearchRequest();
        request.indices("book");
        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30)));

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

      /*  // 分页查询
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        // (当前页码 - 1) * 每页显示数据条数
        builder.from(0); // 第一条数据即起始位置
        builder.size(2); // 查询条数
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

/*        // 查询排序 sort
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.ASC);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

/*        // 过滤字段 fetchSource
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        String[] includes = {"name"};
        String[] excludes = {"age"};
        builder.fetchSource(includes,excludes);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/


/*        // 组合查询
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // And
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","男"));
        // Or
        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
        boolQueryBuilder.should(QueryBuilders.matchQuery("age",50));

        builder.query(boolQueryBuilder);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

/*        // 范围查询
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder range = QueryBuilders.rangeQuery("age");
        range.gte(30); // 大于等于50
        range.lte(50); // 小于等于50

        builder.query(range);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

 /*       // 模糊查询 fuzzyQuery
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "wangwu");
        fuzzyQueryBuilder.fuzziness(Fuzziness.ONE);

        builder.query(fuzzyQueryBuilder);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/


 /*       // 高亮查询 HighlightBuilder "highlight":{"name":["<font color='red'>zhangsan</font>"]}}]}
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhangsan");

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>"); //
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name"); // 对name进行替换

        builder.highlighter(highlightBuilder);
        builder.query(termQueryBuilder);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

/*        // 聚合查询  "aggregations":{"max#maxAge":{"value":60.0}}
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(maxAggregationBuilder);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });*/

        // 分组查询(也是聚合查询) 以key的为分组条件 key即为age  ===> "buckets":[{"key":50,"doc_count":3},{"key":30,"doc_count":1},{"key":40,"doc_count":1},{"key":60,"doc_count":1}]}
        SearchRequest request = new SearchRequest();
        request.indices("book");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermsAggregationBuilder maxAggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(maxAggregationBuilder);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach((item)->{
            System.out.println(item.getSourceAsString());
        });
        // 关闭客户端
        client.close();
    }
}
