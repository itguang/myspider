package com.libstar.kb.spider.sp.doab.article;

import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import com.libstar.kb.spider.sp.doab.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李增光
 * @create 2018-08-09 10:52
 **/
@Component
@Slf4j
public class DoabArticleProcessor implements PageProcessor {


    @Override
    public void process(Page page) {
        Integer currentPage = Integer.parseInt(UrlUtils.getParams(page.getUrl().get()).get("page"));
        String queryField = UrlUtils.getParams(page.getUrl().get()).get("queryfield").toUpperCase();
        Html html = page.getHtml();
        String substring = html.xpath("//form[@name='goToPage']").regex("of [\\d]+").get().substring(3);
        int totalPage = Integer.parseInt(substring);
        log.info("queryField={},totalPage={},currentPage={}", queryField, totalPage, currentPage);

        if (1 == currentPage) {
            String url = page.getUrl().get().replace("1", "#");
            for (int i = 2; i <= totalPage; i++) {
                String newUrrl = url.replace("#", i + "");
                page.addTargetRequest(newUrrl);
            }
        }

        Selectable xpath = html.xpath("//div[@class='wholePage']/div[@id='pageContainer']/div[@id='result']/div[@itemtype='http://schema.org/Book']");
        List<Selectable> nodes = xpath.nodes();
        ArrayList<BookEntity> list = new ArrayList<>();
        for (Selectable node : nodes) {
            String img = "http://schema.org/Book" + node.xpath("//div[@class='imageDiv']/img/@src").get();
            String name = node.xpath("//div[@class='data']/b/span[@itemprop='name']/text()").get();
            String author = node.xpath("//div[@class='data']/div[@style='color: #585858']/a[@itemprop='author']/text()").get();
            String isbn = node.xpath("//div[@class='data']/div[@style='color: #585858']/span[@itemprop='isbn']/text()").get().replaceAll(" ", ",");
            String year = node.xpath("//div[@class='data']/div[@style='color: #585858']/span[@itemprop='datePublished']/text()").get();
            String pages = node.xpath("//div[@class='data']/div[@style='color: #585858']/span[@itemprop='numberOfPages']/text()").get();
            String publisher = node.xpath("//div[@class='data']/div[@style='color: #585858']/a[@itemprop='publisher']/text()").get();
            String subject = node.xpath("//div[@class='data']/div[@style='color: #585858']/a[@itemprop='about']/text()").get();
            String description = node.xpath("//div[@class='data']/div[@class='linkContent']/div[@itemprop='description']/p/text()").get();
            List<String> Keywords = node.xpath("//div[@class='data']/div[@class='linkContent']/div/p/a[@itemprop='keywords']/text()").all();
            Selectable replace = node.replace("\n", "")
                    .replace("\r", "")
                    .replace("\t", "");
            String language = replace.regex("<strong>Language</strong>:(.*?)<br>").get();
            String doi = replace.regex("<strong>DOI</strong>:(.*?)<strong>Language</strong>").get();
            String dateOfAddDoab = replace.regex("<strong>Added to DOAB on </strong>:(.*?)<br>").get();

            String bookTitle = replace.regex("<strong>Book title:</strong>(.*?)</i>").get();

            BookEntity bookEntity = new BookEntity();
            bookEntity.setAuthor(author);
            bookEntity.setDateOfAddDoab(null == dateOfAddDoab ? "" : dateOfAddDoab.trim());
            bookEntity.setDescription(description);
            bookEntity.setDoi(null == doi ? "" : doi.trim());
            bookEntity.setImg(img);
            bookEntity.setIsbn(isbn);
            bookEntity.setKeywords(StringUtils.strip(Keywords.toString(), "[]"));
            bookEntity.setLanguage(null == language ? "" : language.trim());
            bookEntity.setName(name);
            bookEntity.setPages(pages);
            bookEntity.setPublisher(publisher);
            bookEntity.setSubject(subject);
            bookEntity.setYear(year);
            bookEntity.setBookTitle(bookTitle);
            bookEntity.setRequestUrl(page.getUrl().get());

            list.add(bookEntity);
        }
        page.putField("list", list);


    }

    @Override
    public Site getSite() {
        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60 * 1000);
        return site;
    }
}
