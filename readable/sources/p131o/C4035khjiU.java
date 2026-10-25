package p131o;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* renamed from: o.khjiU */
/* loaded from: classes.dex */
public final class C4035khjiU {

    /* renamed from: mjFkc */
    public final AZxh f14575mjFkc;

    /* renamed from: AZxh */
    public int f14574AZxh = Integer.MAX_VALUE;

    /* renamed from: wA */
    public int f14576wA = 0;

    /* renamed from: o.khjiU$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public abstract InputConnection mo12593AZxh(InputConnection inputConnection, EditorInfo editorInfo);

        /* renamed from: mjFkc */
        public abstract KeyListener mo12594mjFkc(KeyListener keyListener);

        /* renamed from: wA */
        public abstract void mo12595wA(boolean z);
    }

    /* renamed from: o.khjiU$mjFkc */
    public static class mjFkc extends AZxh {

        /* renamed from: AZxh */
        public final C4949yRYQP f14577AZxh;

        /* renamed from: mjFkc */
        public final EditText f14578mjFkc;

        public mjFkc(EditText editText, boolean z) {
            this.f14578mjFkc = editText;
            C4949yRYQP c4949yRYQP = new C4949yRYQP(editText, z);
            this.f14577AZxh = c4949yRYQP;
            editText.addTextChangedListener(c4949yRYQP);
            editText.setEditableFactory(C3216YDiFPt.getInstance());
        }

        @Override // p131o.C4035khjiU.AZxh
        /* renamed from: AZxh */
        public InputConnection mo12593AZxh(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof C4302olO ? inputConnection : new C4302olO(this.f14578mjFkc, inputConnection, editorInfo);
        }

        @Override // p131o.C4035khjiU.AZxh
        /* renamed from: mjFkc */
        public KeyListener mo12594mjFkc(KeyListener keyListener) {
            if (keyListener instanceof C2558OGo) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new C2558OGo(keyListener);
        }

        @Override // p131o.C4035khjiU.AZxh
        /* renamed from: wA */
        public void mo12595wA(boolean z) {
            this.f14577AZxh.m14007wA(z);
        }
    }

    public C4035khjiU(EditText editText, boolean z) {
        AbstractC2280K3.m9122lgHUyS(editText, "editText cannot be null");
        this.f14575mjFkc = new mjFkc(editText, z);
    }

    /* renamed from: AZxh */
    public InputConnection m12590AZxh(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f14575mjFkc.mo12593AZxh(inputConnection, editorInfo);
    }

    /* renamed from: mjFkc */
    public KeyListener m12591mjFkc(KeyListener keyListener) {
        return this.f14575mjFkc.mo12594mjFkc(keyListener);
    }

    /* renamed from: wA */
    public void m12592wA(boolean z) {
        this.f14575mjFkc.mo12595wA(z);
    }
}
