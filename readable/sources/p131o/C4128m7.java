package p131o;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.p038google.p039android.p042gms.p043auth.p044api.p045signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* renamed from: o.m7 */
/* loaded from: classes.dex */
public class C4128m7 {

    /* renamed from: ZfxDd */
    public static C4128m7 f14876ZfxDd;

    /* renamed from: wA */
    public static final Lock f14877wA = new ReentrantLock();

    /* renamed from: AZxh */
    public final SharedPreferences f14878AZxh;

    /* renamed from: mjFkc */
    public final Lock f14879mjFkc = new ReentrantLock();

    public C4128m7(Context context) {
        this.f14878AZxh = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: ZfxDd */
    public static final String m12749ZfxDd(String str, String str2) {
        return str + ":" + str2;
    }

    /* renamed from: mjFkc */
    public static C4128m7 m12750mjFkc(Context context) {
        AbstractC2138I3.m8648xJ(context);
        Lock lock = f14877wA;
        lock.lock();
        try {
            if (f14876ZfxDd == null) {
                f14876ZfxDd = new C4128m7(context.getApplicationContext());
            }
            C4128m7 c4128m7 = f14876ZfxDd;
            lock.unlock();
            return c4128m7;
        } catch (Throwable th) {
            f14877wA.unlock();
            throw th;
        }
    }

    /* renamed from: AZxh */
    public GoogleSignInAccount m12751AZxh() {
        String strM12752wA;
        String strM12752wA2 = m12752wA("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strM12752wA2) || (strM12752wA = m12752wA(m12749ZfxDd("googleSignInAccount", strM12752wA2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m2359VA(strM12752wA);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: wA */
    public final String m12752wA(String str) {
        this.f14879mjFkc.lock();
        try {
            return this.f14878AZxh.getString(str, null);
        } finally {
            this.f14879mjFkc.unlock();
        }
    }
}
