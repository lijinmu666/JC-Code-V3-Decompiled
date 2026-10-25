package p131o;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.p038google.p039android.datatransport.p041runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* renamed from: o.g0 */
/* loaded from: classes.dex */
public class C3727g0 implements InterfaceC4957yb {

    /* renamed from: AZxh */
    public final InterfaceC4829wfQA f13665AZxh;

    /* renamed from: mjFkc */
    public final Context f13666mjFkc;

    /* renamed from: wA */
    public final AbstractC4391q6 f13667wA;

    public C3727g0(Context context, InterfaceC4829wfQA interfaceC4829wfQA, AbstractC4391q6 abstractC4391q6) {
        this.f13666mjFkc = context;
        this.f13665AZxh = interfaceC4829wfQA;
        this.f13667wA = abstractC4391q6;
    }

    @Override // p131o.InterfaceC4957yb
    /* renamed from: AZxh */
    public void mo11971AZxh(AbstractC3140X8 abstractC3140X8, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.f13666mjFkc, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f13666mjFkc.getSystemService("jobscheduler");
        int iM11974wA = m11974wA(abstractC3140X8);
        if (!z && m11972ZfxDd(jobScheduler, iM11974wA, i)) {
            AbstractC4122m1.m12737mjFkc("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", abstractC3140X8);
            return;
        }
        long jMo11674AZxh = this.f13665AZxh.mo11674AZxh(abstractC3140X8);
        JobInfo.Builder builderM13174wA = this.f13667wA.m13174wA(new JobInfo.Builder(iM11974wA, componentName), abstractC3140X8.mo10889ZfxDd(), jMo11674AZxh, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", abstractC3140X8.mo10887AZxh());
        persistableBundle.putInt("priority", AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd()));
        if (abstractC3140X8.mo10890wA() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(abstractC3140X8.mo10890wA(), 0));
        }
        builderM13174wA.setExtras(persistableBundle);
        AbstractC4122m1.m12733AZxh("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", abstractC3140X8, Integer.valueOf(iM11974wA), Long.valueOf(this.f13667wA.m13175xJ(abstractC3140X8.mo10889ZfxDd(), jMo11674AZxh, i)), Long.valueOf(jMo11674AZxh), Integer.valueOf(i));
        jobScheduler.schedule(builderM13174wA.build());
    }

    /* renamed from: ZfxDd */
    public final boolean m11972ZfxDd(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }

    @Override // p131o.InterfaceC4957yb
    /* renamed from: mjFkc */
    public void mo11973mjFkc(AbstractC3140X8 abstractC3140X8, int i) {
        mo11971AZxh(abstractC3140X8, i, false);
    }

    /* renamed from: wA */
    public int m11974wA(AbstractC3140X8 abstractC3140X8) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f13666mjFkc.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(abstractC3140X8.mo10887AZxh().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd())).array());
        if (abstractC3140X8.mo10890wA() != null) {
            adler32.update(abstractC3140X8.mo10890wA());
        }
        return (int) adler32.getValue();
    }
}
