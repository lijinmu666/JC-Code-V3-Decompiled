package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC4543sMIIyd;

@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m4988d2 = {"Landroidx/lifecycle/DefaultLifecycleObserverAdapter;", "Landroidx/lifecycle/KLFTb;", "Lo/sMIIyd;", "defaultLifecycleObserver", "lifecycleEventObserver", "<init>", "(Lo/sMIIyd;Landroidx/lifecycle/KLFTb;)V", "Lo/W0;", "source", "Landroidx/lifecycle/wA$mjFkc;", "event", BuildConfig.f24315FLAVOR, "VA", "(Lo/W0;Landroidx/lifecycle/wA$mjFkc;)V", "mjFkc", "Lo/sMIIyd;", "AZxh", "Landroidx/lifecycle/KLFTb;", "lifecycle-common"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements InterfaceC0104KLFTb {

    /* renamed from: AZxh, reason: from kotlin metadata */
    public final InterfaceC0104KLFTb lifecycleEventObserver;

    /* renamed from: mjFkc, reason: from kotlin metadata */
    public final InterfaceC4543sMIIyd defaultLifecycleObserver;

    /* renamed from: androidx.lifecycle.DefaultLifecycleObserverAdapter$mjFkc */
    public /* synthetic */ class C0101mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f1340mjFkc;

        static {
            int[] iArr = new int[AbstractC0112wA.mjFkc.m1101values().length];
            try {
                iArr[AbstractC0112wA.mjFkc.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0112wA.mjFkc.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0112wA.mjFkc.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0112wA.mjFkc.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0112wA.mjFkc.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0112wA.mjFkc.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0112wA.mjFkc.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f1340mjFkc = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(InterfaceC4543sMIIyd defaultLifecycleObserver, InterfaceC0104KLFTb interfaceC0104KLFTb) {
        Intrinsics.checkNotNullParameter(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.defaultLifecycleObserver = defaultLifecycleObserver;
        this.lifecycleEventObserver = interfaceC0104KLFTb;
    }

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (C0101mjFkc.f1340mjFkc[event.ordinal()]) {
            case 1:
                this.defaultLifecycleObserver.m13498qdMbNW(source);
                break;
            case 2:
                this.defaultLifecycleObserver.m13495KLFTb(source);
                break;
            case 3:
                this.defaultLifecycleObserver.mo631lgHUyS(source);
                break;
            case 4:
                this.defaultLifecycleObserver.m13496MiMN(source);
                break;
            case 5:
                this.defaultLifecycleObserver.m13497fehf(source);
                break;
            case 6:
                this.defaultLifecycleObserver.m13499xJ(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0104KLFTb interfaceC0104KLFTb = this.lifecycleEventObserver;
        if (interfaceC0104KLFTb != null) {
            interfaceC0104KLFTb.mo4VA(source, event);
        }
    }
}
