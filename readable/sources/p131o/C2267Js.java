package p131o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: o.Js */
/* loaded from: classes.dex */
public final class C2267Js {

    /* renamed from: mjFkc */
    public final C2125Hs f9058mjFkc;

    public C2267Js(C2125Hs c2125Hs) {
        AbstractC4912xs abstractC4912xs = C4843ws.f17266AZxh;
        this.f9058mjFkc = c2125Hs;
    }

    /* renamed from: mjFkc */
    public static C2267Js m9066mjFkc(String str) {
        return new C2267Js(new C2125Hs("#vk "));
    }

    /* renamed from: AZxh */
    public final List m9067AZxh(CharSequence charSequence) {
        charSequence.getClass();
        C2058Gs c2058Gs = new C2058Gs(this.f9058mjFkc, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (c2058Gs.hasNext()) {
            arrayList.add((String) c2058Gs.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
