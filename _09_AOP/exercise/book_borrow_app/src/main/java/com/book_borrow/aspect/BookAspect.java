package com.book_borrow.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component              //purpose -> create obj bean for BookAspect
public class BookAspect {
    //obj để ghi log
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //dấu * -> tất cả method
    //dấu .. -> áp dụng cho all tham số truyền vào
    //define JP (method in Controller) suitable for Advice (code below)  ?
    //execution -> khi gọi method trong controller thì sẽ thực thi advice below.
    @AfterThrowing("execution(* com.book_borrow.controller.BookController.*(..))")
    public void logAfterMethodReturn(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
//        System.out.println("Method Name"+ nameMethod);
        //ghi log:
//        logger.info("Method Name" + nameMethod);
        logger.error("Method Name" + nameMethod);
    }

    //Ghi log tất cả các action khiến trạng thái sách của thư viện bị thay đổi.
    //
    //Ghi log số lượng người đã ghé thăm thư viện sách (tất cả các thao tác).
    // Gợi ý: ở đây cần sử dụng một join point khác với afterthrowing.
}
