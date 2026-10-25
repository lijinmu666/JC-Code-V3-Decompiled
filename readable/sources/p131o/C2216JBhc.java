package p131o;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* renamed from: o.JBhc */
/* loaded from: classes.dex */
public class C2216JBhc {

    /* renamed from: AZxh */
    public final C4035khjiU f8889AZxh;

    /* renamed from: mjFkc */
    public final EditText f8890mjFkc;

    public C2216JBhc(EditText editText) {
        this.f8890mjFkc = editText;
        this.f8889AZxh = new C4035khjiU(editText, false);
    }

    /* renamed from: AZxh */
    public boolean m8914AZxh(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* renamed from: KLFTb */
    public void m8915KLFTb(boolean z) {
        this.f8889AZxh.m12592wA(z);
    }

    /* renamed from: ZfxDd */
    public InputConnection m8916ZfxDd(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f8889AZxh.m12590AZxh(inputConnection, editorInfo);
    }

    /* renamed from: mjFkc */
    public KeyListener m8917mjFkc(KeyListener keyListener) {
        return m8914AZxh(keyListener) ? this.f8889AZxh.m12591mjFkc(keyListener) : keyListener;
    }

    /* renamed from: wA */
    public void m8918wA(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f8890mjFkc.getContext().obtainStyledAttributes(attributeSet, AbstractC3407b5.f12938WrLQs, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f12979jm) ? typedArrayObtainStyledAttributes.getBoolean(AbstractC3407b5.f12979jm, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            m8915KLFTb(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
