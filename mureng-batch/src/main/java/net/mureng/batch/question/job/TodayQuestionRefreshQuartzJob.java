package net.mureng.batch.question.job;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.mureng.batch.core.job.MurengQuartzJob;
import net.mureng.batch.util.JobLauncherUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

import static net.mureng.batch.question.job.TodayQuestionRefreshJobConfig.TODAY_QUESTION_REFRESH_JOB_LAUNCHER_NAME;

@Slf4j
@Getter @Setter
public class TodayQuestionRefreshQuartzJob extends MurengQuartzJob {

    @Override
    public void interrupt() throws UnableToInterruptJobException {

    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobLauncherUtil.getBeanName(TODAY_QUESTION_REFRESH_JOB_LAUNCHER_NAME).execute();
    }
}
