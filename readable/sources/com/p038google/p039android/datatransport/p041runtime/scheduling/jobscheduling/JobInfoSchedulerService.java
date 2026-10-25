package com.p038google.p039android.datatransport.p041runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import p131o.AbstractC2480N3;
import p131o.AbstractC3140X8;
import p131o.C3543d9;
import p131o.RunnableC3796h0;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        C3543d9.m11710JHa(getApplicationContext());
        AbstractC3140X8.mjFkc mjfkcMo10892ZfxDd = AbstractC3140X8.m10886mjFkc().mo10891AZxh(string).mo10892ZfxDd(AbstractC2480N3.m9583AZxh(i));
        if (string2 != null) {
            mjfkcMo10892ZfxDd.mo10894wA(Base64.decode(string2, 0));
        }
        C3543d9.m11712wA().m11714KLFTb().m7678xJ(mjfkcMo10892ZfxDd.mo10893mjFkc(), i2, RunnableC3796h0.m12161mjFkc(this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
