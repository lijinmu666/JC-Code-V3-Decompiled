package p131o;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* renamed from: o.N6 */
/* loaded from: classes.dex */
public class C2483N6 {

    /* renamed from: AZxh */
    public static final C2957UOnCkw f9656AZxh = C2957UOnCkw.m10490mjFkc(C2483N6.class).m10500AZxh(C4441qqdo.m13300xJ(C3922j2.class)).m10500AZxh(C4441qqdo.m13300xJ(Context.class)).m10503ZfxDd(new InterfaceC2597Otxclu() { // from class: o.uU
        @Override // p131o.InterfaceC2597Otxclu
        /* renamed from: mjFkc */
        public final Object mo7992mjFkc(InterfaceC4803wGscSa interfaceC4803wGscSa) {
            return new C2483N6((Context) interfaceC4803wGscSa.mo8924mjFkc(Context.class));
        }
    }).m10504wA();

    /* renamed from: mjFkc */
    public final Context f9657mjFkc;

    public C2483N6(Context context) {
        this.f9657mjFkc = context;
    }

    /* renamed from: AZxh */
    public final SharedPreferences m9586AZxh() {
        return this.f9657mjFkc.getSharedPreferences("com.google.mlkit.internal", 0);
    }

    /* renamed from: mjFkc */
    public synchronized String m9587mjFkc() {
        String string = m9586AZxh().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        m9586AZxh().edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }
}
