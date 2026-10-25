package p131o;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.gD */
/* loaded from: classes.dex */
public final class FragmentC3740gD extends Fragment implements InterfaceC2929U0 {

    /* renamed from: ZfxDd */
    public static final WeakHashMap f13690ZfxDd = new WeakHashMap();

    /* renamed from: wA */
    public Bundle f13693wA;

    /* renamed from: mjFkc */
    public final Map f13692mjFkc = Collections.synchronizedMap(new C4633tjSezt());

    /* renamed from: AZxh */
    public int f13691AZxh = 0;

    /* renamed from: JHa */
    public static FragmentC3740gD m11984JHa(Activity activity) {
        FragmentC3740gD fragmentC3740gD;
        WeakHashMap weakHashMap = f13690ZfxDd;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (fragmentC3740gD = (FragmentC3740gD) weakReference.get()) != null) {
            return fragmentC3740gD;
        }
        try {
            FragmentC3740gD fragmentC3740gD2 = (FragmentC3740gD) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (fragmentC3740gD2 == null || fragmentC3740gD2.isRemoving()) {
                fragmentC3740gD2 = new FragmentC3740gD();
                activity.getFragmentManager().beginTransaction().add(fragmentC3740gD2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(fragmentC3740gD2));
            return fragmentC3740gD2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    @Override // p131o.InterfaceC2929U0
    /* renamed from: AZxh */
    public final void mo8531AZxh(String str, LifecycleCallback lifecycleCallback) {
        if (this.f13692mjFkc.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f13692mjFkc.put(str, lifecycleCallback);
        if (this.f13691AZxh > 0) {
            new HandlerC4274oL(Looper.getMainLooper()).post(new RunnableC4329pB(this, lifecycleCallback, str));
        }
    }

    @Override // p131o.InterfaceC2929U0
    /* renamed from: KLFTb */
    public final Activity mo8532KLFTb() {
        return getActivity();
    }

    @Override // p131o.InterfaceC2929U0
    /* renamed from: ZfxDd */
    public final LifecycleCallback mo8533ZfxDd(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f13692mjFkc.get(str));
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f13692mjFkc.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).m2389mjFkc(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator it = this.f13692mjFkc.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2387KLFTb(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13691AZxh = 1;
        this.f13693wA = bundle;
        for (Map.Entry entry : this.f13692mjFkc.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo2386JHa(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f13691AZxh = 5;
        Iterator it = this.f13692mjFkc.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).m2391xJ();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f13691AZxh = 3;
        Iterator it = this.f13692mjFkc.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2388lgHUyS();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f13692mjFkc.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).mo2390qdMbNW(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f13691AZxh = 2;
        Iterator it = this.f13692mjFkc.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2384Dt();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f13691AZxh = 4;
        Iterator it = this.f13692mjFkc.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2385ETF();
        }
    }
}
