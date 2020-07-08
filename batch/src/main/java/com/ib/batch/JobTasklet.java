package com.ib.batch;

import com.ib.config.LoanClient;
import com.ib.generated.LoanWS;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class JobTasklet implements Tasklet {

    @Autowired
    LoanClient loanClient;

    EmailService service = new EmailService();

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//        System.out.println("MyTask start..");

//        LocalDate currentDate = LocalDate.now();
//        LocalDate borrowingDate;
//        LocalDate returningDate;
//
//        List<LoanWS> loans = this.loanClient.getAllLateLoans();
//        for (LoanWS loan : loans) {
//            borrowingDate = LocalDate.from(loan.getBorrowingDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
//            returningDate = LocalDate.from(loan.getReturnDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
//            String to = loan.getUser().getEmail();
//            String subject = "Borrowing : return date exceeded ("
//                    + returningDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
//                    + ") by "
//                    + DAYS.between(returningDate, currentDate)
//                    + " days";
//
//            String text = "Return date exceeded for the book \""
//                    + loan.getBook().getEsbn()
//                    + "\" that you borrowed on "
//                    + borrowingDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//
//            service.sendSimpleMessage(to, subject, text);
//        }
//
//        String subject = "Borrowing : return date exceeded";
//
//        String text = "Return date exceeded for the book";
//
//        String to = MailConstants.FRIEND_EMAIL;
//
//        service.sendSimpleMessage(to, subject, text);
 //       System.out.println("MyTask start..");
        return RepeatStatus.FINISHED;
    }
}