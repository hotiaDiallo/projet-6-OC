package com.ib.batch;

import com.ib.config.LoanClient;
import com.ib.generated.LoanWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ib.*"})
public class Application implements CommandLineRunner
{
    @Autowired
    LoanClient loanClient;

    EmailService service = new EmailService();

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyTask start..");

        LocalDate currentDate = LocalDate.now();
        LocalDate borrowingDate;
        LocalDate returningDate;

        List<LoanWS> loans = this.loanClient.getAllLateLoans();
        for (LoanWS loan : loans) {
            borrowingDate = LocalDate.from(loan.getBorrowingDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
            returningDate = LocalDate.from(loan.getReturnDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
            //String to = loan.getUser().getEmail();
            String to = MailConstants.FRIEND_EMAIL;
            String subject = "Borrowing : return date exceeded ("
                    + returningDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                    + ") by "
                    + DAYS.between(returningDate, currentDate)
                    + " days";

            String text = "Return date exceeded for the book \""
                    + loan.getBook().getEsbn()
                    + "\" that you borrowed on "
                    + borrowingDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

            service.sendSimpleMessage(to, subject, text);
        }
        System.out.println("MyTask start..");
    }
}
