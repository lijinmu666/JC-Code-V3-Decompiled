package androidx.p017core.p018app;

import android.app.PendingIntent;
import androidx.p017core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import p131o.AbstractC2550O9;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    /* renamed from: read */
    public static RemoteActionCompat m541read(AbstractC2550O9 abstractC2550O9) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f943mjFkc = (IconCompat) abstractC2550O9.m9865Ucbh(remoteActionCompat.f943mjFkc, 1);
        remoteActionCompat.f939AZxh = abstractC2550O9.m9866VA(remoteActionCompat.f939AZxh, 2);
        remoteActionCompat.f944wA = abstractC2550O9.m9866VA(remoteActionCompat.f944wA, 3);
        remoteActionCompat.f942ZfxDd = (PendingIntent) abstractC2550O9.m9857IEE(remoteActionCompat.f942ZfxDd, 4);
        remoteActionCompat.f941KLFTb = abstractC2550O9.m9877lgHUyS(remoteActionCompat.f941KLFTb, 5);
        remoteActionCompat.f940JHa = abstractC2550O9.m9877lgHUyS(remoteActionCompat.f940JHa, 6);
        return remoteActionCompat;
    }

    /* renamed from: write */
    public static void m542write(RemoteActionCompat remoteActionCompat, AbstractC2550O9 abstractC2550O9) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC2550O9.m9855Gd(false, false);
        abstractC2550O9.m9882rWxwaT(remoteActionCompat.f943mjFkc, 1);
        abstractC2550O9.m9886wJVbdd(remoteActionCompat.f939AZxh, 2);
        abstractC2550O9.m9886wJVbdd(remoteActionCompat.f944wA, 3);
        abstractC2550O9.m9852CqaNbM(remoteActionCompat.f942ZfxDd, 4);
        abstractC2550O9.m9884vI(remoteActionCompat.f941KLFTb, 5);
        abstractC2550O9.m9884vI(remoteActionCompat.f940JHa, 6);
    }
}
