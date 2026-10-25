package p131o;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: o.BW */
/* loaded from: classes.dex */
public final class C1699BW {

    /* renamed from: mjFkc */
    public final String f7481mjFkc = "\n";

    public C1699BW(String str) {
    }

    /* renamed from: mjFkc */
    public static C1699BW m7696mjFkc(String str) {
        return new C1699BW("\n");
    }

    /* renamed from: wA */
    public static final CharSequence m7697wA(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    /* renamed from: AZxh */
    public final String m7698AZxh(Iterable iterable) throws IOException {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                sb.append(m7697wA(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f7481mjFkc);
                    sb.append(m7697wA(it.next()));
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
