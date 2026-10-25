package p131o;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.p017core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p131o.AbstractC2346L2;

/* renamed from: o.M2 */
/* loaded from: classes.dex */
public class C2410M2 implements InterfaceC2279K2 {

    /* renamed from: AZxh */
    public final Notification.Builder f9532AZxh;

    /* renamed from: KLFTb */
    public RemoteViews f9534KLFTb;

    /* renamed from: ZfxDd */
    public RemoteViews f9535ZfxDd;

    /* renamed from: lgHUyS */
    public int f9536lgHUyS;

    /* renamed from: mjFkc */
    public final Context f9537mjFkc;

    /* renamed from: qdMbNW */
    public RemoteViews f9538qdMbNW;

    /* renamed from: wA */
    public final AbstractC2346L2.ZfxDd f9539wA;

    /* renamed from: JHa */
    public final List f9533JHa = new ArrayList();

    /* renamed from: xJ */
    public final Bundle f9540xJ = new Bundle();

    /* renamed from: o.M2$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static Notification.Builder m9431AZxh(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        /* renamed from: JHa */
        public static Notification.Builder m9432JHa(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }

        /* renamed from: KLFTb */
        public static Notification.Builder m9433KLFTb(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        /* renamed from: ZfxDd */
        public static Notification.Builder m9434ZfxDd(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        /* renamed from: mjFkc */
        public static Notification.Builder m9435mjFkc(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        /* renamed from: wA */
        public static Notification.Builder m9436wA(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }
    }

    /* renamed from: o.M2$JHa */
    public static class JHa {
        /* renamed from: AZxh */
        public static Notification.Action.Builder m9437AZxh(Notification.Action.Builder builder, int i) {
            return builder.setSemanticAction(i);
        }

        /* renamed from: mjFkc */
        public static Notification.Builder m9438mjFkc(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }
    }

    /* renamed from: o.M2$KLFTb */
    public static class KLFTb {
        /* renamed from: AZxh */
        public static Notification.Builder m9439AZxh(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        /* renamed from: JHa */
        public static Notification.Builder m9440JHa(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        /* renamed from: KLFTb */
        public static Notification.Builder m9441KLFTb(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        /* renamed from: ZfxDd */
        public static Notification.Builder m9442ZfxDd(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        /* renamed from: mjFkc */
        public static Notification.Builder m9443mjFkc(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        /* renamed from: wA */
        public static Notification.Builder m9444wA(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        /* renamed from: xJ */
        public static Notification.Builder m9445xJ(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    /* renamed from: o.M2$ZfxDd */
    public static class ZfxDd {
        /* renamed from: AZxh */
        public static Notification.Builder m9446AZxh(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        /* renamed from: KLFTb */
        public static Notification.Builder m9447KLFTb(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }

        /* renamed from: ZfxDd */
        public static Notification.Builder m9448ZfxDd(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        /* renamed from: mjFkc */
        public static Notification.Action.Builder m9449mjFkc(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        /* renamed from: wA */
        public static Notification.Builder m9450wA(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }
    }

    /* renamed from: o.M2$lgHUyS */
    public static class lgHUyS {
        /* renamed from: AZxh */
        public static Notification.Builder m9451AZxh(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }

        /* renamed from: mjFkc */
        public static Notification.Action.Builder m9452mjFkc(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }
    }

    /* renamed from: o.M2$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static Notification.Action.Builder m9453AZxh(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        /* renamed from: Dt */
        public static Notification.Builder m9454Dt(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }

        /* renamed from: JHa */
        public static String m9455JHa(Notification notification) {
            return notification.getGroup();
        }

        /* renamed from: KLFTb */
        public static Notification.Action.Builder m9456KLFTb(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i, charSequence, pendingIntent);
        }

        /* renamed from: ZfxDd */
        public static Notification.Action m9457ZfxDd(Notification.Action.Builder builder) {
            return builder.build();
        }

        /* renamed from: lgHUyS */
        public static Notification.Builder m9458lgHUyS(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        /* renamed from: mjFkc */
        public static Notification.Builder m9459mjFkc(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        /* renamed from: qdMbNW */
        public static Notification.Builder m9460qdMbNW(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        /* renamed from: wA */
        public static Notification.Action.Builder m9461wA(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        /* renamed from: xJ */
        public static Notification.Builder m9462xJ(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }
    }

    /* renamed from: o.M2$wA */
    public static class wA {
        /* renamed from: AZxh */
        public static Notification.Builder m9463AZxh(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        /* renamed from: mjFkc */
        public static Notification.Action.Builder m9464mjFkc(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        /* renamed from: wA */
        public static Notification.Builder m9465wA(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* renamed from: o.M2$xJ */
    public static class xJ {
        /* renamed from: AZxh */
        public static Notification.Builder m9466AZxh(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        /* renamed from: ZfxDd */
        public static Notification.Builder m9467ZfxDd(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }

        /* renamed from: mjFkc */
        public static Notification.Builder m9468mjFkc(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        /* renamed from: wA */
        public static Notification.Action.Builder m9469wA(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }
    }

    public C2410M2(AbstractC2346L2.ZfxDd zfxDd) {
        int i;
        this.f9539wA = zfxDd;
        Context context = zfxDd.f9335mjFkc;
        this.f9537mjFkc = context;
        Notification.Builder builderM9443mjFkc = KLFTb.m9443mjFkc(context, zfxDd.f9347zvd);
        this.f9532AZxh = builderM9443mjFkc;
        Notification notification = zfxDd.f9326aqHPIZ;
        builderM9443mjFkc.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, zfxDd.f9338qdMbNW).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(zfxDd.f9311KLFTb).setContentText(zfxDd.f9310JHa).setContentInfo(zfxDd.f9305ETF).setContentIntent(zfxDd.f9345xJ).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(zfxDd.f9333lgHUyS, (notification.flags & 128) != 0).setNumber(zfxDd.f9320VA).setProgress(zfxDd.f9328diqgf, zfxDd.f9329eyqo, zfxDd.f9319Ucbh);
        IconCompat iconCompat = zfxDd.f9304Dt;
        wA.m9463AZxh(builderM9443mjFkc, iconCompat == null ? null : iconCompat.m546Dt(context));
        builderM9443mjFkc.setSubText(zfxDd.f9330fehf).setUsesChronometer(zfxDd.f9340rkYL).setPriority(zfxDd.f9314MiMN);
        Iterator it = zfxDd.f9301AZxh.iterator();
        while (it.hasNext()) {
            m9428AZxh((AbstractC2346L2.mjFkc) it.next());
        }
        Bundle bundle = zfxDd.f9344wJVbdd;
        if (bundle != null) {
            this.f9540xJ.putAll(bundle);
        }
        this.f9535ZfxDd = zfxDd.f9303CqaNbM;
        this.f9534KLFTb = zfxDd.f9346xrEuO;
        this.f9532AZxh.setShowWhen(zfxDd.f9324YoKzxo);
        mjFkc.m9460qdMbNW(this.f9532AZxh, zfxDd.f9341vI);
        mjFkc.m9462xJ(this.f9532AZxh, zfxDd.f9331huTpC);
        mjFkc.m9454Dt(this.f9532AZxh, zfxDd.f9308HGpJ);
        mjFkc.m9458lgHUyS(this.f9532AZxh, zfxDd.f9307Gd);
        this.f9536lgHUyS = zfxDd.f9315NPj;
        AZxh.m9431AZxh(this.f9532AZxh, zfxDd.f9332lB);
        AZxh.m9436wA(this.f9532AZxh, zfxDd.f9334mByQ);
        AZxh.m9432JHa(this.f9532AZxh, zfxDd.f9317OjSQV);
        AZxh.m9434ZfxDd(this.f9532AZxh, zfxDd.f9316Ne);
        AZxh.m9433KLFTb(this.f9532AZxh, notification.sound, notification.audioAttributes);
        ArrayList arrayList = zfxDd.f9306GMIER;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                AZxh.m9435mjFkc(this.f9532AZxh, (String) it2.next());
            }
        }
        this.f9538qdMbNW = zfxDd.f9312KLMXS;
        if (zfxDd.f9325ZfxDd.size() > 0) {
            Bundle bundle2 = zfxDd.m9328ZfxDd().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i2 = 0; i2 < zfxDd.f9325ZfxDd.size(); i2++) {
                bundle4.putBundle(Integer.toString(i2), AbstractC2479N2.m9581mjFkc((AbstractC2346L2.mjFkc) zfxDd.f9325ZfxDd.get(i2)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            zfxDd.m9328ZfxDd().putBundle("android.car.EXTENSIONS", bundle2);
            this.f9540xJ.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i3 = Build.VERSION.SDK_INT;
        Object obj = zfxDd.f9313KRTLGT;
        if (obj != null) {
            wA.m9465wA(this.f9532AZxh, obj);
        }
        this.f9532AZxh.setExtras(zfxDd.f9344wJVbdd);
        ZfxDd.m9447KLFTb(this.f9532AZxh, zfxDd.f9318Pq);
        RemoteViews remoteViews = zfxDd.f9303CqaNbM;
        if (remoteViews != null) {
            ZfxDd.m9450wA(this.f9532AZxh, remoteViews);
        }
        RemoteViews remoteViews2 = zfxDd.f9346xrEuO;
        if (remoteViews2 != null) {
            ZfxDd.m9446AZxh(this.f9532AZxh, remoteViews2);
        }
        RemoteViews remoteViews3 = zfxDd.f9312KLMXS;
        if (remoteViews3 != null) {
            ZfxDd.m9448ZfxDd(this.f9532AZxh, remoteViews3);
        }
        KLFTb.m9439AZxh(this.f9532AZxh, zfxDd.f9327cMLeY);
        KLFTb.m9441KLFTb(this.f9532AZxh, zfxDd.f9309IEE);
        KLFTb.m9440JHa(this.f9532AZxh, zfxDd.f9339rWxwaT);
        KLFTb.m9445xJ(this.f9532AZxh, zfxDd.f9321Vnb);
        KLFTb.m9442ZfxDd(this.f9532AZxh, zfxDd.f9315NPj);
        if (zfxDd.f9302BAnRFn) {
            KLFTb.m9444wA(this.f9532AZxh, zfxDd.f9322VocHEe);
        }
        if (!TextUtils.isEmpty(zfxDd.f9347zvd)) {
            this.f9532AZxh.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it3 = zfxDd.f9343wA.iterator();
        if (it3.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it3.next());
            throw null;
        }
        xJ.m9468mjFkc(this.f9532AZxh, zfxDd.f9336oCFDzJ);
        xJ.m9466AZxh(this.f9532AZxh, AbstractC2346L2.wA.m9352mjFkc(null));
        if (i3 >= 31 && (i = zfxDd.f9342vadzgd) != 0) {
            lgHUyS.m9451AZxh(this.f9532AZxh, i);
        }
        if (zfxDd.f9323WrLQs) {
            if (this.f9539wA.f9307Gd) {
                this.f9536lgHUyS = 2;
            } else {
                this.f9536lgHUyS = 1;
            }
            this.f9532AZxh.setVibrate(null);
            this.f9532AZxh.setSound(null);
            int i4 = notification.defaults & (-4);
            notification.defaults = i4;
            this.f9532AZxh.setDefaults(i4);
            if (TextUtils.isEmpty(this.f9539wA.f9331huTpC)) {
                mjFkc.m9462xJ(this.f9532AZxh, "silent");
            }
            KLFTb.m9442ZfxDd(this.f9532AZxh, this.f9536lgHUyS);
        }
    }

    /* renamed from: AZxh */
    public final void m9428AZxh(AbstractC2346L2.mjFkc mjfkc) {
        IconCompat iconCompatM9343ZfxDd = mjfkc.m9343ZfxDd();
        Notification.Action.Builder builderM9464mjFkc = wA.m9464mjFkc(iconCompatM9343ZfxDd != null ? iconCompatM9343ZfxDd.m551qdMbNW() : null, mjfkc.m9344lgHUyS(), mjfkc.m9345mjFkc());
        if (mjfkc.m9342KLFTb() != null) {
            for (RemoteInput remoteInput : C3925j5.m12342AZxh(mjfkc.m9342KLFTb())) {
                mjFkc.m9461wA(builderM9464mjFkc, remoteInput);
            }
        }
        Bundle bundle = mjfkc.m9347wA() != null ? new Bundle(mjfkc.m9347wA()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", mjfkc.m9339AZxh());
        int i = Build.VERSION.SDK_INT;
        ZfxDd.m9449mjFkc(builderM9464mjFkc, mjfkc.m9339AZxh());
        bundle.putInt("android.support.action.semanticAction", mjfkc.m9341JHa());
        JHa.m9437AZxh(builderM9464mjFkc, mjfkc.m9341JHa());
        xJ.m9469wA(builderM9464mjFkc, mjfkc.m9340Dt());
        if (i >= 31) {
            lgHUyS.m9452mjFkc(builderM9464mjFkc, mjfkc.m9346qdMbNW());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", mjfkc.m9348xJ());
        mjFkc.m9453AZxh(builderM9464mjFkc, bundle);
        mjFkc.m9459mjFkc(this.f9532AZxh, mjFkc.m9457ZfxDd(builderM9464mjFkc));
    }

    /* renamed from: ZfxDd */
    public Notification m9429ZfxDd() {
        return this.f9532AZxh.build();
    }

    @Override // p131o.InterfaceC2279K2
    /* renamed from: mjFkc */
    public Notification.Builder mo9117mjFkc() {
        return this.f9532AZxh;
    }

    /* renamed from: wA */
    public Notification m9430wA() {
        Bundle bundleM9309mjFkc;
        RemoteViews remoteViewsM9314JHa;
        RemoteViews remoteViewsM9316ZfxDd;
        AbstractC2346L2.KLFTb kLFTb = this.f9539wA.f9337qGY;
        if (kLFTb != null) {
            kLFTb.mo9310AZxh(this);
        }
        RemoteViews remoteViewsM9315KLFTb = kLFTb != null ? kLFTb.m9315KLFTb(this) : null;
        Notification notificationM9429ZfxDd = m9429ZfxDd();
        if (remoteViewsM9315KLFTb != null) {
            notificationM9429ZfxDd.contentView = remoteViewsM9315KLFTb;
        } else {
            RemoteViews remoteViews = this.f9539wA.f9303CqaNbM;
            if (remoteViews != null) {
                notificationM9429ZfxDd.contentView = remoteViews;
            }
        }
        if (kLFTb != null && (remoteViewsM9316ZfxDd = kLFTb.m9316ZfxDd(this)) != null) {
            notificationM9429ZfxDd.bigContentView = remoteViewsM9316ZfxDd;
        }
        if (kLFTb != null && (remoteViewsM9314JHa = this.f9539wA.f9337qGY.m9314JHa(this)) != null) {
            notificationM9429ZfxDd.headsUpContentView = remoteViewsM9314JHa;
        }
        if (kLFTb != null && (bundleM9309mjFkc = AbstractC2346L2.m9309mjFkc(notificationM9429ZfxDd)) != null) {
            kLFTb.mo9312mjFkc(bundleM9309mjFkc);
        }
        return notificationM9429ZfxDd;
    }
}
