package cy.arctique.imspringboot.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cy
 * @date 2022-08-13 10:20
 */
@Component
@Service
@Slf4j
public class AutoTask {

    @Scheduled(cron = "0/3 * * * * ?")
    public void run() {
        log.warn("Auto task run......{}",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(new Date()));
    }
}
