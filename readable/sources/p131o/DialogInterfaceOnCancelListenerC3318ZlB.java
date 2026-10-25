package p131o;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.p022app.AbstractC0093KLFTb;
import androidx.fragment.p022app.AbstractC0095lgHUyS;
import androidx.fragment.p022app.Fragment;

/* renamed from: o.ZlB */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC3318ZlB extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: ANMGZc */
    public boolean f12208ANMGZc;

    /* renamed from: JrJO */
    public Handler f12210JrJO;

    /* renamed from: dm */
    public Dialog f12217dm;

    /* renamed from: tQ */
    public boolean f12220tQ;

    /* renamed from: vjlshU */
    public boolean f12221vjlshU;

    /* renamed from: yfx */
    public boolean f12223yfx;

    /* renamed from: nxI */
    public Runnable f12219nxI = new mjFkc();

    /* renamed from: WGXroI */
    public DialogInterface.OnCancelListener f12213WGXroI = new AZxh();

    /* renamed from: XV */
    public DialogInterface.OnDismissListener f12214XV = new wA();

    /* renamed from: bbzow */
    public int f12216bbzow = 0;

    /* renamed from: SwgkN */
    public int f12211SwgkN = 0;

    /* renamed from: JBhc */
    public boolean f12209JBhc = true;

    /* renamed from: Vdz */
    public boolean f12212Vdz = true;

    /* renamed from: jm */
    public int f12218jm = -1;

    /* renamed from: alEkx */
    public InterfaceC3070W2 f12215alEkx = new ZfxDd();

    /* renamed from: xROA */
    public boolean f12222xROA = false;

    /* renamed from: o.ZlB$AZxh */
    public class AZxh implements DialogInterface.OnCancelListener {
        public AZxh() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC3318ZlB.this.f12217dm != null) {
                DialogInterfaceOnCancelListenerC3318ZlB dialogInterfaceOnCancelListenerC3318ZlB = DialogInterfaceOnCancelListenerC3318ZlB.this;
                dialogInterfaceOnCancelListenerC3318ZlB.onCancel(dialogInterfaceOnCancelListenerC3318ZlB.f12217dm);
            }
        }
    }

    /* renamed from: o.ZlB$KLFTb */
    public class KLFTb extends AbstractC3963jeHSg {

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC3963jeHSg f12226mjFkc;

        public KLFTb(AbstractC3963jeHSg abstractC3963jeHSg) {
            this.f12226mjFkc = abstractC3963jeHSg;
        }

        @Override // p131o.AbstractC3963jeHSg
        /* renamed from: AZxh */
        public boolean mo849AZxh() {
            return this.f12226mjFkc.mo849AZxh() || DialogInterfaceOnCancelListenerC3318ZlB.this.m11222XgAT();
        }

        @Override // p131o.AbstractC3963jeHSg
        /* renamed from: mjFkc */
        public View mo850mjFkc(int i) {
            return this.f12226mjFkc.mo849AZxh() ? this.f12226mjFkc.mo850mjFkc(i) : DialogInterfaceOnCancelListenerC3318ZlB.this.m11225jtz(i);
        }
    }

    /* renamed from: o.ZlB$ZfxDd */
    public class ZfxDd implements InterfaceC3070W2 {
        public ZfxDd() {
        }

        @Override // p131o.InterfaceC3070W2
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo10764mjFkc(InterfaceC3068W0 interfaceC3068W0) {
            if (interfaceC3068W0 == null || !DialogInterfaceOnCancelListenerC3318ZlB.this.f12212Vdz) {
                return;
            }
            View viewM799XbiWeM = DialogInterfaceOnCancelListenerC3318ZlB.this.m799XbiWeM();
            if (viewM799XbiWeM.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC3318ZlB.this.f12217dm != null) {
                if (AbstractC0093KLFTb.m857dm(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC3318ZlB.this.f12217dm);
                }
                DialogInterfaceOnCancelListenerC3318ZlB.this.f12217dm.setContentView(viewM799XbiWeM);
            }
        }
    }

    /* renamed from: o.ZlB$mjFkc */
    public class mjFkc implements Runnable {
        public mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogInterfaceOnCancelListenerC3318ZlB.this.f12214XV.onDismiss(DialogInterfaceOnCancelListenerC3318ZlB.this.f12217dm);
        }
    }

    /* renamed from: o.ZlB$wA */
    public class wA implements DialogInterface.OnDismissListener {
        public wA() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC3318ZlB.this.f12217dm != null) {
                DialogInterfaceOnCancelListenerC3318ZlB dialogInterfaceOnCancelListenerC3318ZlB = DialogInterfaceOnCancelListenerC3318ZlB.this;
                dialogInterfaceOnCancelListenerC3318ZlB.onDismiss(dialogInterfaceOnCancelListenerC3318ZlB.f12217dm);
            }
        }
    }

    /* renamed from: FbxKQm */
    public Dialog mo9419FbxKQm(Bundle bundle) {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(m810fFz(), m11224eQ());
    }

    /* renamed from: IyS */
    public final void m11220IyS(Bundle bundle) {
        if (this.f12212Vdz && !this.f12222xROA) {
            try {
                this.f12208ANMGZc = true;
                Dialog dialogMo9419FbxKQm = mo9419FbxKQm(bundle);
                this.f12217dm = dialogMo9419FbxKQm;
                if (this.f12212Vdz) {
                    m11223dGDT(dialogMo9419FbxKQm, this.f12216bbzow);
                    Context contextM801YoKzxo = m801YoKzxo();
                    if (contextM801YoKzxo instanceof Activity) {
                        this.f12217dm.setOwnerActivity((Activity) contextM801YoKzxo);
                    }
                    this.f12217dm.setCancelable(this.f12209JBhc);
                    this.f12217dm.setOnCancelListener(this.f12213WGXroI);
                    this.f12217dm.setOnDismissListener(this.f12214XV);
                    this.f12222xROA = true;
                } else {
                    this.f12217dm = null;
                }
                this.f12208ANMGZc = false;
            } catch (Throwable th) {
                this.f12208ANMGZc = false;
                throw th;
            }
        }
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: JYn */
    public void mo772JYn(Bundle bundle) {
        super.mo772JYn(bundle);
        this.f12210JrJO = new Handler();
        this.f12212Vdz = this.f1135eyqo == 0;
        if (bundle != null) {
            this.f12216bbzow = bundle.getInt("android:style", 0);
            this.f12211SwgkN = bundle.getInt("android:theme", 0);
            this.f12209JBhc = bundle.getBoolean("android:cancelable", true);
            this.f12212Vdz = bundle.getBoolean("android:showsDialog", this.f12212Vdz);
            this.f12218jm = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: Moer */
    public void mo778Moer(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.mo778Moer(layoutInflater, viewGroup, bundle);
        if (this.f1140mByQ != null || this.f12217dm == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f12217dm.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: WGXroI */
    public void mo794WGXroI() {
        super.mo794WGXroI();
        Dialog dialog = this.f12217dm;
        if (dialog != null) {
            this.f12220tQ = true;
            dialog.setOnDismissListener(null);
            this.f12217dm.dismiss();
            if (!this.f12223yfx) {
                onDismiss(this.f12217dm);
            }
            this.f12217dm = null;
            this.f12222xROA = false;
        }
    }

    /* renamed from: XDdeP */
    public Dialog m11221XDdeP() {
        return this.f12217dm;
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: XV */
    public void mo798XV() {
        super.mo798XV();
        if (!this.f12221vjlshU && !this.f12223yfx) {
            this.f12223yfx = true;
        }
        m792Vnb().m1062xJ(this.f12215alEkx);
    }

    /* renamed from: XgAT */
    public boolean m11222XgAT() {
        return this.f12222xROA;
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: alEkx */
    public void mo802alEkx() {
        super.mo802alEkx();
        Dialog dialog = this.f12217dm;
        if (dialog != null) {
            this.f12220tQ = false;
            dialog.show();
            View decorView = this.f12217dm.getWindow().getDecorView();
            AbstractC4356pa.m13133mjFkc(decorView, this);
            AbstractC4489ra.m13378mjFkc(decorView, this);
            AbstractC4421qa.m13267mjFkc(decorView, this);
        }
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: bbzow */
    public LayoutInflater mo804bbzow(Bundle bundle) {
        LayoutInflater layoutInflaterMo804bbzow = super.mo804bbzow(bundle);
        if (this.f12212Vdz && !this.f12208ANMGZc) {
            m11220IyS(bundle);
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f12217dm;
            return dialog != null ? layoutInflaterMo804bbzow.cloneInContext(dialog.getContext()) : layoutInflaterMo804bbzow;
        }
        if (AbstractC0093KLFTb.m857dm(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.f12212Vdz) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterMo804bbzow;
    }

    /* renamed from: dGDT */
    public void m11223dGDT(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: dm */
    public void mo807dm() {
        super.mo807dm();
        Dialog dialog = this.f12217dm;
        if (dialog != null) {
            dialog.hide();
        }
    }

    /* renamed from: eQ */
    public int m11224eQ() {
        return this.f12211SwgkN;
    }

    /* renamed from: jtz */
    public View m11225jtz(int i) {
        Dialog dialog = this.f12217dm;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f12220tQ) {
            return;
        }
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        m11226rdJr(true, true);
    }

    /* renamed from: rdJr */
    public final void m11226rdJr(boolean z, boolean z2) {
        if (this.f12223yfx) {
            return;
        }
        this.f12223yfx = true;
        this.f12221vjlshU = false;
        Dialog dialog = this.f12217dm;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f12217dm.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.f12210JrJO.getLooper()) {
                    onDismiss(this.f12217dm);
                } else {
                    this.f12210JrJO.post(this.f12219nxI);
                }
            }
        }
        this.f12220tQ = true;
        if (this.f12218jm >= 0) {
            m838vI().m933tjSezt(this.f12218jm, 1);
            this.f12218jm = -1;
            return;
        }
        AbstractC0095lgHUyS abstractC0095lgHUySM864Dt = m838vI().m864Dt();
        abstractC0095lgHUySM864Dt.mo959ETF(this);
        if (z) {
            abstractC0095lgHUySM864Dt.mo960JHa();
        } else {
            abstractC0095lgHUySM864Dt.mo961KLFTb();
        }
    }

    /* renamed from: tAfC */
    public final Dialog m11227tAfC() {
        Dialog dialogM11221XDdeP = m11221XDdeP();
        if (dialogM11221XDdeP != null) {
            return dialogM11221XDdeP;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: xJ */
    public AbstractC3963jeHSg mo843xJ() {
        return new KLFTb(super.mo843xJ());
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: yfx */
    public void mo847yfx(Bundle bundle) {
        Bundle bundle2;
        super.mo847yfx(bundle);
        if (this.f12217dm == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f12217dm.onRestoreInstanceState(bundle2);
    }
}
