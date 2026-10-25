package p131o;

import java.io.IOException;

/* renamed from: o.Ex */
/* loaded from: classes.dex */
public final class C1926Ex extends IOException {
    public C1926Ex(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    public C1926Ex(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
