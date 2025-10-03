package ashleysaintlouis.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        log.info("A hora é agora usando somente taxa fixa {} \n", dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 60000, initialDelay = 30000)
    public void reportCurrentTimeDelay() {
        log.info("A hora é agora usando taxa fixa e inicialDelay {} \n", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 00 15 03 10 ?")
    public void tarefasPeriodicas() {
        log.info("Agora é a tarefa usa cron {} \n", dateFormat.format(new Date()));
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void tarefaPeriodicasAsync() throws InterruptedException {
        log.info("Essa tarefa taxa fixa é assync {} \n", System.currentTimeMillis() / 1000);
        Thread.sleep(2000);
    }

}
