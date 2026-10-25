package p131o;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.p038google.p039android.p042gms.p046common.p047api.GoogleApiActivity;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2346L2;

/* renamed from: o.e */
/* loaded from: classes.dex */
public class C3597e extends C3661f {

    /* renamed from: wA */
    public String f13423wA;

    /* renamed from: KLFTb */
    public static final Object f13421KLFTb = new Object();

    /* renamed from: JHa */
    public static final C3597e f13420JHa = new C3597e();

    /* renamed from: ZfxDd */
    public static final int f13422ZfxDd = C3661f.f13514mjFkc;

    /* renamed from: MiMN */
    public static C3597e m11771MiMN() {
        return f13420JHa;
    }

    @Override // p131o.C3661f
    /* renamed from: AZxh */
    public Intent mo11772AZxh(Context context, int i, String str) {
        return super.mo11772AZxh(context, i, str);
    }

    @Override // p131o.C3661f
    /* renamed from: Dt */
    public final boolean mo11773Dt(int i) {
        return super.mo11773Dt(i);
    }

    /* renamed from: ETF */
    public Dialog m11774ETF(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m11786qGY(activity, i, AbstractDialogInterfaceOnClickListenerC3374ad.m11392AZxh(activity, mo11772AZxh(activity, i, "d"), i2), onCancelListener, null);
    }

    /* renamed from: IEE */
    public final C4491rc m11775IEE(Context context, AbstractC4424qc abstractC4424qc) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        C4491rc c4491rc = new C4491rc(abstractC4424qc);
        AbstractC4895xd.m13956ZfxDd(context, c4491rc, intentFilter);
        c4491rc.m13381mjFkc(context);
        if (m11876qdMbNW(context, "com.google.android.gms")) {
            return c4491rc;
        }
        abstractC4424qc.mo13271mjFkc();
        c4491rc.m13380AZxh();
        return null;
    }

    @Override // p131o.C3661f
    /* renamed from: KLFTb */
    public final String mo11776KLFTb(int i) {
        return super.mo11776KLFTb(i);
    }

    /* renamed from: Pq */
    public final void m11777Pq(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC4761vdbwS.m13790mjFkc(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* renamed from: Ucbh */
    public final boolean m11778Ucbh(Activity activity, InterfaceC2929U0 interfaceC2929U0, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogM11786qGY = m11786qGY(activity, i, AbstractDialogInterfaceOnClickListenerC3374ad.m11393wA(interfaceC2929U0, mo11772AZxh(activity, i, "d"), 2), onCancelListener, null);
        if (dialogM11786qGY == null) {
            return false;
        }
        m11777Pq(activity, dialogM11786qGY, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    /* renamed from: VA */
    public PendingIntent m11779VA(Context context, C3613eEOGOh c3613eEOGOh) {
        return c3613eEOGOh.m11824ZfxDd() ? c3613eEOGOh.m11827wA() : mo11788wA(context, c3613eEOGOh.m11826mjFkc(), 0);
    }

    /* renamed from: YoKzxo */
    public boolean m11780YoKzxo(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogM11774ETF = m11774ETF(activity, i, i2, onCancelListener);
        if (dialogM11774ETF == null) {
            return false;
        }
        m11777Pq(activity, dialogM11774ETF, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    /* renamed from: diqgf */
    public final void m11781diqgf(Context context, int i, String str, PendingIntent pendingIntent) throws Resources.NotFoundException {
        int i2;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null), new IllegalArgumentException());
        if (i == 18) {
            m11782eyqo(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strM13512KLFTb = AbstractC4559sc.m13512KLFTb(context, i);
        String strM13513ZfxDd = AbstractC4559sc.m13513ZfxDd(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) AbstractC2138I3.m8648xJ(context.getSystemService("notification"));
        AbstractC2346L2.ZfxDd zfxDdM9322IEE = new AbstractC2346L2.ZfxDd(context).m9324MiMN(true).m9323JHa(true).m9321ETF(strM13512KLFTb).m9322IEE(new AbstractC2346L2.AZxh().m9311lgHUyS(strM13513ZfxDd));
        if (AbstractC3943jKf.m12428AZxh(context)) {
            AbstractC2138I3.m8646qdMbNW(AbstractC4856x3.m13897wA());
            zfxDdM9322IEE.m9331fehf(context.getApplicationInfo().icon).m9336rkYL(2);
            if (AbstractC3943jKf.m12433wA(context)) {
                zfxDdM9322IEE.m9333mjFkc(AbstractC4389q4.f16015mjFkc, resources.getString(AbstractC2348L4.f9386rkYL), pendingIntent);
            } else {
                zfxDdM9322IEE.m9335qdMbNW(pendingIntent);
            }
        } else {
            zfxDdM9322IEE.m9331fehf(R.drawable.stat_sys_warning).m9325Pq(resources.getString(AbstractC2348L4.f9383lgHUyS)).m9330eyqo(System.currentTimeMillis()).m9335qdMbNW(pendingIntent).m9320Dt(strM13513ZfxDd);
        }
        if (AbstractC4856x3.m13891JHa()) {
            AbstractC2138I3.m8646qdMbNW(AbstractC4856x3.m13891JHa());
            synchronized (f13421KLFTb) {
                str2 = this.f13423wA;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(AbstractC2348L4.f9388xJ);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            zfxDdM9322IEE.m9332lgHUyS(str2);
        }
        Notification notificationM9337wA = zfxDdM9322IEE.m9337wA();
        if (i == 1 || i == 2 || i == 3) {
            AbstractC3919j.f14232AZxh.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationM9337wA);
    }

    /* renamed from: eyqo */
    public final void m11782eyqo(Context context) {
        new HandlerC2642Pc(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    /* renamed from: fehf */
    public final Dialog m11783fehf(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(AbstractC4559sc.m13516wA(activity, 18));
        builder.setPositiveButton(BuildConfig.f24315FLAVOR, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        m11777Pq(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    /* renamed from: huTpC */
    public final boolean m11784huTpC(Context context, C3613eEOGOh c3613eEOGOh, int i) {
        PendingIntent pendingIntentM11779VA;
        if (AbstractC3067W.m10744mjFkc(context) || (pendingIntentM11779VA = m11779VA(context, c3613eEOGOh)) == null) {
            return false;
        }
        m11781diqgf(context, c3613eEOGOh.m11826mjFkc(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.m2370mjFkc(context, pendingIntentM11779VA, i, true), AbstractC1705Bd.f7502mjFkc | 134217728));
        return true;
    }

    @Override // p131o.C3661f
    /* renamed from: lgHUyS */
    public int mo11785lgHUyS(Context context, int i) {
        return super.mo11785lgHUyS(context, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: qGY */
    public final Dialog m11786qGY(Context context, int i, AbstractDialogInterfaceOnClickListenerC3374ad abstractDialogInterfaceOnClickListenerC3374ad, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(AbstractC4559sc.m13516wA(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strM13510AZxh = AbstractC4559sc.m13510AZxh(context, i);
        if (strM13510AZxh != null) {
            if (abstractDialogInterfaceOnClickListenerC3374ad == null) {
                abstractDialogInterfaceOnClickListenerC3374ad = onClickListener;
            }
            builder.setPositiveButton(strM13510AZxh, abstractDialogInterfaceOnClickListenerC3374ad);
        }
        String strM13511JHa = AbstractC4559sc.m13511JHa(context, i);
        if (strM13511JHa != null) {
            builder.setTitle(strM13511JHa);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i)), new IllegalArgumentException());
        return builder.create();
    }

    /* renamed from: rkYL */
    public void m11787rkYL(Context context, int i) {
        m11781diqgf(context, i, null, m11874ZfxDd(context, i, 0, "n"));
    }

    @Override // p131o.C3661f
    /* renamed from: wA */
    public PendingIntent mo11788wA(Context context, int i, int i2) {
        return super.mo11788wA(context, i, i2);
    }

    @Override // p131o.C3661f
    /* renamed from: xJ */
    public int mo11789xJ(Context context) {
        return super.mo11789xJ(context);
    }
}
