package Serialization;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BookSerializer {

    public static void main(String[] args) throws JsonProcessingException {
        // Create a sample BooksPojo object
        BooksPojo book = new BooksPojo();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setIsbn("978-0134685991");
        book.setPublishedYear(2018);

        // Keys to exclude dynamically (passed at runtime)
        Set<String> fieldsToExclude = new HashSet<>(Arrays.asList("title", "isbn"));

        // Serialize with filtered fields
        String resultJson = serializeBookWithExclusions(book, fieldsToExclude);
        System.out.println(resultJson);
    }

    public static String serializeBookWithExclusions(BooksPojo book, Set<String> excludeFields) throws JsonProcessingException {
        // Mark the class with a filter name
        ObjectMapper mapper = new ObjectMapper();

        // You must annotate the class with @JsonFilter
        mapper.setFilterProvider(new SimpleFilterProvider()
                .addFilter("bookFilter", SimpleBeanPropertyFilter.serializeAllExcept(excludeFields)));

        mapper.writerWithDefaultPrettyPrinter().
        return null;
    }
}
