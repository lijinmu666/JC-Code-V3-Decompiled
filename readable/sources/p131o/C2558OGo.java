package p131o;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.p020emoji2.p021text.C0084wA;

/* renamed from: o.OGo */
/* loaded from: classes.dex */
public final class C2558OGo implements KeyListener {

    /* renamed from: AZxh */
    public final mjFkc f9939AZxh;

    /* renamed from: mjFkc */
    public final KeyListener f9940mjFkc;

    /* renamed from: o.OGo$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public boolean m9894mjFkc(Editable editable, int i, KeyEvent keyEvent) {
            return C0084wA.m689JHa(editable, i, keyEvent);
        }
    }

    public C2558OGo(KeyListener keyListener) {
        this(keyListener, new mjFkc());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i) {
        this.f9940mjFkc.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f9940mjFkc.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f9939AZxh.m9894mjFkc(editable, i, keyEvent) || this.f9940mjFkc.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f9940mjFkc.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f9940mjFkc.onKeyUp(view, editable, i, keyEvent);
    }

    public C2558OGo(KeyListener keyListener, mjFkc mjfkc) {
        this.f9940mjFkc = keyListener;
        this.f9939AZxh = mjfkc;
    }
}
