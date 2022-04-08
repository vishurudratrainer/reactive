package com.example.reactiveRelationship.config;

import com.example.reactiveRelationship.entity.Author;
import com.example.reactiveRelationship.entity.Book;
import io.r2dbc.spi.Row;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@ReadingConverter
@Slf4j
public class BookReadConverter implements Converter<Row, Book> {

    @Override
    public Book convert(Row source) {
        Author author = new Author();
        author.setId(source.get("authorId", UUID.class));
        author.setName(source.get("authorName", String.class));

        Book book = new Book();
        book.setId(source.get("id",UUID.class));
        book.setAuthor(author.getId());
//        book.setDateOfPartition(source.get("date_of_partition", Instant.class));
        log.info("Author retrieved : "+ author);
        book.setRetrievedAuthor(author);
        return book ;
    }

}