package p131o;

import android.os.Bundle;
import androidx.p017core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.p249jcajce.p280util.AnnotatedPrivateKey;
import p131o.AbstractC2346L2;

/* renamed from: o.N2 */
/* loaded from: classes.dex */
public abstract class AbstractC2479N2 {

    /* renamed from: mjFkc */
    public static final Object f9632mjFkc = new Object();

    /* renamed from: AZxh */
    public static final Object f9631AZxh = new Object();

    /* renamed from: AZxh */
    public static Bundle m9580AZxh(C3925j5 c3925j5) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c3925j5.m12350qdMbNW());
        bundle.putCharSequence(AnnotatedPrivateKey.f21953LABEL, c3925j5.m12349lgHUyS());
        bundle.putCharSequenceArray("choices", c3925j5.m12347KLFTb());
        bundle.putBoolean("allowFreeFormInput", c3925j5.m12351wA());
        bundle.putBundle("extras", c3925j5.m12352xJ());
        Set setM12348ZfxDd = c3925j5.m12348ZfxDd();
        if (setM12348ZfxDd != null && !setM12348ZfxDd.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setM12348ZfxDd.size());
            Iterator it = setM12348ZfxDd.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: mjFkc */
    public static Bundle m9581mjFkc(AbstractC2346L2.mjFkc mjfkc) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatM9343ZfxDd = mjfkc.m9343ZfxDd();
        bundle.putInt("icon", iconCompatM9343ZfxDd != null ? iconCompatM9343ZfxDd.m545AZxh() : 0);
        bundle.putCharSequence("title", mjfkc.m9344lgHUyS());
        bundle.putParcelable("actionIntent", mjfkc.m9345mjFkc());
        Bundle bundle2 = mjfkc.m9347wA() != null ? new Bundle(mjfkc.m9347wA()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", mjfkc.m9339AZxh());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", m9582wA(mjfkc.m9342KLFTb()));
        bundle.putBoolean("showsUserInterface", mjfkc.m9348xJ());
        bundle.putInt("semanticAction", mjfkc.m9341JHa());
        return bundle;
    }

    /* renamed from: wA */
    public static Bundle[] m9582wA(C3925j5[] c3925j5Arr) {
        if (c3925j5Arr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c3925j5Arr.length];
        for (int i = 0; i < c3925j5Arr.length; i++) {
            bundleArr[i] = m9580AZxh(c3925j5Arr[i]);
        }
        return bundleArr;
    }
}
