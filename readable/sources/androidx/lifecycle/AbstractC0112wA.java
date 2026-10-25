package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.InterfaceC3001V0;

/* renamed from: androidx.lifecycle.wA */
/* loaded from: classes.dex */
public abstract class AbstractC0112wA {

    /* renamed from: mjFkc */
    public AtomicReference f1403mjFkc = new AtomicReference();

    /* renamed from: androidx.lifecycle.wA$AZxh */
    public enum AZxh {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: lgHUyS */
        public final boolean m1098lgHUyS(AZxh state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return compareTo(state) >= 0;
        }
    }

    /* renamed from: androidx.lifecycle.wA$mjFkc */
    public enum mjFkc {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C6346mjFkc Companion = new C6346mjFkc(null);

        /* renamed from: androidx.lifecycle.wA$mjFkc$AZxh */
        public /* synthetic */ class AZxh {

            /* renamed from: mjFkc */
            public static final /* synthetic */ int[] f1413mjFkc;

            static {
                int[] iArr = new int[mjFkc.m1101values().length];
                try {
                    iArr[mjFkc.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[mjFkc.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[mjFkc.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[mjFkc.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[mjFkc.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[mjFkc.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[mjFkc.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f1413mjFkc = iArr;
            }
        }

        /* renamed from: androidx.lifecycle.wA$mjFkc$mjFkc, reason: collision with other inner class name */
        public static final class C6346mjFkc {

            /* renamed from: androidx.lifecycle.wA$mjFkc$mjFkc$mjFkc, reason: collision with other inner class name */
            public /* synthetic */ class C6347mjFkc {

                /* renamed from: mjFkc */
                public static final /* synthetic */ int[] f1414mjFkc;

                static {
                    int[] iArr = new int[AZxh.m1097values().length];
                    try {
                        iArr[AZxh.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AZxh.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AZxh.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[AZxh.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[AZxh.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f1414mjFkc = iArr;
                }
            }

            public /* synthetic */ C6346mjFkc(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: AZxh */
            public final mjFkc m1103AZxh(AZxh state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i = C6347mjFkc.f1414mjFkc[state.ordinal()];
                if (i == 1) {
                    return mjFkc.ON_START;
                }
                if (i == 2) {
                    return mjFkc.ON_RESUME;
                }
                if (i != 5) {
                    return null;
                }
                return mjFkc.ON_CREATE;
            }

            /* renamed from: mjFkc */
            public final mjFkc m1104mjFkc(AZxh state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i = C6347mjFkc.f1414mjFkc[state.ordinal()];
                if (i == 1) {
                    return mjFkc.ON_DESTROY;
                }
                if (i == 2) {
                    return mjFkc.ON_STOP;
                }
                if (i != 3) {
                    return null;
                }
                return mjFkc.ON_PAUSE;
            }

            public C6346mjFkc() {
            }
        }

        /* renamed from: lgHUyS */
        public final AZxh m1102lgHUyS() {
            switch (AZxh.f1413mjFkc[ordinal()]) {
                case 1:
                case 2:
                    return AZxh.CREATED;
                case 3:
                case 4:
                    return AZxh.STARTED;
                case 5:
                    return AZxh.RESUMED;
                case 6:
                    return AZxh.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* renamed from: AZxh */
    public abstract AZxh mo1035AZxh();

    /* renamed from: mjFkc */
    public abstract void mo1044mjFkc(InterfaceC3001V0 interfaceC3001V0);

    /* renamed from: wA */
    public abstract void mo1046wA(InterfaceC3001V0 interfaceC3001V0);
}
