package p131o;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: o.k9 */
/* loaded from: classes.dex */
public abstract class AbstractC4000k9 {

    /* renamed from: AZxh */
    public static final InterfaceC3929j9 f14448AZxh;

    /* renamed from: BAnRFn */
    public static final InterfaceC3929j9 f14449BAnRFn;

    /* renamed from: CqaNbM */
    public static final InterfaceC3929j9 f14450CqaNbM;

    /* renamed from: Dt */
    public static final AbstractC3867i9 f14451Dt;

    /* renamed from: ETF */
    public static final InterfaceC3929j9 f14452ETF;

    /* renamed from: GMIER */
    public static final AbstractC3867i9 f14453GMIER;

    /* renamed from: Gd */
    public static final InterfaceC3929j9 f14454Gd;

    /* renamed from: HGpJ */
    public static final AbstractC3867i9 f14455HGpJ;

    /* renamed from: IEE */
    public static final AbstractC3867i9 f14456IEE;

    /* renamed from: JHa */
    public static final AbstractC3867i9 f14457JHa;

    /* renamed from: JYn */
    public static final InterfaceC3929j9 f14458JYn;

    /* renamed from: KLFTb */
    public static final AbstractC3867i9 f14459KLFTb;

    /* renamed from: KLMXS */
    public static final InterfaceC3929j9 f14460KLMXS;

    /* renamed from: KRTLGT */
    public static final InterfaceC3929j9 f14461KRTLGT;

    /* renamed from: MiMN */
    public static final InterfaceC3929j9 f14462MiMN;

    /* renamed from: NPj */
    public static final AbstractC3867i9 f14463NPj;

    /* renamed from: Ne */
    public static final AbstractC3867i9 f14464Ne;

    /* renamed from: OjSQV */
    public static final InterfaceC3929j9 f14465OjSQV;

    /* renamed from: Pq */
    public static final InterfaceC3929j9 f14466Pq;

    /* renamed from: Ucbh */
    public static final AbstractC3867i9 f14467Ucbh;

    /* renamed from: VA */
    public static final AbstractC3867i9 f14468VA;

    /* renamed from: Vnb */
    public static final InterfaceC3929j9 f14469Vnb;

    /* renamed from: VocHEe */
    public static final AbstractC3867i9 f14470VocHEe;

    /* renamed from: WrLQs */
    public static final AbstractC3867i9 f14471WrLQs;

    /* renamed from: YoKzxo */
    public static final AbstractC3867i9 f14472YoKzxo;

    /* renamed from: ZfxDd */
    public static final InterfaceC3929j9 f14473ZfxDd;

    /* renamed from: aqHPIZ */
    public static final InterfaceC3929j9 f14474aqHPIZ;

    /* renamed from: cMLeY */
    public static final InterfaceC3929j9 f14475cMLeY;

    /* renamed from: diqgf */
    public static final AbstractC3867i9 f14476diqgf;

    /* renamed from: eyqo */
    public static final AbstractC3867i9 f14477eyqo;

    /* renamed from: fehf */
    public static final InterfaceC3929j9 f14478fehf;

    /* renamed from: huTpC */
    public static final AbstractC3867i9 f14479huTpC;

    /* renamed from: lB */
    public static final AbstractC3867i9 f14480lB;

    /* renamed from: lgHUyS */
    public static final AbstractC3867i9 f14481lgHUyS;

    /* renamed from: mByQ */
    public static final AbstractC3867i9 f14482mByQ;

    /* renamed from: mjFkc */
    public static final AbstractC3867i9 f14483mjFkc;

    /* renamed from: oCFDzJ */
    public static final AbstractC3867i9 f14484oCFDzJ;

    /* renamed from: qGY */
    public static final AbstractC3867i9 f14485qGY;

    /* renamed from: qdMbNW */
    public static final InterfaceC3929j9 f14486qdMbNW;

    /* renamed from: rWxwaT */
    public static final AbstractC3867i9 f14487rWxwaT;

    /* renamed from: rkYL */
    public static final InterfaceC3929j9 f14488rkYL;

    /* renamed from: uHVRx */
    public static final InterfaceC3929j9 f14489uHVRx;

    /* renamed from: vI */
    public static final AbstractC3867i9 f14490vI;

    /* renamed from: vadzgd */
    public static final InterfaceC3929j9 f14491vadzgd;

    /* renamed from: wA */
    public static final AbstractC3867i9 f14492wA;

    /* renamed from: wJVbdd */
    public static final InterfaceC3929j9 f14493wJVbdd;

    /* renamed from: xJ */
    public static final InterfaceC3929j9 f14494xJ;

    /* renamed from: xrEuO */
    public static final AbstractC3867i9 f14495xrEuO;

    /* renamed from: zvd */
    public static final AbstractC3867i9 f14496zvd;

    /* renamed from: o.k9$AZxh */
    public class AZxh extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Number number) throws IOException {
            c1598a0.mo7541mByQ(number);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Number mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                return Long.valueOf(c4587t0.mo13555VocHEe());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    /* renamed from: o.k9$BAnRFn */
    public class BAnRFn extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Boolean bool) throws IOException {
            c1598a0.mo7529OjSQV(bool == null ? "null" : bool.toString());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Boolean mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return Boolean.valueOf(c4587t0.mo13550OjSQV());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$Dt */
    public class Dt extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, StringBuffer stringBuffer) throws IOException {
            c1598a0.mo7529OjSQV(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public StringBuffer mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return new StringBuffer(c4587t0.mo13550OjSQV());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$ETF */
    public class ETF extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Class mo3481read(C4587t0 c4587t0) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* renamed from: o.k9$Gd */
    public class Gd implements InterfaceC3929j9 {

        /* renamed from: AZxh */
        public final /* synthetic */ Class f14497AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Class f14498mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ AbstractC3867i9 f14499wA;

        public Gd(Class cls, Class cls2, AbstractC3867i9 abstractC3867i9) {
            this.f14498mjFkc = cls;
            this.f14497AZxh = cls2;
            this.f14499wA = abstractC3867i9;
        }

        public String toString() {
            return "Factory[type=" + this.f14498mjFkc.getName() + "+" + this.f14497AZxh.getName() + ",adapter=" + this.f14499wA + "]";
        }
    }

    /* renamed from: o.k9$HGpJ */
    public class HGpJ implements InterfaceC3929j9 {

        /* renamed from: AZxh */
        public final /* synthetic */ AbstractC3867i9 f14500AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Class f14501mjFkc;

        public HGpJ(Class cls, AbstractC3867i9 abstractC3867i9) {
            this.f14501mjFkc = cls;
            this.f14500AZxh = abstractC3867i9;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f14501mjFkc.getName() + ",adapter=" + this.f14500AZxh + "]";
        }
    }

    /* renamed from: o.k9$IEE */
    public class IEE extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Locale locale) throws IOException {
            c1598a0.mo7529OjSQV(locale == null ? null : locale.toString());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Locale mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(c4587t0.mo13550OjSQV(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }
    }

    /* renamed from: o.k9$JHa */
    public class JHa extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, String str) throws IOException {
            c1598a0.mo7529OjSQV(str);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String mo3481read(C4587t0 c4587t0) throws IOException {
            EnumC4786w0 enumC4786w0Mo13542CqaNbM = c4587t0.mo13542CqaNbM();
            if (enumC4786w0Mo13542CqaNbM != EnumC4786w0.NULL) {
                return enumC4786w0Mo13542CqaNbM == EnumC4786w0.BOOLEAN ? Boolean.toString(c4587t0.mo13543Gd()) : c4587t0.mo13550OjSQV();
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$KLFTb */
    public class KLFTb extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Character ch) throws IOException {
            c1598a0.mo7529OjSQV(ch == null ? null : String.valueOf(ch));
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Character mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            String strMo13550OjSQV = c4587t0.mo13550OjSQV();
            if (strMo13550OjSQV.length() == 1) {
                return Character.valueOf(strMo13550OjSQV.charAt(0));
            }
            throw new C4719v0("Expecting character, got: " + strMo13550OjSQV);
        }
    }

    /* renamed from: o.k9$MiMN */
    public class MiMN extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, URI uri) throws IOException {
            c1598a0.mo7529OjSQV(uri == null ? null : uri.toASCIIString());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public URI mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                String strMo13550OjSQV = c4587t0.mo13550OjSQV();
                if ("null".equals(strMo13550OjSQV)) {
                    return null;
                }
                return new URI(strMo13550OjSQV);
            } catch (URISyntaxException e) {
                throw new C4252o0(e);
            }
        }
    }

    /* renamed from: o.k9$Ne */
    public class Ne extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, AtomicBoolean atomicBoolean) throws IOException {
            c1598a0.mo7528Ne(atomicBoolean.get());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean mo3481read(C4587t0 c4587t0) {
            return new AtomicBoolean(c4587t0.mo13543Gd());
        }
    }

    /* renamed from: o.k9$OjSQV */
    public class OjSQV extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, AtomicInteger atomicInteger) throws IOException {
            c1598a0.mo7539lB(atomicInteger.get());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AtomicInteger mo3481read(C4587t0 c4587t0) {
            try {
                return new AtomicInteger(c4587t0.mo13567vI());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    /* renamed from: o.k9$Pq */
    public class Pq extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: read */
        public AbstractC4187n0 mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0 instanceof C4853x0) {
                return ((C4853x0) c4587t0).m13879aqHPIZ();
            }
            switch (vI.f14507mjFkc[c4587t0.mo13542CqaNbM().ordinal()]) {
                case 1:
                    return new C4520s0(new C2477N0(c4587t0.mo13550OjSQV()));
                case 2:
                    return new C4520s0(Boolean.valueOf(c4587t0.mo13543Gd()));
                case 3:
                    return new C4520s0(c4587t0.mo13550OjSQV());
                case 4:
                    c4587t0.mo13569wJVbdd();
                    return C4318p0.f15892mjFkc;
                case 5:
                    C3858i0 c3858i0 = new C3858i0();
                    c4587t0.mo13556ZfxDd();
                    while (c4587t0.mo13558diqgf()) {
                        c3858i0.m12264IEE(mo3481read(c4587t0));
                    }
                    c4587t0.mo13553VA();
                    return c3858i0;
                case 6:
                    C4385q0 c4385q0 = new C4385q0();
                    c4587t0.mo13545KLFTb();
                    while (c4587t0.mo13558diqgf()) {
                        c4385q0.m13158fehf(c4587t0.mo13541BAnRFn(), mo3481read(c4587t0));
                    }
                    c4587t0.mo13547MiMN();
                    return c4385q0;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: write, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, AbstractC4187n0 abstractC4187n0) throws IOException {
            if (abstractC4187n0 == null || abstractC4187n0.m12831YoKzxo()) {
                c1598a0.mo7531Ucbh();
                return;
            }
            if (abstractC4187n0.m12833qGY()) {
                C4520s0 c4520s0M12834qdMbNW = abstractC4187n0.m12834qdMbNW();
                if (c4520s0M12834qdMbNW.m13438eyqo()) {
                    c1598a0.mo7541mByQ(c4520s0M12834qdMbNW.mo12263ETF());
                    return;
                } else if (c4520s0M12834qdMbNW.m13435Pq()) {
                    c1598a0.mo7528Ne(c4520s0M12834qdMbNW.mo12268ZfxDd());
                    return;
                } else {
                    c1598a0.mo7529OjSQV(c4520s0M12834qdMbNW.mo12267VA());
                    return;
                }
            }
            if (abstractC4187n0.m12830MiMN()) {
                c1598a0.mo7545xJ();
                Iterator it = abstractC4187n0.m12836xJ().iterator();
                while (it.hasNext()) {
                    mo3482write(c1598a0, (AbstractC4187n0) it.next());
                }
                c1598a0.mo7532VA();
                return;
            }
            if (!abstractC4187n0.m12835rkYL()) {
                throw new IllegalArgumentException("Couldn't write " + abstractC4187n0.getClass());
            }
            c1598a0.mo7540lgHUyS();
            for (Map.Entry entry : abstractC4187n0.m12832lgHUyS().m13157eyqo()) {
                c1598a0.mo7535diqgf((String) entry.getKey());
                mo3482write(c1598a0, (AbstractC4187n0) entry.getValue());
            }
            c1598a0.mo7527MiMN();
        }
    }

    /* renamed from: o.k9$Ucbh */
    public class Ucbh implements InterfaceC3929j9 {

        /* renamed from: AZxh */
        public final /* synthetic */ AbstractC3867i9 f14502AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Class f14503mjFkc;

        public Ucbh(Class cls, AbstractC3867i9 abstractC3867i9) {
            this.f14503mjFkc = cls;
            this.f14502AZxh = abstractC3867i9;
        }

        public String toString() {
            return "Factory[type=" + this.f14503mjFkc.getName() + ",adapter=" + this.f14502AZxh + "]";
        }
    }

    /* renamed from: o.k9$VA */
    public class VA extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, URL url) throws IOException {
            c1598a0.mo7529OjSQV(url == null ? null : url.toExternalForm());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public URL mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            String strMo13550OjSQV = c4587t0.mo13550OjSQV();
            if ("null".equals(strMo13550OjSQV)) {
                return null;
            }
            return new URL(strMo13550OjSQV);
        }
    }

    /* renamed from: o.k9$VocHEe */
    public class VocHEe extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Boolean bool) throws IOException {
            c1598a0.mo7544wJVbdd(bool);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Boolean mo3481read(C4587t0 c4587t0) throws IOException {
            EnumC4786w0 enumC4786w0Mo13542CqaNbM = c4587t0.mo13542CqaNbM();
            if (enumC4786w0Mo13542CqaNbM != EnumC4786w0.NULL) {
                return enumC4786w0Mo13542CqaNbM == EnumC4786w0.STRING ? Boolean.valueOf(Boolean.parseBoolean(c4587t0.mo13550OjSQV())) : Boolean.valueOf(c4587t0.mo13543Gd());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$YoKzxo */
    public class YoKzxo extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, InetAddress inetAddress) throws IOException {
            c1598a0.mo7529OjSQV(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public InetAddress mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return InetAddress.getByName(c4587t0.mo13550OjSQV());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$ZfxDd */
    public class ZfxDd extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Number number) throws IOException {
            c1598a0.mo7541mByQ(number);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Number mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return Double.valueOf(c4587t0.mo13544HGpJ());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$diqgf */
    public class diqgf implements InterfaceC3929j9 {
    }

    /* renamed from: o.k9$eyqo */
    public class eyqo extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, BitSet bitSet) throws IOException {
            c1598a0.mo7545xJ();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                c1598a0.mo7539lB(bitSet.get(i) ? 1L : 0L);
            }
            c1598a0.mo7532VA();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BitSet mo3481read(C4587t0 c4587t0) throws IOException {
            BitSet bitSet = new BitSet();
            c4587t0.mo13556ZfxDd();
            EnumC4786w0 enumC4786w0Mo13542CqaNbM = c4587t0.mo13542CqaNbM();
            int i = 0;
            while (enumC4786w0Mo13542CqaNbM != EnumC4786w0.END_ARRAY) {
                int i2 = vI.f14507mjFkc[enumC4786w0Mo13542CqaNbM.ordinal()];
                boolean zMo13543Gd = true;
                if (i2 != 1) {
                    if (i2 == 2) {
                        zMo13543Gd = c4587t0.mo13543Gd();
                    } else {
                        if (i2 != 3) {
                            throw new C4719v0("Invalid bitset value type: " + enumC4786w0Mo13542CqaNbM);
                        }
                        String strMo13550OjSQV = c4587t0.mo13550OjSQV();
                        try {
                            if (Integer.parseInt(strMo13550OjSQV) == 0) {
                                zMo13543Gd = false;
                            }
                        } catch (NumberFormatException unused) {
                            throw new C4719v0("Error: Expecting: bitset number value (1, 0), Found: " + strMo13550OjSQV);
                        }
                    }
                } else if (c4587t0.mo13567vI() == 0) {
                }
                if (zMo13543Gd) {
                    bitSet.set(i);
                }
                i++;
                enumC4786w0Mo13542CqaNbM = c4587t0.mo13542CqaNbM();
            }
            c4587t0.mo13553VA();
            return bitSet;
        }
    }

    /* renamed from: o.k9$fehf */
    public class fehf extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Calendar calendar) throws IOException {
            if (calendar == null) {
                c1598a0.mo7531Ucbh();
                return;
            }
            c1598a0.mo7540lgHUyS();
            c1598a0.mo7535diqgf("year");
            c1598a0.mo7539lB(calendar.get(1));
            c1598a0.mo7535diqgf("month");
            c1598a0.mo7539lB(calendar.get(2));
            c1598a0.mo7535diqgf("dayOfMonth");
            c1598a0.mo7539lB(calendar.get(5));
            c1598a0.mo7535diqgf("hourOfDay");
            c1598a0.mo7539lB(calendar.get(11));
            c1598a0.mo7535diqgf("minute");
            c1598a0.mo7539lB(calendar.get(12));
            c1598a0.mo7535diqgf("second");
            c1598a0.mo7539lB(calendar.get(13));
            c1598a0.mo7527MiMN();
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Calendar mo3481read(C4587t0 c4587t0) throws IOException, NumberFormatException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            c4587t0.mo13545KLFTb();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (c4587t0.mo13542CqaNbM() != EnumC4786w0.END_OBJECT) {
                String strMo13541BAnRFn = c4587t0.mo13541BAnRFn();
                int iMo13567vI = c4587t0.mo13567vI();
                if ("year".equals(strMo13541BAnRFn)) {
                    i = iMo13567vI;
                } else if ("month".equals(strMo13541BAnRFn)) {
                    i2 = iMo13567vI;
                } else if ("dayOfMonth".equals(strMo13541BAnRFn)) {
                    i3 = iMo13567vI;
                } else if ("hourOfDay".equals(strMo13541BAnRFn)) {
                    i4 = iMo13567vI;
                } else if ("minute".equals(strMo13541BAnRFn)) {
                    i5 = iMo13567vI;
                } else if ("second".equals(strMo13541BAnRFn)) {
                    i6 = iMo13567vI;
                }
            }
            c4587t0.mo13547MiMN();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }
    }

    /* renamed from: o.k9$huTpC */
    public class huTpC implements InterfaceC3929j9 {

        /* renamed from: AZxh */
        public final /* synthetic */ Class f14504AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Class f14505mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ AbstractC3867i9 f14506wA;

        public huTpC(Class cls, Class cls2, AbstractC3867i9 abstractC3867i9) {
            this.f14505mjFkc = cls;
            this.f14504AZxh = cls2;
            this.f14506wA = abstractC3867i9;
        }

        public String toString() {
            return "Factory[type=" + this.f14504AZxh.getName() + "+" + this.f14505mjFkc.getName() + ",adapter=" + this.f14506wA + "]";
        }
    }

    /* renamed from: o.k9$lB */
    public class lB extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Number number) throws IOException {
            c1598a0.mo7541mByQ(number);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Number mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                return Byte.valueOf((byte) c4587t0.mo13567vI());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    /* renamed from: o.k9$lgHUyS */
    public class lgHUyS extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, BigInteger bigInteger) throws IOException {
            c1598a0.mo7541mByQ(bigInteger);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public BigInteger mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                return new BigInteger(c4587t0.mo13550OjSQV());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    /* renamed from: o.k9$mByQ */
    public class mByQ extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Number number) throws IOException {
            c1598a0.mo7541mByQ(number);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Number mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                return Integer.valueOf(c4587t0.mo13567vI());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    /* renamed from: o.k9$mjFkc */
    public class mjFkc extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, AtomicIntegerArray atomicIntegerArray) throws IOException {
            c1598a0.mo7545xJ();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                c1598a0.mo7539lB(atomicIntegerArray.get(i));
            }
            c1598a0.mo7532VA();
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray mo3481read(C4587t0 c4587t0) throws IOException {
            ArrayList arrayList = new ArrayList();
            c4587t0.mo13556ZfxDd();
            while (c4587t0.mo13558diqgf()) {
                try {
                    arrayList.add(Integer.valueOf(c4587t0.mo13567vI()));
                } catch (NumberFormatException e) {
                    throw new C4719v0(e);
                }
            }
            c4587t0.mo13553VA();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }
    }

    /* renamed from: o.k9$qGY */
    public class qGY extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Currency currency) throws IOException {
            c1598a0.mo7529OjSQV(currency.getCurrencyCode());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Currency mo3481read(C4587t0 c4587t0) {
            return Currency.getInstance(c4587t0.mo13550OjSQV());
        }
    }

    /* renamed from: o.k9$qdMbNW */
    public class qdMbNW extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, StringBuilder sb) throws IOException {
            c1598a0.mo7529OjSQV(sb == null ? null : sb.toString());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public StringBuilder mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return new StringBuilder(c4587t0.mo13550OjSQV());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$rkYL */
    public class rkYL extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, UUID uuid) throws IOException {
            c1598a0.mo7529OjSQV(uuid == null ? null : uuid.toString());
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public UUID mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return UUID.fromString(c4587t0.mo13550OjSQV());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$vI */
    public static /* synthetic */ class vI {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f14507mjFkc;

        static {
            int[] iArr = new int[EnumC4786w0.m13807values().length];
            f14507mjFkc = iArr;
            try {
                iArr[EnumC4786w0.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14507mjFkc[EnumC4786w0.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14507mjFkc[EnumC4786w0.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14507mjFkc[EnumC4786w0.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14507mjFkc[EnumC4786w0.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14507mjFkc[EnumC4786w0.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14507mjFkc[EnumC4786w0.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14507mjFkc[EnumC4786w0.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14507mjFkc[EnumC4786w0.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14507mjFkc[EnumC4786w0.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: o.k9$wA */
    public class wA extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Number number) throws IOException {
            c1598a0.mo7541mByQ(number);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Number mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return Float.valueOf((float) c4587t0.mo13544HGpJ());
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }
    }

    /* renamed from: o.k9$wJVbdd */
    public class wJVbdd extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, Number number) throws IOException {
            c1598a0.mo7541mByQ(number);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Number mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                return Short.valueOf((short) c4587t0.mo13567vI());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    /* renamed from: o.k9$xJ */
    public class xJ extends AbstractC3867i9 {
        @Override // p131o.AbstractC3867i9
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, BigDecimal bigDecimal) throws IOException {
            c1598a0.mo7541mByQ(bigDecimal);
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public BigDecimal mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() == EnumC4786w0.NULL) {
                c4587t0.mo13569wJVbdd();
                return null;
            }
            try {
                return new BigDecimal(c4587t0.mo13550OjSQV());
            } catch (NumberFormatException e) {
                throw new C4719v0(e);
            }
        }
    }

    static {
        AbstractC3867i9 abstractC3867i9NullSafe = new ETF().nullSafe();
        f14483mjFkc = abstractC3867i9NullSafe;
        f14448AZxh = m12486AZxh(Class.class, abstractC3867i9NullSafe);
        AbstractC3867i9 abstractC3867i9NullSafe2 = new eyqo().nullSafe();
        f14492wA = abstractC3867i9NullSafe2;
        f14473ZfxDd = m12486AZxh(BitSet.class, abstractC3867i9NullSafe2);
        VocHEe vocHEe = new VocHEe();
        f14459KLFTb = vocHEe;
        f14457JHa = new BAnRFn();
        f14494xJ = m12488mjFkc(Boolean.TYPE, Boolean.class, vocHEe);
        lB lBVar = new lB();
        f14481lgHUyS = lBVar;
        f14486qdMbNW = m12488mjFkc(Byte.TYPE, Byte.class, lBVar);
        wJVbdd wjvbdd = new wJVbdd();
        f14451Dt = wjvbdd;
        f14452ETF = m12488mjFkc(Short.TYPE, Short.class, wjvbdd);
        mByQ mbyq = new mByQ();
        f14468VA = mbyq;
        f14462MiMN = m12488mjFkc(Integer.TYPE, Integer.class, mbyq);
        AbstractC3867i9 abstractC3867i9NullSafe3 = new OjSQV().nullSafe();
        f14472YoKzxo = abstractC3867i9NullSafe3;
        f14488rkYL = m12486AZxh(AtomicInteger.class, abstractC3867i9NullSafe3);
        AbstractC3867i9 abstractC3867i9NullSafe4 = new Ne().nullSafe();
        f14485qGY = abstractC3867i9NullSafe4;
        f14478fehf = m12486AZxh(AtomicBoolean.class, abstractC3867i9NullSafe4);
        AbstractC3867i9 abstractC3867i9NullSafe5 = new mjFkc().nullSafe();
        f14456IEE = abstractC3867i9NullSafe5;
        f14466Pq = m12486AZxh(AtomicIntegerArray.class, abstractC3867i9NullSafe5);
        f14476diqgf = new AZxh();
        f14477eyqo = new wA();
        f14467Ucbh = new ZfxDd();
        KLFTb kLFTb = new KLFTb();
        f14479huTpC = kLFTb;
        f14454Gd = m12488mjFkc(Character.TYPE, Character.class, kLFTb);
        JHa jHa = new JHa();
        f14455HGpJ = jHa;
        f14490vI = new xJ();
        f14470VocHEe = new lgHUyS();
        f14449BAnRFn = m12486AZxh(String.class, jHa);
        qdMbNW qdmbnw = new qdMbNW();
        f14480lB = qdmbnw;
        f14493wJVbdd = m12486AZxh(StringBuilder.class, qdmbnw);
        Dt dt = new Dt();
        f14482mByQ = dt;
        f14465OjSQV = m12486AZxh(StringBuffer.class, dt);
        VA va = new VA();
        f14464Ne = va;
        f14450CqaNbM = m12486AZxh(URL.class, va);
        MiMN miMN = new MiMN();
        f14495xrEuO = miMN;
        f14460KLMXS = m12486AZxh(URI.class, miMN);
        YoKzxo yoKzxo = new YoKzxo();
        f14496zvd = yoKzxo;
        f14475cMLeY = m12487ZfxDd(InetAddress.class, yoKzxo);
        rkYL rkyl = new rkYL();
        f14487rWxwaT = rkyl;
        f14469Vnb = m12486AZxh(UUID.class, rkyl);
        AbstractC3867i9 abstractC3867i9NullSafe6 = new qGY().nullSafe();
        f14463NPj = abstractC3867i9NullSafe6;
        f14491vadzgd = m12486AZxh(Currency.class, abstractC3867i9NullSafe6);
        fehf fehfVar = new fehf();
        f14484oCFDzJ = fehfVar;
        f14474aqHPIZ = m12489wA(Calendar.class, GregorianCalendar.class, fehfVar);
        IEE iee = new IEE();
        f14471WrLQs = iee;
        f14461KRTLGT = m12486AZxh(Locale.class, iee);
        Pq pq = new Pq();
        f14453GMIER = pq;
        f14489uHVRx = m12487ZfxDd(AbstractC4187n0.class, pq);
        f14458JYn = new diqgf();
    }

    /* renamed from: AZxh */
    public static InterfaceC3929j9 m12486AZxh(Class cls, AbstractC3867i9 abstractC3867i9) {
        return new Ucbh(cls, abstractC3867i9);
    }

    /* renamed from: ZfxDd */
    public static InterfaceC3929j9 m12487ZfxDd(Class cls, AbstractC3867i9 abstractC3867i9) {
        return new HGpJ(cls, abstractC3867i9);
    }

    /* renamed from: mjFkc */
    public static InterfaceC3929j9 m12488mjFkc(Class cls, Class cls2, AbstractC3867i9 abstractC3867i9) {
        return new huTpC(cls, cls2, abstractC3867i9);
    }

    /* renamed from: wA */
    public static InterfaceC3929j9 m12489wA(Class cls, Class cls2, AbstractC3867i9 abstractC3867i9) {
        return new Gd(cls, cls2, abstractC3867i9);
    }
}
