package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.C0111qdMbNW;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.C2825SOS;
import p131o.InterfaceC2343L;
import p131o.InterfaceC3068W0;

@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m4988d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "Lo/L;", "Lo/W0;", "<init>", "()V", "Landroid/content/Context;", "context", "wA", "(Landroid/content/Context;)Lo/W0;", BuildConfig.f24315FLAVOR, "Ljava/lang/Class;", "mjFkc", "()Ljava/util/List;", "lifecycle-process_release"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC2343L {
    @Override // p131o.InterfaceC2343L
    /* renamed from: mjFkc */
    public List mo629mjFkc() {
        return CollectionsKt.emptyList();
    }

    @Override // p131o.InterfaceC2343L
    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public InterfaceC3068W0 mo626AZxh(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        C2825SOS c2825sosM10142KLFTb = C2825SOS.m10142KLFTb(context);
        Intrinsics.checkNotNullExpressionValue(c2825sosM10142KLFTb, "getInstance(context)");
        if (!c2825sosM10142KLFTb.m10148xJ(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0108ZfxDd.m1071mjFkc(context);
        C0111qdMbNW.AZxh aZxh = C0111qdMbNW.f1390qdMbNW;
        aZxh.m1092AZxh(context);
        return aZxh.m1093mjFkc();
    }
}
