package com.bruceking.elasticsearchapi.util;

import com.bruceking.elasticsearchapi.bean.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {

    public List<Content> parseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keywords;

        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");

        Elements elements = element.getElementsByTag("li");
        List<Content> goodslist = new ArrayList<>();
        for (Element el : elements) {
            String img = el.getElementsByTag("img").eq(0).attr("src");
            String fakeprice = el.getElementsByClass("p-price").eq(0).text().split(" ")[0];
            char[] chars = fakeprice.toCharArray();
            String sprice = "";
            for(int i = 1 ; i <chars.length; i++){
                sprice += chars[i];
            }
            float price = Float.parseFloat(sprice);
            String title = el.getElementsByClass("p-name").eq(0).text();

            Content content = new Content(title,img,price);
            goodslist.add(content);
        }
        System.out.println(goodslist);
        return goodslist;
    }

}
