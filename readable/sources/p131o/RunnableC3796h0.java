package p131o;

import android.app.job.JobParameters;
import com.p038google.p039android.datatransport.p041runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* renamed from: o.h0 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC3796h0 implements Runnable {

    /* renamed from: AZxh */
    public final JobParameters f13914AZxh;

    /* renamed from: mjFkc */
    public final JobInfoSchedulerService f13915mjFkc;

    public RunnableC3796h0(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f13915mjFkc = jobInfoSchedulerService;
        this.f13914AZxh = jobParameters;
    }

    /* renamed from: mjFkc */
    public static Runnable m12161mjFkc(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new RunnableC3796h0(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13915mjFkc.jobFinished(this.f13914AZxh, false);
    }
}
