package p131o;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p131o.AbstractC2485N8;

/* renamed from: o.R8 */
/* loaded from: classes.dex */
public class C2741R8 extends AbstractC2485N8 {

    /* renamed from: cMLeY */
    public int f10382cMLeY;

    /* renamed from: KLMXS */
    public ArrayList f10380KLMXS = new ArrayList();

    /* renamed from: zvd */
    public boolean f10384zvd = true;

    /* renamed from: rWxwaT */
    public boolean f10383rWxwaT = false;

    /* renamed from: Vnb */
    public int f10381Vnb = 0;

    /* renamed from: o.R8$AZxh */
    public static class AZxh extends AbstractC2549O8 {

        /* renamed from: mjFkc */
        public C2741R8 f10385mjFkc;

        public AZxh(C2741R8 c2741r8) {
            this.f10385mjFkc = c2741r8;
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: ZfxDd */
        public void mo8144ZfxDd(AbstractC2485N8 abstractC2485N8) {
            C2741R8 c2741r8 = this.f10385mjFkc;
            if (c2741r8.f10383rWxwaT) {
                return;
            }
            c2741r8.m9617bbzow();
            this.f10385mjFkc.f10383rWxwaT = true;
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            C2741R8 c2741r8 = this.f10385mjFkc;
            int i = c2741r8.f10382cMLeY - 1;
            c2741r8.f10382cMLeY = i;
            if (i == 0) {
                c2741r8.f10383rWxwaT = false;
                c2741r8.m9598IEE();
            }
            abstractC2485N8.mo9616aqHPIZ(this);
        }
    }

    /* renamed from: o.R8$mjFkc */
    public class mjFkc extends AbstractC2549O8 {

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC2485N8 f10387mjFkc;

        public mjFkc(AbstractC2485N8 abstractC2485N8) {
            this.f10387mjFkc = abstractC2485N8;
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            this.f10387mjFkc.mo9632uHVRx();
            abstractC2485N8.mo9616aqHPIZ(this);
        }
    }

    /* renamed from: ANMGZc */
    public final void m10043ANMGZc(AbstractC2485N8 abstractC2485N8) {
        this.f10380KLMXS.add(abstractC2485N8);
        abstractC2485N8.f9668IEE = this;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: ETF */
    public void mo9594ETF(C2875T8 c2875t8) {
        super.mo9594ETF(c2875t8);
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9594ETF(c2875t8);
        }
    }

    /* renamed from: IVlxe */
    public C2741R8 m10044IVlxe(int i) {
        if (i == 0) {
            this.f10384zvd = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.f10384zvd = false;
        }
        return this;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: JBhc, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9627mjFkc(AbstractC2485N8.JHa jHa) {
        return (C2741R8) super.mo9627mjFkc(jHa);
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: JYgkl */
    public void mo9600JYgkl(AbstractC2485N8.KLFTb kLFTb) {
        super.mo9600JYgkl(kLFTb);
        this.f10381Vnb |= 8;
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9600JYgkl(kLFTb);
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: KRTLGT */
    public void mo9603KRTLGT(View view) {
        super.mo9603KRTLGT(view);
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9603KRTLGT(view);
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: Moer, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9614XV(long j) {
        return (C2741R8) super.mo9614XV(j);
    }

    /* renamed from: SmIWf */
    public final void m10047SmIWf() {
        AZxh aZxh = new AZxh(this);
        Iterator it = this.f10380KLMXS.iterator();
        while (it.hasNext()) {
            ((AbstractC2485N8) it.next()).mo9627mjFkc(aZxh);
        }
        this.f10382cMLeY = this.f10380KLMXS.size();
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: SwgkN */
    public String mo9608SwgkN(String str) {
        String strMo9608SwgkN = super.mo9608SwgkN(str);
        for (int i = 0; i < this.f10380KLMXS.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strMo9608SwgkN);
            sb.append("\n");
            sb.append(((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9608SwgkN(str + "  "));
            strMo9608SwgkN = sb.toString();
        }
        return strMo9608SwgkN;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: VA */
    public void mo8133VA(C2875T8 c2875t8) {
        if (m9636xrEuO(c2875t8.f10645AZxh)) {
            Iterator it = this.f10380KLMXS.iterator();
            while (it.hasNext()) {
                AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) it.next();
                if (abstractC2485N8.m9636xrEuO(c2875t8.f10645AZxh)) {
                    abstractC2485N8.mo8133VA(c2875t8);
                    c2875t8.f10647wA.add(abstractC2485N8);
                }
            }
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: Vdz, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9591AZxh(View view) {
        for (int i = 0; i < this.f10380KLMXS.size(); i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9591AZxh(view);
        }
        return (C2741R8) super.mo9591AZxh(view);
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: WGXroI */
    public void mo9612WGXroI(AbstractC2676Q8 abstractC2676Q8) {
        super.mo9612WGXroI(abstractC2676Q8);
        this.f10381Vnb |= 2;
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9612WGXroI(abstractC2676Q8);
        }
    }

    /* renamed from: alEkx */
    public AbstractC2485N8 m10049alEkx(int i) {
        if (i < 0 || i >= this.f10380KLMXS.size()) {
            return null;
        }
        return (AbstractC2485N8) this.f10380KLMXS.get(i);
    }

    /* renamed from: dm */
    public int m10050dm() {
        return this.f10380KLMXS.size();
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: fehf */
    public void mo9622fehf(ViewGroup viewGroup, C2937U8 c2937u8, C2937U8 c2937u82, ArrayList arrayList, ArrayList arrayList2) {
        long jM9611VocHEe = m9611VocHEe();
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) this.f10380KLMXS.get(i);
            if (jM9611VocHEe > 0 && (this.f10384zvd || i == 0)) {
                long jM9611VocHEe2 = abstractC2485N8.m9611VocHEe();
                if (jM9611VocHEe2 > 0) {
                    abstractC2485N8.mo9614XV(jM9611VocHEe2 + jM9611VocHEe);
                } else {
                    abstractC2485N8.mo9614XV(jM9611VocHEe);
                }
            }
            abstractC2485N8.mo9622fehf(viewGroup, c2937u8, c2937u82, arrayList, arrayList2);
        }
    }

    /* renamed from: jm */
    public C2741R8 m10051jm(AbstractC2485N8 abstractC2485N8) {
        m10043ANMGZc(abstractC2485N8);
        long j = this.f9691wA;
        if (j >= 0) {
            abstractC2485N8.mo9601JYn(j);
        }
        if ((this.f10381Vnb & 1) != 0) {
            abstractC2485N8.mo9602JrJO(m9621eyqo());
        }
        if ((this.f10381Vnb & 2) != 0) {
            m9597HGpJ();
            abstractC2485N8.mo9612WGXroI(null);
        }
        if ((this.f10381Vnb & 4) != 0) {
            abstractC2485N8.mo9628nxI(m9596Gd());
        }
        if ((this.f10381Vnb & 8) != 0) {
            abstractC2485N8.mo9600JYgkl(m9620diqgf());
        }
        return this;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: nxI */
    public void mo9628nxI(AbstractC4590t3 abstractC4590t3) {
        super.mo9628nxI(abstractC4590t3);
        this.f10381Vnb |= 4;
        if (this.f10380KLMXS != null) {
            for (int i = 0; i < this.f10380KLMXS.size(); i++) {
                ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9628nxI(abstractC4590t3);
            }
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: qdMbNW */
    public void mo8139qdMbNW(C2875T8 c2875t8) {
        if (m9636xrEuO(c2875t8.f10645AZxh)) {
            Iterator it = this.f10380KLMXS.iterator();
            while (it.hasNext()) {
                AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) it.next();
                if (abstractC2485N8.m9636xrEuO(c2875t8.f10645AZxh)) {
                    abstractC2485N8.mo8139qdMbNW(c2875t8);
                    c2875t8.f10647wA.add(abstractC2485N8);
                }
            }
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: rkYL, reason: merged with bridge method [inline-methods] */
    public AbstractC2485N8 mo9619clone() {
        C2741R8 c2741r8 = (C2741R8) super.mo9619clone();
        c2741r8.f10380KLMXS = new ArrayList();
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            c2741r8.m10043ANMGZc(((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9619clone());
        }
        return c2741r8;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: tQ, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9616aqHPIZ(AbstractC2485N8.JHa jHa) {
        return (C2741R8) super.mo9616aqHPIZ(jHa);
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: uHVRx */
    public void mo9632uHVRx() {
        if (this.f10380KLMXS.isEmpty()) {
            m9617bbzow();
            m9598IEE();
            return;
        }
        m10047SmIWf();
        if (this.f10384zvd) {
            Iterator it = this.f10380KLMXS.iterator();
            while (it.hasNext()) {
                ((AbstractC2485N8) it.next()).mo9632uHVRx();
            }
            return;
        }
        for (int i = 1; i < this.f10380KLMXS.size(); i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i - 1)).mo9627mjFkc(new mjFkc((AbstractC2485N8) this.f10380KLMXS.get(i)));
        }
        AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) this.f10380KLMXS.get(0);
        if (abstractC2485N8 != null) {
            abstractC2485N8.mo9632uHVRx();
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: vadzgd */
    public void mo9633vadzgd(View view) {
        super.mo9633vadzgd(view);
        int size = this.f10380KLMXS.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9633vadzgd(view);
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: vjlshU, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9601JYn(long j) {
        ArrayList arrayList;
        super.mo9601JYn(j);
        if (this.f9691wA >= 0 && (arrayList = this.f10380KLMXS) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9601JYn(j);
            }
        }
        return this;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: xROA, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9602JrJO(TimeInterpolator timeInterpolator) {
        this.f10381Vnb |= 1;
        ArrayList arrayList = this.f10380KLMXS;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9602JrJO(timeInterpolator);
            }
        }
        return (C2741R8) super.mo9602JrJO(timeInterpolator);
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: yfx, reason: merged with bridge method [inline-methods] */
    public C2741R8 mo9613WrLQs(View view) {
        for (int i = 0; i < this.f10380KLMXS.size(); i++) {
            ((AbstractC2485N8) this.f10380KLMXS.get(i)).mo9613WrLQs(view);
        }
        return (C2741R8) super.mo9613WrLQs(view);
    }
}
