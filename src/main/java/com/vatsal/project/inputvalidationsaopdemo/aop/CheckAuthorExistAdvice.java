package com.vatsal.project.inputvalidationsaopdemo.aop;

import com.vatsal.project.inputvalidationsaopdemo.dto.Book;
import com.vatsal.project.inputvalidationsaopdemo.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class CheckAuthorExistAdvice {

    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Checks if author exists
     */
    @Before("@annotation(com.vatsal.project.inputvalidationsaopdemo.aop.CheckAuthorExists)")
    public void checkAuthorExists(JoinPoint joinPoint) {
        log.debug("entered into advice");

        List<Object> objectList = Arrays.stream(joinPoint.getArgs()).filter(s -> s.getClass().getName().equalsIgnoreCase("com.vatsal.project.inputvalidationsaopdemo.dto.Book")).collect(Collectors.toList());
        List<Book> bookList = (List<Book>) (Object) objectList;
        for (Book book : bookList) {
            int createdBy = book.getCreatedBy();
            Optional<String> optional = authorRepository.findById(createdBy);
            if (!optional.isPresent()) {
                throw new IllegalArgumentException("author not found");
            }
        }
    }
}
