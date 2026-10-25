package p131o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: o.U2 */
/* loaded from: classes.dex */
public abstract class AbstractC2931U2 {

    /* renamed from: o.U2$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public final Object f10766AZxh;

        /* renamed from: mjFkc */
        public final List f10767mjFkc;

        public /* synthetic */ mjFkc(Object obj, AbstractC3610eC abstractC3610eC) {
            AbstractC2138I3.m8648xJ(obj);
            this.f10766AZxh = obj;
            this.f10767mjFkc = new ArrayList();
        }

        /* renamed from: mjFkc */
        public mjFkc m10467mjFkc(String str, Object obj) {
            AbstractC2138I3.m8648xJ(str);
            this.f10767mjFkc.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f10766AZxh.getClass().getSimpleName());
            sb.append('{');
            int size = this.f10767mjFkc.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.f10767mjFkc.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: AZxh */
    public static int m10464AZxh(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: mjFkc */
    public static boolean m10465mjFkc(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: wA */
    public static mjFkc m10466wA(Object obj) {
        return new mjFkc(obj, null);
    }
}
