package p131o;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import p131o.C1901EcuP;

/* renamed from: o.N */
/* loaded from: classes.dex */
public abstract class AbstractC2476N {

    /* renamed from: o.N$AZxh */
    public interface AZxh {
        /* renamed from: mjFkc */
        boolean mo9407mjFkc(C2540O c2540o, int i, Bundle bundle);
    }

    /* renamed from: o.N$mjFkc */
    public class mjFkc extends InputConnectionWrapper {

        /* renamed from: mjFkc */
        public final /* synthetic */ AZxh f9629mjFkc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public mjFkc(InputConnection inputConnection, boolean z, AZxh aZxh) {
            super(inputConnection, z);
            this.f9629mjFkc = aZxh;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
            if (this.f9629mjFkc.mo9407mjFkc(C2540O.m9779JHa(inputContentInfo), i, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i, bundle);
        }
    }

    /* renamed from: AZxh */
    public static AZxh m9567AZxh(final View view) {
        AbstractC2280K3.m9126xJ(view);
        return new AZxh() { // from class: o.M
            @Override // p131o.AbstractC2476N.AZxh
            /* renamed from: mjFkc */
            public final boolean mo9407mjFkc(C2540O c2540o, int i, Bundle bundle) {
                return AbstractC2476N.m9568KLFTb(view, c2540o, i, bundle);
            }
        };
    }

    /* renamed from: KLFTb */
    public static /* synthetic */ boolean m9568KLFTb(View view, C2540O c2540o, int i, Bundle bundle) {
        if ((i & 1) != 0) {
            try {
                c2540o.m9782ZfxDd();
                Parcelable parcelable = (Parcelable) c2540o.m9781KLFTb();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        return AbstractC2876T9.m10237JrJO(view, new C1901EcuP.mjFkc(new ClipData(c2540o.m9780AZxh(), new ClipData.Item(c2540o.m9783mjFkc())), 2).m8163ZfxDd(c2540o.m9784wA()).m8162AZxh(bundle).m8164mjFkc()) == null;
    }

    /* renamed from: ZfxDd */
    public static InputConnection m9569ZfxDd(InputConnection inputConnection, EditorInfo editorInfo, AZxh aZxh) {
        AbstractC3003V2.m10658ZfxDd(inputConnection, "inputConnection must be non-null");
        AbstractC3003V2.m10658ZfxDd(editorInfo, "editorInfo must be non-null");
        AbstractC3003V2.m10658ZfxDd(aZxh, "onCommitContentListener must be non-null");
        return new mjFkc(inputConnection, false, aZxh);
    }

    /* renamed from: wA */
    public static InputConnection m9571wA(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return m9569ZfxDd(inputConnection, editorInfo, m9567AZxh(view));
    }
}
