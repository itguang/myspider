package com.libstar.kb.spider.sp.doab.qingxi;

import com.libstar.kb.spider.sp.doab.DoabUtil;
import com.libstar.kb.spider.sp.doab.dao.BookRepository;
import com.libstar.kb.spider.sp.doab.entity.BookEntity;
import com.libstar.kb.spider.sp.doab.qingxi.dao.DcBookRepository;
import com.libstar.kb.spider.sp.doab.qingxi.dao.KbComponentRepository;
import com.libstar.kb.spider.sp.doab.qingxi.dao.TitleRepositoey;
import com.libstar.kb.spider.sp.doab.qingxi.entity.Book;
import com.libstar.kb.spider.sp.doab.qingxi.entity.KbComponent;
import com.libstar.kb.spider.sp.doab.qingxi.entity.Title;
import com.libstar.kb.spider.sp.doab.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李增光
 * @create 2018-08-14 10:30
 **/
@Service
@Slf4j
public class WashBookService {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository doabBookRepository;

    @Autowired
    KbComponentRepository kbComponentRepository;

    @Autowired
    DcBookRepository dcBookRepository;

    @Autowired
    TitleRepositoey titleRepositoey;


    public void wash() {
        List<BookEntity> list = doabBookRepository.findAll();

        for (BookEntity bookEntity : list) {

            String isbn10 = bookEntity.getIsbn10();
            String isbn13 = bookEntity.getIsbn13();

            KbComponent kbComponent = kbComponentRepository.saveAndFlush(new KbComponent());
            long kbcId = kbComponent.getKbcId();

            System.out.println("kbcId=" + kbcId);

            if (isbn10 != null) {
                List<Book> allByIsbn10 = dcBookRepository.findAllByIsbn10(isbn10);
                if (allByIsbn10.size() == 0) {

                    //插入Book
                    Book book = new Book();
                    book.setKbcId(kbcId);
                    book.setAuthor(bookEntity.getAuthor());
                    book.setIsbn10(isbn10);
                    book.setIsbn13(isbn13);

                    String description = bookEntity.getDescription();
                    if (null != description) {
                        book.setDocAbstract(description.length() > 4000 ? description.substring(0, 3999) : description);
                    }

                    book.setTitle(null == bookEntity.getBookTitle() ? bookEntity.getName() : bookEntity.getBookTitle());
                    book.setPages(DoabUtil.getPage(bookEntity.getPages()));
                    String keywords = bookEntity.getKeywords();
                    if (keywords != null) {
                        book.setKeywords(keywords.length() > 500 ? keywords.substring(0, 499) : keywords);
                    }

                    book.setSubject(bookEntity.getSubject());
                    book.setPublisher(bookEntity.getPublisher());

                    try {
                        int pubYear = Integer.parseInt(bookEntity.getYear());
                        book.setPubYear(pubYear);
                    } catch (NumberFormatException e) {
                        book.setPubYear(null);
                    }

                    book.setImageAddress(bookEntity.getImg());
                    dcBookRepository.save(book);

                    //插入Title
                    Title title = new Title();
                    title.setKbcId(kbcId);
                    title.setDoi(bookEntity.getDoi());
                    title.setCoverUrl(bookEntity.getImg());
                    title.setUrl(bookEntity.getRequestUrl());
                    titleRepositoey.save(title);
                }

            }

            if (isbn13 != null) {
                List<Book> allByIsbn13 = dcBookRepository.findAllByIsbn13(isbn13);
                if (allByIsbn13.size() == 0) {

                    //插入Book
                    Book book = new Book();
                    book.setKbcId(kbcId);
                    book.setAuthor(bookEntity.getAuthor());
                    book.setIsbn10(isbn10);
                    book.setIsbn13(isbn13);

                    String description = bookEntity.getDescription();
                    if (null != description) {
                        book.setDocAbstract(description.length() > 4000 ? description.substring(0, 3999) : description);
                    }

                    book.setTitle(null == bookEntity.getBookTitle() ? bookEntity.getName() : bookEntity.getBookTitle());
                    book.setPages(DoabUtil.getPage(bookEntity.getPages()));
                    String keywords = bookEntity.getKeywords();
                    if (keywords != null) {
                        book.setKeywords(keywords.length() > 500 ? keywords.substring(0, 499) : keywords);
                    }

                    book.setSubject(bookEntity.getSubject());
                    book.setPublisher(bookEntity.getPublisher());

                    try {
                        int pubYear = Integer.parseInt(bookEntity.getYear());
                        book.setPubYear(pubYear);
                    } catch (NumberFormatException e) {
                        book.setPubYear(null);
                    }

                    book.setImageAddress(bookEntity.getImg());
                    dcBookRepository.save(book);

                    //插入Title
                    Title title = new Title();
                    title.setKbcId(kbcId);
                    title.setDoi(bookEntity.getDoi());
                    title.setCoverUrl(bookEntity.getImg());
                    title.setUrl(bookEntity.getRequestUrl());
                    titleRepositoey.save(title);
                }

            }


        }
        System.out.println("OK!");


    }


    public void getIsbn() {

        List<BookEntity> list = doabBookRepository.findAll();

        for (BookEntity bookEntity : list) {
            String isbn = bookEntity.getIsbn();

            //10位
            if (isbn.length() == 10) {
                bookEntity.setIsbn10(isbn);
            } else if (isbn.length() == 13) {
                bookEntity.setIsbn13(isbn);
            } else {
                String[] isbns = isbn.split(",");
                if (isbns.length >= 2) {
                    if (isbns[0].length() == 10) {
                        bookEntity.setIsbn10(isbns[0]);
                    }
                    if (isbns[0].length() == 13) {
                        bookEntity.setIsbn13(isbns[0]);
                    }
                    if (isbns[1].length() == 10) {
                        bookEntity.setIsbn10(isbns[1]);
                    }
                    if (isbns[1].length() == 13) {
                        bookEntity.setIsbn13(isbns[1]);
                    }

                }

            }
            doabBookRepository.save(bookEntity);
            log.info("isbn={},isbn10={},isbn13={}", bookEntity.getIsbn(), bookEntity.getIsbn10(), bookEntity.getIsbn13());
        }
    }


}
